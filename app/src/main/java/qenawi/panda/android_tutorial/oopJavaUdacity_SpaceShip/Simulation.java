package qenawi.panda.android_tutorial.oopJavaUdacity_SpaceShip;

import timber.log.Timber;

import java.util.ArrayList;

public class Simulation {
    public  ArrayList<Item> loadItems()
    {
        /*
        this method loads all items from a text file and returns an ArrayList of Items:
        Each line in the text file consists of the item name followed by = then its weigh in kg. For example:
      habitat=100000
       colony=50000
       food=50000
         */
        return new ArrayList<Item>(){
            {
                this.add(new Item("item1",100000));
                this.add(new Item("item2",50000));
                this.add(new Item("item3",30000));
                this.add(new Item("item4",70000));
            }}
            ;
    }

    public  ArrayList<U1> loadU1(ArrayList<Item>items)
       {
        /*
        this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
         It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that
         one until all items are loaded.
         The method then returns the ArrayList of those U1 rockets that are fully loaded
         */
           Rocket u1=new U1();
           int totalW=0;
           for (Item item:items)
           {
               totalW+=item.getWeight();
           }
           return new ArrayList<U1>((totalW/u1.getMaxWeight())+(totalW%u1.getMaxWeight()==0?0:1));
       }

    public  ArrayList<U2> loadU2(ArrayList<Item>items)
 {
Rocket u2=new U2();
int totalW=0;
for (Item item:items)
{
    totalW+=item.getWeight();
}
return new ArrayList<U2>((totalW/u2.getMaxWeight())+(totalW%u2.getMaxWeight()==0?0:1));
 }

    protected   <T extends Rocket> int runSimulation(ArrayList<T> rockets)
    {  int TotalBudget = 0;
       for (Rocket r: rockets)
            {
            if (r.lunch()&&r.land())
            {
                TotalBudget+=r.getCoast();
                continue;
            }
            while (!r.lunch()||!r.land()){TotalBudget+=r.getCoast();}
            }
        Timber.tag(Simulation.class.getSimpleName()).v("Total Coast %d",TotalBudget);
        return TotalBudget;
    }

}
