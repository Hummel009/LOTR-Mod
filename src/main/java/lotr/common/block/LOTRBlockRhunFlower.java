package lotr.common.block;

import java.util.List;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.IIcon;

public class LOTRBlockRhunFlower extends LOTRBlockFlower {
    @SideOnly(value = Side.CLIENT)
    private IIcon[] flowerIcons;
    private static String[] flowerNames = new String[] {"chrysBlue", "chrysOrange", "chrysPink", "chrysYellow", "chrysWhite"};

    @SideOnly(value = Side.CLIENT)
    @Override
    public IIcon getIcon(int i, int j) {
        if(j >= flowerNames.length) {
            j = 0;
        }
        return this.flowerIcons[j];
    }

    @SideOnly(value = Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconregister) {
        this.flowerIcons = new IIcon[flowerNames.length];
        for(int i = 0; i < flowerNames.length; ++i) {
            this.flowerIcons[i] = iconregister.registerIcon(this.getTextureName() + "_" + flowerNames[i]);
        }
    }

    @Override
    public int damageDropped(int i) {
        return i;
    }

    @SideOnly(value = Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < flowerNames.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
