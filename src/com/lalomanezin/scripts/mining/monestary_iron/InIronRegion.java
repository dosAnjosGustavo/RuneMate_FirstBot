package com.lalomanezin.scripts.mining.monestary_iron;
import com.lalomanezin.scripts.mining.monestary_iron.branches.InCastleWarsRegion;
import com.lalomanezin.scripts.mining.monestary_iron.branches.IsInventoryFull;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InIronRegion extends BranchTask {
    private final IsInventoryFull isInventoryfull = new IsInventoryFull();
    private final InCastleWarsRegion incastlewarsregion = new InCastleWarsRegion();

    Coordinate inIronRegion = new Coordinate(2604,3227,0);

    @Override
    public boolean validate() {
        Player player;
        return (player = Players.getLocal()) != null && Distance.between(inIronRegion, player) < 50;
    }

    @Override
    public TreeTask failureTask() {return incastlewarsregion;}

    @Override
    public TreeTask successTask() {return isInventoryfull;}

}
