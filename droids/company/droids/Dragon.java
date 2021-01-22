package com.company.droids;

import com.company.output.Output;

import java.util.ArrayList;

public class Dragon extends Droid {
    private int fireballDamage;

    public int getFireballDamage() {
        return fireballDamage;
    }

    public void setFireballDamage(int fireballDamage) {
        this.fireballDamage = fireballDamage;
    }

    public Dragon() {
        super(150, 15, "Dragon", 50, 3);
        fireballDamage = 30;
    }

    @Override
    public void useIndividualAbility(Droid whoGet) {
        Output output = new Output();
        if (getCanUseAbility() <= 0) {
            System.out.println("Ви не можете використати вашу суперздібність!");
        } else {
            whoGet.setHealth(whoGet.getHealth() - getFireballDamage());
            if (whoGet.getHealth() < 0) {
                whoGet.setHealth(0);
            }
            setCanUseAbility(getCanUseAbility() - 1);
            output.loseHPbyAbility(whoGet);
        }
    }

    @Override
    public void useTeamIndividualAbility(ArrayList<Droid> team) {
        for (Droid droid : team) {
            if (getCanUseAbility() <= 0) {
                System.out.println("Ви не можете використати вашу суперздібність!");
            } else {
                droid.setHealth(droid.getHealth() - this.getFireballDamage());
                setCanUseAbility(getCanUseAbility() - 1);
                if (droid.getHealth() < 0) {
                    droid.setHealth(0);
                }
                System.out.println(droid.getName() + " втратив здоров'я від суперздібності ворога! Здоров'я дроїда - " + droid.getHealth());
            }
        }
    }
}
