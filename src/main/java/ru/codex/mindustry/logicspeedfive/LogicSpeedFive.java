package ru.codex.mindustry.logicspeedfive;

import arc.Core;
import arc.Events;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.entities.EntityGroup;
import mindustry.game.EventType.WorldLoadEvent;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.mod.Plugin;
import mindustry.ui.dialogs.SettingsMenuDialog.SettingsTable;
import mindustry.world.Block;
import mindustry.world.blocks.logic.LogicBlock;

/** Configurable instruction-rate multipliers for the three vanilla logic processors. */
public final class LogicSpeedFive extends Plugin {
    private static final String PREFIX = "logicspeedfive.";
    private static final String ENABLED = PREFIX + "enabled";
    private static final String MICRO_ENABLED = PREFIX + "micro.enabled";
    private static final String LOGIC_ENABLED = PREFIX + "logic.enabled";
    private static final String HYPER_ENABLED = PREFIX + "hyper.enabled";
    private static final String MICRO_MULTIPLIER = PREFIX + "micro.multiplier";
    private static final String LOGIC_MULTIPLIER = PREFIX + "logic.multiplier";
    private static final String HYPER_MULTIPLIER = PREFIX + "hyper.multiplier";

    private Processor[] processors;

    @Override
    public void init() {
        // Resolve content blocks during init rather than class loading, when
        // Mindustry may not have finished registering content yet.
        processors = new Processor[]{
            new Processor(Blocks.microProcessor, 2, MICRO_ENABLED, MICRO_MULTIPLIER),
            new Processor(Blocks.logicProcessor, 8, LOGIC_ENABLED, LOGIC_MULTIPLIER),
            new Processor(Blocks.hyperProcessor, 25, HYPER_ENABLED, HYPER_MULTIPLIER)
        };
        for (Processor processor : processors) {
            processor.lastAppliedRate = processor.vanillaRate;
        }

        Events.on(WorldLoadEvent.class, event -> refreshRates());

        // Dedicated servers have no UI. Desktop hosts use local settings and
        // this does not add a mod requirement for guests.
        if (!Vars.headless && Vars.ui != null) {
            Vars.ui.settings.addCategory("Logic Speed Five", (SettingsTable table) -> {
                table.checkPref(ENABLED, true, value -> refreshRates());
                table.category(PREFIX + "micro.section");
                addProcessorSettings(table, processors[0]);
                table.category(PREFIX + "logic.section");
                addProcessorSettings(table, processors[1]);
                table.category(PREFIX + "hyper.section");
                addProcessorSettings(table, processors[2]);
            });
        }

        refreshRates();
    }

    private void addProcessorSettings(SettingsTable table, Processor processor) {
        table.checkPref(processor.enabledKey, true, value -> refreshRates());
        table.sliderPref(processor.multiplierKey, 5, 1, 15,
            value -> value + "x", value -> refreshRates());
    }

    /** Reapply to block defaults and existing buildings after each setting change. */
    private void refreshRates() {
        if (Core.settings == null) return;

        boolean globallyEnabled = Core.settings.getBool(ENABLED, true);
        for (Processor processor : processors) {
            int oldRate = processor.lastAppliedRate;
            int desiredRate = RatePolicy.effectiveRate(processor.vanillaRate, globallyEnabled,
                Core.settings.getBool(processor.enabledKey, true), Core.settings.getInt(processor.multiplierKey, 5));

            if (!(processor.block instanceof LogicBlock logicBlock)) continue;

            // Preserve another mod's customization unless this value is
            // vanilla or the last value assigned by this plugin.
            boolean managesBlockRate = logicBlock.instructionsPerTick == oldRate
                || logicBlock.instructionsPerTick == processor.vanillaRate;
            if (managesBlockRate) {
                logicBlock.instructionsPerTick = desiredRate;
            }
            int currentBlockRate = logicBlock.instructionsPerTick;

            if (managesBlockRate) {
                EntityGroup<Building> buildings = Groups.build;
                buildings.each(building -> {
                    if (!(building instanceof LogicBlock.LogicBuild logicBuild)) return;
                    if (logicBuild.block != processor.block) return;

                    // New builds inherit instructionsPerTick. Existing builds
                    // follow live changes while carrying a vanilla/plugin rate.
                    if (logicBuild.ipt == oldRate || logicBuild.ipt == processor.vanillaRate) {
                        logicBuild.ipt = currentBlockRate;
                    }
                });
                processor.lastAppliedRate = currentBlockRate;
            }
        }
    }

    private static final class Processor {
        final Block block;
        final int vanillaRate;
        final String enabledKey;
        final String multiplierKey;
        int lastAppliedRate;

        Processor(Block block, int vanillaRate, String enabledKey, String multiplierKey) {
            this.block = block;
            this.vanillaRate = vanillaRate;
            this.enabledKey = enabledKey;
            this.multiplierKey = multiplierKey;
        }
    }
}
