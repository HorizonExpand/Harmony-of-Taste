package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class HarmonyOfTasteFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, HarmonyOfTaste.MODID);

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, HarmonyOfTaste.MODID);
    
    public static final DeferredHolder<FluidType, FluidType> GOAT_MILK_TYPE =
            FLUID_TYPES.register("goat_milk", () ->
                    new FluidType(FluidType.Properties.create()
                            .descriptionId("fluid.harmony_of_taste.goat_milk")
                            .density(1024)
                            .viscosity(1024)
                            .temperature(300)
                            .canExtinguish(true)
                            .fallDistanceModifier(0.0F)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
                    ));

    public static final DeferredHolder<Fluid, FlowingFluid> GOAT_MILK =
            FLUIDS.register("goat_milk", () -> new BaseFlowingFluid.Source(makeProperties()));

    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_GOAT_MILK =
            FLUIDS.register("flowing_goat_milk", () -> new BaseFlowingFluid.Flowing(makeProperties()));

    private static BaseFlowingFluid.Properties makeProperties() {
        return new BaseFlowingFluid.Properties(
                GOAT_MILK_TYPE,
                GOAT_MILK,
                FLOWING_GOAT_MILK
        ).bucket(HarmonyOfTasteItems.GOAT_MILK_BUCKET);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
    }
}
