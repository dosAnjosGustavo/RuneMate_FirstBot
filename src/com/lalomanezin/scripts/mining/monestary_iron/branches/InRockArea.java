package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.MineRock;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InRockArea extends BranchTask {

    private final MineRock mineRock = new MineRock();
    private final InsideMonestary insideMonestary = new InsideMonestary();

    private final Area nearIronRocks = new Area.Rectangular(new Coordinate(2601,3238,0), new Coordinate(2606,3232,0));

    @Override
    public boolean validate() {
        Player player;
        return (player = Players.getLocal()) != null && nearIronRocks.contains(player);
    }

    @Override
    public TreeTask failureTask() { return insideMonestary;}
    @Override
    public TreeTask successTask(){return mineRock;}
}
