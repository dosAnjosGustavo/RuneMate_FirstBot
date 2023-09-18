package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.EquipRing;
import com.lalomanezin.scripts.mining.monestary_iron.leafs.OpenBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class HaveRingInInv extends BranchTask {
    private final EquipRing equipRing = new EquipRing();
    private final OpenBank openBank = new OpenBank();

    @Override
    public boolean validate() {
        return Inventory.contains("Ring of dueling(8)");}

    @Override
    public TreeTask failureTask() { return openBank;}
    @Override
    public TreeTask successTask() { return equipRing;}


}
