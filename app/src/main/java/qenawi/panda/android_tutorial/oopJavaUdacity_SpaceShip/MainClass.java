package qenawi.panda.android_tutorial.oopJavaUdacity_SpaceShip;

import timber.log.Timber;

import java.util.ArrayList;


public class MainClass {
    public static void main() {
        Simulation simulation = new Simulation();
        ArrayList<Item> items = simulation.loadItems();
        ArrayList<U1> u1 = new ArrayList<U1>();
        ArrayList<U2> u2 = new ArrayList<U2>();
        u1 = simulation.loadU1(items);
        u2 = simulation.loadU2(items);
        Timber.tag(MainClass.class.getSimpleName()).v("U1 %d",simulation.runSimulation(u1));
        Timber.tag(MainClass.class.getSimpleName()).v("U2 %d",simulation.runSimulation(u2));

    }
}
