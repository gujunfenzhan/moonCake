package com.taotie.mooncake.item;

import com.taotie.mooncake.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;

public class ModItems {
	public static final Item Flour = new ItemFlour();
	public static final Item Dough = new BaseItem().u("Dough").r("dough").c(CreativeTabsLoader.moonCake).o("dough");
	public static final Item Bag = new BaseItem().u("Bag").r("bag").c(CreativeTabsLoader.moonCake).o("bag");
	public static final Item ItemFlour=new BaseItem().u("Flour").r("item_flour").c(CreativeTabsLoader.moonCake).o("flour");
	public static final Item MoonCake=new BaseItem().u("MoonCake").r("mooncake").c(CreativeTabsLoader.moonCake).o("mooncake");
	public static final Item Glass=new ItemGlass();
}
