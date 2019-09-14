package com.mooncakes.mooncakesmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Creative by TaoTie on 2019/9/14
 */
public class Iitem extends Item {
	public Iitem(String name, String unlocalizedName, CreativeTabs tab) {
		this.setRegistryName(name);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(tab);
	}
}
