package net.matija.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.matija.tutorialmod.TutorialMod;
import net.matija.tutorialmod.block.ModBlocks;
import net.matija.tutorialmod.item.custom.MetalDetectorItem;
import net.matija.tutorialmod.item.custom.ModArmorItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //class thar registers all our custom items

    //adding an item
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item MUG = registerItem("mug", new Item(new FabricItemSettings().maxCount(16)));

    //advanced item
    public static Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    //food item
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item CHOCOLATE_MILK = registerItem("chocolate_milk",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHOCOLATE_MILK)));

    public static final Item CHEESE = registerItem("cheese",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHEESE)));

    public static final Item SALAMI = registerItem("salami",
            new Item(new FabricItemSettings().food(ModFoodComponents.SALAMI)));

    public static final Item SANDWICH = registerItem("sandwich",
            new Item(new FabricItemSettings().food(ModFoodComponents.SANDWICH)));

    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));


    //fuel item
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette", new Item(new FabricItemSettings()));

    //3d model
    public static final Item RUBY_STAFF = registerItem("ruby_staff",
            new Item(new FabricItemSettings().maxCount(1)));

    //tools
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, 2, 2f,  new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
                new AxeItem(ModToolMaterial.RUBY, 5, 1f,  new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
                new ShovelItem(ModToolMaterial.RUBY, 2, 2f,  new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
                new HoeItem(ModToolMaterial.RUBY, 2, 2.5f,  new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
                new SwordItem(ModToolMaterial.RUBY, 4, 3f,  new FabricItemSettings()));

    //armor
    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //seeds
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));
    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);

    }

    //actually registering the item
    public static Item registerItem(String name, Item item){
        //important that it is the net.minecraft.registry (look at imports)
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        //just a message
        TutorialMod.LOGGER.info("Registstering mod items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
