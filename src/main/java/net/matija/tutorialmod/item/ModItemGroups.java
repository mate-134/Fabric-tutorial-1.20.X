package net.matija.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.matija.tutorialmod.TutorialMod;
import net.matija.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //creating a custom ItemGroup
    //important that it is the net.minecraft.registry (look at imports)
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "mod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mod"))
                    .icon(() -> new ItemStack(ModItems.RUBY))
                    .entries((displayContext, entries) -> {

                        //here is where you add all the items to the group
                        //you can also add vanilla items to a custom group
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.MUG);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.END_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);

                        entries.add(ModItems.METAL_DETECTOR);

                        entries.add(ModBlocks.SOUND_BLOCK);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.CHOCOLATE_MILK);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.SALAMI);
                        entries.add(ModItems.SANDWICH);
                        entries.add(ModItems.CORN);

                        entries.add(ModItems.COAL_BRIQUETTE);

                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_SLAB);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_WALL);
                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);

                        entries.add(ModItems.RUBY_STAFF);

                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_SWORD);

                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);

                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.CORN_SEEDS);

                        entries.add(ModBlocks.DAHLIA);

                    }).build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering item groups for " + TutorialMod.MOD_ID);
    }
}
