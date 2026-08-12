package com.sebas2008.blood_and_ferrum.effect;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Blood_and_Ferrum.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> INGENUITY = MOB_EFFECTS.register("ingenuity",
            () -> new IngenuityEffect(MobEffectCategory.BENEFICIAL, 0xFFB100));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}



