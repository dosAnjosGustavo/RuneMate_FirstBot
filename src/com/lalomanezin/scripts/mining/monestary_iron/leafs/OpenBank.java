package com.lalomanezin.scripts.mining.monestary_iron.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class OpenBank extends LeafTask {

    private final Coordinate bank = new Coordinate(2444,3083,0);
    private Player player;

    @Override
    public  void execute() {
        GameObject bankChest = GameObjects.newQuery().on(bank).names("Bank chest").actions("Use").results().first();
        if(bankChest != null) {
            if (bankChest.isVisible()) {
                if (bankChest.interact("Use")) {
                    Execution.delayUntil(() -> Bank.isOpen(), () -> (player = Players.getLocal()) != null && player.isMoving(), 100, 1000);
                }
            } else {
                Camera.turnTo(bankChest);
            }
        } else {
            Environment.getBot().getLogger().info("Bank chest was null in OpenBank");
        }
    }
}
