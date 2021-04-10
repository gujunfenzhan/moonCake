package ink.mhxk.mooncoke.init;

import ink.mhxk.mooncoke.item.MoonCake;
import ink.mhxk.mooncoke.item.MoonCakeNormal;
import ink.mhxk.mooncoke.item.Peach;
import net.minecraft.item.Item;

/**
 * Creative by GoldMain on 2019/9/14
 */
public interface ModItemLoader {
    public Item MOONCAKE_NORMAL = new MoonCakeNormal().setRegistryName("mooncake_normal").setUnlocalizedName("mooncakeNormal");
    public Item MOONCAKE = new MoonCake().setRegistryName("mooncake").setUnlocalizedName("mooncake");
    public Item PEACH = new Peach().setRegistryName("peach").setUnlocalizedName("peach");
}
