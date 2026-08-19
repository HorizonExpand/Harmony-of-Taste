package net.hrumer.harmony_of_taste;

import net.hrumer.harmony_of_taste.init.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForgeMod;

@Mod(HarmonyOfTaste.MODID)
public class HarmonyOfTaste {
    public static final String MODID = "harmony_of_taste";

    public HarmonyOfTaste(IEventBus modEventBus) {
        HarmonyOfTasteBlocks.registry(modEventBus);
        HarmonyOfTasteItems.registry(modEventBus);
        HarmonyOfTasteCreativeTabs.registry(modEventBus);
        HarmonyOfTasteFeatures.register(modEventBus);
        HarmonyOfTasteFluids.register(modEventBus);
        HarmonyOfTasteDataComponents.register(modEventBus);
        NeoForgeMod.enableMilkFluid();
    }

}
