package net.akirabane.akiramod.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> MYTHRIL_ORE_PLACED = PlacedFeatures.register("mythril_ore_placed",
            ModConfiguredFeatures.MYTHRIL_ORE, modifiersWithCount(7,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80),
                            YOffset.aboveBottom(80))));

    public static final RegistryEntry<PlacedFeature> NETHER_MYTHRIL_ORE_PLACED = PlacedFeatures.register("nether_mythril_ore_placed",
            ModConfiguredFeatures.NETHER_MYTHRIL_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80),
                            YOffset.aboveBottom(80))));

    public static final RegistryEntry<PlacedFeature> END_MYTHRIL_ORE_PLACED = PlacedFeatures.register("end_raw_mythril_block_placed",
            ModConfiguredFeatures.END_MYTHRIL_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80),
                            YOffset.aboveBottom(80))));

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
