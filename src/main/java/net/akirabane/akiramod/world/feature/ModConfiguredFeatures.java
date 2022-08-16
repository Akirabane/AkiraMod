package net.akirabane.akiramod.world.feature;

import net.akirabane.akiramod.AkiraMod;
import net.akirabane.akiramod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_MYTHRIL_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MYTHRIL_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MYTHRIL_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> NETHER_MYTHRIL_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ModBlocks.NETHER_MYTHRIL_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> END_MYTHRIL_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.RAW_MYTHRIL_BLOCK.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MYTHRIL_ORE =
            ConfiguredFeatures.register("mythril_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_MYTHRIL_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_MYTHRIL_ORE =
            ConfiguredFeatures.register("nether_mythril_ore", Feature.ORE, new OreFeatureConfig(NETHER_MYTHRIL_ORES, 12));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_MYTHRIL_ORE =
            ConfiguredFeatures.register("raw_mythril_block", Feature.ORE, new OreFeatureConfig(END_MYTHRIL_ORES, 12));
    public static void registerConfiguredFeatures() {
        AkiraMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + AkiraMod.MOD_ID);
    }
}
