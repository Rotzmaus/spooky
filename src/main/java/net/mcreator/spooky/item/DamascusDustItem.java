
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

public class DamascusDustItem extends Item {
	public DamascusDustItem() {
		super(new Item.Properties().tab(SpookyModTabs.TAB_MOD_ITEMS).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("damascus_dust");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Used for crafting"));
	}
}