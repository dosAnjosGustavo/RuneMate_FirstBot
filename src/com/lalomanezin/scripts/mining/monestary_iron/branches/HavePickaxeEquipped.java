package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.Stop;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Arrays;

public class HavePickaxeEquipped extends BranchTask {

    private final HaveCapeEquipped haveCapeEquipped = new HaveCapeEquipped();
    private final Stop stop = new Stop();

    private final String[] PICKAXES = {"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe", "Dragon pickaxe", "Infernal pickaxe"};

    public boolean validate() {
        return Equipment.containsAnyOf(PICKAXES) || Inventory.containsAnyOf(PICKAXES);
    }

    public TreeTask failureTask() {return stop;}
    public TreeTask successTask() {return haveCapeEquipped;}

}
