package com.sebas2008.blood_and_ferrum.components;

import com.mojang.serialization.Codec;
import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Blood_and_Ferrum.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> AMMO =
            DATA_COMPONENT_TYPES.register("ammo",
                    () -> DataComponentType.<Integer>builder().persistent(Codec.INT).build());

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
