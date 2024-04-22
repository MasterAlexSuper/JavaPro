public class Participant {
    int maxRun;
    float maxJump;
    String name;

    public boolean run(int toRun, String obstacle) {
        if (toRun > maxRun) {
            System.out.println(name + " could not run " + toRun + "m on " + obstacle);
            return false;
        } else {
            System.out.println(name + " has run on " + obstacle + " " + toRun + "m.");
            return true;
        }
    }


    public boolean jump(float toJump, String obstacle) {
        if (toJump > maxJump) {
            System.out.println(name + " could not jump over " + toJump + "m " + obstacle);
            return false;
        } else {
            System.out.println(name + " has jumped over " + toJump + "m " + obstacle);
            return true;
        }
    }
//    public String overcome() {}

    Participant(String name, int maxRun, float maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }
}
