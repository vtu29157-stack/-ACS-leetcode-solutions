class ParkingSystem {
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        // Index 1 is big, 2 is medium, 3 is small
        count = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (count[carType] > 0) {
            count[carType]--;
            return true;
        }
        return false;
    }
}
