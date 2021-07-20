package com.taotie.mooncake.inventory;

import com.taotie.mooncake.tileentity.TileEntityGrinder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerGrinder extends Container {
	public TileEntityGrinder _tileEntity;
	private int processTime = 0;

	public ContainerGrinder(EntityPlayer player, TileEntity tileEntity) {
		super();
		_tileEntity = (TileEntityGrinder) tileEntity;
		this.addSlotToContainer(_tileEntity.slot1);
		this.addSlotToContainer(_tileEntity.slot2);
		this.addSlotToContainer(_tileEntity.slot3);
		this.addSlotToContainer(_tileEntity.slot4);

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return playerIn.getDistanceSq(this._tileEntity.getPos()) <= 64;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		super.updateProgressBar(id, data);
		switch (id) {
		case 0:
			processTime = data;
		}
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener icontainerlistener = this.listeners.get(i);
			icontainerlistener.sendWindowProperty(this, 0, _tileEntity.getProcessTime());
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		return ItemStack.EMPTY;
	}

	public int getTotalProcessTime() {
		return _tileEntity.getTotalProcessTime();
	}
	
	public int getProcessTime() {
		return processTime;
	}
}
