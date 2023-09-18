package com.lalomanezin.scripts.mining.monestary_iron.branches;

import com.lalomanezin.scripts.mining.monestary_iron.leafs.OpenMonestaryDoor;
import com.lalomanezin.scripts.mining.monestary_iron.leafs.WalkToRockArea;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsDoorClosed extends BranchTask {

    private final OpenMonestaryDoor openMonestaryDoor = new OpenMonestaryDoor();
    private final WalkToRockArea walkToRockArea = new WalkToRockArea();

    private final Coordinate doorCoord = new Coordinate(2606,3219,0);
    @Override
    public boolean validate() {
        GameObject door = GameObjects.newQuery().names("Door").actions("Open").on(doorCoord).results().first();
        return door != null;
    }
    @Override
    public TreeTask failureTask() { return walkToRockArea;}
    public TreeTask successTask() { return openMonestaryDoor;}
}
