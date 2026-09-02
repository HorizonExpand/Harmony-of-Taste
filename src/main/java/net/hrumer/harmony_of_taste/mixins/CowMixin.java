package net.hrumer.harmony_of_taste.mixins;

import net.hrumer.harmony_of_taste.init.HarmonyOfTasteItems;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Cow.class)
public class CowMixin {
    
    @Inject(method = "mobInteract", at = @At("RETURN"), cancellable = true)
    private void onInteract(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        Cow cow = (Cow) (Object) this;
        if (itemstack.is(Items.GLASS_BOTTLE) && !cow.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, HarmonyOfTasteItems.MILK_BOTTLE.toStack());
            player.setItemInHand(interactionHand, itemstack1);
            cir.setReturnValue(InteractionResult.sidedSuccess(cow.level().isClientSide));
        }
    }
}
