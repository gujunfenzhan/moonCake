package com.taotie.mooncake.block;

import com.taotie.mooncake.MoonCakeMod;
import com.taotie.mooncake.creativetab.CreativeTabsLoader;
import com.taotie.mooncake.inventory.GuiElementLoader;
import com.taotie.mooncake.tileentity.TileEntityGrinder;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class BlockGrinder extends BlockContainer {

	public BlockGrinder() {
		super(Material.IRON);
		setRegistryName("grinder");
		setUnlocalizedName("Grinder");
		setCreativeTab(CreativeTabsLoader.moonCake);
		setHardness(2);
		setHarvestLevel("pickaxe",0);
		setResistance(10);
		setSoundType(SoundType.STONE);
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

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof TileEntityGrinder)
		{

			TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) tileentity;
			ItemStackHandler itemStackHandler = tileEntityGrinder.items;
			for (int i = 0; i < itemStackHandler.getSlots(); i++) {

				worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),itemStackHandler.getStackInSlot(i)));
			}

		}

		super.breakBlock(worldIn, pos, state);
	}
}
