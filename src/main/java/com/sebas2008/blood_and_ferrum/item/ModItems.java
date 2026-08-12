package com.sebas2008.blood_and_ferrum.item;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.item.custom.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Blood_and_Ferrum.MOD_ID);

    public static final DeferredItem<Item> M1911_MAGAZINE = ITEMS.register(
            "m1911_magazine", () -> new MagazineItem(new Item.Properties()));

    public static final DeferredItem<Item> M1911_MAGAZINE_LOADED = ITEMS.register(
            "m1911_magazine_loaded", () -> new MagazineItem(new Item.Properties()));

    public static final DeferredHolder<Item, Item> C_CROSS = ITEMS.register(
            "c_cross", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item , Item> O_CROSS = ITEMS.register(
            "o_cross", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> COPPER_AND_ZINC = ITEMS.register(
            "r_c_zinc", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> RAW_LEAD = ITEMS.register(
            "r_l", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> BRASS = ITEMS.register(
            "brass", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> LEAD = ITEMS.register(
            "lead", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> RAW_IRON_COAL = ITEMS.register(
            "i_coal", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> RAW_ZINC = ITEMS.register(
            "r_zinc", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ZINC = ITEMS.register(
            "zinc", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> STEEL = ITEMS.register(
            "steel", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SILVER = ITEMS.register(
            "silver", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ACP45 = ITEMS.register(
            "45acp", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SHELL_45ACP = ITEMS.register(
            "shell_45acp", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> POINT_45ACP = ITEMS.register(
            "point_45acp", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> RAW_SILVER = ITEMS.register(
            "r_silver", () -> new Item(new Item.Properties()));

    public static final DeferredItem<PoweredCristianCrossItem> POWERED_CRISTIAN_CROSS = ITEMS.register(
            "p_c_c", () -> new PoweredCristianCrossItem(new Item.Properties().durability(PoweredCristianCrossItem.MAX_USES).stacksTo(1))
    );

    public static final DeferredItem<PoweredOrtodoxCrossItem> POWERED_ORTODOX_CROSS = ITEMS.register(
            "p_o_c", () -> new PoweredOrtodoxCrossItem(new Item.Properties().durability(PoweredCristianCrossItem.MAX_USES).stacksTo(1))
    );

    public static final DeferredHolder<Item, Item> YUURI_HELMET = ITEMS.register("yuuri_helmet",
            () -> new YuuriArmorItem(ModArmorMaterials.YUURI_ARMOR, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(18))));

    public static final DeferredHolder<Item, Item> YUURI_CHESTPLATE = ITEMS.register("yuuri_chestplate",
            () -> new YuuriArmorItem(ModArmorMaterials.YUURI_ARMOR, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(24))));

    public static final DeferredHolder<Item, Item> YUURI_LEGGINGS = ITEMS.register("yuuri_leggings",
            () -> new YuuriArmorItem(ModArmorMaterials.YUURI_ARMOR, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(18))));

    public static final DeferredHolder<Item, Item> YUURI_BOOTS = ITEMS.register("yuuri_boots",
            () -> new YuuriArmorItem(ModArmorMaterials.YUURI_ARMOR, ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(18))));



    public static final DeferredHolder<Item, Item> CHITO_HELMET = ITEMS.register("chito_helmet",
            () -> new ChitoArmorItem(ModArmorMaterials.CHITO_ARMOR, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(18))));

    public static final DeferredHolder<Item, Item> CHITO_CHESTPLATE = ITEMS.register("chito_chestplate",
            () -> new ChitoArmorItem(ModArmorMaterials.CHITO_ARMOR, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(24))));

    public static final DeferredHolder<Item, Item> CHITO_LEGGINGS = ITEMS.register("chito_leggings",
            () -> new ChitoArmorItem(ModArmorMaterials.CHITO_ARMOR, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(18))));

    public static final DeferredHolder<Item, Item> CHITO_BOOTS = ITEMS.register("chito_boots",
            () -> new ChitoArmorItem(ModArmorMaterials.CHITO_ARMOR, ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(18))));



    public static final DeferredHolder<Item, Item> DORAYAKI = ITEMS.register("dorayaki",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DORAYAKI)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}