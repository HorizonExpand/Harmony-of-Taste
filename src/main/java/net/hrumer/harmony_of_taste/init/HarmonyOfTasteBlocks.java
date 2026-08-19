package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;
import net.hrumer.harmony_of_taste.content.blocks.HaySlabBlock;
import net.hrumer.harmony_of_taste.content.blocks.HayStairsBlock;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HarmonyOfTasteBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HarmonyOfTaste.MODID);

    public static final DeferredBlock<Block> CHAMPIGNON = BLOCKS.register("champignon", () -> new MushroomBlock(HarmonyOfTasteFeatures.HUGE_CHAMPIGNON.getKey(),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((p_50892_) -> 1).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> POTTED_CHAMPIGNON = BLOCKS.register("potted_champignon", () -> new FlowerPotBlock(CHAMPIGNON.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CHAMPIGNON_STEM = BLOCKS.register("champignon_stem", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> CHAMPIGNON_BLOCK = BLOCKS.register("champignon_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> HAY_SLAB = BLOCKS.register("hay_slab", () -> new HaySlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> HAY_STAIRS = BLOCKS.register("hay_stairs", () -> new HayStairsBlock(Blocks.HAY_BLOCK.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));

    public static void registry(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}