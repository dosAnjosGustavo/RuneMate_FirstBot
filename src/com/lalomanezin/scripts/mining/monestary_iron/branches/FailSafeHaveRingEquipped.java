package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.Stop;
import com.lalomanezin.scripts.mining.monestary_iron.leafs.TeleportCwars;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Arrays;

public class FailSafeHaveRingEquipped extends BranchTask {

    private final TeleportCwars teleportCwars = new TeleportCwars();
    private final Stop stop = new Stop();

    private final String[] anyRing = {"Ring of Dueling(8)", "Ring of Dueling(7)","Ring of Dueling(6)", "Ring of Dueling(5)", "Ring of Dueling(4)", "Ring of Dueling(3)", "Ring of Dueling(2)", "Ring of Dueling(1)"};

    @Override
    public boolean validate() {
        return Equipment.containsAnyOf(anyRing);
    }

    @Override
    public TreeTask failureTask() { return stop;}

    @Override
    public TreeTask successTask() {return teleportCwars;}
}
