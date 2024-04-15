import javax.swing.*;

public class Animal {
    private String name;
    private int maxDistSwim;
    private int maxDistRun;

    public void run(int dist){
        if (dist <= maxDistRun){
            System.out.println(name + " runs " + dist + "m.");
        }
        else {
            System.out.println(name + " can`t run " + dist + "m.");
        }
    }

    public void swim(int dist){
        if (maxDistSwim == 0 )
            System.out.println(name + " can`t swim");

        else if (dist <= maxDistSwim)
            System.out.println(name + " swims " + dist + "m.");

        else
            System.out.println(name + "can`t swim " + dist + "m.");
    }

    public Animal(String name, int maxDistRun, int maxDistSwim){
        this.name = name;
        this.maxDistRun = maxDistRun;
        this.maxDistSwim = maxDistSwim;
    }
}
