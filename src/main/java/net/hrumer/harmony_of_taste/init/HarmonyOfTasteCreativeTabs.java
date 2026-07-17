package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HarmonyOfTasteCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HarmonyOfTaste.MODID);

    public static final Supplier<CreativeModeTab> HARMONY_OF_TASTE_TAB = CREATIVE_MODE_TABS.register("harmony_of_taste_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(HarmonyOfTasteItems.CHAMPIGNON_ITEM.get()))
            .title(Component.translatable("itemGroup.harmony_of_taste"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(HarmonyOfTasteItems.CHAMPIGNON_ITEM);
                output.accept(HarmonyOfTasteItems.CHAMPIGNON_STEM_ITEM);
                output.accept(HarmonyOfTasteItems.CHAMPIGNON_BLOCK_ITEM);
                output.accept(HarmonyOfTasteItems.RAW_GOAT_MEAT);
                output.accept(HarmonyOfTasteItems.COOKED_GOAT_MEAT);
            })
            .build());

    public static void registry(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
