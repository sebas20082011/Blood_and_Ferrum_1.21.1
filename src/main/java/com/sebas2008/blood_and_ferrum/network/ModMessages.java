package com.sebas2008.blood_and_ferrum.network;

import com.sebas2008.blood_and_ferrum.item.custom.MagazineReloadHandler;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModMessages {

    public static void register(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");

        registrar.playToServer(
                ReloadPayload.TYPE,
                ReloadPayload.STREAM_CODEC,
                (payload, context) -> context.enqueueWork(() -> {
                    if (context.player() instanceof ServerPlayer player) {
                        MagazineReloadHandler.handleMagazineReload(player);
                    }
                })
        );
    }
}
