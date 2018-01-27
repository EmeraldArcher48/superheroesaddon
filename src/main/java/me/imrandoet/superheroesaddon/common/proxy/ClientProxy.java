package me.imrandoet.superheroesaddon.common.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import me.imrandoet.superheroesaddon.client.heroes.renderers.RenderManager;
import me.imrandoet.superheroesaddon.client.renders.RenderBlackFlash;
import me.imrandoet.superheroesaddon.client.renders.RenderLightning;
import me.imrandoet.superheroesaddon.client.renders.RenderWebSlingLine;
import me.imrandoet.superheroesaddon.common.entity.EntityBlackFlash;
import me.imrandoet.superheroesaddon.common.interaction.key.KeyManager;
import me.imrandoet.superheroesaddon.common.entity.EntityLightning;
import me.imrandoet.superheroesaddon.common.entity.EntityWebSlingLine;
import me.imrandoet.superheroesaddon.common.event.ClientEventHandler;

public class ClientProxy extends ServerProxy {

    @Override
    public void init() {
        super.init();
        RenderManager.register();
        RenderingRegistry.registerEntityRenderingHandler(EntityWebSlingLine.class, new RenderWebSlingLine());
        RenderingRegistry.registerEntityRenderingHandler(EntityLightning.class, new RenderLightning());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlackFlash.class, new RenderBlackFlash());
        registerEventHandler(new ClientEventHandler());
    }

    @Override
    public void preInit() {
        super.preInit();
        KeyManager.register();
    }
}
