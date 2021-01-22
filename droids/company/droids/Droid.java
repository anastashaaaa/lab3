package com.company.droids;

import java.util.ArrayList;

public class Droid {
    private int health;
    private int damage;
    private String name;
    private int armor;
    private int canUseAbility;

    public Droid(int health, int damage, String name, int armor, int canUseAbility) {
        this.health = health;
        this.damage = damage;
        this.name = name;
        this.armor = armor;
        this.canUseAbility = canUseAbility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getCanUseAbility() {
        return canUseAbility;
    }

    public void setCanUseAbility(int canUse) {
        this.canUseAbility = canUse;
    }

    /**
     * удар дроїда
     */
    public void makeHit(Droid whoGet) {
        whoGet.setHealth(whoGet.getHealth() - this.getDamage());
        if (whoGet.getHealth() < 0) {
            whoGet.setHealth(0);
        }
    }

    /**
     * втрата броні
     */
    public void loseArmor(Droid whoPunch) {
        int loseHealth;
        if ((this.getArmor() - whoPunch.getDamage()) <= 0) {
            if (this.getArmor() > 0) {
                loseHealth = (this.getHealth() + this.getArmor() - whoPunch.getDamage());
            } else {
                loseHealth = (this.getHealth() - (whoPunch.getDamage() - this.getArmor()));
            }
            this.setHealth(loseHealth);
            this.setArmor(0);
        } else {
            this.setArmor(this.getArmor() - whoPunch.getDamage());
        }
    }

    /**
     * хто перший вдарить
     */
    public static int whoPunch(int punch) {
        if (punch == 0) {
            punch = 1;
        } else {
            punch = 0;
        }
        return punch;
    }

    /**
     * Хто вдарить перший
     */
    public static int firstPunch(int max, Droid droid1, Droid droid2) {
        int firstPunch = (int) (Math.random() * ++max);
        if (firstPunch == 1) {
            System.out.println("Випав Орел, перший б'є " + droid1.getName() + "\n");
        }
        if (firstPunch == 0) {
            System.out.println("Випала Решка, перший б'є " + droid2.getName() + "\n");
        }
        return firstPunch;
    }

    public void useIndividualAbility(Droid whoGet) {
        System.out.println("You don't have any abilities :(");
    }

    public void useTeamIndividualAbility(ArrayList<Droid> team) {
        System.out.println("You don't have any abilities :(");
    }
}
