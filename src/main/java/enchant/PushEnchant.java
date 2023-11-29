package enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Vec3d;

import static java.lang.Math.*;

public class PushEnchant extends Enchantment {

	public PushEnchant() {
		super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	}
	@Override
	public int getMinPower(int level) {
		return 1;
	}
	@Override
	public int getMaxLevel() {
		return 5;
	}
	@Override
		public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		double yaw = -user.prevPitch * 0.0349066;
		double pitch = -user.prevHeadYaw * 0.0174533;
		double x = cos(yaw) * sin(pitch);
		double y = -sin(yaw);
		double z = cos(yaw) * cos(pitch);
		Vec3d playerVelocity = user.getVelocity();
		double magnitude = sqrt(playerVelocity.x * playerVelocity.x + playerVelocity.y * playerVelocity.y + playerVelocity.z * playerVelocity.z);
		if(target instanceof LivingEntity) {
			int ymag = 1;
			if (y < 0 && !target.isTouchingWater()) {
				user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 15 * 4 * level, level / 2));
				user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 15 * 4 * level, level / 2));
				user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 4 * level, level * 2));
				ymag = 50;
			}
			target.addVelocity(
				x * (level * 0.10 + 1) * magnitude,
				y * (level * 0.10 + 1) * magnitude * ymag,
				z * (level * 0.10 + 1) * magnitude);
		}
		super.onTargetDamaged(user, target, level);
	}
}
