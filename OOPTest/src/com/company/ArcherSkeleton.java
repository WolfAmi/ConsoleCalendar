package com.company;

public class ArcherSkeleton extends AEnemySkeleton {

    private int skeletonDamage;

    ArcherSkeleton(){
        skeletonDamage=5;
    }

    @Override
    public int inflictionDamage(int playerHitpoint) {

        int arrowsNumber = 10;

        while (arrowsNumber!=0)  {
            playerHitpoint -= skeletonDamage;
            arrowsNumber--;
        }

        return playerHitpoint;
    }
}
