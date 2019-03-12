package qenawi.panda.android_tutorial.oopJavaUdacity_SpaceShip;

public class Item {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    public Item(String name, int Weight) {
        this.name = name;
        this.Weight = Weight;
    }
    public Item(){}
    private String name;
    private Integer Weight;
}
