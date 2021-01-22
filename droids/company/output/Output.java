package com.company.output;

import com.company.droids.*;
import com.company.fights.OneVsOne;

import java.util.ArrayList;

public class Output {

    public void loseHealthOrArmor(Droid droid) {
        if (droid.getArmor() > 0) {
            System.out.println(droid.getName() + " втрачає броню. Запас його броні - " + droid.getArmor());
        }
        if (droid.getArmor() <= 0) {
            System.out.println(droid.getName() + " втрачає здоров'я. Запас його здоров'я - " + droid.getHealth());
        }
    }

    public void whoMakeHit(Droid droid) {
        System.out.println("\n" + droid.getName() + " робить удар!");
    }

    public void exception() {
        System.out.println("Ви нічого не обрали!");
    }

    public void youHaveAbility(Droid droid) {
        System.out.println("\n" + droid.getName() + " має суперздібність, бажаєте використати? 1 - так, 2 - ні");
    }

    public void useAbility(Droid droid) {
        System.out.println("\n" + droid.getName() + " використовує суперздібність! Ховайсь!!!");
    }

    public void loseHPbyAbility(Droid droid) {
        System.out.println(droid.getName() + " втрачає здоров'я від суперздібності суперника. Запас здоров'я - " + droid.getHealth());
    }

    public void winRound(Droid droid) {
        System.out.println("\n" + droid.getName() + " WIN!!!");
    }

    public void addHPbyHealer(Droid healer) {
        System.out.println("\n" + healer.getName() + " відновлює здоров'я. Запас здоров'я - " + healer.getHealth());
    }

    public void teamWin(ArrayList<Droid> team) {
        int size = team.size();
        if (size == 1) {
            for (Droid droid : team) {
                System.out.println("Переміг дроїд " + droid.getName() + "!!!");
            }
        } else {
            System.out.print("Перемогла команда ");
            for (Droid droid : team) {
                System.out.print(droid.getName() + " ");
            }
            System.out.println("!!!");
        }
    }

    public void showInfoAboutDroids() {
        OneVsOne oneVsOne = new OneVsOne();
        Dragon dragon = new Dragon();
        Bastion bastion = new Bastion();
        Healer healer = new Healer();
        Wizard wizard = new Wizard();

        System.out.println("✤✤✤✤✤✤➊➊➊➊✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤DRAGON✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤➊➊➊➊✤✤✤✤✤✤");
        System.out.println("Здоров'я - " + dragon.getHealth());
        System.out.println("Броня - " + dragon.getArmor());
        System.out.println("Урон - " + dragon.getDamage());
        System.out.println("Урон здібності - " + dragon.getFireballDamage());
        System.out.println("Може використати здібність " + dragon.getCanUseAbility() + " рази\n\n");
        oneVsOne.sleepTime(1000);

        System.out.println("✤✤✤✤✤✤➋➋➋➋➋✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤BASTION✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤➋➋➋➋➋✤✤✤✤✤✤");
        System.out.println("Здоров'я - " + bastion.getHealth());
        System.out.println("Броня - " + bastion.getArmor());
        System.out.println("Урон - " + bastion.getDamage());
        System.out.println("Урон здібності - " + bastion.getSplashJumpDamage());
        System.out.println("Може використати здібність " + bastion.getCanUseAbility() + " рази\n\n");
        oneVsOne.sleepTime(1000);

        System.out.println("✤✤✤✤✤✤➌➌➌➌➌✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤HEALER✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤➌➌➌➌➌✤✤✤✤✤✤");
        System.out.println("Здоров'я - " + healer.getHealth());
        System.out.println("Броня - " + healer.getArmor());
        System.out.println("Урон - " + healer.getDamage());
        System.out.println("Може відновити - " + healer.getHealHP() + " одиниць здоров'я");
        System.out.println("Може використати здібність " + healer.getCanUseAbility() + " рази\n\n");
        oneVsOne.sleepTime(1000);

        System.out.println("✤✤✤✤✤✤➍➍➍➍➍✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤WIZARD✤✤✤✤✤✤");
        System.out.println("✤✤✤✤✤✤➍➍➍➍➍✤✤✤✤✤✤");
        System.out.println("Здоров'я - " + wizard.getHealth());
        System.out.println("Броня - " + wizard.getArmor());
        System.out.println("Урон - " + wizard.getDamage());
        System.out.println("Урон здібності - " + wizard.getSpiritsDamage());
        System.out.println("Може використати здібність " + wizard.getCanUseAbility() + " разів\n\n");

    }
}
