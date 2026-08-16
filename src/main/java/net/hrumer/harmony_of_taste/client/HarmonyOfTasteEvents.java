package net.hrumer.harmony_of_taste.client;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;
import net.hrumer.harmony_of_taste.init.HarmonyOfTasteFluids;

import net.minecraft.resources.ResourceLocation;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = HarmonyOfTaste.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HarmonyOfTasteEvents {

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {

            private static final ResourceLocation STILL =
                    ResourceLocation.fromNamespaceAndPath("neoforge", "block/milk_still");
            private static final ResourceLocation FLOWING =
                    ResourceLocation.fromNamespaceAndPath("neoforge", "block/milk_flowing");

            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING;
            }

            @Override
            public int getTintColor() {
                return 0xFFE6E6DA;
            }

        }, HarmonyOfTasteFluids.GOAT_MILK_TYPE.value());
    }
}