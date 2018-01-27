package me.imrandoet.superheroesaddon.common.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import net.minecraft.entity.Entity;

/**
 * Created by ImranDoet on 16-7-2017.
 */
public class EntityManager {

    private static int nextID = -1;

    public static void register() {
        registerEntity(EntityWebSlingLine.class, "WebSlingLine", 64, 10, true);
        registerEntity(EntityWebSlingArrow.class, "WebSlingArrow", 64, 10, true);
        registerEntity(EntityLightning.class, "LightningThrow", 64, 10, true);
        registerEntity(EntityBlackFlash.class, "BlackFlash", 100, 1, true);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendVelocityUpdates) {
        EntityRegistry.registerModEntity(entityClass, name, ++nextID, SuperheroesAddon.instance, trackingRange, updateFrequency, sendVelocityUpdates);
    }

}
