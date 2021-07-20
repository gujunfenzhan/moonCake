package com.taotie.mooncake.creativetab;

import com.taotie.mooncake.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsMoonCake extends CreativeTabs {
	public CreativeTabsMoonCake() {
		super("moon_cake");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.Flour);
	}
}
