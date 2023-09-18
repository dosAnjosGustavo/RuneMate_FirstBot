package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.TeleportCwars;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsInventoryFull extends BranchTask {

    private final TeleportCwars teleportCwars = new TeleportCwars();
    private final InRockArea inRockArea = new InRockArea();

    @Override
    public boolean validate() {
        return Inventory.isFull();
    }
    @Override
    public TreeTask failureTask() { return inRockArea;}
    @Override
    public TreeTask successTask() { return teleportCwars;}

}
