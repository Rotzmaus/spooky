
package net.mcreator.spooky.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.spooky.procedures.HelmettickeventProcedure;
import net.mcreator.spooky.procedures.ChestplateTickEventProcedure;
import net.mcreator.spooky.procedures.BootsTickEventProcedure;
import net.mcreator.spooky.init.SpookyModItems;

import java.util.List;

public abstract class BronzeSetAugItem extends ArmorItem {
	public BronzeSetAugItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 50;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 4, 5, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(SpookyModItems.BRONZE_DUST));
			}

			@Override
			public String getName() {
				return "bronze_set_aug";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends BronzeSetAugItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("bronze_set_aug_helmet");
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A75Level 1"));
			list.add(new TextComponent("\u00A76Augmented with sturdy Fangs"));
			list.add(new TextComponent("\u00A72Health x 1.075"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "spooky:textures/models/armor/augbronzeset_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			HelmettickeventProcedure.execute(entity);
		}
	}

	public static class Chestplate extends BronzeSetAugItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("bronze_set_aug_chestplate");
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A75Level1"));
			list.add(new TextComponent("\u00A77Looks Cute and feels Nice :)"));
			list.add(new TextComponent("\u00A72Health x 1.125"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "spooky:textures/models/armor/augbronzeset_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			ChestplateTickEventProcedure.execute(entity);
		}
	}

	public static class Boots extends BronzeSetAugItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("bronze_set_aug_boots");
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A75Level 1"));
			list.add(new TextComponent("\u00A7dOstrichfeatherlight Crocs"));
			list.add(new TextComponent("\u00A7dwith Extra Holes for Breathing;)"));
			list.add(new TextComponent("\u00A72Health x 1.025"));
			list.add(new TextComponent("\u00A7bPress B Key"));
			list.add(new TextComponent("\u00A7b To put Crocs in Sport mode"));
			list.add(new TextComponent("\u00A7b(Speed 2 for limited time)"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "spooky:textures/models/armor/augbronzeset_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			BootsTickEventProcedure.execute(entity);
		}
	}
}
