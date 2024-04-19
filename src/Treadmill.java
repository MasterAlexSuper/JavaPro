public class Treadmill implements Obstacle {
    private final int length;

    Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.run(length, "treadmill");

    }
}
