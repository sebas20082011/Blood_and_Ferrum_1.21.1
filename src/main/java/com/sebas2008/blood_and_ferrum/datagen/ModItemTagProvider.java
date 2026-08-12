package com.sebas2008.blood_and_ferrum.datagen;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    // Correct tag path in 1.21+ for powder snow walking
    public static final TagKey<Item> POWDER_SNOW_WALKABLE =
            ItemTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "powder_snow_walkable_wearables"));

    // Tag for preventing freeze damage
    public static final TagKey<Item> FREEZE_IMMUNE =
            ItemTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "freeze_immune_wearables"));

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Blood_and_Ferrum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Walk on top of powder snow without sinking
        this.tag(POWDER_SNOW_WALKABLE)
                .add(ModItems.YUURI_BOOTS.get())
                .add(ModItems.CHITO_BOOTS.get());

        // Prevent taking damage / freezing in powder snow
        this.tag(FREEZE_IMMUNE)
                .add(ModItems.YUURI_BOOTS.get())
                .add(ModItems.CHITO_BOOTS.get());
    }
}











