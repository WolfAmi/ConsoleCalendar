package com.company;

public class WarriorSkeleton extends AEnemySkeleton {

    private int skeletonDamage;

    WarriorSkeleton (){
        skeletonDamage=30;
    }

    @Override
    public int inflictionDamage(int playerHitpoint) {

        playerHitpoint-=skeletonDamage;

        return playerHitpoint;
    }
}
