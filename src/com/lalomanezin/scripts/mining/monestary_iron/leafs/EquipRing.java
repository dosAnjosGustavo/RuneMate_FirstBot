package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class EquipRing extends LeafTask {
    @Override
    public void execute() {
        SpriteItem invRing = Inventory.newQuery().names("Ring of dueling(8)").results().first();
        invRing.click();
    }
}
