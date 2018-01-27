package me.imrandoet.superheroesaddon.common.abilities.interfaces;

import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.keybinds.KeyBindTranslator;
import fiskfille.heroes.common.keybinds.SHKeyBinding;

/**
 * Created by ImranDoet on 27-10-2017.
 */

public interface IEnergyBeam extends IAbility {

    @KeyBindTranslator.TranslatedKeyBind(key = "key.energyBeam")
    SHKeyBinding getEergyBeamKey();
}
