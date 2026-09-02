package net.hrumer.harmony_of_taste.mixins;

import net.hrumer.harmony_of_taste.init.HarmonyOfTasteItems;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Goat.class)
public class GoatMixin {

    @Inject(method = "mobInteract", at = @At("RETURN"), cancellable = true)
    private void onInteract(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        Goat goat = (Goat) (Object) this;
        if (!goat.isBaby()) {
            if (itemstack.is(Items.GLASS_BOTTLE)) {
                player.playSound(SoundEvents.GOAT_MILK, 1.0F, 1.0F);
                ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, HarmonyOfTasteItems.GOAT_MILK_BOTTLE.toStack());
                player.setItemInHand(interactionHand, itemstack1);
                cir.setReturnValue(InteractionResult.sidedSuccess(goat.level().isClientSide));
            } else if (itemstack.is(Items.BUCKET)) {
                player.playSound(SoundEvents.GOAT_MILK, 1.0F, 1.0F);
                ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, HarmonyOfTasteItems.GOAT_MILK_BUCKET.toStack());
                player.setItemInHand(interactionHand, itemstack1);
                cir.setReturnValue(InteractionResult.sidedSuccess(goat.level().isClientSide));
            }
        }
    }
}
