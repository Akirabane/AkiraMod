package net.akirabane.akiramod.item;

import net.akirabane.akiramod.AkiraMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_NUGGET = registerItem("mythril_nugget",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_RAW = registerItem("mythril_raw",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_HELMET = registerItem("mythril_helmet",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_CHESTPLATE = registerItem("mythril_chestplate",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_LEGGINGS = registerItem("mythril_leggings",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_BOOTS = registerItem("mythril_boots",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_SWORD = registerItem("mythril_sword",
            new SwordItem(ToolMaterials.NETHERITE, 15, 7f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AkiraMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AkiraMod.LOGGER.info("Registering Mod Items for " + AkiraMod.MOD_ID);
    }
}
