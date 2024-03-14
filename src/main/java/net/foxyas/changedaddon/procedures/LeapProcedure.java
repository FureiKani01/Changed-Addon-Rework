package net.foxyas.changedaddon.procedures;

import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.foxyas.changedaddon.network.ChangedAddonModVariables;

public class LeapProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double motionZ = 0;
		double deltaZ = 0;
		double distance = 0;
		double deltaX = 0;
		double motionY = 0;
		double deltaY = 0;
		double motionX = 0;
		double maxSpeed = 0;
		double speed = 0;
		double Yspeed = 0;
		if ((entity.getCapability(ChangedAddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ChangedAddonModVariables.PlayerVariables())).transfur) {
			if (CanLeapProcedure.execute(entity)) {
				if (entity.isOnGround() && !entity.isInWater()) {
					if (!entity.isShiftKeyDown()) {
						deltaX = -Math.sin((entity.getYRot() / 180) * (float) Math.PI);
						deltaY = -Math.sin((entity.getXRot() / 180) * (float) Math.PI);
						deltaZ = Math.cos((entity.getYRot() / 180) * (float) Math.PI);
						speed = 0.4;
						motionX = deltaX * speed;
						motionY = deltaY * speed;
						motionZ = deltaZ * speed;
						entity.setDeltaMovement(entity.getDeltaMovement().add(motionX, motionY, motionZ));
						if (entity instanceof Player _player)
							_player.causeFoodExhaustion((float) 0.5);
					}
					if (entity.isShiftKeyDown()) {
						deltaX = -Math.sin((entity.getYRot() / 180) * (float) Math.PI);
						deltaY = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
								- entity.getY();
						deltaZ = Math.cos((entity.getYRot() / 180) * (float) Math.PI);
						speed = 0.15;
						Yspeed = 0.5;
						motionX = deltaX * speed;
						motionY = deltaY * Yspeed;
						motionZ = deltaZ * speed;
						entity.setDeltaMovement(entity.getDeltaMovement().add(motionX, motionY, motionZ));
						if (entity instanceof Player _player)
							_player.causeFoodExhaustion((float) (motionY * 0.25));
					}
				}
			}
		}
	}
}
