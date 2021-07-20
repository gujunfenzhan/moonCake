package com.taotie.mooncake.tileentity;

import com.taotie.mooncake.MoonCakeMod;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityLoader {
	public TileEntityLoader()
    {
        registerTileEntity(TileEntityGrinder.class, "Grinder");
    }

    @SuppressWarnings("deprecation")
	public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id)
    {
        GameRegistry.registerTileEntity(tileEntityClass, MoonCakeMod.MODID + ":" + id);
    }
}
