package org.tutmods.shungite.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.tutmods.shungite.ShungiteConstants;
import org.tutmods.shungite.setup.ModEffects;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = ShungiteConstants.MOD_ID)
public class LivingUpdateEvent {
    private static final HashMap<UUID, Integer> timeSinceLastHurtAroundPlayer = new HashMap<>();

    @SubscribeEvent
    public static void killAura(final LivingEvent.LivingUpdateEvent event) {
        // Only effect players that have the aura
        if (event.getEntityLiving().hasEffect(ModEffects.FIVE_G_AURA.get()) && event.getEntityLiving() instanceof PlayerEntity) {
            final PlayerEntity entity = (PlayerEntity) event.getEntityLiving();
            final int timeSinceLastDamageTick = timeSinceLastHurtAroundPlayer.getOrDefault(entity.getUUID(), 31);


            final EffectInstance effect = entity.getEffect(ModEffects.FIVE_G_AURA.get());
            if (effect != null && timeSinceLastDamageTick > 40) {
                final int effectLevel = effect.getAmplifier();
                      double amplifiedEffect = effectLevel * 0.5D;
                final double amplifedEffectDamage = amplifiedEffect / 2.0D;

                if (amplifiedEffect < 2) {
                    amplifiedEffect = 2;
                }

                final AxisAlignedBB boundingBoxAroundPlayer = new AxisAlignedBB(
                        entity.xo - amplifiedEffect,
                        entity.yo - amplifiedEffect,
                        entity.zo - amplifiedEffect,
                        entity.xo + amplifiedEffect,
                        entity.yo + amplifiedEffect,
                        entity.zo + amplifiedEffect
                );

                final List<Entity> entitiesWithingBoundingBoxExcludingPlayers = entity.level.getEntities(
                        entity,
                        boundingBoxAroundPlayer,
                        (mob) -> mob instanceof MonsterEntity
                );

                final DamageSource damageSource = DamageSource
                        .playerAttack(entity)
                        .setMagic();

                entitiesWithingBoundingBoxExcludingPlayers.forEach( mob -> mob.hurt(damageSource, (float) amplifedEffectDamage));

                timeSinceLastHurtAroundPlayer.put(entity.getUUID(), 0);
            }
            else {
                timeSinceLastHurtAroundPlayer.put(entity.getUUID(), timeSinceLastDamageTick + 1);
            }
        }
    }
}
