package qenawi.panda.android_tutorial.oopJavaUdacity_SpaceShip;

public class Rocket implements SpaceShip
{
    public Rocket()
    {

    }

    public int getCoast()
    {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCargoCarried() {
        return cargoCarried;
    }

    public void setCargoCarried(int cargoCarried) {
        this.cargoCarried = cargoCarried;
    }
    public Rocket(int coast, int weight, int maxWeight, int cargoCarried)
    {
        this.coast = coast;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.cargoCarried = cargoCarried;
    }

    private  int coast;
    private  int weight;// Rocket Weight
    private  int maxWeight;//cargo limit
    private  int cargoCarried;
    @Override
    public boolean lunch()
    {
        return true;
    }

    @Override
    public boolean land()
    {
        return true;
    }
    @Override
     public final boolean canCarry(Item item)
    {
        return (this.weight+cargoCarried+item.getWeight())<=this.maxWeight;
    }
    @Override
    public final boolean carry(Item item)
    {
        this.cargoCarried+=item.getWeight();
        return true;
    }
}
