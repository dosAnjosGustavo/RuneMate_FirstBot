package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.awt.*;

public class MineRock extends LeafTask {
    private final Color iron = new Color(32,17,14);
    private final Color empty = new Color(48,48,48);
    final Area ores = new Area.Rectangular(new Coordinate(2601,3232,0), new Coordinate(2606,3238,0));

    @Override
    public void execute() {
        GameObject mineableRock = GameObjects.newQuery().within(ores).names("Rocks").colorSubstitutions(empty,iron).results().nearest();
        if (mineableRock!= null) {
            int miningXPbefore = Skill.MINING.getExperience();
            if (mineableRock.isVisible()) {
                if(mineableRock.interact("Mine")) {
                Execution.delayUntil(() -> !mineableRock.isValid() || Skill.MINING.getExperience() > miningXPbefore, 200,15000);
            }
            } else {
                Camera.turnTo(mineableRock);
            }
        } else {
            Environment.getBot().getLogger().info("The rock we looked for in MineRock was null");
        }

    }
}
