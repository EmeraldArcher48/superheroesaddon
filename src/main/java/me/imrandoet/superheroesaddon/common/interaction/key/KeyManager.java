package me.imrandoet.superheroesaddon.common.interaction.key;

import cpw.mods.fml.client.registry.ClientRegistry;
import fiskfille.heroes.common.keybinds.KeyBindingAbility;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by ImranDoet on 27-10-2017.
 */

public class KeyManager {

    public static SHKeyBinding ABILITY_6 = new KeyBindingAbility("key.suitAbility", 6, Keyboard.KEY_P);

    public static void register() {
        ClientRegistry.registerKeyBinding(ABILITY_6);
    }

}
