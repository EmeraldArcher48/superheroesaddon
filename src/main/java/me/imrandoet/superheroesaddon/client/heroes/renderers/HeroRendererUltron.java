package me.imrandoet.superheroesaddon.client.heroes.renderers;

import fiskfille.heroes.client.render.hero.HeroRendererBase;
import net.minecraft.entity.Entity;

/**
 * Created by ImranDoet on 27-10-2017.
 */

public class HeroRendererUltron extends HeroRendererBase {

    @Override
    public MappedResourceLocation getLightsTexture(Entity entity, int slot) {
        return this.getTexture("lights_layer1");
    }

    @Override
    protected void mapTextures(TextureMapper map) {
        super.mapTextures(map);
        map.add("lights");
        map.add("lights_layer1");
    }
}
