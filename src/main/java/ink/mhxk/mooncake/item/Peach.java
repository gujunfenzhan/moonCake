package ink.mhxk.mooncake.item;

import ink.mhxk.mooncake.init.ModCreativeTabLoader;
import net.minecraft.item.ItemFood;

public class Peach
extends ItemFood {
    public Peach() {
        super(5,false);
        this.setCreativeTab(ModCreativeTabLoader.MOONCAKE);
    }
}
