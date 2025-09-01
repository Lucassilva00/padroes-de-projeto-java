package com.lucas.game.State;

import com.lucas.game.player.Player;

public class RunningState implements State {
    @Override
    public void action(Player player) {
        System.out.println(player.getName() + " está correndo e não pode atacar agora.");
    }
}
