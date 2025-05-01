package com.sebas2008.blood_and_ferrum.item;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Blood_and_Ferrum.MOD_ID);

public static final RegistryObject<Item> C_CROSS=ITEMS.register
        ("c_cross", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> O_CROSS=ITEMS.register
            ("o_cross", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_AND_ZINC=ITEMS.register
            ("r_c_zinc", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_LEAD=ITEMS.register
            ("r_l", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BRASS=ITEMS.register
            ("brass", ()-> new Item(new Item.Properties()));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
