package Tests;

public class Test {

    public boolean carParking(int[] parkingLot, int n ) {


        int prev = 0, next=0;

        if(parkingLot == null || parkingLot.length == 0) {
            return false;
        }

        if(parkingLot[0] == 0 && parkingLot[1]== 0) {
            parkingLot[0] = 1;
            n--;

        }
        prev = parkingLot[0];
        next = parkingLot[2];
        for(int j=1;j<parkingLot.length-1;j++) {

            if(prev==0 && next==0) {
                parkingLot[j] = 1;
                n--;
            }
            prev = parkingLot[j];
            next = parkingLot[j+2];

        }

        if(n<=0) return true;
        else return false;


    }
}
