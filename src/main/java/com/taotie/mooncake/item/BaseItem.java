package com.taotie.mooncake.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseItem extends Item {
	private String o = null;

	public BaseItem o(String name) {
		o = name;
		return this;
	}

	public BaseItem r(String name) {
		setRegistryName(name);
		return this;
	}

	public BaseItem u(String name) {
		setUnlocalizedName(name);
		return this;
	}

	public BaseItem c(CreativeTabs tab) {
		setCreativeTab(tab);
		return this;
	}

	public BaseItem d(int i) {
		setMaxDamage(i);
		return this;
	}

	public String go() {
		return o;
	}
}
