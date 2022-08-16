package net.akirabane.akiramod;

import net.akirabane.akiramod.block.ModBlocks;
import net.akirabane.akiramod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AkiraMod implements ModInitializer {
	public static final String MOD_ID = "akiramod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBLocks();
	}
}
