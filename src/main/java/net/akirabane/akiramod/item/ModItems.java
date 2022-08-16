package net.akirabane.akiramod.item;

import net.akirabane.akiramod.AkiraMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AkiraMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AkiraMod.LOGGER.info("Registering Mod Items for " + AkiraMod.MOD_ID);
    }
}
