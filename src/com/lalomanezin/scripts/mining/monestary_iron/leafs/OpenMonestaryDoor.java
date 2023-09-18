package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class OpenMonestaryDoor extends LeafTask {


    private final Coordinate doorCoord = new Coordinate(2606,3219,0);
    @Override
    public void execute() {
        GameObject door = GameObjects.newQuery().names(("Door")).actions("Open").on(doorCoord).results().first();
        if (door != null) {
            if (door.isVisible()) {
                if (door.interact("Open")) {
                    Execution.delayWhile(() -> door.isValid(), 1500);
                }
            } else {
                Camera.turnTo(door);
            }
        } else {
            Environment.getBot().getLogger().info("Door was null in OpenMonestaryDoor");
    }
    }
}
