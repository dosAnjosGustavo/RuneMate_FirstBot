package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class TeleportToMonestary extends LeafTask {


    Coordinate inIronRegion = new Coordinate(2604,3227,0);
    private Player player;


    @Override
    public void execute() {
        SpriteItem ardyCloak = Equipment.getItems("Ardougne cloak 1").first();
        if (ardyCloak != null) {
            if(ardyCloak.interact("Kandarin Monastery")) {
                Execution.delayUntil(() -> (player= Players.getLocal()) != null && Distance.between(inIronRegion, player) < 50 && player.getAnimationId() == -1, 5000);
            }
        }
    }
}
