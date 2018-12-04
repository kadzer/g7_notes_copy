import java.util.ArrayList;

public class Hangar {
    private ArrayList<Plane> planes;
    private int capacity;

    public Hangar(ArrayList<Plane> planes, int capacity) {
        this.planes = planes;
        this.capacity = capacity;
    }

    public ArrayList<Plane> getPlanes() {
        return new ArrayList<>(this.planes);
    }

    public int numberOfPlanes() {
        return this.planes.size();
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    public int getCapacity() {
        return capacity;
    }
}
