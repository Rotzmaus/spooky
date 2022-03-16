
package net.mcreator.spooky.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.spooky.init.SpookyModTabs;

import java.util.List;

public class AngryFeatherItem extends Item {
	public AngryFeatherItem() {
		super(new Item.Properties().tab(SpookyModTabs.TAB_MOD_ITEMS).stacksTo(64).rarity(Rarity.UNCOMMON));
		setRegistryName("angry_feather");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Looks like a normal Feather..."));
		list.add(new TextComponent("And yet I feel its fury"));
	}
}
