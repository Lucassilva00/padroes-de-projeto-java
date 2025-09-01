package com.lucas.game.State;

import com.lucas.game.player.Player;

public class AttackingState implements State {
    @Override
    public void action(Player player) {
        System.out.println(player.attack());
    }
}
