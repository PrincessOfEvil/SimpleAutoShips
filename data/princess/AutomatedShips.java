package data.princess;

import java.awt.Color;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.FleetDataAPI;
import com.fs.starfarer.api.characters.CharacterStatsSkillEffect;
import com.fs.starfarer.api.characters.DescriptionSkillEffect;
import com.fs.starfarer.api.characters.FleetTotalItem;
import com.fs.starfarer.api.characters.FleetTotalSource;
import com.fs.starfarer.api.characters.LevelBasedEffect;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.characters.SkillSpecAPI;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.AICoreOfficerPluginImpl;
import com.fs.starfarer.api.impl.campaign.ids.Skills;
import com.fs.starfarer.api.impl.campaign.ids.Strings;
import com.fs.starfarer.api.impl.campaign.ids.Tags;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.impl.hullmods.Automated;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.util.Misc;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class AutomatedShips
	{
	public static class LevelE extends BaseSkillEffectDescription implements CharacterStatsSkillEffect
		{
		public void apply(MutableCharacterStatsAPI stats, String id, float level)
			{
			if (stats.isPlayerStats())
				{
				Misc.getAllowedRecoveryTags().add(Tags.AUTOMATED_RECOVERABLE);
				}
			}

		public void unapply(MutableCharacterStatsAPI stats, String id)
			{
			if (stats.isPlayerStats())
				{
				Misc.getAllowedRecoveryTags().remove(Tags.AUTOMATED_RECOVERABLE);
				}
			}
		
		public void createCustomDescription(MutableCharacterStatsAPI stats, SkillSpecAPI skill, TooltipMakerAPI info, float width)
			{			
			init(stats, skill);
			info.addPara("Enables the recovery of some automated ships, such as derelict drones", hc, 0f);
			info.addSpacer(5f);
			}
		
		public String getEffectPerLevelDescription()
			{
			return null;
			}

		public ScopeDescription getScopeDescription()
			{
			return ScopeDescription.FLEET;
			}
		}
		
	public static class LevelPi extends BaseSkillEffectDescription implements CharacterStatsSkillEffect
		{
	//	private static Logger logger = Global.getLogger(LevelPi.class);
		
		public void apply(MutableCharacterStatsAPI stats, String id, float level) { }
 		public void unapply(MutableCharacterStatsAPI stats, String id) { }
 		
		public void createCustomDescription(MutableCharacterStatsAPI stats, SkillSpecAPI skill, TooltipMakerAPI info, float width)
			{
		/*	try
				{
				logger.log(Level.INFO, Global.getSettings().loadJSON("data/characters/skills/automated_ships.skill"));
				}
			catch (Throwable t) 
				{
				logger.log(Level.INFO, "weewooweewoo", t);
				}*/
			
			init(stats, skill);
			info.addPara("Enables attaching officers to automated ships", this.hc, 0.0F);
			info.addPara("Automated ships can only be captained by AI cores", this.hc, 0.0F);
			info.addSpacer(5.0F);
			}
		
		public String getEffectPerLevelDescription()
			{
			return null;
			}
		
		public LevelBasedEffect.ScopeDescription getScopeDescription()
			{
			return LevelBasedEffect.ScopeDescription.FLEET;
			}
		}
	}





