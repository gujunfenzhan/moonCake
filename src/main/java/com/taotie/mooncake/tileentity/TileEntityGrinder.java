package com.taotie.mooncake.tileentity;

import com.taotie.mooncake.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class TileEntityGrinder extends TileEntity implements ITickable {
	private boolean isOpen = false;
	private int processTime = -1;
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
		return processTime >= 0&&processTime<=getTotalProcessTime();
	}

	public boolean isProcessOver() {
		return processTime ==getTotalProcessTime();
	}

	public boolean canProcess() {
		return items.getStackInSlot(1).isItemEqual(new ItemStack(Items.WHEAT))&&items.getStackInSlot(3).getCount()<items.getSlotLimit(3);
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
		if (!isProcess() && canProcess()) {
			processTime = 0;
		}
		if (isProcess() && canProcess()) {
			++processTime;
		}
		if (!this.world.isRemote) {
			if (isProcess() && canProcess()) {
				if(isProcessOver())
				{
					if(items.getStackInSlot(2).isItemEqual(new ItemStack(ModItems.Bag))&&
							((items.getStackInSlot(0).getCount()>=64&&items.getStackInSlot(1).getCount()>=64)||items.getStackInSlot(1).getCount()>=128))
					{
						ItemStack inp1 = items.getStackInSlot(0);
						ItemStack inp2 = items.getStackInSlot(1);
						ItemStack inp3 = items.getStackInSlot(2);
						ItemStack out = items.getStackInSlot(3);
						if(out.isEmpty()) {
							out = new ItemStack(ModItems.Flour);
							out.setCount(0);
						}
						if(out.getCount()< out.getMaxStackSize())
						{
							if(inp2.getCount()>128)
							{
								inp2.setCount(inp2.getCount()-128);
							}
							else
							{
								inp1.setCount(inp1.getCount()-64);
								inp2.setCount(inp2.getCount()-64);
							}
							inp3.setCount(inp3.getCount()-1);
							out.setCount(out.getCount()+1);
							items.setStackInSlot(0, inp1);
							items.setStackInSlot(1, inp2);
							items.setStackInSlot(2, inp3);
							items.setStackInSlot(3, out);
						}
					}
					else
					{
						ItemStack inp = items.getStackInSlot(1);
						ItemStack out = items.getStackInSlot(3);
						if(out.isEmpty()) {
							out = new ItemStack(ModItems.ItemFlour);
							out.setCount(0);
						}
						if(out.getCount()< out.getMaxStackSize())
						{
							inp.setCount(inp.getCount()-1);
							out.setCount(out.getCount()+1);
							items.setStackInSlot(1, inp);
							items.setStackInSlot(3, out);
						}
					}
				}
			} else
				processTime = -1;
		}
	}
}
