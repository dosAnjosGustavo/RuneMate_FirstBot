package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InCastleWarsRegion extends BranchTask {
    private final IsBankOpen isBankOpen = new IsBankOpen();
    private final FailSafeHaveRingEquipped failSafeHaveRingEquipped = new FailSafeHaveRingEquipped();

    Coordinate inCwarsRegion = new Coordinate(2440,3090,0);

    @Override
    public boolean validate() {
        Player player;
        return (player = Players.getLocal()) != null && Distance.between(inCwarsRegion, player) < 50;
    }

    @Override
    public TreeTask failureTask() { return failSafeHaveRingEquipped;}
    @Override public TreeTask successTask() {return isBankOpen;}

}
