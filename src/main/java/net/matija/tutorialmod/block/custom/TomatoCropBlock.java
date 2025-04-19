package net.matija.tutorialmod.block.custom;

import net.matija.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class TomatoCropBlock extends CropBlock {
    //if it's made just as variable here it's shared with all other instances
    public static final int MAX_AGE = 5;

    //if it's like this it's separate for each crop
    public static final IntProperty AGE = Properties.AGE_5;  //or IntProperty.of("age", 0,5)

    public TomatoCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.TOMATO_SEEDS;
    }

    //don't forget to make this one public
    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
