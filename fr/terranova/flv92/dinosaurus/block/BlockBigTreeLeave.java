package fr.terranova.flv92.dinosaurus.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockLeaves;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

/**
 * @author Flv92
 */
public class BlockBigTreeLeave extends BlockLeaves implements IShearable {

    public BlockBigTreeLeave(int id, int texture) {
        super(id, texture);
        this.graphicsLevel = true;
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
        return this.graphicsLevel == true ? 21 : 22;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, 0));
        return ret;
    }

    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 0, 1));
    }

    @Override
    public boolean isOpaqueCube() {
        return !this.graphicsLevel;
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }
}
