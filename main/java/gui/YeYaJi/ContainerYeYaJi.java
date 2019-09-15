package gui.YeYaJi;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerYeYaJi extends Container {
	public ContainerYeYaJi(EntityPlayer player) {
		super();
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 99 + i * 18));
			}
		}
		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 157));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO 自动生成的方法存根
		return true;
	}

}
