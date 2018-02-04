package me.imrandoet.superheroesaddon.client.heroes.renderers;

import fiskfille.heroes.client.model.ModelCaped;
import fiskfille.heroes.client.render.hero.HeroRenderer;
import fiskfille.heroes.client.render.hero.HeroRendererBase;
import me.imrandoet.superheroesaddon.common.heroes.HeroManager;

/**
 * Created by ImranDoet on 23-10-2017.
 */

public class RenderManager {

    public static void register() {
        HeroRenderer.register(HeroManager.ACCELERATED_MAN, new HeroRendererBase());
        HeroRenderer.register(HeroManager.CYCLOPS, new HeroRendererCyclops());
        HeroRenderer.register(HeroManager.QUICKSILVER, new HeroRendererBase());
        HeroRenderer.register(HeroManager.SAVITAR, new HeroRendererBase());
        HeroRenderer.register(HeroManager.SPIDERMAN, new HeroRendererBase().setMasked(true));
        HeroRenderer.register(HeroManager.SUPERMAN, new HeroRendererBase(new ModelCaped(25)).setCaped(true));
        HeroRenderer.register(HeroManager.ULTRON, new HeroRendererUltron());
        HeroRenderer.register(HeroManager.WINTER_SOLDIER, new HeroRendererBase());
        HeroRenderer.register(HeroManager.BLACK_FLASH, new HeroRendererBase());
    }

}
