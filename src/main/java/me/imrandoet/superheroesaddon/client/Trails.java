package me.imrandoet.superheroesaddon.client;

import fiskfille.heroes.client.trail.SpeedTrailRenderer;
import fiskfille.heroes.client.trail.TrailType;
import fiskfille.heroes.common.entity.EntitySpeedMirage;
import net.minecraft.entity.EntityLivingBase;

/**
 * Created by ImranDoet on 9-6-2017.
 */
public class Trails {

    public Trails() {}

    public static TrailType lightblue = new TrailType("lightblue", 0x00FFFF).setMirageColor(1.0F, 0.2F, 0.2F);
    public static TrailType purple = new TrailType("purple", 0xa049b6).setMirageColor(1.0F, 0.2F, 0.2F);
    public static TrailType none = new TrailType("none", 0x00FFFF) {
        @Override
        public SpeedTrailRenderer getSpeedTrailRenderer() {
            return new SpeedTrailRenderer() {
                @Override
                public void renderTrail(EntityLivingBase entityLivingBase, TrailType trailType) {
                }

                @Override
                public void renderFlickering(EntityLivingBase entityLivingBase, TrailType trailType) {
                }

                @Override
                public void preRenderSpeedMirage(EntitySpeedMirage entitySpeedMirage, TrailType trailType) {
                }

                @Override
                public boolean shouldRenderSpeedMirage(EntitySpeedMirage entitySpeedMirage, TrailType trailType) {
                    return false;
                }
            };
        }
    };

}
