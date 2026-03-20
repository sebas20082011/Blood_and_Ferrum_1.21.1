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



        if (this.rightLeg != null) {
            this.rightLeg.setRotX(-this.rightLeg.getRotX());
        }
        if (this.leftLeg != null) {
            this.leftLeg.setRotX(-this.leftLeg.getRotX());
        }
        if (this.rightBoot != null) {
            this.rightBoot.setRotX(-this.rightBoot.getRotX());
        }
        if (this.leftBoot != null) {
            this.leftBoot.setRotX(-this.leftBoot.getRotX());
        }
    }
}

