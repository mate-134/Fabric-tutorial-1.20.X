package net.matija.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.matija.tutorialmod.block.ModBlocks;
import net.matija.tutorialmod.item.ModItemGroups;
import net.matija.tutorialmod.item.ModItems;
import net.matija.tutorialmod.sound.ModSounds;
import net.matija.tutorialmod.util.ModCustomTrades;
import net.matija.tutorialmod.util.ModLootTableModifiers;
import net.matija.tutorialmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();

		//for fuel items
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);

		//vanilla loot table modifications
		ModLootTableModifiers.modifyLootTables();

		//register trades
		ModCustomTrades.registerCustomTrades();

		//registering villagers
		ModVillagers.registerVillagers();

		//registering sounds
		ModSounds.registerSounds();
	}
}