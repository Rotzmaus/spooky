
package net.mcreator.spooky.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.spooky.init.SpookyModItems;

public class BronzeSwordItem extends SwordItem {
	public BronzeSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 500;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(SpookyModItems.BRONZE_DUST));
			}
		}, 3, -2.3f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
		setRegistryName("bronze_sword");
	}
}
