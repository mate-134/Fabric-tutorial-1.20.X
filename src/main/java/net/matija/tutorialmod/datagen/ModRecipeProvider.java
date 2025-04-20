package net.matija.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.matija.tutorialmod.block.ModBlocks;
import net.matija.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;


import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(
            ModItems.RAW_RUBY, ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter consumer) {
        offerSmelting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "mod");
        offerBlasting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "mod");

        //block recipes
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY,
                RecipeCategory.MISC, ModBlocks.RUBY_BLOCK);

        //custom                             category            outcome       count
        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.MUG, 3)
                .pattern("# #")
                .pattern(" # ")
                .input('#', Items.CLAY_BALL)
                //needed for the recipe to generate (the criteria to unlock the recipe in the recipe book)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                //sets the name
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.MUG)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.CHOCOLATE_MILK, 1)
                .input(ModItems.MUG)
                .input(Items.COCOA_BEANS)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(ModItems.MUG), conditionsFromItem(ModItems.MUG))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHOCOLATE_MILK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE, 3)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHEESE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SALAMI, 3)
                .input(Items.PORKCHOP)
                .criterion(hasItem(Items.PORKCHOP), conditionsFromItem(Items.PORKCHOP))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SALAMI)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SANDWICH, 1)
                .input(Items.BREAD)
                .input(ModItems.TOMATO)
                .input(ModItems.CHEESE)
                .input(ModItems.SALAMI)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SANDWICH)));

        //tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE, 1)
                .pattern("###")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('#', ModItems.RUBY)
                .input('1', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.RUBY_PICKAXE)));

        //seeds
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOMATO_SEEDS, 3)
                .input(ModItems.TOMATO)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.TOMATO_SEEDS)));

    }
}
