
package net.foxyas.changedaddon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.foxyas.changedaddon.init.ChangedAddonModTabs;

public class CatalyzeddnaItem extends Item {
	public CatalyzeddnaItem() {
		super(new Item.Properties().tab(ChangedAddonModTabs.TAB_CHANGED_ADDON).stacksTo(1).rarity(Rarity.RARE));
	}
}
