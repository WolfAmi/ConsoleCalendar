package com.company;

public class WizardSkeleton extends AEnemySkeleton {

    private int skeletonDamage;

    WizardSkeleton (){
        skeletonDamage=2;
    }

    @Override
    public int inflictionDamage(int playerHitpoint) {
        int wizardMana = 30;

        while (wizardMana!=0)  {
            playerHitpoint -= skeletonDamage;
            wizardMana--;
        }

        return playerHitpoint;
    }
}
