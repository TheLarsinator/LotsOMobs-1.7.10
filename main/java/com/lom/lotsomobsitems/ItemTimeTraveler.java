package com.lom.lotsomobsitems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.lom.lotsomobscore.ConfigDetails;
import com.lom.lotsomobscore.LotsOMobs;
import com.lom.lotsomobsdino.TeleporterDino;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTimeTraveler extends Item
{
    public ItemTimeTraveler()
    {
        super();
        this.maxStackSize = 1;
        this.setCreativeTab(LotsOMobs.LotsOMobsItemsTab);
        this.setMaxDamage(20);      
    }
	

public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par5Entity)
{
    if (par5Entity instanceof EntityPlayerMP)
    {
     EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
     if (par5Entity.dimension != ConfigDetails.dimension)
     {
      thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, ConfigDetails.dimension, new TeleporterDino(thePlayer.mcServer.worldServerForDimension(ConfigDetails.dimension)));
     }
     else
     {
      thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterDino(thePlayer.mcServer.worldServerForDimension(0)));
     }
    }
    return par1ItemStack;
}
}