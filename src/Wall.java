public class Wall implements Obstacle {
    private final float height;

    Wall(float height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.jump(height, "wall");

    }
}
