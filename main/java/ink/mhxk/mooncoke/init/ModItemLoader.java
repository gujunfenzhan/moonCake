package ink.mhxk.mooncoke.init;

import ink.mhxk.mooncoke.item.MoonCakeNormal;
import net.minecraft.item.Item;

/**
 * Creative by GoldMain on 2019/9/14
 */
public interface ModItemLoader {
    public Item MOONCAKE_NORMAL = new MoonCakeNormal().setRegistryName("mooncake_normal").setUnlocalizedName("mooncakeNormal");
}
