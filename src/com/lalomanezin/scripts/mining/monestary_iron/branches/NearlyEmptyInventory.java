package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.CloseBank;
import com.lalomanezin.scripts.mining.monestary_iron.leafs.DepositedUnwanted;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class NearlyEmptyInventory extends BranchTask {

    private final CloseBank closeBank = new CloseBank();
    private final DepositedUnwanted depositedUnwanted = new DepositedUnwanted();

    @Override
    public boolean validate() {
        return Inventory.getEmptySlots() > 27;
    }

    @Override
    public TreeTask failureTask() {return depositedUnwanted;}

    @Override
    public TreeTask successTask() {return closeBank;}


}
