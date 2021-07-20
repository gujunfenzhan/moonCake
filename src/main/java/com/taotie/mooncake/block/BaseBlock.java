package com.taotie.mooncake.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class BaseBlock extends Block {
	public BaseBlock(Material blockMaterialIn) {
		super(blockMaterialIn);
	}

	public BaseBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
	}

	public BaseBlock registerOre(String name) {
		OreDictionary.registerOre(name, this);
		return this;
	}
}
