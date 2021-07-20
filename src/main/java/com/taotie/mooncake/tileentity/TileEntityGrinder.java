package com.taotie.mooncake.tileentity;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class TileEntityGrinder extends TileEntity implements ITickable {
	private boolean isOpen = false;
	private int processTime = 0;
	public ItemStackHandler items = new ItemStackHandler(4);
	public SlotItemHandler slot1 = new SlotItemHandler(items, 0, 56, 17);
	public SlotItemHandler slot2 = new SlotItemHandler(items, 1, 56, 35);
	public SlotItemHandler slot3 = new SlotItemHandler(items, 2, 56, 53);
	public SlotItemHandler slot4 = new SlotItemHandler(items, 3, 116, 35) {
		@Override
		public boolean isItemValid(ItemStack stack) {
			return false;
		}
	};

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		items.deserializeNBT(nbt.getCompoundTag("items"));
		processTime = nbt.getInteger("process");
		super.readFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setTag("items", items.serializeNBT());
		nbt.setInteger("process", processTime);
		return super.writeToNBT(nbt);
	}

	public void setOpenGui(boolean open) {
		isOpen = open;
	}

	public int getProcessTime() {
		return processTime;
	}

	public int getTotalProcessTime() {
		return 200;
	}

	public boolean isProcess() {
		return processTime > 0;
	}

	public boolean canProcess() {
		return true;
	}

	@Override
	public void update() {
		if (items.getStackInSlot(1).getCount() != items.getStackInSlot(1).getMaxStackSize()
				&& !items.getStackInSlot(0).isEmpty() && (items.getStackInSlot(0).isItemEqual(items.getStackInSlot(1))
						|| items.getStackInSlot(1).isEmpty())) {
			ItemStack item = items.getStackInSlot(1);
			ItemStack item1 = items.getStackInSlot(0);
			int len1 = item.getCount();
			if (item.isEmpty()) {
				item = new ItemStack(item1.getItem());
				item.setCount(0);
			}
			item.setCount(item1.getCount() + item.getCount() > item1.getMaxStackSize() ? item.getMaxStackSize()
					: item1.getCount() + item.getCount());
			int len2 = item.getCount();
			item1.setCount(item1.getCount() - len2 + len1);
			items.setStackInSlot(1, item);
			items.setStackInSlot(0, item1);
		}
		if (!isProcess() && items.getStackInSlot(1).isItemEqual(new ItemStack(Items.WHEAT))) {
			processTime = getTotalProcessTime();
		}
		if (isProcess() && canProcess()) {
			--processTime;
		}
		if (!this.world.isRemote) {
			if (isProcess()) {

			} else
				processTime = 0;
		}
	}
}
