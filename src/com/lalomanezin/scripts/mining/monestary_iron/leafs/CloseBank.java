package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class CloseBank extends LeafTask {
    @Override
    public void execute(){
        Bank.close();
    }
}
