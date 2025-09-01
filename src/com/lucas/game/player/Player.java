package com.lucas.game.player;

import com.lucas.game.State.State;

public class Player {

    private String name;
    private String role;
    private int hp;

    private State state;

    public void setState(State state) {
        this.state = state;
        state.action(this);
    }

    public Player(String name, String role) {
        this.name = name;
        this.role = role;

        switch (role.toLowerCase()){
            case "mage" -> this.hp = 90;
            case "melee" -> this.hp = 110;
            case "summoner" -> this.hp = 75;
            default -> this.hp = 100;//Abrange ranged e todos outros casos.
        }
    }

    public int takeDamage(int damage){
        hp = hp - damage;
        hp = Math.max(hp, 0);
        return hp;
    }

    public int attack(){
        int damage;
        switch (role.toLowerCase()) {
            case "mage" -> damage = 15;
            case "ranged" -> damage = 14;
            case "melee" -> damage = 12;
            case "summoner" -> damage = 16;
            default -> damage = 10;
        }
        System.out.println(name + " atacou causando " + damage + " de dano!");
        return damage;
    }

    public void heal(int amount){
        hp += amount;
        System.out.println(name + " recuperou " + amount + " de HP. HP agora: " + hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
