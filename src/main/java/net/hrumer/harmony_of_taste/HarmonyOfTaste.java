package net.hrumer.harmony_of_taste;

import net.hrumer.harmony_of_taste.init.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForgeMod;

@Mod(HarmonyOfTaste.MODID)
public class HarmonyOfTaste {
    public static final String MODID = "harmony_of_taste";

    public HarmonyOfTaste(IEventBus eventBus) {
        HarmonyOfTasteBlocks.registry(eventBus);
        HarmonyOfTasteItems.registry(eventBus);
        HarmonyOfTasteFeatures.register(eventBus);
        HarmonyOfTasteFluids.register(eventBus);
        HarmonyOfTasteDataComponents.register(eventBus);
        
        NeoForgeMod.enableMilkFluid();

        if (ModList.get().isLoaded("vortylib")) {
            HarmonyOfTasteCreativeTabs.registryVortyLib(eventBus);
        } else {
            HarmonyOfTasteCreativeTabs.registry(eventBus);
        }
    }
}
