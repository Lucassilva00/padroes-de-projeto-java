package com.lucas.game;

import com.lucas.game.State.AttackingState;
import com.lucas.game.State.IdleState;
import com.lucas.game.State.RunningState;
import com.lucas.game.player.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do jogador:");
        String nome = scanner.nextLine();

        System.out.println("Escolha a classe (mage, ranged, melee, summoner):");
        String classe = scanner.nextLine().toLowerCase();

        Player player = new Player(nome, classe);

        System.out.println("Bem-vindo ao jogo, " + player.getName() + "!");
        System.out.println("Classe: " + player.getRole() + " | HP inicial: " + player.getHp() + " | Poder de ataque: " + player.attack());

        boolean running = true;
        while (running) {
            System.out.println("\nEscolha uma ação: \nidle \nrun \nattack \nheal \nexit\n");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "idle":
                    player.setState(new IdleState());
                    break;
                case "run":
                    player.setState(new RunningState());
                    break;
                case "attack":
                    player.setState(new AttackingState());
                    // simula dano recebido do inimigo
                    int damage = random.nextInt(20) + 1; // dano aleatório entre 1 e 20
                    int hpAtual = player.takeDamage(damage);
                    System.out.println("O jogador recebeu " + damage + " de dano. HP agora: " + hpAtual);
                    if (hpAtual == 0) {
                        System.out.println("O jogador morreu! Fim de jogo.");
                        running = false;
                    }
                    break;
                case "heal":
                    int healAmount = random.nextInt(15) + 5; // cura entre 5 e 20
                    player.heal(healAmount);
                    break;
                case "exit":
                    running = false;
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Ação inválida!");
            }
        }

        scanner.close();}
}
