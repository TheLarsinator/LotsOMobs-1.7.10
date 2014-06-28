package com.lom.lotsomobscore;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LotsOMobsConfigEvent 
{
	   @SubscribeEvent
	   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) 
	   {
		   System.out.println(eventArgs.modID);
	        if(eventArgs.modID.equals("lom"))
	        {
	 		   System.out.println("Oh! There you are!");
	 		   LotsOMobs.syncConfig();
	        }
	   }
}
