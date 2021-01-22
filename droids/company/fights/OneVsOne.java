package com.company.fights;

import com.company.droids.*;
import com.company.output.Output;

import java.util.Scanner;

public class OneVsOne {

    private final Scanner in = new Scanner(System.in);
    private int cooldownFirstDroid = 3;
    private int cooldownSecondDroid = 3;
    private Droid firstOpponent;
    private Droid secondOpponent;

    public Droid getFirstOpponent() {
        return firstOpponent;
    }

    public void setFirstOpponent(Droid firstOpponent) {
        this.firstOpponent = firstOpponent;
    }

    public Droid getSecondOpponent() {
        return secondOpponent;
    }

    public void setSecondOpponent(Droid secondOpponent) {
        this.secondOpponent = secondOpponent;
    }


    private int choose = 2;


    public void sleepTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseCharacters() {

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                Scanner input = new Scanner(System.in);
                int choose;
                System.out.println("Оберіть першого персонажа:");
                System.out.println("\n1 - Dragon\n2 - Bastion\n3 - Healer\n4 - Wizard");
                choose = input.nextInt();
                switch (choose) {
                    case 1: {
                        setFirstOpponent(new Dragon());
                        break;
                    }
                    case 2: {
                        setFirstOpponent(new Bastion());
                        break;
                    }
                    case 3: {
                        setFirstOpponent(new Healer());
                        break;
                    }
                    case 4: {
                        setFirstOpponent(new Wizard());
                        break;
                    }
                    default: {
                        System.out.println("Ви нічого не обрали!");
                    }
                }
            }

            if (i == 1) {
                Scanner input = new Scanner(System.in);
                int choose;
                System.out.println("Оберіть другого персонажа:");
                System.out.println("\n1 - Dragon\n2 - Bastion\n3 - Healer\n4 - Wizard");
                choose = input.nextInt();
                switch (choose) {
                    case 1: {
                        setSecondOpponent(new Dragon());
                        ;
                        break;
                    }
                    case 2: {
                        setSecondOpponent(new Bastion());
                        break;
                    }
                    case 3: {
                        setSecondOpponent(new Healer());
                        break;
                    }
                    case 4: {
                        setSecondOpponent(new Wizard());
                        break;
                    }
                    default: {
                        System.out.println("Ви нічого не обрали!");
                    }
                }
            }
        }
    }

    public void FightOneVsOne() {

        Output output = new Output();
        chooseCharacters();
        int punch = Droid.firstPunch(1, firstOpponent, secondOpponent);
        sleepTime(3000);
        do {
            /** Б'Є ПЕРШИЙ ДРОЇД */
            if (punch == 1) {
                if ((cooldownFirstDroid == 0) && (firstOpponent.getCanUseAbility() > 0)) {   // Якщо кд на суперздібність == 0 && can use > 0
                    output.youHaveAbility(firstOpponent);
                    choose = in.nextInt();
                }
                switch (choose) {
                    case 1: {  // використання суперздібності
                        output.useAbility(firstOpponent);
                        firstOpponent.useIndividualAbility(secondOpponent);
                        sleepTime(1000);
                        cooldownFirstDroid = 3;
                        choose = 2;
                        break;
                    }
                    case 2: {  //звичайний удар
                        if (secondOpponent.getArmor() <= 0) {// удар по хп
                            output.whoMakeHit(firstOpponent);
                            firstOpponent.makeHit(secondOpponent);
                            output.loseHealthOrArmor(secondOpponent);

                            sleepTime(1000);
                        } else {  //удар по броні
                            output.whoMakeHit(firstOpponent);
                            secondOpponent.loseArmor(firstOpponent);
                            output.loseHealthOrArmor(secondOpponent);
                            sleepTime(1000);
                        }

                        if (cooldownFirstDroid > 0) { // зменшення кд
                            cooldownFirstDroid = cooldownFirstDroid - 1;
                        }
                        break;
                    }
                    default: { // якшо нічого не обрали
                        output.exception();
                        break;
                    }
                }


                /** Б'Є ДРУГИЙ ДРОЇД */
            } else {
                if ((cooldownSecondDroid == 0) && (secondOpponent.getCanUseAbility() > 0)) {  // Якщо кд на суперздібність == 0 && can use > 0
                    output.youHaveAbility(secondOpponent);
                    choose = in.nextInt();
                }
                switch (choose) {
                    case 1: {     // використання суперздібності
                        output.useAbility(secondOpponent);
                        secondOpponent.useIndividualAbility(firstOpponent);
                        sleepTime(1000);

                        cooldownSecondDroid = 3;
                        choose = 2;
                        break;
                    }
                    case 2: {    //звичайний удар
                        if (firstOpponent.getArmor() <= 0) {   // удар по хп
                            output.whoMakeHit(secondOpponent);
                            secondOpponent.makeHit(firstOpponent);
                            output.loseHealthOrArmor(firstOpponent);
                            sleepTime(1000);

                        } else {     //удар по броні
                            output.whoMakeHit(secondOpponent);
                            firstOpponent.loseArmor(secondOpponent);
                            output.loseHealthOrArmor(firstOpponent);
                            sleepTime(1000);
                        }

                        if (cooldownSecondDroid > 0) {     // зменшення кд
                            cooldownSecondDroid = cooldownSecondDroid - 1;
                        }
                        break;
                    }
                    default:   // якшо нічого не обрали
                        output.exception();
                        break;
                }


            }
            punch = Droid.whoPunch(punch);  // зміна нападника
        } while ((firstOpponent.getHealth() > 0) && (secondOpponent.getHealth() > 0));

        if (secondOpponent.getHealth() <= 0) {
            output.winRound(firstOpponent);
        }
        if (firstOpponent.getHealth() <= 0) {
            output.winRound(secondOpponent);
        }
        sleepTime(5000);
    }
}

