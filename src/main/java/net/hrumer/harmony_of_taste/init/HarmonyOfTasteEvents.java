package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.fluids.capability.templates.FluidHandlerItemStackSimple;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;

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

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(
                Capabilities.FluidHandler.ITEM,
                (stack, context) -> new FluidBucketWrapper(stack),
                HarmonyOfTasteItems.GOAT_MILK_BUCKET.get());
        event.registerItem(
                Capabilities.FluidHandler.ITEM,
                (stack, context) -> new FluidHandlerItemStackSimple(
                        () -> HarmonyOfTasteDataComponents.FLUID_CONTENT.get(),
                        stack,
                        250),
                HarmonyOfTasteItems.GOAT_MILK_BOTTLE.get());
        event.registerItem(
                Capabilities.FluidHandler.ITEM,
                (stack, context) -> new FluidHandlerItemStackSimple(
                        () -> HarmonyOfTasteDataComponents.FLUID_CONTENT.get(),
                        stack,
                        250),
                HarmonyOfTasteItems.COW_MILK_BOTTLE.get());
    }

    @SubscribeEvent
    public static void modifyComponents(ModifyDefaultComponentsEvent event) {
        event.modify(Items.MILK_BUCKET, builder -> {
            builder.set(
                    DataComponents.FOOD,
                    new FoodProperties.Builder()
                            .nutrition(6)
                            .saturationModifier(0.6f)
                            .alwaysEdible()
                            .build());
        });
    }
}