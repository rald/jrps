import java.util.Scanner;

class Cpu extends Player {

    Cpu(String name, Double life, Double recovery) {
        super(name, life, recovery);
    }

    String getInput() {
        return Character.toString("rpsb".charAt((int)Math.floor(Math.random()*4)));
    }

}
