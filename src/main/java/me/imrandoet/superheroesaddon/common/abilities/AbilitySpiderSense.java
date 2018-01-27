package me.imrandoet.superheroesaddon.common.abilities;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;

/**
 * Created by ImranDoet on 1-11-2017.
 */

public class AbilitySpiderSense extends Ability<IAbility> {

    public AbilitySpiderSense(int tier) {
        super(tier);
    }

    @Override
    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        super.onUpdate(entity, hero, instance, phase);
    }
}
