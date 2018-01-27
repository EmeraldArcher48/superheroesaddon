package me.imrandoet.superheroesaddon.common.abilities.weakness;

import fiskfille.heroes.common.weakness.Weakness;

/**
 * Created by ImranDoet on 26-10-2017.
 */

public class Weaknesses {

    public static WeaknessHighPitch HIGH_PITCH = new WeaknessHighPitch();

    public static void register() {
//        for (Field f : Weaknesses.class.getFields()) {
//            if (f.getType() == Weakness.class) {
//                try {
//                    Weakness.register("superheroesaddon:" + f.getName().toLowerCase(Locale.ROOT), (Weakness) f.get(null));
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
        Weakness.register("superheroesaddon:high_pitch", HIGH_PITCH);
    }

}
