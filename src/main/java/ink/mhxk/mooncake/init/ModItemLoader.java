package ink.mhxk.mooncake.init;

import ink.mhxk.mooncake.item.MoonCake;
import ink.mhxk.mooncake.item.MoonCakeNormal;
import ink.mhxk.mooncake.item.Peach;
import net.minecraft.item.Item;

/**
 * Creative by GoldMain on 2019/9/14
 */
public interface ModItemLoader {
    public Item MOONCAKE_NORMAL = new MoonCakeNormal().setRegistryName("mooncake_normal").setUnlocalizedName("mooncakeNormal");
    public Item MOONCAKE = new MoonCake().setRegistryName("mooncake").setUnlocalizedName("mooncake");
    public Item PEACH = new Peach().setRegistryName("peach").setUnlocalizedName("peach");
}
