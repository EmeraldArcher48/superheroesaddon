package me.imrandoet.superheroesaddon.common.abilities.weakness;

import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.weakness.Weakness;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

/**
 * Created by ImranDoet on 26-10-2017.
 */

public class WeaknessHighPitch extends Weakness {

    @Override
    public float damageTaken(EntityLivingBase entity, EntityLivingBase attacker, Hero hero, DamageSource source, float amount, float originalAmount) {
        amount = super.damageTaken(entity, attacker, hero, source, amount, originalAmount);

        if (source.getDamageType().equalsIgnoreCase("sound")) {
            amount *= 2.5;
        }

        return amount;
    }
}
