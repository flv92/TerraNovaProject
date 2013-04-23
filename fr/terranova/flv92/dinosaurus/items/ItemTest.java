package fr.terranova.flv92.dinosaurus.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import fr.terranova.flv92.dinosaurus.common.WorldGenDinoTrees;
import net.minecraft.world.World;

/**
 * @author Flv92
 */
public class ItemTest extends Item {

    public ItemTest(int id) {
        super(id);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
        (new WorldGenDinoTrees()).generate(par3World, itemRand, par4, par5, par6);
        return true;
    }
}
