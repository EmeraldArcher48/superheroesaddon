package me.imrandoet.superheroesaddon.common.proxy;

import me.imrandoet.superheroesaddon.common.blocks.SUHBlocks;
import me.imrandoet.superheroesaddon.common.data.SUHData;
import me.imrandoet.superheroesaddon.common.generator.KryptoniteGenerator;
import me.imrandoet.superheroesaddon.common.items.SUHItems;
import me.imrandoet.superheroesaddon.common.entity.EntityManager;
import me.imrandoet.superheroesaddon.common.heroes.HeroManager;
import me.imrandoet.superheroesaddon.common.abilities.Abilities;
import me.imrandoet.superheroesaddon.common.event.CommonEventHandler;
import me.imrandoet.superheroesaddon.helper.SHAEnumHelper;
import me.imrandoet.superheroesaddon.common.abilities.weakness.Weaknesses;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by ImranDoet on 16-7-2017.
 */
public class ServerProxy extends fiskfille.heroes.common.proxy.CommonProxy {

    @Override
    public void preInit() {
        HeroManager.register();
        EntityManager.register();
        Abilities.register();
        Weaknesses.register();
        registerEventHandler(new CommonEventHandler());
        SUHBlocks.init();
        SUHItems.init();
        new SHAEnumHelper();
    }

    @Override
    public void init() {
        SUHData.init();
        MinecraftForge.ORE_GEN_BUS.register(new KryptoniteGenerator());
    }
}
