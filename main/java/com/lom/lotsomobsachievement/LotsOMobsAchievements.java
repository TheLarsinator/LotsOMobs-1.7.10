package com.lom.lotsomobsachievement;

import net.minecraftforge.event.world.BlockEvent;

import com.lom.lotsomobscore.handler.ConfigHandler;
import com.lom.lotsomobsinit.LotsOMobsAchievementsBook;
import com.lom.lotsomobsinit.LotsOMobsBlocks;
import com.lom.lotsomobsinit.LotsOMobsItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;


public class LotsOMobsAchievements
{
	@SubscribeEvent
	public void OnItemPickUp(PlayerEvent.ItemPickupEvent event)
	{
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawVenison)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementDeer, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawBoar)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementBoar, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawCamel)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementCamel, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawReptile)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementReptile, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawWhale)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementWhale, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawLion)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementLion, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawFrog)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementFrog, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.RawPenguin)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementPenguin, 1);
		}	
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.DinoBone)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementDino, 1);
		}	
		if(event.pickedUp.getEntityItem().getItem() == LotsOMobsItems.WoolyFur)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementIceCreature, 1);
		}	
	}
	
	@SubscribeEvent
	public void OnLogIn(PlayerEvent.PlayerLoggedInEvent event)
	{
		event.player.addStat(LotsOMobsAchievementsBook.AchievementLogIn, 1);
		
	}
	
	@SubscribeEvent
	public void OnTeleport(PlayerEvent.PlayerChangedDimensionEvent event)
	{
		if(event.toDim == ConfigHandler.dimension)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementDino, 1);
		}
		else if(event.toDim == ConfigHandler.dimension2)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementIceAge, 1);
		}
	}
	
	@SubscribeEvent
	public void OnBlockBreak(BlockEvent.BreakEvent event)
	{
		if(event.block == LotsOMobsBlocks.FossilOre)
		{
			event.getPlayer().addStat(LotsOMobsAchievementsBook.AchievementFossil, 1);
		}
		if(event.block == LotsOMobsBlocks.AmberOre)
		{
			event.getPlayer().addStat(LotsOMobsAchievementsBook.AchievementAmber, 1);
		}
		if(event.block == LotsOMobsBlocks.IcemintuimOre)
		{
			event.getPlayer().addStat(LotsOMobsAchievementsBook.AchievementIcemintuim, 1);
		}
	}
	
	@SubscribeEvent
	public void OnCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		System.out.println("DebugMSG");

		if(event.crafting.getItem() == LotsOMobsItems.IcemintuimSword || event.crafting.getItem() == LotsOMobsItems.IcemintuimShovel || event.crafting.getItem() == LotsOMobsItems.IcemintuimAxe || event.crafting.getItem() == LotsOMobsItems.IcemintuimPickaxe || event.crafting.getItem() == LotsOMobsItems.IcemintuimHoe)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementIceTool, 1);
		}
		if(event.crafting.getItem() == LotsOMobsItems.AmberSword || event.crafting.getItem() == LotsOMobsItems.AmberShovel || event.crafting.getItem() == LotsOMobsItems.AmberAxe || event.crafting.getItem() == LotsOMobsItems.AmberPickaxe || event.crafting.getItem() == LotsOMobsItems.AmberHoe)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementAmberTool, 1);
		}
		if(event.crafting.getItem() == LotsOMobsItems.IcemintuimHelmet || event.crafting.getItem() == LotsOMobsItems.IcemintuimChestplate || event.crafting.getItem() == LotsOMobsItems.IcemintuimLeggings || event.crafting.getItem() == LotsOMobsItems.IcemintuimBoots)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementIceArmor, 1);
		}
		if(event.crafting.getItem() == LotsOMobsItems.AmberHelmet || event.crafting.getItem() == LotsOMobsItems.AmberChestplate || event.crafting.getItem() == LotsOMobsItems.AmberLeggings)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementAmberArmor, 1);
		}
		if(event.crafting.getItem() == LotsOMobsItems.EskimoHelmet || event.crafting.getItem() == LotsOMobsItems.EskimoChestplate || event.crafting.getItem() == LotsOMobsItems.EskimoLeggings || event.crafting.getItem() == LotsOMobsItems.EskimoBoots)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementEskimoArmor, 1);
		}
		if(event.crafting.getItem() == LotsOMobsItems.DinoFurHelmet || event.crafting.getItem() == LotsOMobsItems.DinoFurChestplate || event.crafting.getItem() == LotsOMobsItems.DinoFurLeggings)
		{
			event.player.addStat(LotsOMobsAchievementsBook.AchievementDinoArmor, 1);
		}
	}
}
