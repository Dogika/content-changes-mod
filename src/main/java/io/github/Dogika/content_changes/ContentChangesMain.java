package io.github.Dogika.content_changes;


import item.ModItems;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ContentChangesMain implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Content Changes");
	public static final String MOD_ID = "content_changes";

	public static Vec3d boost = new Vec3d(0, 0, 0);
	@Override
	public void onInitialize(ModContainer mod) {
		ModItems.registerModItems();
	}
}
