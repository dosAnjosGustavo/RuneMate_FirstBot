package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.WithdrawRing;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Arrays;

public class HaveRing extends BranchTask {

    private final NearlyEmptyInventory nearlyEmptyInventory = new NearlyEmptyInventory();
    private final WithdrawRing withdrawRing = new WithdrawRing();

    private final String[] RINGS = {"Ring of Dueling(8)", "Ring of Dueling(7)","Ring of Dueling(6)", "Ring of Dueling(5)", "Ring of Dueling(4)", "Ring of Dueling(3)", "Ring of Dueling(2)", "Ring of Dueling(1)"};

    @Override
    public boolean validate() {
        return Equipment.containsAnyOf(RINGS) || Inventory.containsAnyOf(RINGS);
    }

    @Override
    public TreeTask failureTask() { return withdrawRing;}
    @Override
    public TreeTask successTask() { return nearlyEmptyInventory;}

}
