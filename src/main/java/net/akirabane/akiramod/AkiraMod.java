package net.akirabane.akiramod;

import net.akirabane.akiramod.block.ModBlocks;
import net.akirabane.akiramod.event.ThirstTickHandler;
import net.akirabane.akiramod.item.ModItems;
import net.akirabane.akiramod.networking.ModMessages;
import net.akirabane.akiramod.villager.ModVillagers;
import net.akirabane.akiramod.world.feature.ModConfiguredFeatures;
import net.akirabane.akiramod.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AkiraMod implements ModInitializer {
	public static final String MOD_ID = "akiramod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		//Ore management
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModOreGeneration.generateOres();

		//Items & blocks management
		ModItems.registerModItems();
		ModBlocks.registerModBLocks();

		//entity management
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		//Client to server packet registering
		ModMessages.registerC2SPackets();

		//Thirst tick management
		ServerTickEvents.START_SERVER_TICK.register(new ThirstTickHandler());
	}
}
