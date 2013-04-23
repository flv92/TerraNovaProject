package fr.terranova.flv92.dinosaurus.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * @author Flv92
 */
public class DinoCreativeTab extends CreativeTabs {

    public DinoCreativeTab() {
        super("DinoCreativeTab");
        this.setNoScrollbar();
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Dinosaurus.dinoSkull);
    }
}
