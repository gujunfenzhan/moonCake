package ink.mhxk.mooncake.utils;

import net.minecraft.potion.PotionEffect;

/**
 * Creative by GoldMain on 2019/9/14
 */
public class MojangPotionEffectsUtils {
    public static PotionEffect copyPotionEffect(PotionEffect potionEffect){
        return new PotionEffect(potionEffect.getPotion(),potionEffect.getDuration(),potionEffect.getAmplifier());
    }
}
