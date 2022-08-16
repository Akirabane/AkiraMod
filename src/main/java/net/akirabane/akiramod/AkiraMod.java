package net.akirabane.akiramod;

import net.akirabane.akiramod.block.ModBlocks;
import net.akirabane.akiramod.item.ModItems;
import net.akirabane.akiramod.world.feature.ModConfiguredFeatures;
import net.akirabane.akiramod.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AkiraMod implements ModInitializer {
	public static final String MOD_ID = "akiramod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();
		ModOreGeneration.generateOres();

		ModItems.registerModItems();
		ModBlocks.registerModBLocks();
	}
}
