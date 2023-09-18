package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class TeleportCwars extends LeafTask {
    private final String[] RINGS = {"Ring of Dueling(8)", "Ring of Dueling(7)","Ring of Dueling(6)", "Ring of Dueling(5)", "Ring of Dueling(4)", "Ring of Dueling(3)", "Ring of Dueling(2)", "Ring of Dueling(1)"};

    Coordinate inCwarsRegion = new Coordinate(2440,3090,0);
    private Player player;


    @Override
    public void execute() {
        SpriteItem duelring = Equipment.getItems(RINGS).first();
        if (duelring != null) {
            if(duelring.interact("Castle Wars")) {
                Execution.delayUntil(() -> (player= Players.getLocal()) != null && Distance.between(inCwarsRegion, player) < 50 && player.getAnimationId() == -1, 5000);
            }
        }
    }
}
