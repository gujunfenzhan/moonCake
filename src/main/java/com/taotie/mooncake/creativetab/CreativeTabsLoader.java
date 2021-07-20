package com.taotie.mooncake.creativetab;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader {
    public static CreativeTabs moonCake;

    public CreativeTabsLoader() {
    	moonCake = new CreativeTabsMoonCake();
    }
}
