package net.matija.tutorialmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(2).saturationModifier(.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();

    public static final FoodComponent CHOCOLATE_MILK = new FoodComponent.Builder().alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 3600), 100f).build();

    public static final FoodComponent CHEESE = new FoodComponent.Builder().hunger(2)
            .saturationModifier(.2f).build();

    public static final FoodComponent SALAMI = new FoodComponent.Builder().hunger(3)
            .saturationModifier(.25f).build();

    public static final FoodComponent SANDWICH = new FoodComponent.Builder().hunger(13)
            .saturationModifier(.5f).build();

    public static final FoodComponent CORN = new FoodComponent.Builder().hunger(3).saturationModifier(.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();
}
