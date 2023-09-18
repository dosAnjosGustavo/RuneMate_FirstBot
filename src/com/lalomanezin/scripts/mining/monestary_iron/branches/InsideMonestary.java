package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.WalkToRockArea;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InsideMonestary extends BranchTask {

    private final IsDoorClosed isdoorClosed = new IsDoorClosed();
    private final WalkToRockArea walkToRockArea = new WalkToRockArea();


    private final Area inMonestary = new Area.Rectangular(new Coordinate(2604,3218,0), new Coordinate(2608,3211,0));

    @Override
    public boolean validate() {
        Player player;
        return (player = Players.getLocal()) != null && inMonestary.contains(player);
    }

    @Override
    public TreeTask failureTask() {return walkToRockArea;}
    public TreeTask successTask() {return isdoorClosed;}
}
