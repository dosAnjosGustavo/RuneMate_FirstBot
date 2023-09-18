package com.lalomanezin.scripts.mining.monestary_iron;

import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class RegalIron extends TreeBot {

    @Override
    public TreeTask createRootTask() {
        return new InIronRegion();
    }
}

