package net.mcreator.spooky.network;

import net.minecraftforge.fmllegacy.network.PacketDistributor;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.spooky.SpookyMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpookyModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SpookyMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.effectiveHealthPointsMax = original.effectiveHealthPointsMax;
			clone.effectiveHealthPoints = original.effectiveHealthPoints;
			clone.playerLevel = original.playerLevel;
			clone.playerEXP = original.playerEXP;
			clone.playerEXPneeded = original.playerEXPneeded;
			clone.showStatsOverlay = original.showStatsOverlay;
			clone.safeEXPWehnLeveling = original.safeEXPWehnLeveling;
			clone.Helmet = original.Helmet;
			clone.Chestplate = original.Chestplate;
			clone.Leggins = original.Leggins;
			clone.Boots = original.Boots;
			clone.HelmetMatch = original.HelmetMatch;
			clone.HelmetMathOff = original.HelmetMathOff;
			clone.HelmetCalcOff = original.HelmetCalcOff;
			clone.ChestplateMathOn = original.ChestplateMathOn;
			clone.LegginsMathOn = original.LegginsMathOn;
			clone.BootsMathOn = original.BootsMathOn;
			clone.ChestplateMathOff = original.ChestplateMathOff;
			clone.LegginsMathOff = original.LegginsMathOff;
			clone.BootsMathOff = original.BootsMathOff;
			clone.ChestplateCalcOff = original.ChestplateCalcOff;
			clone.LegginsCalcOff = original.LegginsCalcOff;
			clone.BootsCalcOff = original.BootsCalcOff;
			clone.Spawnchance = original.Spawnchance;
			clone.HotPlacesLevel = original.HotPlacesLevel;
			clone.HotPlacesExp = original.HotPlacesExp;
			clone.HotPlacesEXPNeeded = original.HotPlacesEXPNeeded;
			clone.SafeHotPlacesExp = original.SafeHotPlacesExp;
			clone.Regen = original.Regen;
			clone.RegenTime = original.RegenTime;
			clone.RegenLevel = original.RegenLevel;
			clone.PlainsLevel = original.PlainsLevel;
			clone.PlainsEXP = original.PlainsEXP;
			clone.PlainsEXPNeeded = original.PlainsEXPNeeded;
			clone.ForestLevel = original.ForestLevel;
			clone.ForestEXP = original.ForestEXP;
			clone.ForestEXPNeeded = original.ForestEXPNeeded;
			clone.AngryChickenKilled = original.AngryChickenKilled;
			clone.AnimeCowKilled = original.AnimeCowKilled;
			clone.Money = original.Money;
			clone.OstrichKilled = original.OstrichKilled;
			clone.CrocsSportMode = original.CrocsSportMode;
			clone.BoarKilled = original.BoarKilled;
			clone.SandGoblinKilled = original.SandGoblinKilled;
			clone.WaterLevel = original.WaterLevel;
			clone.WaterExp = original.WaterExp;
			clone.WaterEXPNeeded = original.WaterEXPNeeded;
			clone.ActivePlainsLevel = original.ActivePlainsLevel;
			clone.ActiveHPLevel = original.ActiveHPLevel;
			clone.ColdPLacesLevel = original.ColdPLacesLevel;
			clone.ColdPLacesEXP = original.ColdPLacesEXP;
			clone.ColdPlacesEXPNeeded = original.ColdPlacesEXPNeeded;
			clone.DoublejumpReady = original.DoublejumpReady;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("spooky", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double effectiveHealthPointsMax = 5.0;
		public double effectiveHealthPoints = 5.0;
		public double playerLevel = 0;
		public double playerEXP = 0;
		public double playerEXPneeded = 0.0;
		public boolean showStatsOverlay = false;
		public double safeEXPWehnLeveling = 0;
		public boolean Helmet = false;
		public boolean Chestplate = false;
		public boolean Leggins = false;
		public boolean Boots = false;
		public boolean HelmetMatch = false;
		public boolean HelmetMathOff = true;
		public double HelmetCalcOff = 1.0;
		public boolean ChestplateMathOn = false;
		public boolean LegginsMathOn = false;
		public boolean BootsMathOn = false;
		public boolean ChestplateMathOff = true;
		public boolean LegginsMathOff = true;
		public boolean BootsMathOff = true;
		public double ChestplateCalcOff = 1.0;
		public double LegginsCalcOff = 1.0;
		public double BootsCalcOff = 1.0;
		public double Spawnchance = 0.98;
		public double HotPlacesLevel = 1.0;
		public double HotPlacesExp = 0.0;
		public double HotPlacesEXPNeeded = 100.0;
		public double SafeHotPlacesExp = 0.0;
		public double Regen = 0;
		public double RegenTime = 10.0;
		public double RegenLevel = 1.0;
		public double PlainsLevel = 0;
		public double PlainsEXP = 0.0;
		public double PlainsEXPNeeded = 100.0;
		public double ForestLevel = 0;
		public double ForestEXP = 0;
		public double ForestEXPNeeded = 100.0;
		public boolean AngryChickenKilled = false;
		public boolean AnimeCowKilled = false;
		public double Money = 0;
		public boolean OstrichKilled = false;
		public boolean CrocsSportMode = false;
		public boolean BoarKilled = false;
		public boolean SandGoblinKilled = false;
		public double WaterLevel = 0;
		public double WaterExp = 0;
		public double WaterEXPNeeded = 100.0;
		public double ActivePlainsLevel = 0;
		public double ActiveHPLevel = 0;
		public double ColdPLacesLevel = 0;
		public double ColdPLacesEXP = 0;
		public double ColdPlacesEXPNeeded = 100.0;
		public boolean DoublejumpReady = true;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				SpookyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("effectiveHealthPointsMax", effectiveHealthPointsMax);
			nbt.putDouble("effectiveHealthPoints", effectiveHealthPoints);
			nbt.putDouble("playerLevel", playerLevel);
			nbt.putDouble("playerEXP", playerEXP);
			nbt.putDouble("playerEXPneeded", playerEXPneeded);
			nbt.putBoolean("showStatsOverlay", showStatsOverlay);
			nbt.putDouble("safeEXPWehnLeveling", safeEXPWehnLeveling);
			nbt.putBoolean("Helmet", Helmet);
			nbt.putBoolean("Chestplate", Chestplate);
			nbt.putBoolean("Leggins", Leggins);
			nbt.putBoolean("Boots", Boots);
			nbt.putBoolean("HelmetMatch", HelmetMatch);
			nbt.putBoolean("HelmetMathOff", HelmetMathOff);
			nbt.putDouble("HelmetCalcOff", HelmetCalcOff);
			nbt.putBoolean("ChestplateMathOn", ChestplateMathOn);
			nbt.putBoolean("LegginsMathOn", LegginsMathOn);
			nbt.putBoolean("BootsMathOn", BootsMathOn);
			nbt.putBoolean("ChestplateMathOff", ChestplateMathOff);
			nbt.putBoolean("LegginsMathOff", LegginsMathOff);
			nbt.putBoolean("BootsMathOff", BootsMathOff);
			nbt.putDouble("ChestplateCalcOff", ChestplateCalcOff);
			nbt.putDouble("LegginsCalcOff", LegginsCalcOff);
			nbt.putDouble("BootsCalcOff", BootsCalcOff);
			nbt.putDouble("Spawnchance", Spawnchance);
			nbt.putDouble("HotPlacesLevel", HotPlacesLevel);
			nbt.putDouble("HotPlacesExp", HotPlacesExp);
			nbt.putDouble("HotPlacesEXPNeeded", HotPlacesEXPNeeded);
			nbt.putDouble("SafeHotPlacesExp", SafeHotPlacesExp);
			nbt.putDouble("Regen", Regen);
			nbt.putDouble("RegenTime", RegenTime);
			nbt.putDouble("RegenLevel", RegenLevel);
			nbt.putDouble("PlainsLevel", PlainsLevel);
			nbt.putDouble("PlainsEXP", PlainsEXP);
			nbt.putDouble("PlainsEXPNeeded", PlainsEXPNeeded);
			nbt.putDouble("ForestLevel", ForestLevel);
			nbt.putDouble("ForestEXP", ForestEXP);
			nbt.putDouble("ForestEXPNeeded", ForestEXPNeeded);
			nbt.putBoolean("AngryChickenKilled", AngryChickenKilled);
			nbt.putBoolean("AnimeCowKilled", AnimeCowKilled);
			nbt.putDouble("Money", Money);
			nbt.putBoolean("OstrichKilled", OstrichKilled);
			nbt.putBoolean("CrocsSportMode", CrocsSportMode);
			nbt.putBoolean("BoarKilled", BoarKilled);
			nbt.putBoolean("SandGoblinKilled", SandGoblinKilled);
			nbt.putDouble("WaterLevel", WaterLevel);
			nbt.putDouble("WaterExp", WaterExp);
			nbt.putDouble("WaterEXPNeeded", WaterEXPNeeded);
			nbt.putDouble("ActivePlainsLevel", ActivePlainsLevel);
			nbt.putDouble("ActiveHPLevel", ActiveHPLevel);
			nbt.putDouble("ColdPLacesLevel", ColdPLacesLevel);
			nbt.putDouble("ColdPLacesEXP", ColdPLacesEXP);
			nbt.putDouble("ColdPlacesEXPNeeded", ColdPlacesEXPNeeded);
			nbt.putBoolean("DoublejumpReady", DoublejumpReady);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			effectiveHealthPointsMax = nbt.getDouble("effectiveHealthPointsMax");
			effectiveHealthPoints = nbt.getDouble("effectiveHealthPoints");
			playerLevel = nbt.getDouble("playerLevel");
			playerEXP = nbt.getDouble("playerEXP");
			playerEXPneeded = nbt.getDouble("playerEXPneeded");
			showStatsOverlay = nbt.getBoolean("showStatsOverlay");
			safeEXPWehnLeveling = nbt.getDouble("safeEXPWehnLeveling");
			Helmet = nbt.getBoolean("Helmet");
			Chestplate = nbt.getBoolean("Chestplate");
			Leggins = nbt.getBoolean("Leggins");
			Boots = nbt.getBoolean("Boots");
			HelmetMatch = nbt.getBoolean("HelmetMatch");
			HelmetMathOff = nbt.getBoolean("HelmetMathOff");
			HelmetCalcOff = nbt.getDouble("HelmetCalcOff");
			ChestplateMathOn = nbt.getBoolean("ChestplateMathOn");
			LegginsMathOn = nbt.getBoolean("LegginsMathOn");
			BootsMathOn = nbt.getBoolean("BootsMathOn");
			ChestplateMathOff = nbt.getBoolean("ChestplateMathOff");
			LegginsMathOff = nbt.getBoolean("LegginsMathOff");
			BootsMathOff = nbt.getBoolean("BootsMathOff");
			ChestplateCalcOff = nbt.getDouble("ChestplateCalcOff");
			LegginsCalcOff = nbt.getDouble("LegginsCalcOff");
			BootsCalcOff = nbt.getDouble("BootsCalcOff");
			Spawnchance = nbt.getDouble("Spawnchance");
			HotPlacesLevel = nbt.getDouble("HotPlacesLevel");
			HotPlacesExp = nbt.getDouble("HotPlacesExp");
			HotPlacesEXPNeeded = nbt.getDouble("HotPlacesEXPNeeded");
			SafeHotPlacesExp = nbt.getDouble("SafeHotPlacesExp");
			Regen = nbt.getDouble("Regen");
			RegenTime = nbt.getDouble("RegenTime");
			RegenLevel = nbt.getDouble("RegenLevel");
			PlainsLevel = nbt.getDouble("PlainsLevel");
			PlainsEXP = nbt.getDouble("PlainsEXP");
			PlainsEXPNeeded = nbt.getDouble("PlainsEXPNeeded");
			ForestLevel = nbt.getDouble("ForestLevel");
			ForestEXP = nbt.getDouble("ForestEXP");
			ForestEXPNeeded = nbt.getDouble("ForestEXPNeeded");
			AngryChickenKilled = nbt.getBoolean("AngryChickenKilled");
			AnimeCowKilled = nbt.getBoolean("AnimeCowKilled");
			Money = nbt.getDouble("Money");
			OstrichKilled = nbt.getBoolean("OstrichKilled");
			CrocsSportMode = nbt.getBoolean("CrocsSportMode");
			BoarKilled = nbt.getBoolean("BoarKilled");
			SandGoblinKilled = nbt.getBoolean("SandGoblinKilled");
			WaterLevel = nbt.getDouble("WaterLevel");
			WaterExp = nbt.getDouble("WaterExp");
			WaterEXPNeeded = nbt.getDouble("WaterEXPNeeded");
			ActivePlainsLevel = nbt.getDouble("ActivePlainsLevel");
			ActiveHPLevel = nbt.getDouble("ActiveHPLevel");
			ColdPLacesLevel = nbt.getDouble("ColdPLacesLevel");
			ColdPLacesEXP = nbt.getDouble("ColdPLacesEXP");
			ColdPlacesEXPNeeded = nbt.getDouble("ColdPlacesEXPNeeded");
			DoublejumpReady = nbt.getBoolean("DoublejumpReady");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.effectiveHealthPointsMax = message.data.effectiveHealthPointsMax;
					variables.effectiveHealthPoints = message.data.effectiveHealthPoints;
					variables.playerLevel = message.data.playerLevel;
					variables.playerEXP = message.data.playerEXP;
					variables.playerEXPneeded = message.data.playerEXPneeded;
					variables.showStatsOverlay = message.data.showStatsOverlay;
					variables.safeEXPWehnLeveling = message.data.safeEXPWehnLeveling;
					variables.Helmet = message.data.Helmet;
					variables.Chestplate = message.data.Chestplate;
					variables.Leggins = message.data.Leggins;
					variables.Boots = message.data.Boots;
					variables.HelmetMatch = message.data.HelmetMatch;
					variables.HelmetMathOff = message.data.HelmetMathOff;
					variables.HelmetCalcOff = message.data.HelmetCalcOff;
					variables.ChestplateMathOn = message.data.ChestplateMathOn;
					variables.LegginsMathOn = message.data.LegginsMathOn;
					variables.BootsMathOn = message.data.BootsMathOn;
					variables.ChestplateMathOff = message.data.ChestplateMathOff;
					variables.LegginsMathOff = message.data.LegginsMathOff;
					variables.BootsMathOff = message.data.BootsMathOff;
					variables.ChestplateCalcOff = message.data.ChestplateCalcOff;
					variables.LegginsCalcOff = message.data.LegginsCalcOff;
					variables.BootsCalcOff = message.data.BootsCalcOff;
					variables.Spawnchance = message.data.Spawnchance;
					variables.HotPlacesLevel = message.data.HotPlacesLevel;
					variables.HotPlacesExp = message.data.HotPlacesExp;
					variables.HotPlacesEXPNeeded = message.data.HotPlacesEXPNeeded;
					variables.SafeHotPlacesExp = message.data.SafeHotPlacesExp;
					variables.Regen = message.data.Regen;
					variables.RegenTime = message.data.RegenTime;
					variables.RegenLevel = message.data.RegenLevel;
					variables.PlainsLevel = message.data.PlainsLevel;
					variables.PlainsEXP = message.data.PlainsEXP;
					variables.PlainsEXPNeeded = message.data.PlainsEXPNeeded;
					variables.ForestLevel = message.data.ForestLevel;
					variables.ForestEXP = message.data.ForestEXP;
					variables.ForestEXPNeeded = message.data.ForestEXPNeeded;
					variables.AngryChickenKilled = message.data.AngryChickenKilled;
					variables.AnimeCowKilled = message.data.AnimeCowKilled;
					variables.Money = message.data.Money;
					variables.OstrichKilled = message.data.OstrichKilled;
					variables.CrocsSportMode = message.data.CrocsSportMode;
					variables.BoarKilled = message.data.BoarKilled;
					variables.SandGoblinKilled = message.data.SandGoblinKilled;
					variables.WaterLevel = message.data.WaterLevel;
					variables.WaterExp = message.data.WaterExp;
					variables.WaterEXPNeeded = message.data.WaterEXPNeeded;
					variables.ActivePlainsLevel = message.data.ActivePlainsLevel;
					variables.ActiveHPLevel = message.data.ActiveHPLevel;
					variables.ColdPLacesLevel = message.data.ColdPLacesLevel;
					variables.ColdPLacesEXP = message.data.ColdPLacesEXP;
					variables.ColdPlacesEXPNeeded = message.data.ColdPlacesEXPNeeded;
					variables.DoublejumpReady = message.data.DoublejumpReady;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
