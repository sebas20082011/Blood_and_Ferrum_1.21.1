package com.sebas2008.blood_and_ferrum.item.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;


@EventBusSubscriber(modid = "bloodandferrum", value = Dist.CLIENT)
public class KeyMappings {

    public static final KeyMapping RELOAD_KEY = new KeyMapping(
            "key.bloodandferrum.reload",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "key.categories.bloodandferrum"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(RELOAD_KEY);
    }
}
