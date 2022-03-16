
package net.mcreator.spooky.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.spooky.procedures.Spawnomatic1Procedure;
import net.mcreator.spooky.init.SpookyModTabs;

import java.util.List;

public class SpawnOMaticItem extends Item {
	public SpawnOMaticItem() {
		super(new Item.Properties().tab(SpookyModTabs.TAB_MOD_ITEMS).stacksTo(1).fireResistant().rarity(Rarity.EPIC));
		setRegistryName("spawn_o_matic");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("\u00A7dUsed To Manipulate Spawnig"));
		list.add(new TextComponent("\u00A7dUse with care!"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Spawnomatic1Procedure.execute(world, x, y, z, entity);
		return ar;
	}
}
