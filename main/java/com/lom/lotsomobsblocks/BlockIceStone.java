package com.lom.lotsomobsblocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.lom.lotsomobscore.LotsOMobs;
import com.lom.lotsomobsinit.LotsOMobsBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIceStone extends Block
{

	public BlockIceStone(int par1, Material par2Material) {
        super(Material.rock);
        this.setCreativeTab(LotsOMobs.LotsOMobsBlockTab);
}

public Item getItemDropped(int par1, Random par2Random, int par3)
{
        return Item.getItemFromBlock(LotsOMobsBlocks.IceCobble);
}
@Override
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister iconRegister)
{

   blockIcon = iconRegister.registerIcon(LotsOMobs.modid + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
}

}
