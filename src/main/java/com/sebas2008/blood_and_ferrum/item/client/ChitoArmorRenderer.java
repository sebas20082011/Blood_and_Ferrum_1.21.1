package com.sebas2008.blood_and_ferrum.item.client;

import com.sebas2008.blood_and_ferrum.item.custom.ChitoArmorItem;
import com.sebas2008.blood_and_ferrum.item.custom.YuuriArmorItem;
import net.minecraft.client.model.HumanoidModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class ChitoArmorRenderer extends GeoArmorRenderer<ChitoArmorItem> {
    public ChitoArmorRenderer() {
        super(new ChitoArmorModel());
    }

    }

