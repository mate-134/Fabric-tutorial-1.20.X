package net.matija.tutorialmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.matija.tutorialmod.block.ModBlocks;
import net.matija.tutorialmod.item.ModItems;
import net.matija.tutorialmod.villager.ModVillagers;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades{

    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    //one trade
                    factories.add((entity, random) -> new TradeOffer(
                            //cost
                            new ItemStack(Items.EMERALD, 2),
                            //product
                            new ItemStack(ModItems.TOMATO, 12),
                            6,5,0.05f));

                    //the second trade
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 7),
                            new ItemStack(ModItems.TOMATO, 2),
                            3,7,0.08f));
                });

        //trades a villager gets at level 2
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.CORN, 22),
                            new ItemStack(Items.EMERALD, 6),
                            4,8,0.05f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GOLD_INGOT, 5),
                            new ItemStack(Items.WHEAT_SEEDS, 4),
                            new ItemStack(ModItems.CORN_SEEDS, 4),
                            3,10,0.08f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 24),
                            //how to get an enchanted book trade
                            EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SWIFT_SNEAK, 2)),
                            2, 12,0.075f));
                });

        //for a wandering trader
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RAW_RUBY, 12),
                            new ItemStack(ModItems.METAL_DETECTOR, 1),
                            2, 12,0.075f));
                });

        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 12),
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(ModItems.CHOCOLATE_MILK, 1),
                            2, 12,0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER,2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 12),
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModBlocks.SOUND_BLOCK, 1),
                            1, 0,0.0f));
                });

    }
}
