package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsBankOpen extends BranchTask {

    private final HaveRing haveRing= new HaveRing();
    private final HaveEquippedRing haveEquippedRing = new HaveEquippedRing();

    @Override
    public boolean validate() {
        return Bank.isOpen();
    }

    @Override
    public TreeTask failureTask() { return haveEquippedRing;}
    @Override
    public TreeTask successTask() { return haveRing;}
}
