package fr.terranova.flv92.dinosaurus.common;

import fr.terranova.flv92.dinosaurus.biome.BiomeGenDinoPlains;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDinoTrees extends WorldGenerator {

    @SuppressWarnings("empty-statement")
    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        int treeHeight = 20 + rand.nextInt(4);

        // Trying to find a place to place tree on the floor!
        int treeFootX = x;
        int treeFootZ = z;
        int treeFootY = world.getTopSolidOrLiquidBlock(treeFootX, treeFootZ) - 1;
        if (world.getBlockId(treeFootX, treeFootY, treeFootZ) != BiomeGenDinoPlains.topBlockID)
        {
            return false;
        }
        for (int i = 2; i < treeHeight; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                for (int k = 0; k < 16; k++)
                {
                    if (!world.isAirBlock(treeFootX - 8 + j, treeFootY + i, treeFootZ - 8 + k))
                    {
                        return false;
                    }
                }
            }
        }
        for (int i = 1; i < treeHeight; i++)
        {
            world.setBlock(treeFootX, treeFootY + i, treeFootZ, Dinosaurus.blockHugeThinTreeLog1.blockID);
        }

        //Doing things to prepare branches
        int firstBranchHeight = treeHeight / 2 + (rand.nextInt(2) - 1);
        int secondBranchHeight = firstBranchHeight + 4 + (rand.nextInt(2) - 1);
        int thirdBranchHeight = secondBranchHeight + 4 + (rand.nextInt(2) - 1);
        if (thirdBranchHeight > treeHeight)
        {
            thirdBranchHeight = treeHeight;
        }

        int n, pos;
        int tab[] =
        {
            0, 0, 0
        };
        pos = 0;
        do
        {
            n = rand.nextInt(4) + 1; // ENTRE 1 et 50 INCLUS
            boolean bool = true;
            for (int i = 0; i < pos; i++)
            {
                if (n == tab[i])
                {
                    bool = false;

                }
            }
            if (bool != false)
            {
                tab[pos++] = n;
            }
        } while (pos < 3);

        int fullTab[][] =
        {
            {
                tab[0], firstBranchHeight
            },
            {
                tab[1], secondBranchHeight
            },
            {
                tab[2], thirdBranchHeight
            }
        };
        //Doing first Branch
        for (int index = 0; index < 3; index++)
        {
            int branchSize = rand.nextInt(2) + 1;
            int a = rand.nextInt(35);
            if (a == 0)
            {
                branchSize = 0;
            }
            if (a < 4)
            {
                branchSize = 3;
            }
            for (int i = 1; i < branchSize + 1; i++)
            {
                if (fullTab[index][0] == 1)
                {
                    world.setBlock(treeFootX + i, treeFootY + fullTab[index][1], treeFootZ, Dinosaurus.blockHugeThinTreeLog3.blockID);
                    WorldGenDinoTrees.generateLeavesAroundBlock(world, treeFootX + i, treeFootY + fullTab[index][1], treeFootZ);
                } else if (fullTab[index][0] == 2)
                {
                    world.setBlock(treeFootX - i, treeFootY + fullTab[index][1], treeFootZ, Dinosaurus.blockHugeThinTreeLog3.blockID);
                    WorldGenDinoTrees.generateLeavesAroundBlock(world, treeFootX - i, treeFootY + fullTab[index][1], treeFootZ);

                } else if (fullTab[index][0] == 3)
                {
                    world.setBlock(treeFootX, treeFootY + fullTab[index][1], treeFootZ + i, Dinosaurus.blockHugeThinTreeLog2.blockID);
                    WorldGenDinoTrees.generateLeavesAroundBlock(world, treeFootX, treeFootY + fullTab[index][1], treeFootZ + i);

                } else if (fullTab[index][0] == 4)
                {
                    world.setBlock(treeFootX, treeFootY + fullTab[index][1], treeFootZ - i, Dinosaurus.blockHugeThinTreeLog2.blockID);
                    WorldGenDinoTrees.generateLeavesAroundBlock(world, treeFootX, treeFootY + fullTab[index][1], treeFootZ - i);

                }
            }
        }
        WorldGenDinoTrees.generateLeavesAroundBlock(world, treeFootX, treeFootY + treeHeight, treeFootZ);
        return false;
    }

    public static void generateLeavesAroundBlock(World world, int x, int y, int z) {

        int id = Dinosaurus.blockHugeThinTreeLeaves.blockID;
        boolean bool[] =
        {
            false, false, false, false
        };
        if (world.isAirBlock(x + 1, y + 1, z))
        {
            world.setBlock(x + 1, y + 1, z, id);
        }
        if (world.isAirBlock(x - 1, y + 1, z))
        {
            world.setBlock(x - 1, y + 1, z, id);
        }
        if (world.isAirBlock(x + 1, y - 1, z))
        {
            world.setBlock(x + 1, y - 1, z, id);
        }
        if (world.isAirBlock(x - 1, y - 1, z))
        {
            world.setBlock(x - 1, y - 1, z, id);
        }
        if (world.isAirBlock(x, y + 1, z))
        {
            world.setBlock(x, y + 1, z, id);
        }
        if (world.isAirBlock(x, y + 2, z))
        {
            world.setBlock(x, y + 2, z, id);
        }
        if (world.isAirBlock(x, y - 1, z))
        {
            world.setBlock(x, y - 1, z, id);
        }
        if (world.isAirBlock(x, y - 2, z))
        {
            world.setBlock(x, y - 2, z, id);
        }
        if (world.isAirBlock(x + 1, y, z))
        {
            bool[0] = true;
            world.setBlock(x + 1, y, z, id);
        }
        if (world.isAirBlock(x + 2, y, z) && bool[0])
        {
            world.setBlock(x + 2, y, z, id);
        }
        if (world.isAirBlock(x - 1, y, z))
        {
            bool[1] = true;
            world.setBlock(x - 1, y, z, id);
        }
        if (world.isAirBlock(x - 2, y, z) && bool[1])
        {
            world.setBlock(x - 2, y, z, id);
        }
        if (world.isAirBlock(x, y, z + 1))
        {
            bool[2] = true;
            world.setBlock(x, y, z + 1, id);
        }
        if (world.isAirBlock(x, y, z + 2) && bool[2])
        {
            world.setBlock(x, y, z + 2, id);
        }
        if (world.isAirBlock(x, y, z - 1))
        {
            bool[3] = true;
            world.setBlock(x, y, z - 1, id);
        }
        if (world.isAirBlock(x, y, z - 2) && bool[3])
        {
            world.setBlock(x, y, z - 2, id);
        }
        if (world.isAirBlock(x, y + 1, z + 1))
        {
            world.setBlock(x, y + 1, z + 1, id);
        }
        if (world.isAirBlock(x, y + 1, z - 1))
        {
            world.setBlock(x, y + 1, z - 1, id);
        }
        if (world.isAirBlock(x, y - 1, z + 1))
        {
            world.setBlock(x, y - 1, z + 1, id);
        }
        if (world.isAirBlock(x, y - 1, z - 1))
        {
            world.setBlock(x, y - 1, z - 1, id);
        }
        if (world.isAirBlock(x + 1, y, z + 1))
        {
            world.setBlock(x + 1, y, z + 1, id);
        }
        if (world.isAirBlock(x + 1, y, z - 1))
        {
            world.setBlock(x + 1, y, z - 1, id);
        }
        if (world.isAirBlock(x - 1, y, z + 1))
        {
            world.setBlock(x - 1, y, z + 1, id);
        }
        if (world.isAirBlock(x - 1, y, z - 1))
        {
            world.setBlock(x - 1, y, z - 1, id);
        }


    }
}
