public enum PlaneType {
    BOEING747(500),
    BOEING767(700),
    BOEING777(1000);

    private int capacity;

    PlaneType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
