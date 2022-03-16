/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.spooky as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.spooky;

import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;

public class BoarLeapGoal extends LeapAtTargetGoal {
   private final Mob mob;
   private LivingEntity target;
   private final float yd;

   public BoarLeapGoal(Mob p_25492_, float p_25493_) {
   	super (p_25492_, p_25493_);
      this.mob = p_25492_;
      this.yd = p_25493_;
   }

   public boolean canUse() {
      if (this.mob.isVehicle()) {
         return false;
      } else {
         this.target = this.mob.getTarget();
         if (this.target == null) {
            return false;
         } else {
            double d0 = this.mob.distanceToSqr(this.target);
            if (!(d0 < 3.5D) && !(d0 > 16.0D)) {
               if (!this.mob.isOnGround()) {
                  return false;
               } else {
                  return this.mob.getRandom().nextInt(5) == 0;
               }
            } else {
               return false;
            }
         }
      }
   }

   public boolean canContinueToUse() {
      return !this.mob.isOnGround();
   }

   public void start() {
      Vec3 vec3 = this.mob.getDeltaMovement();
      Vec3 vec31 = new Vec3(this.target.getX() - this.mob.getX(), 0.0D, this.target.getZ() - this.mob.getZ());
      if (vec31.lengthSqr() > 1.0E-7D) {
         vec31 = vec31.normalize().scale(0.4D).add(vec3.scale(0.2D));
      }

      this.mob.setDeltaMovement(((vec31.x) * 3.5D), (double)this.yd , ((vec31.z) * 3.5D));
		// damage
      this.mob.doHurtTarget(mob.getTarget());
   }
}
