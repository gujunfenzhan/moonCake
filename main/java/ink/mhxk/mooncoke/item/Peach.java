package ink.mhxk.mooncoke.item;

import ink.mhxk.mooncoke.init.ModCreativeTabLoader;
import net.minecraft.item.ItemFood;

public class Peach
extends ItemFood {
    public Peach() {
        super(5,false);
        this.setCreativeTab(ModCreativeTabLoader.MOONCAKE);
    }
}
