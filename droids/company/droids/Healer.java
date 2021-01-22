package com.company.droids;

import com.company.output.Output;

import java.util.ArrayList;

public class Healer extends Droid {

    private int healHP;
    private int canUseAbility;

    public int getHealHP() {
        return healHP;
    }

    public void setHealHP(int healHP) {
        this.healHP = healHP;
    }

    public int getCanUseAbility() {
        return canUseAbility;
    }

    public void setCanUseAbility(int canUseAbility) {
        this.canUseAbility = canUseAbility;
    }

    public Healer() {
        super(70, 15, "Healer", 20, 3);
        healHP = 50;
        canUseAbility = 2;
    }

    @Override
    public void useIndividualAbility(Droid healer) {
        Output output = new Output();
        if (this.getCanUseAbility() <= 0) {
            System.out.println("Ви не можете використати вашу суперздібність!");
        } else {
            this.setHealth(this.getHealth() + getHealHP());
            output.addHPbyHealer(this);
        }
    }

    @Override
    public void useTeamIndividualAbility(ArrayList<Droid> team) {
        for (Droid droid : team) {
            if (getCanUseAbility() <= 0) {
                System.out.println("Ви не можете використати вашу суперздібність!");
            } else {
                droid.setHealth(droid.getHealth() - this.getDamage());
                setCanUseAbility(getCanUseAbility() - 1);
                if (droid.getHealth() < 0) {
                    droid.setHealth(0);
                } else {
                    System.out.println(droid.getName() + " втратив здоров'я від суперздібності ворога! Здоров'я дроїда - " + droid.getHealth());
                }
            }
        }
        this.setHealth(this.getHealth() + getHealHP());
        System.out.println(this.getName() + " вилікував себе на " + getHealHP() + " HP!");
    }
}
