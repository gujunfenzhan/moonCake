package com.mooncakes.mooncakesmod.block;

import gui.GuiElementLoader;
import ink.mhxk.mooncoke.MoonCakeMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class YeYaJi extends Block {
	public YeYaJi() {
		super(Material.IRON);
		this.setRegistryName("compressor");
		this.setUnlocalizedName("Compressor");
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn != null && !worldIn.isRemote)
			playerIn.openGui(MoonCakeMain.INSTANCE, GuiElementLoader.GUI_YeYaJi, worldIn, pos.getX(), pos.getY(),
					pos.getZ());
		return true;
	}
}
