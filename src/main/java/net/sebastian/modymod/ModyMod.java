package net.sebastian.modymod;

import net.fabricmc.api.ModInitializer;

import net.sebastian.modymod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModyMod implements ModInitializer {
	public static final String MOD_ID = "modymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}