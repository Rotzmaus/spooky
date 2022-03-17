
package net.mcreator.spooky.item;

import net.minecraft.sounds.SoundEvent;

public abstract class DruidSetItem extends ArmorItem {

	public DruidSetItem(EquipmentSlot slot, Item.Properties properties) {
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
				return "druid_set";
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

	public static class Helmet extends DruidSetItem {

		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));

			setRegistryName("druid_set_helmet");
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A72Health x 1.05"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "spooky:textures/models/armor/bronzeset_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			HelmettickeventProcedure.execute(entity);
		}
	}

	public static class Chestplate extends DruidSetItem {

		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));

			setRegistryName("druid_set_chestplate");
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A72Health x 1.1"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "spooky:textures/models/armor/bronzeset_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			ChestplateTickEventProcedure.execute(entity);
		}
	}

	public static class Leggings extends DruidSetItem {

		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));

			setRegistryName("druid_set_leggings");
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A72Health x 1.075"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "spooky:textures/models/armor/bronzeset_layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			LegginsTickEventProcedure.execute(entity);
		}
	}

	public static class Boots extends DruidSetItem {

		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));

			setRegistryName("druid_set_boots");
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A72Health x 1.025"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "spooky:textures/models/armor/bronzeset_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			BootsTickEventProcedure.execute(entity);
		}
	}

}
