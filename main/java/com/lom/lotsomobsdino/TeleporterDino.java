package com.lom.lotsomobsdino;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import com.lom.lotsomobsinit.LotsOMobsBlocks;
public class TeleporterDino extends Teleporter
{
private final WorldServer worldServerInstance;
/** A private Random() function in Teleporter */
private final Random random;
/** Stores successful portal placement locations for rapid lookup. */
private final LongHashMap destinationCoordinateCache = new LongHashMap();
/**
         * A list of valid keys for the destinationCoordainteCache. These are based on the X & Z of the players initial
         * location.
         */
private final List destinationCoordinateKeys = new ArrayList();
public TeleporterDino(WorldServer par1WorldServer)
{
         super(par1WorldServer);
         this.worldServerInstance = par1WorldServer;
         this.random = new Random(par1WorldServer.getSeed());
}
/**
         * Place an entity in a nearby portal, creating one if necessary.
         */
public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
{
         if (this.worldServerInstance.provider.dimensionId != 1)
         {
                 if (!this.placeInExistingPortal(par1Entity, par2, par4, par6, par8))
                 {
                         this.makePortal(par1Entity);
                         this.placeInExistingPortal(par1Entity, par2, par4, par6, par8);
                 }
         }
         else
         {
                 int i = MathHelper.floor_double(par1Entity.posX);
                 int j = MathHelper.floor_double(par1Entity.posY) - 1;
                 int k = MathHelper.floor_double(par1Entity.posZ);
                 byte b0 = 1;
                 byte b1 = 0;
                 for (int l = -2; l <= 2; ++l)
                 {
                         for (int i1 = -2; i1 <= 2; ++i1)
                         {
                                 for (int j1 = -1; j1 < 3; ++j1)
                                 {
                                         int k1 = i + i1 * b0 + l * b1;
                                         int l1 = j + j1;
                                         int i2 = k + i1 * b1 - l * b0;
                                         boolean flag = j1 < 0;
                                        
                                         /** change this block **/
                                         this.worldServerInstance.setBlock(k1, l1, i2, Blocks.mossy_cobblestone, 0, 0);
                                 }
                         }
                 }
                 par1Entity.setLocationAndAngles((double)i, (double)j, (double)k, par1Entity.rotationYaw, 0.0F);
                 par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
         }
}
/**
         * Place an entity in a nearby portal which already exists.
         */
public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
{
         short short1 = 128;
         double d3 = -1.0D;
         int i = 0;
         int j = 0;
         int k = 0;
         int l = MathHelper.floor_double(par1Entity.posX);
         int i1 = MathHelper.floor_double(par1Entity.posZ);
         long j1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
         boolean flag = true;
         double d4;
         int k1;
         if (this.destinationCoordinateCache.containsItem(j1))
         {
                 PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(j1);
                 d3 = 0.0D;
                 i = portalposition.posX;
                 j = portalposition.posY;
                 k = portalposition.posZ;
                 portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
                 flag = false;
         }
         else
         {
                 for (k1 = l - short1; k1 <= l + short1; ++k1)
                 {
                         double d5 = (double)k1 + 0.5D - par1Entity.posX;
                         for (int l1 = i1 - short1; l1 <= i1 + short1; ++l1)
                         {
                                 double d6 = (double)l1 + 0.5D - par1Entity.posZ;
                                 for (int i2 = this.worldServerInstance.getActualHeight() - 1; i2 >= 0; --i2)
                                 {
                                         /** change this block **/
                                         if (this.worldServerInstance.getBlock(k1, i2, l1) == LotsOMobsBlocks.DinoPortal)
                                         {
                                                 /** change this block **/
                                                 while (this.worldServerInstance.getBlock(k1, i2 - 1, l1) == LotsOMobsBlocks.DinoPortal)
                                                 {
                                                         --i2;
                                                 }
                                                 d4 = (double)i2 + 0.5D - par1Entity.posY;
                                                 double d7 = d5 * d5 + d4 * d4 + d6 * d6;
                                                 if (d3 < 0.0D || d7 < d3)
                                                 {
                                                         d3 = d7;
                                                         i = k1;
                                                         j = i2;
                                                         k = l1;
                                                 }
                                         }
                                 }
                         }
                 }
         }
         if (d3 >= 0.0D)
         {
                 if (flag)
                 {
                         this.destinationCoordinateCache.add(j1, new DinoPortalPosition(this, i, j, k, this.worldServerInstance.getTotalWorldTime()));
                         this.destinationCoordinateKeys.add(Long.valueOf(j1));
                 }
                 double d8 = (double)i + 0.5D;
                 double d9 = (double)j + 0.5D;
                 d4 = (double)k + 0.5D;
                 int j2 = -1;
                 /** change this block **/
                 if (this.worldServerInstance.getBlock(i - 1, j, k) == LotsOMobsBlocks.DinoPortal)
                 {
                         j2 = 2;
                 }
                 /** change this block **/
                 if (this.worldServerInstance.getBlock(i + 1, j, k) == LotsOMobsBlocks.DinoPortal)
                 {
                         j2 = 0;
                 }
                 /** change this block **/
                 if (this.worldServerInstance.getBlock(i, j, k - 1) == LotsOMobsBlocks.DinoPortal)
                 {
                         j2 = 3;
                 }
                 /** change this block **/
                 if (this.worldServerInstance.getBlock(i, j, k + 1) == LotsOMobsBlocks.DinoPortal)
                 {
                         j2 = 1;
                 }
                 int k2 = par1Entity.getTeleportDirection();
                 if (j2 > -1)
                 {
                         int l2 = Direction.rotateLeft[j2];
                         int i3 = Direction.offsetX[j2];
                         int j3 = Direction.offsetZ[j2];
                         int k3 = Direction.offsetX[l2];
                         int l3 = Direction.offsetZ[l2];
                         boolean flag1 = !this.worldServerInstance.isAirBlock(i + i3 + k3, j, k + j3 + l3) || !this.worldServerInstance.isAirBlock(i + i3 + k3, j + 1, k + j3 + l3);
                         boolean flag2 = !this.worldServerInstance.isAirBlock(i + i3, j, k + j3) || !this.worldServerInstance.isAirBlock(i + i3, j + 1, k + j3);
                         if (flag1 && flag2)
                         {
                                 j2 = Direction.rotateOpposite[j2];
                                 l2 = Direction.rotateOpposite[l2];
                                 i3 = Direction.offsetX[j2];
                                 j3 = Direction.offsetZ[j2];
                                 k3 = Direction.offsetX[l2];
                                 l3 = Direction.offsetZ[l2];
                                 k1 = i - k3;
                                 d8 -= (double)k3;
                                 int i4 = k - l3;
                                 d4 -= (double)l3;
                                 flag1 = !this.worldServerInstance.isAirBlock(k1 + i3 + k3, j, i4 + j3 + l3) || !this.worldServerInstance.isAirBlock(k1 + i3 + k3, j + 1, i4 + j3 + l3);
                                 flag2 = !this.worldServerInstance.isAirBlock(k1 + i3, j, i4 + j3) || !this.worldServerInstance.isAirBlock(k1 + i3, j + 1, i4 + j3);
                         }
                         float f1 = 0.5F;
                         float f2 = 0.5F;
                         if (!flag1 && flag2)
                         {
                                 f1 = 1.0F;
                         }
                         else if (flag1 && !flag2)
                         {
                                 f1 = 0.0F;
                         }
                         else if (flag1 && flag2)
                         {
                                 f2 = 0.0F;
                         }
                         d8 += (double)((float)k3 * f1 + f2 * (float)i3);
                         d4 += (double)((float)l3 * f1 + f2 * (float)j3);
                         float f3 = 0.0F;
                         float f4 = 0.0F;
                         float f5 = 0.0F;
                         float f6 = 0.0F;
                         if (j2 == k2)
                         {
                                 f3 = 1.0F;
                                 f4 = 1.0F;
                         }
                         else if (j2 == Direction.rotateOpposite[k2])
                         {
                                 f3 = -1.0F;
                                 f4 = -1.0F;
                         }
                         else if (j2 == Direction.rotateRight[k2])
                         {
                                 f5 = 1.0F;
                                 f6 = -1.0F;
                         }
                         else
                         {
                                 f5 = -1.0F;
                                 f6 = 1.0F;
                         }
                         double d10 = par1Entity.motionX;
                         double d11 = par1Entity.motionZ;
                         par1Entity.motionX = d10 * (double)f3 + d11 * (double)f6;
                         par1Entity.motionZ = d10 * (double)f5 + d11 * (double)f4;
                         par1Entity.rotationYaw = par8 - (float)(k2 * 90) + (float)(j2 * 90);
                 }
                 else
                 {
                         par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
                 }
                 par1Entity.setLocationAndAngles(d8, d9, d4, par1Entity.rotationYaw, par1Entity.rotationPitch);
                 return true;
         }
         else
         {
                 return false;
         }
}
public boolean makePortal(Entity par1Entity)
{
    byte b0 = 16;
    double d0 = -1.0D;
    int i = MathHelper.floor_double(par1Entity.posX);
    int j = MathHelper.floor_double(par1Entity.posY);
    int k = MathHelper.floor_double(par1Entity.posZ);
    int l = i;
    int i1 = j;
    int j1 = k;
    int k1 = 0;
    int l1 = this.random.nextInt(4);
    int i2;
    double d1;
    int k2;
    double d2;
    int i3;
    int j3;
    int k3;
    int l3;
    int i4;
    int j4;
    int k4;
    int l4;
    int i5;
    double d3;
    double d4;

    for (i2 = i - b0; i2 <= i + b0; ++i2)
    {
        d1 = (double)i2 + 0.5D - par1Entity.posX;

        for (k2 = k - b0; k2 <= k + b0; ++k2)
        {
            d2 = (double)k2 + 0.5D - par1Entity.posZ;
            label274:

            for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
            {
                if (this.worldServerInstance.isAirBlock(i2, i3, k2))
                {
                    while (i3 > 0 && this.worldServerInstance.isAirBlock(i2, i3 - 1, k2))
                    {
                        --i3;
                    }

                    for (j3 = l1; j3 < l1 + 4; ++j3)
                    {
                        k3 = j3 % 2;
                        l3 = 1 - k3;

                        if (j3 % 4 >= 2)
                        {
                            k3 = -k3;
                            l3 = -l3;
                        }

                        for (i4 = 0; i4 < 3; ++i4)
                        {
                            for (j4 = 0; j4 < 4; ++j4)
                            {
                                for (k4 = -1; k4 < 4; ++k4)
                                {
                                    l4 = i2 + (j4 - 1) * k3 + i4 * l3;
                                    i5 = i3 + k4;
                                    int j5 = k2 + (j4 - 1) * l3 - i4 * k3;

                                    if (k4 < 0 && !this.worldServerInstance.getBlock(l4, i5, j5).getMaterial().isSolid() || k4 >= 0 && !this.worldServerInstance.isAirBlock(l4, i5, j5))
                                    {
                                        continue label274;
                                    }
                                }
                            }
                        }

                        d3 = (double)i3 + 0.5D - par1Entity.posY;
                        d4 = d1 * d1 + d3 * d3 + d2 * d2;

                        if (d0 < 0.0D || d4 < d0)
                        {
                            d0 = d4;
                            l = i2;
                            i1 = i3;
                            j1 = k2;
                            k1 = j3 % 4;
                        }
                    }
                }
            }
        }
    }

    if (d0 < 0.0D)
    {
        for (i2 = i - b0; i2 <= i + b0; ++i2)
        {
            d1 = (double)i2 + 0.5D - par1Entity.posX;

            for (k2 = k - b0; k2 <= k + b0; ++k2)
            {
                d2 = (double)k2 + 0.5D - par1Entity.posZ;
                label222:

                for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
                {
                    if (this.worldServerInstance.isAirBlock(i2, i3, k2))
                    {
                        while (i3 > 0 && this.worldServerInstance.isAirBlock(i2, i3 - 1, k2))
                        {
                            --i3;
                        }

                        for (j3 = l1; j3 < l1 + 2; ++j3)
                        {
                            k3 = j3 % 2;
                            l3 = 1 - k3;

                            for (i4 = 0; i4 < 4; ++i4)
                            {
                                for (j4 = -1; j4 < 4; ++j4)
                                {
                                    k4 = i2 + (i4 - 1) * k3;
                                    l4 = i3 + j4;
                                    i5 = k2 + (i4 - 1) * l3;

                                    if (j4 < 0 && !this.worldServerInstance.getBlock(k4, l4, i5).getMaterial().isSolid() || j4 >= 0 && !this.worldServerInstance.isAirBlock(k4, l4, i5))
                                    {
                                        continue label222;
                                    }
                                }
                            }

                            d3 = (double)i3 + 0.5D - par1Entity.posY;
                            d4 = d1 * d1 + d3 * d3 + d2 * d2;

                            if (d0 < 0.0D || d4 < d0)
                            {
                                d0 = d4;
                                l = i2;
                                i1 = i3;
                                j1 = k2;
                                k1 = j3 % 2;
                            }
                        }
                    }
                }
            }
        }
    }

    int k5 = l;
    int j2 = i1;
    k2 = j1;
    int l5 = k1 % 2;
    int l2 = 1 - l5;

    if (k1 % 4 >= 2)
    {
        l5 = -l5;
        l2 = -l2;
    }

    boolean flag;

    if (d0 < 0.0D)
    {
        if (i1 < 70)
        {
            i1 = 70;
        }

        if (i1 > this.worldServerInstance.getActualHeight() - 10)
        {
            i1 = this.worldServerInstance.getActualHeight() - 10;
        }

        j2 = i1;

        for (i3 = -1; i3 <= 1; ++i3)
        {
            for (j3 = 1; j3 < 3; ++j3)
            {
                for (k3 = -1; k3 < 3; ++k3)
                {
                    l3 = k5 + (j3 - 1) * l5 + i3 * l2;
                    i4 = j2 + k3;
                    j4 = k2 + (j3 - 1) * l2 - i3 * l5;
                    flag = k3 < 0;
                    this.worldServerInstance.setBlock(l3, i4, j4, flag ? Blocks.mossy_cobblestone : Blocks.air);
                }
            }
        }
    }

    for (i3 = 0; i3 < 4; ++i3)
    {
        for (j3 = 0; j3 < 4; ++j3)
        {
            for (k3 = -1; k3 < 4; ++k3)
            {
                l3 = k5 + (j3 - 1) * l5;
                i4 = j2 + k3;
                j4 = k2 + (j3 - 1) * l2;
                flag = j3 == 0 || j3 == 3 || k3 == -1 || k3 == 3;
                this.worldServerInstance.setBlock(l3, i4, j4, (Block)(flag ? Blocks.mossy_cobblestone : LotsOMobsBlocks.DinoPortal), 0, 2);
            }
        }

        for (j3 = 0; j3 < 4; ++j3)
        {
            for (k3 = -1; k3 < 4; ++k3)
            {
                l3 = k5 + (j3 - 1) * l5;
                i4 = j2 + k3;
                j4 = k2 + (j3 - 1) * l2;
                this.worldServerInstance.notifyBlocksOfNeighborChange(l3, i4, j4, this.worldServerInstance.getBlock(l3, i4, j4));
            }
        }
    }

    return true;
}
/**
         * called periodically to remove out-of-date portal locations from the cache list. Argument par1 is a
         * WorldServer.getTotalWorldTime() value.
         */
public void removeStalePortalLocations(long par1)
{
         if (par1 % 100L == 0L)
         {
                 Iterator iterator = this.destinationCoordinateKeys.iterator();
                 long j = par1 - 600L;
                 while (iterator.hasNext())
                 {
                         Long olong = (Long)iterator.next();
                         PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());
                         if (portalposition == null || portalposition.lastUpdateTime < j)
                         {
                                 iterator.remove();
                                 this.destinationCoordinateCache.remove(olong.longValue());
                         }
                 }
         }
}
}