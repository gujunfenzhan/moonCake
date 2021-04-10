package gui;

import gui.YeYaJi.ContainerYeYaJi;
import gui.YeYaJi.GuiContainerYeYaJi;
import ink.mhxk.mooncoke.MoonCakeMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Creative by TaoTie on 2019/9/14
 */
public class GuiElementLoader implements IGuiHandler {
    public static final int GUI_YeYaJi = 1;

    public GuiElementLoader() {
        NetworkRegistry.INSTANCE.registerGuiHandler(MoonCakeMain.INSTANCE, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_YeYaJi:
                return new ContainerYeYaJi(player);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_YeYaJi:
                return new GuiContainerYeYaJi(new ContainerYeYaJi(player));
            default:
                return null;
        }
    }

    public TileEntity getTileEntity(World world, int x, int y, int z) {
        return world.getTileEntity(new BlockPos(x, y, z));
    }
}
