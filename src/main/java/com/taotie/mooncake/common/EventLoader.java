package com.taotie.mooncake.common;

import com.taotie.mooncake.item.ItemGlass;
import com.taotie.mooncake.item.ModItems;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;

public class EventLoader {
    public EventLoader() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void itemColors(ColorHandlerEvent.Item event) {

        try {
            ModItems modItems = new ModItems();
            for (Field field : ModItems.class.getFields()) {
                Item item = (Item) field.get(modItems);
                if (item instanceof IItemColor)
                    event.getItemColors().registerItemColorHandler((IItemColor) item, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
