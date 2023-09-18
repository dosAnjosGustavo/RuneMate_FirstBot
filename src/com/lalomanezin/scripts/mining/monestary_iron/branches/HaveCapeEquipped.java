package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.Stop;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class HaveCapeEquipped extends BranchTask {

    private final HaveNearlyEmptyInv haveNearlyEmptyInv = new HaveNearlyEmptyInv();
    private final Stop stop = new Stop();


    @Override
    public boolean validate() {
        return Inventory.contains("Ardougne teleport");
    }

    @Override
    public TreeTask failureTask() {return haveNearlyEmptyInv;}

    @Override
    public TreeTask successTask() {return stop;}
}
