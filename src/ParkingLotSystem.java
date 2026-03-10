import java.util.*;

public class ParkingLotSystem {

    static String[] parkingLot = new String[10];

    public static int hash(String plate){

        return Math.abs(plate.hashCode()%parkingLot.length);
    }

    public static int parkVehicle(String plate){

        int index = hash(plate);

        while(parkingLot[index]!=null)
            index=(index+1)%parkingLot.length;

        parkingLot[index]=plate;

        return index;
    }

    public static void main(String[] args) {

        System.out.println("Vehicle parked at "+parkVehicle("ABC123"));
        System.out.println("Vehicle parked at "+parkVehicle("XYZ999"));
    }
}