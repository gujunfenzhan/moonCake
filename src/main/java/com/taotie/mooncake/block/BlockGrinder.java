package com.taotie.mooncake.block;

import com.taotie.mooncake.MoonCakeMod;
import com.taotie.mooncake.creativetab.CreativeTabsLoader;
import com.taotie.mooncake.inventory.GuiElementLoader;
import com.taotie.mooncake.tileentity.TileEntityGrinder;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGrinder extends BlockContainer {

	public BlockGrinder() {
		super(Material.IRON);
		setRegistryName("grinder");
		setUnlocalizedName("Grinder");
		setCreativeTab(CreativeTabsLoader.moonCake);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof TileEntityGrinder) {
				TileEntityGrinder entityGrinder = (TileEntityGrinder) tileEntity;
				entityGrinder.setOpenGui(true);
				playerIn.openGui(MoonCakeMod.instance, GuiElementLoader.GUI_Grinder, worldIn, pos.getX(), pos.getY(),
						pos.getZ());
			}

		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityGrinder();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
}
