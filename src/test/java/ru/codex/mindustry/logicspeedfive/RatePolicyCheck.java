package ru.codex.mindustry.logicspeedfive;

/** Small no-game regression check for defaults, toggles, and slider bounds. */
public final class RatePolicyCheck {
    public static void main(String[] args) {
        int[] vanillaRates = {2, 8, 25};
        for (int vanilla : vanillaRates) {
            require(RatePolicy.effectiveRate(vanilla, true, true, 5) == vanilla * 5, "default 5x");
            require(RatePolicy.effectiveRate(vanilla, false, true, 5) == vanilla, "master off");
            require(RatePolicy.effectiveRate(vanilla, true, false, 5) == vanilla, "processor off");
            for (int multiplier = 1; multiplier <= 15; multiplier++) {
                require(RatePolicy.effectiveRate(vanilla, true, true, multiplier) == vanilla * multiplier,
                    "multiplier " + multiplier + "x");
            }
            require(RatePolicy.effectiveRate(vanilla, true, true, Integer.MIN_VALUE) == vanilla, "lower clamp");
            require(RatePolicy.effectiveRate(vanilla, true, true, Integer.MAX_VALUE) == vanilla * 15, "upper clamp");
        }
        System.out.println("Rate policy checks passed for micro, logic, and hyper processors.");
    }

    private static void require(boolean condition, String label) {
        if (!condition) throw new AssertionError(label);
    }
}
