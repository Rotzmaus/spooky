
package net.mcreator.spooky.network;

import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.spooky.world.inventory.HotPlacesSpawnomaticMenu;
import net.mcreator.spooky.procedures.ConvertHPDropsProcedure;
import net.mcreator.spooky.procedures.ActivePlainsUpProcedure;
import net.mcreator.spooky.procedures.ActivePlainsDownProcedure;
import net.mcreator.spooky.SpookyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HotPlacesSpawnomaticButtonMessage {
	private final int buttonID, x, y, z;

	public HotPlacesSpawnomaticButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public HotPlacesSpawnomaticButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(HotPlacesSpawnomaticButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(HotPlacesSpawnomaticButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = HotPlacesSpawnomaticMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConvertHPDropsProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			ActivePlainsDownProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ActivePlainsUpProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SpookyMod.addNetworkMessage(HotPlacesSpawnomaticButtonMessage.class, HotPlacesSpawnomaticButtonMessage::buffer,
				HotPlacesSpawnomaticButtonMessage::new, HotPlacesSpawnomaticButtonMessage::handler);
	}
}
