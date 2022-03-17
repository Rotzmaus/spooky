
package net.mcreator.spooky.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.spooky.init.SpookyModItems;

public class DruidSwordItem extends SwordItem {
	public DruidSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 700;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 17;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(SpookyModItems.DRUID_DUST));
			}
		}, 3, -2.2999999999999998f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
		setRegistryName("druid_sword");
	}
}
