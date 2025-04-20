package net.matija.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.matija.tutorialmod.block.ModBlocks;
import net.matija.tutorialmod.entity.ModEntities;
import net.matija.tutorialmod.entity.custom.PorcupineEntity;
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
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
	}
}
