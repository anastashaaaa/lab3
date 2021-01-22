import com.company.fights.OneVsOne;
import com.company.fights.TeamVsTeam;
import com.company.output.Output;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Output output = new Output();
        Scanner input = new Scanner(System.in);


        System.out.println("Виберіть режим бою.\n\n1 - 1 VS 1\n2 - 2 VS 2.");
        int choose = input.nextInt();
        switch (choose) {
            case 1: {
                output.showInfoAboutDroids();
                new OneVsOne().FightOneVsOne();
                break;
            }

            case 2: {
                output.showInfoAboutDroids();
                new TeamVsTeam().fight();
                break;
            }
            default: {
                output.exception();
                break;
            }
        }
    }
}
