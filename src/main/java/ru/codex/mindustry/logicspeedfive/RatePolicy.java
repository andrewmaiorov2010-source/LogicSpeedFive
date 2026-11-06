package ru.codex.mindustry.logicspeedfive;

/** Pure settings-to-instruction-rate policy, kept independent of game runtime APIs. */
final class RatePolicy {
    private RatePolicy() {}

    static int effectiveRate(int vanillaRate, boolean globallyEnabled, boolean processorEnabled, int multiplier) {
        if (!globallyEnabled || !processorEnabled) return vanillaRate;
        int boundedMultiplier = Math.max(1, Math.min(15, multiplier));
        return vanillaRate * boundedMultiplier;
    }
}
