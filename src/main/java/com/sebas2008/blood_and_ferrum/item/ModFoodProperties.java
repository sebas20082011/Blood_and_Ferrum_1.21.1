package com.sebas2008.blood_and_ferrum.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties DORAYAKI = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(3).effect(new MobEffectInstance(MobEffects.LUCK, 150),0.30f).fast().build();
}
