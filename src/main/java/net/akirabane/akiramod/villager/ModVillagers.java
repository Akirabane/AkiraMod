package net.akirabane.akiramod.villager;

import com.google.common.collect.ImmutableSet;
import net.akirabane.akiramod.AkiraMod;
import net.akirabane.akiramod.block.ModBlocks;
import net.akirabane.akiramod.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final PointOfInterestType RAW_POI = registerPOI("raw_poi", ModBlocks.RAW_MYTHRIL_BLOCK);
    public static final VillagerProfession RAW_MASTER = registerProfession("rawmaster",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(AkiraMod.MOD_ID, "raw_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(AkiraMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(AkiraMod.MOD_ID)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(AkiraMod.MOD_ID, name),
                1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers() {
        AkiraMod.LOGGER.debug("Registering Villagers for " + AkiraMod.MOD_ID);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(RAW_MASTER, 1,
                factories -> {
            factories.add(((entity, random) -> new TradeOffer(
               new ItemStack(ModItems.MYTHRIL_RAW, 3),
                    new ItemStack(ModItems.MYTHRIL_NUGGET, 5),
                    6, 2, 0.02f
            )));
                });
    }
}
