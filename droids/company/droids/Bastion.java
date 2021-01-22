package com.company.droids;

import com.company.output.Output;

import java.util.ArrayList;

public class Bastion extends Droid {

    private int splashJumpDamage;

    public Bastion() {
        super(150, 10, "Bastion", 100, 2);
        splashJumpDamage = 30;
    }

    public int getSplashJumpDamage() {
        return splashJumpDamage;
    }

    public void setSplashJumpDamage(int splashJumpDamage) {
        this.splashJumpDamage = splashJumpDamage;
    }


    @Override
    public void useIndividualAbility(Droid whoGet) {
        Output output = new Output();
        if (getCanUseAbility() <= 0) {
            System.out.println("Ви не можете використати вашу суперздібність!");
        } else {
            whoGet.setHealth(whoGet.getHealth() - getSplashJumpDamage());
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
                droid.setHealth(droid.getHealth() - this.getSplashJumpDamage());
                setCanUseAbility(getCanUseAbility() - 1);
                if (droid.getHealth() < 0) {
                    droid.setHealth(0);
                }
                System.out.println(droid.getName() + " втратив здоров'я від суперздібності ворога! Здоров'я дроїда - " + droid.getHealth());
            }
        }
    }
}
