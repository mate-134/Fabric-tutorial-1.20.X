package net.matija.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.matija.tutorialmod.block.ModBlocks;
import net.matija.tutorialmod.block.custom.CornCropBlock;
import net.matija.tutorialmod.block.custom.TomatoCropBlock;
import net.matija.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);

        //ore drops
        //addDrop(ModBlocks.RUBY_ORE, oreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY));   nazalost da samo enega
        //                                              silk touch drop       normal drop
        addDrop(ModBlocks.RUBY_ORE, betterOreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY, 2f, 5f));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, betterOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY, 2f, 5f));
        addDrop(ModBlocks.NETHER_RUBY_ORE, betterOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY, 2f, 5f));
        addDrop(ModBlocks.END_RUBY_ORE, betterOreDrops(ModBlocks.END_RUBY_ORE, ModItems.RAW_RUBY, 4f, 7f));


        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_TRAPDOOR);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);

        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));

        // crop
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5)); // makes it sp ot only drops when the age is 5
        addDrop(ModBlocks.TOMATO_CROP, cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder));

        //corn (2 block high)
        AnyOfLootCondition.Builder builder2 =
                BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 7))
                        .or(BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 8)));

        //BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
        //         .exactMatch(CornCropBlock.AGE, 8));

        addDrop(ModBlocks.CORN_CROP, cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, builder2));

        //flowers
        addDrop(ModBlocks.DAHLIA);
        addPottedPlantDrops(ModBlocks.POTTED_DAHLIA);

    }

    public LootTable.Builder betterOreDrops(Block drop, Item item, float min, float max) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                //amount dropped
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
