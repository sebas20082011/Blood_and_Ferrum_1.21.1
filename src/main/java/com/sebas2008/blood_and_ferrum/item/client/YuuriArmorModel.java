package com.sebas2008.blood_and_ferrum.item.client;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.item.custom.YuuriArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YuuriArmorModel extends GeoModel<YuuriArmorItem> {

    @Override
    public ResourceLocation getModelResource(YuuriArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Blood_and_Ferrum.MOD_ID, "geo/armor/yuuri_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(YuuriArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Blood_and_Ferrum.MOD_ID, "textures/models/armor/yuuri_armor_layer_1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(YuuriArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Blood_and_Ferrum.MOD_ID, "animations/yuuri_armor.animation.json");
    }
}