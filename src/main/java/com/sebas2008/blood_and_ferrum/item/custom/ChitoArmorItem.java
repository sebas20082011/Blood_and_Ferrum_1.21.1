package com.sebas2008.blood_and_ferrum.item.custom;

import com.sebas2008.blood_and_ferrum.effect.ModEffects;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import com.sebas2008.blood_and_ferrum.item.client.ChitoArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public final class ChitoArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ChitoArmorItem(Holder<ArmorMaterial> armorMaterial, ArmorItem.Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }



    @Override
    public boolean isValidRepairItem(@NotNull ItemStack toRepair, @NotNull ItemStack repair) {
        return switch (this.getType()) {
            case HELMET -> repair.is(ModItems.STEEL.get());
            case CHESTPLATE, LEGGINGS -> repair.is(Items.GREEN_WOOL);
            case BOOTS -> repair.is(Items.LEATHER);
            default -> false;
        };
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull net.minecraft.world.entity.Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide() && entity instanceof Player player) {
            if (this.type == ArmorItem.Type.CHESTPLATE && hasFullSetOfArmor(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    private boolean hasFullSetOfArmor(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);

        return !helmet.isEmpty() && helmet.is(ModItems.CHITO_HELMET.get()) &&
                !chestplate.isEmpty() && chestplate.is(ModItems.CHITO_CHESTPLATE.get()) &&
                !leggings.isEmpty() && leggings.is(ModItems.CHITO_LEGGINGS.get()) &&
                !boots.isEmpty() && boots.is(ModItems.CHITO_BOOTS.get());
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(ModEffects.INGENUITY)) {
            player.addEffect(new MobEffectInstance(ModEffects.INGENUITY, 200, 1, true, false, true));
        }
        if (!player.hasEffect(MobEffects.WEAKNESS)) {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0, true, false, true));
        }
        if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2, true, false, true));
        }
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
                if (this.renderer == null) {
                    this.renderer = new ChitoArmorRenderer();
                }
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 20, state -> {
            state.getController().setAnimation(RawAnimation.begin()
                    .then("animation.chito_armor.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}