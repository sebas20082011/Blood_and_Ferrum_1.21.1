package com.sebas2008.blood_and_ferrum.item.client;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.item.custom.ChitoArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

@SuppressWarnings("deprecation")
public class ChitoArmorModel extends GeoModel<ChitoArmorItem> {

    @Override
    public ResourceLocation getModelResource(ChitoArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Blood_and_Ferrum.MOD_ID, "geo/armor/chito_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChitoArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Blood_and_Ferrum.MOD_ID, "textures/models/armor/chito_armor_layer_1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChitoArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Blood_and_Ferrum.MOD_ID, "animations/chito_armor.animation.json");
    }
}