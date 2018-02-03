package me.imrandoet.superheroesaddon.common.data;

import java.lang.reflect.Field;
import java.util.Locale;

import com.google.common.base.Predicate;

import fiskfille.heroes.common.data.SHData;
import net.minecraft.entity.Entity;

/**
 * Created by ImranDoet on 29-10-2017.
 */

public class SUHData<T> extends SHData {

    public static SHData<Double> MOTION_Y_BEFORE_PHASING = new SUHData<Double>(999D).setExempt(RESET);
    public static SHData<Boolean> PHASING = new SUHData<Boolean>(false).setExempt(RESET);
    public static SHData<Boolean> BLACK_FLASH = new SUHData<Boolean>(false).setExempt(RESET);
    public static SHData<Boolean> COLD_BREATH = new SUHData<Boolean>(false).setExempt(RESET);
    public static SHData<Boolean> CLAWS = new SUHData<Boolean>(false).setExempt(RESET);
    public static SHData<Boolean> ENERGY_BEAM = new SUHData<Boolean>(false).setExempt(RESET);

    protected SUHData(DataFactory<T> defaultVal, Predicate<Entity> p) {
        super(defaultVal, p);
    }

    protected SUHData(final T defaultVal, Predicate<Entity> p) {
        super(defaultVal, p);
    }

    protected SUHData(DataFactory<T> defaultVal) {
        super(defaultVal);
    }

    protected SUHData(T defaultVal) {
        super(defaultVal);
    }

    protected SUHData(Predicate<Entity> p) {
        super(p);
    }

    protected SUHData() {
        super();
    }

    public static void init() {
        for (Field field : SUHData.class.getFields()) {
            try {
                Object obj = field.get(null);

                if (SUHData.class.isInstance(obj)) {
                    ((SUHData) obj).init(field, "superheroesaddon:" + field.getName());
                }
            }
            catch (Exception e) {
                if (!(e instanceof NullPointerException)) e.printStackTrace();
            }
        }
    }

    //Thanks Fisk!
}