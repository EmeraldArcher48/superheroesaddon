package me.imrandoet.superheroesaddon.common.heroes;

import fiskfille.heroes.common.hero.Hero;

/**
 * Created by ImranDoet on 5-6-2017.
 */
public class HeroManager {

    public static Hero ACCELERATED_MAN = new ACMan();
    public static Hero CYCLOPS = new Cyclops();
    public static Hero QUICKSILVER = new Quicksilver();
    public static Hero SAVITAR = new Savitar();
    public static Hero SPIDERMAN = new Spiderman();
    public static Hero SUPERMAN = new Superman();
    public static Hero ULTRON = new Ultron();
    public static Hero WINTER_SOLDIER = new WinterSoldier();
    public static Hero BLACK_FLASH = new BlackFlash();

    public static void register() {
        Hero.register("superheroesaddon:accelerated_man", ACCELERATED_MAN);
        Hero.register("superheroesaddon:cyclops", CYCLOPS);
        Hero.register("superheroesaddon:quicksilver", QUICKSILVER);
        Hero.register("superheroesaddon:savitar", SAVITAR);
        Hero.register("superheroesaddon:spiderman", SPIDERMAN);
        Hero.register("superheroesaddon:superman", SUPERMAN);
        Hero.register("superheroesaddon:ultron", ULTRON);
        Hero.register("superheroesaddon:winter_soldier", WINTER_SOLDIER);
        Hero.register("superheroesaddon:black_flash", BLACK_FLASH);

        //fix ant man can grow ;)
    }

}
