package com.lucas.game.State;

import com.lucas.game.player.Player;

public class IdleState implements State {
    @Override
    public void action(Player player) {
        System.out.println(player.getName() + " está parado e não pode atacar agora.");
    }
}
