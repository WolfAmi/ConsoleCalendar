package com.company;

 abstract class AEnemySkeleton {

   private int skeletonDamage;

   AEnemySkeleton(){}

   public int getSkeletonDamage() { return skeletonDamage; }

  abstract public int inflictionDamage(int playerHitpoint);

 }
