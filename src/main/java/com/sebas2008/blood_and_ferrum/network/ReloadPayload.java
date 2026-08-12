package com.sebas2008.blood_and_ferrum.network;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record ReloadPayload() implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<ReloadPayload> TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Blood_and_Ferrum.MOD_ID, "reload_magazine"));

    public static final StreamCodec<FriendlyByteBuf, ReloadPayload> STREAM_CODEC =
            CustomPacketPayload.codec((payload, buffer) -> {}, buffer -> new ReloadPayload());
@NotNull
    @Override
    public CustomPacketPayload.Type<ReloadPayload> type() {
        return TYPE;
    }
}
