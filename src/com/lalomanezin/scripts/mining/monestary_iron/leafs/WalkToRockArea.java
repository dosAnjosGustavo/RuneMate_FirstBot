package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.script.framework.tree.LeafTask;

import javax.swing.plaf.synth.Region;

public class WalkToRockArea extends LeafTask {

    private final Area rockArea = new Area.Rectangular(new Coordinate(2601,3238,0), new Coordinate(2606,3232,0));

    @Override
    public void execute() {
        RegionPath toIron = RegionPath.buildTo(rockArea.getRandomCoordinate());
        if(toIron != null) {
            toIron.step();
        } else {
            Environment.getBot().getLogger().info("Path toIron was null in WalkToRockArea");
        }
    }
}
