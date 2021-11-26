public class Main {

    public static void main(String[] args) {

        int w=0,l=0,d=0;

        Player you=new Human("you",1.0,1.0);
        Player cpu=new Cpu("cpu",1.0,1.0);

        while(true) {

            you.isHit=false;
            cpu.isHit=false;

            Character youHand=you.getInput().charAt(0);
            Character cpuHand=cpu.getInput().charAt(0);

            System.out.printf("you %c vs cpu %c ",youHand,cpuHand);

            if(youHand==cpuHand) {
                d++;
                System.out.print("Draw");
                you.state=PlayerState.NORMAL;
                cpu.state=PlayerState.NORMAL;
            } else if(youHand=='b') {
                if(cpu.state==PlayerState.SUPER) {
                    you.damage(1.0/6.0);
                } else {
                    you.damage(1.0/9.0);
                }
                you.state=PlayerState.SUPER;
                System.out.print("you block!");
            } else if(cpuHand=='b') {
                if(you.state==PlayerState.SUPER) {
                    cpu.damage(1.0/6.0);
                } else {
                    cpu.damage(1.0/9.0);
                }
                cpu.state=PlayerState.SUPER;
                System.out.print("cpu block!");
            } else if(
                    (youHand=='r' && cpuHand=='s') ||
                    (youHand=='p' && cpuHand=='r') ||
                    (youHand=='s' && cpuHand=='p') ) {
                w++;
                System.out.print("cpu is hit");
                if(you.state==PlayerState.SUPER) {
                    cpu.life=0.0;
                    cpu.recovery=0.0;
                    cpu.state=PlayerState.DEAD;
                    System.out.print(" sudden death!");
                } else {
                    cpu.damage(1.0/3.0);
                    cpu.recovery/=2.0;
                }
                cpu.isHit=true;
            } else {
                l++;
                System.out.printf("you are hit");
                if(cpu.state==PlayerState.SUPER) {
                    you.life=0.0;
                    you.recovery=0.0;
                    you.state=PlayerState.DEAD;
                    System.out.print(" sudden death!");
                } else {
                    you.damage(1.0/3.0);
                    you.recovery/=2.0;
                }
                you.isHit=true;
            }

            if(!you.isHit) {
                you.heal(1.0/6.0);
            } else {
                you.state = PlayerState.NORMAL;
            }

            if(!cpu.isHit) {
                cpu.heal(1.0/6.0);
            } else {
                cpu.state = PlayerState.NORMAL;
            }

            System.out.printf("\n(%syou life: %.2f, %scpu life: %.2f)\n(win: %d lose: %d draw: %d)\n",
                    you.state==PlayerState.SUPER?"SUPER ":"",you.life,
                    cpu.state==PlayerState.SUPER?"SUPER ":"",cpu.life,
                    w,l,d);

            if(you.isDead()) {
                System.out.println("You lose!");
                break;
            } else if(cpu.isDead()) {
                System.out.println("You win!");
                break;
            }

        }

        System.out.println("Game over.");

    }

}
