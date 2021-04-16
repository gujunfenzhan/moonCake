package ink.mhxk.mooncake.creativetab;

import ink.mhxk.mooncake.init.ModItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Creative by GoldMain on 2019/9/14
 */
public class CreativeTabMoonCake
extends CreativeTabs {
    public CreativeTabMoonCake() {
        super("mooncake");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItemLoader.MOONCAKE_NORMAL);
    }
}
