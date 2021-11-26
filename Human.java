import java.util.Scanner;

class Human extends Player {

    Human(String name, Double life, Double recovery) {
        super(name, life, recovery);
    }

    String getInput() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("r/p/s/b? ");
            Character input=scanner.nextLine().trim().toLowerCase().charAt(0);
            if("rpsb".indexOf(input)!=-1) {
                return Character.toString(input);
            }
        }
    }



}
