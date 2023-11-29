package item;
import enchant.PushEnchant;
import io.github.Dogika.content_changes.ContentChangesMain;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {

	public static final Item Icon = registerItem("icon", new Item(new QuiltItemSettings().group(ItemGroup.MISC)));
	public static final Enchantment Push = registerEnchant("push", new PushEnchant());

	public static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(ContentChangesMain.MOD_ID, name), item);
	}
	public static Enchantment registerEnchant(String name, PushEnchant item) {
		return Registry.register(Registry.ENCHANTMENT, new Identifier(ContentChangesMain.MOD_ID, name), item);
	}

	public static void registerModItems() {
		ContentChangesMain.LOGGER.info("Registering ModItems for " + ContentChangesMain.MOD_ID);
	}

}
