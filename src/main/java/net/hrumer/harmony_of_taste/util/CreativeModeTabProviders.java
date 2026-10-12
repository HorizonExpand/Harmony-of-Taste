package net.hrumer.harmony_of_taste.util;

import net.hrumer.harmony_of_taste.init.HarmonyOfTasteItems;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CreativeModeTabProviders {
    
    public static List<ItemStack> getAllItems() {
        return List.of(
                HarmonyOfTasteItems.CHAMPIGNON_ITEM.toStack(),
                HarmonyOfTasteItems.CHAMPIGNON_BLOCK_ITEM.toStack(),

                HarmonyOfTasteItems.RAW_GOAT_MEAT.toStack(),
                HarmonyOfTasteItems.COOKED_GOAT_MEAT.toStack(),
                HarmonyOfTasteItems.GOAT_MILK_BUCKET.toStack(),
                HarmonyOfTasteItems.GOAT_MILK_BOTTLE.toStack(),

                HarmonyOfTasteItems.MILK_BOTTLE.toStack(),

                HarmonyOfTasteItems.HAY_SLAB_ITEM.toStack(),
                HarmonyOfTasteItems.HAY_STAIRS_ITEM.toStack()
        );
    }

    public static List<ItemStack> getChampignonGroup() {
        return List.of(
                HarmonyOfTasteItems.CHAMPIGNON_ITEM.toStack(),
                HarmonyOfTasteItems.CHAMPIGNON_BLOCK_ITEM.toStack()
        );
    }
    
    public static List<ItemStack> getGoatGroup() {
        return List.of(
                HarmonyOfTasteItems.RAW_GOAT_MEAT.toStack(),
                HarmonyOfTasteItems.COOKED_GOAT_MEAT.toStack(),
                HarmonyOfTasteItems.GOAT_MILK_BUCKET.toStack(),
                HarmonyOfTasteItems.GOAT_MILK_BOTTLE.toStack()
        );
    }

    public static List<ItemStack> getHayBlocks() {
        return List.of(
                HarmonyOfTasteItems.HAY_SLAB_ITEM.toStack(),
                HarmonyOfTasteItems.HAY_STAIRS_ITEM.toStack()
        );
    }
}
