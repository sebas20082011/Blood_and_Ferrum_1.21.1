package com.sebas2008.blood_and_ferrum.item.client;

import com.sebas2008.blood_and_ferrum.item.custom.YuuriArmorItem;
import net.minecraft.client.model.HumanoidModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class YuuriArmorRenderer extends GeoArmorRenderer<YuuriArmorItem> {
    public YuuriArmorRenderer() {
        super(new YuuriArmorModel());
    }

    @Override
    protected void applyBaseTransformations(HumanoidModel<?> baseModel) {
        super.applyBaseTransformations(baseModel);

        if (this.head != null) {
            this.head.setRotX(-this.head.getRotX());
        }




        if (baseModel.crouching) {
            if (this.body != null) {
                this.body.setRotX(-this.body.getRotX());

            }
        }
    }}

