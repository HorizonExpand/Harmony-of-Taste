package net.hrumer.harmony_of_taste;

import net.hrumer.harmony_of_taste.init.HarmonyOfTasteBlocks;
import net.hrumer.harmony_of_taste.init.HarmonyOfTasteCreativeTabs;
import net.hrumer.harmony_of_taste.init.HarmonyOfTasteItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(HarmonyOfTaste.MODID)
public class HarmonyOfTaste {
    public static final String MODID = "harmony_of_taste";

    public HarmonyOfTaste(IEventBus modEventBus) {
        HarmonyOfTasteBlocks.BLOCKS.register(modEventBus);
        HarmonyOfTasteItems.ITEMS.register(modEventBus);
        HarmonyOfTasteCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }

}
