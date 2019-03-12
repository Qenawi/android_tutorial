package qenawi.panda.android_tutorial.oopJavaUdacity_SpaceShip;

import java.util.Random;

public class U1 extends Rocket
{

    public U1() {
        super(100, 10, 18, 0);
    }

    @Override
    public boolean land() {
        Random rand = new Random();
        Double randG = 0.0;
        randG = rand.nextDouble() + 0.1;
        return (randG * (getCargoCarried() / getMaxWeight())) >= 0.50;
    }

    @Override
    public boolean lunch() {
        Random rand = new Random();
        Double randG = 0.0;
        randG = rand.nextDouble() + 0.1;
        return (randG * (getCargoCarried() / getMaxWeight())) >= 0.50;
    }

}
