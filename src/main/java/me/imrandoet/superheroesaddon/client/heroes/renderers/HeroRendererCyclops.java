package me.imrandoet.superheroesaddon.client.heroes.renderers;

import fiskfille.heroes.client.render.hero.HeroRendererBase;
import me.imrandoet.superheroesaddon.common.data.SUHData;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * Created by ImranDoet on 29-1-2018.
 */

public class HeroRendererCyclops extends HeroRendererBase {

    @Override
    public MappedResourceLocation getTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (SUHData.ENERGY_BEAM.get(entity)) {
            if (slot == 0) {

            }
        }

        return super.getTexture(stack, entity, slot, type);
    }
}
