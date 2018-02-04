package me.imrandoet.superheroesaddon.client.heroes.renderers;

import fiskfille.heroes.client.render.hero.HeroRendererBase;
import fiskfille.heroes.helper.SHHelper;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import me.imrandoet.superheroesaddon.common.data.SUHData;
import me.imrandoet.superheroesaddon.common.heroes.Cyclops;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 29-1-2018.
 */

public class HeroRendererCyclops extends HeroRendererBase {

    @Override
    public MappedResourceLocation getTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (entity instanceof EntityLivingBase && SHHelper.isHero((EntityLivingBase) entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
            if (SHHelper.isHero(entityLivingBase) && SHHelper.getHero(entityLivingBase) instanceof Cyclops) {
                if (SUHData.SHOOTING.get(entityLivingBase)) {
                    if (slot == 0) {
                        return this.getTexture("up");
                    }
                }
            }
        }

        return super.getTexture(stack, entity, slot, type);
    }

    @Override
    protected void mapTextures(TextureMapper map) {
        map.add("up");
        super.mapTextures(map);
    }
}
