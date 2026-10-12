package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;

import net.hrumer.harmony_of_taste.util.CreativeModeTabProviders;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import xox.labvorty.vortylib.data.creative_tab.ExpandableCreativeTab;

import java.util.List;
import java.util.function.Supplier;

public class HarmonyOfTasteCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HarmonyOfTaste.MODID);
    public static final DeferredRegister<CreativeModeTab> VORTY_LIB_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HarmonyOfTaste.MODID);

    public static final Supplier<CreativeModeTab> HARMONY_OF_TASTE_TAB = CREATIVE_MODE_TABS.register("harmony_of_taste_items_tab", () -> CreativeModeTab.builder()
            .icon(HarmonyOfTasteItems.CHAMPIGNON_ITEM::toStack)
            .title(Component.translatable("itemGroup.harmony_of_taste"))
            .displayItems((itemDisplayParameters, output) -> {
                output.acceptAll(CreativeModeTabProviders.getAllItems());
            })
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HARMONY_OF_TASTE_VORTY_LIB_TAB = VORTY_LIB_TABS.register("harmony_of_taste_items_vortylib_tab", () -> ExpandableCreativeTab.builder()
            .addGroup("champignon", HarmonyOfTasteItems.CHAMPIGNON_ITEM.toStack(), CreativeModeTabProviders.getChampignonGroup())
            .addGroup("goat", HarmonyOfTasteItems.RAW_GOAT_MEAT.toStack(), CreativeModeTabProviders.getGoatGroup())
            .addGroup("hay_blocks", HarmonyOfTasteItems.HAY_SLAB_ITEM.toStack(), CreativeModeTabProviders.getHayBlocks())
            .icon(HarmonyOfTasteItems.CHAMPIGNON_ITEM::toStack)
            .title(Component.translatable("itemGroup.harmony_of_taste"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(HarmonyOfTasteItems.MILK_BOTTLE);
            })
            .build());

    public static void registry(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void registryVortyLib(IEventBus eventBus) {
        VORTY_LIB_TABS.register(eventBus);
    }
}
