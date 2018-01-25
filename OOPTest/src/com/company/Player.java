package com.company;

public class Player {

    private int playerHitpoint;

    Player(){
        playerHitpoint = 100;
    }

    public int getPlayerHitpoint() {
        return playerHitpoint;
    }

    public static int damageTaken(AEnemySkeleton skeletonUnit, int playerHitpoint){
        return skeletonUnit.inflictionDamage(playerHitpoint);
    }

    public static void main(String[] args) {
    Player player = new Player();
    int playerHitpoint = player.getPlayerHitpoint();

    AEnemySkeleton archer = new ArcherSkeleton();
    AEnemySkeleton warrior = new WarriorSkeleton();
    AEnemySkeleton wizard = new WizardSkeleton();

    int archerDamage = damageTaken(archer, playerHitpoint);
    int warriorDamage = damageTaken(warrior, playerHitpoint);
    int wizardDamage = damageTaken(wizard, playerHitpoint);

        System.out.println("The archer can inflict "+ archerDamage +" damage");
        System.out.println("The warrior can inflict "+ warriorDamage +" damage");
        System.out.println("The wizard can inflict "+ wizardDamage +" damage");
    }
}
