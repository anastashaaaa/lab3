package com.company.droids;

import com.company.output.Output;

import java.util.ArrayList;

public class Wizard extends Droid {
    private int spiritsDamage;

    public int getSpiritsDamage() {
        return spiritsDamage;
    }

    public void setSpiritsDamage(int spiritsDamage) {
        this.spiritsDamage = spiritsDamage;
    }

    public Wizard() {
        super(100, 20, "Wizard", 20, 5);
        spiritsDamage = 15;
    }

    @Override
    public void loseArmor(Droid whoPunch) {
        int loseHealth;
        if (this.getArmor() - (whoPunch.getDamage() / 2) <= 0) {
            if (this.getArmor() > 0) {
                loseHealth = (this.getHealth() + (this.getArmor() / 2) - whoPunch.getDamage());
            } else {
                loseHealth = (this.getHealth() - (whoPunch.getDamage() - this.getArmor()));
            }
            this.setHealth(loseHealth);
            this.setArmor(0);
        } else {
            this.setArmor(this.getArmor() - (whoPunch.getDamage() / 2));
        }
    }

    @Override
    public void useIndividualAbility(Droid whoGet) {
        Output output = new Output();
        if (getCanUseAbility() == 0) {
            System.out.println("У вас більше немає духів!");
        } else {
            whoGet.setHealth(whoGet.getHealth() - (getSpiritsDamage() + this.getDamage()));
            setCanUseAbility(getCanUseAbility() - 1);
            output.loseHPbyAbility(whoGet);
            if (whoGet.getHealth() < 0) {
                whoGet.setHealth(0);
            }
        }
    }

    @Override
    public void useTeamIndividualAbility(ArrayList<Droid> team) {
        for (Droid droid : team) {
            if (getCanUseAbility() <= 0) {
                System.out.println("Ви не можете використати вашу суперздібність!");
            } else {
                droid.setHealth(droid.getHealth() - (getSpiritsDamage() + this.getDamage()));
                setCanUseAbility(getCanUseAbility() - 1);
                if (droid.getHealth() < 0) {
                    droid.setHealth(0);
                }
                System.out.println(droid.getName() + " втратив здоров'я від суперздібності ворога! Здоров'я дроїда - " + droid.getHealth());
            }
        }
    }
}
