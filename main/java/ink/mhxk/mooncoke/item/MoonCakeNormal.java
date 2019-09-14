package ink.mhxk.mooncoke.item;

import ink.mhxk.mooncoke.init.ModCreativeTabLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

/**
 * Creative by GoldMain on 2019/9/14
 */
public class MoonCakeNormal
extends ItemFood {
    public MoonCakeNormal() {
        super(4,false);
        this.setCreativeTab(ModCreativeTabLoader.MOONCAKE);
    }
}
