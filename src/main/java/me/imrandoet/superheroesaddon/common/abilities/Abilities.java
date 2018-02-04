package me.imrandoet.superheroesaddon.common.abilities;

import com.google.common.collect.ImmutableList;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import me.imrandoet.superheroesaddon.common.abilities.interfaces.IWebSlinging;

import java.lang.reflect.Field;

/**
 * Created by ImranDoet on 12-6-2017.
 */
public class Abilities {

//    public static Ability flight = new Ability("flight4", "realFlight", 5);
//    public static Ability webSling = new Ability("websling", "webSling", 4);
//    public static Ability coldBreath = new Ability("coldbreath", "coldBreath", 4);
//    public static Ability wallClimb = new Ability("wallclimb", "wallClimb", 4);
//    public static Ability energyBeam = new Ability("energybeam", "energyBeam", 2);
//    public static Ability claws = new Ability("claws", "handClaw", 4);
//    public static Ability wallRun = new Ability("wallrun", "wallRun", 5);
//    public static Ability vibeEnergy = new Ability("vibeenergy", "vibeEnergy", 5);
//    public static Ability vibe = new Ability("vibe,", "vibe", 5);
//    public static Ability spiderSense = new Ability("spidersense", "spiderSense", 5);

    public static Ability<IWebSlinging> WEB_SLINGING = new AbilityWebSlinging(4);
    public static Ability<IAbility> FLIGHT = new AbilityFlight(5);
    public static Ability<IAbility> COLD_BREATH = new AbilityColdBreath(4);
    public static Ability<IAbility> WALL_CLIMB = new Ability<IAbility>(4);
    public static Ability<IAbility> CLAWS = new Ability<IAbility>(4);
    public static Ability<IAbility> WALL_RUN = new Ability<IAbility>(5);
    public static Ability<IAbility> VIBE_ENERGY_WAVE = new Ability<IAbility>(5);
    public static Ability<IAbility> VIBING = new Ability<IAbility>(5);
    public static Ability<IAbility> SPIDER_SENSE = new Ability<IAbility>(5);
    public static Ability<IAbility> PHASING = new AbilityPhasing(5);
    public static Ability<IAbility> LEAD_SIGHT = new AbilityLeadSight(5);
//    public static Ability<IAbility> LIGHTNING_THROW = new AbilityLightningThrow(5);

    public static void register() {
//        for (Field field : Abilities.class.getFields()) {
//            try {
//                Ability.register(field.getName().toLowerCase(Locale.ROOT), (Ability)field.get((Object) null));
//            } catch (IllegalAccessException exception) {
//                System.out.println("Could not register ability " + field.getName().toLowerCase(Locale.ROOT) + "! Error:" + exception.getStackTrace());
//            }
//        }
        Ability.register("superheroesaddon:web_slinging", WEB_SLINGING);
        Ability.register("superheroesaddon:flight", FLIGHT);
        Ability.register("superheroesaddon:cold_breath", COLD_BREATH);
        Ability.register("superheroesaddon:wall_climb", WALL_CLIMB);
        Ability.register("superheroesaddon:claws", CLAWS);
        Ability.register("superheroesaddon:wall_run", WALL_RUN);
        Ability.register("superheroesaddon:vibe_energy_wave", VIBE_ENERGY_WAVE);
        Ability.register("superheroesaddon:vibing", VIBING);
        Ability.register("superheroesaddon:spider_sense", SPIDER_SENSE);
        Ability.register("superheroesaddon:phasing", PHASING);
        Ability.register("superheroesaddon:lead_sight", LEAD_SIGHT);
//        Ability.register("superheroesaddon:lightning_throw", LIGHTNING_THROW);

        for (Hero hero : Hero.getSpeedsters()) {
            if (hero.getVersion() == ItemHeroArmor.ArmorVersion.DCTV || hero.getVersion() == ItemHeroArmor.ArmorVersion.DCEU || hero.getVersion() == ItemHeroArmor.ArmorVersion.DCAU || hero.getVersion() == ItemHeroArmor.ArmorVersion.COMICS) {
                ImmutableList.Builder builder = ImmutableList.builder();
                builder.addAll(hero.getAbilities());
                builder.add(PHASING);
//                builder.add(LIGHTNING_THROW);
                ImmutableList<Abilities> newList = builder.build();

                try {
                    Field f = Hero.class.getDeclaredField("abilities");
                    f.setAccessible(true);
                    f.set(hero, newList);
                    f.setAccessible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
