package com.mooncakes.mooncakesmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Iblock extends Block {
	public Iblock(Material material, String name, String unlocalizedName, CreativeTabs tab) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(tab);
	}
}
