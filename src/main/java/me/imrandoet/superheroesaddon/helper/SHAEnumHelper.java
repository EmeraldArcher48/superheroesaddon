package me.imrandoet.superheroesaddon.helper;

import fiskfille.heroes.common.data.Cooldowns;
import fiskfille.heroes.common.interaction.EnumInteraction;
import fiskfille.heroes.common.interaction.Interaction;
import me.imrandoet.superheroesaddon.common.interaction.InteractionLightningThrow;
import me.imrandoet.superheroesaddon.common.interaction.InteractionWebSlinging;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by ImranDoet on 24-10-2017.
 */

public class SHAEnumHelper extends EnumHelper {

    private static Class[][] commonTypes = {{EnumInteraction.class, Class.class}, {Cooldowns.Cooldown.class, int.class}};

    public static final EnumInteraction LIGHTNING_THROWING = addEnumInteraction("LIGHTNING_THROW", InteractionLightningThrow.class);
    public static final EnumInteraction WEB_SLINGING = addEnumInteraction("WEB_SLINGING", InteractionWebSlinging.class);

    public static final Cooldowns.Cooldown LIGHTNING_THROWING_COOLDOWN = addEnumCooldown("LIGHTNING_THROWING_COOLDOWN", 200);
    public static final Cooldowns.Cooldown WEB_SLINGING_COOLDOWN = addEnumCooldown("WEB_SLINGING_COOLDOWN", 10);

    public static Cooldowns.Cooldown addEnumCooldown(String name, int cooldown) {
        return addEnum(Cooldowns.Cooldown.class, name, cooldown);
    }

    public static EnumInteraction addEnumInteraction(String name, Class<? extends Interaction> interaction) {
        return addEnum(EnumInteraction.class, name, interaction);
    }

    public static <T extends Enum<?>> T addEnum(Class<T> enumType, String enumName, Object... paramValues) {
        return addEnum(commonTypes, enumType, enumName, paramValues);
    }
}
