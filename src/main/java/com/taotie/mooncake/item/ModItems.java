package com.taotie.mooncake.item;

import com.taotie.mooncake.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;

public class ModItems {
	public static final Item Flour = new BaseItem().u("Flour").r("flour").c(CreativeTabsLoader.moonCake).d(256)
			.o("flour");
	public static final Item Dough = new BaseItem().u("Dough").r("dough").c(CreativeTabsLoader.moonCake).o("dough");
	public static final Item Bag = new BaseItem().u("Bag").r("bag").c(CreativeTabsLoader.moonCake).o("bag");
}
