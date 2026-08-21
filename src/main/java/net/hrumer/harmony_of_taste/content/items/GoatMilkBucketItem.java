package net.hrumer.harmony_of_taste.content.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;

public class GoatMilkBucketItem extends BucketItem {
    
    public GoatMilkBucketItem(Fluid fluid, Item.Properties properties) {
        super(fluid, properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        FoodProperties foodproperties = itemStack.getFoodProperties(livingEntity);
        livingEntity.eat(level, itemStack, foodproperties);
        if (livingEntity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            List<MobEffectInstance> effects = new ArrayList<>(livingEntity.getActiveEffects());

            boolean removeBeneficial = livingEntity.getRandom().nextBoolean();

            for (MobEffectInstance instance : effects) {
                MobEffectCategory effectCategory = instance.getEffect().value().getCategory();

                if (removeBeneficial) {
                    if (effectCategory == MobEffectCategory.BENEFICIAL) {
                        livingEntity.removeEffect(instance.getEffect());
                    }
                } else {
                    if (effectCategory == MobEffectCategory.HARMFUL || effectCategory == MobEffectCategory.NEUTRAL) {
                        livingEntity.removeEffect(instance.getEffect());
                    }
                }
            }
        }

        if (livingEntity instanceof Player player) {
            return ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.BUCKET), false);
        } else {
            itemStack.consume(1, livingEntity);
            return itemStack;
        }
    }

    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return ItemUtils.startUsingInstantly(level, player, interactionHand);
    }
}
