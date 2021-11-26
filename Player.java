import java.util.Scanner;

abstract class Player {

    PlayerState state = PlayerState.NORMAL;
    String name = null;
    Double life = null;
    Double recovery = null;
    boolean isHit = false;

    Player(String name, Double life, Double recovery) {
        this.name = name;
        this.life = life;
        this.recovery = recovery;
    }

    void heal(Double heal) {
        this.life += heal * recovery;
    }

    void damage(Double damage) {
        this.life -= damage;
        if(isDead()) {
            this.life=0.0;
            state = PlayerState.DEAD;
        }
    }

    boolean isDead() {
        return this.life <= 0;
    }

    abstract String getInput();

}

