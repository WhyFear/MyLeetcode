/**
 * https://leetcode-cn.com/problems/design-parking-system/
 */
class ParkingSystem {
    private int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 3:
                return --small >= 0;
            case 2:
                return --medium >= 0;
            case 1:
                return --big >= 0;
        }
        return false;
    }
}