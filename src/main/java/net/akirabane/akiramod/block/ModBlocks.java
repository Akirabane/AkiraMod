package net.akirabane.akiramod.block;

import net.akirabane.akiramod.AkiraMod;
import net.akirabane.akiramod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.15f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(0.09f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(0.09f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block NETHER_MYTHRIL_ORE = registerBlock("nether_mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(0.09f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.15f).requiresTool()), ModItemGroup.MYTHRIL);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(AkiraMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(AkiraMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBLocks() {
        AkiraMod.LOGGER.info("Registering ModBlocks for " + AkiraMod.MOD_ID);
    }
}
