class Vehicle{
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    Vehicle(String licensePlate, String ownerName, int hoursParked){
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    String getLicensePlate(){
        return licensePlate;
    }

    String getOwnerName(){
        return ownerName;
    }

    int getHoursParked(){
        return hoursParked;
    }

    void displayInfo(){
        System.out.println("License: " + licensePlate + ", Owner: " + ownerName + ", Hours: " + hoursParked);
    }
}

class ParkingLot{
    private Vehicle[] vehicles;
    private int count;

    ParkingLot(){
        vehicles = new Vehicle[5];
        count = 0;
    }

    void parkVehicle(Vehicle v){
        if (count < 5){
            vehicles[count] = v;
            count++;
        } else{
            System.out.println("Parking lot is full!");
        }
    }

    void removeVehicle(String license){
		boolean found = false;
        for (int i = 0; i < count; i++){
            if (vehicles[i].getLicensePlate().equals(license)){
                found = true;
                for (int j = i; j < count - 1; j++){
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[count - 1] = null;
                count--;
                System.out.println("Vehicle with license " + license + " removed.");
                break;
            }
        }
        if (!found){
            System.out.println("Vehicle with license " + license + " not found.");
        }
    }

    void displayAllVehicles(){
        if (count == 0){
            System.out.println("No vehicles parked.");
        }
		else{
            for (int i = 0; i < count; i++){
                vehicles[i].displayInfo();
            }
        }
    }
}

class Main{
    public static void main(String[] args){
        ParkingLot lot = new ParkingLot();

        Vehicle v1 = new Vehicle("ABC123", "John Doe", 2);
        Vehicle v2 = new Vehicle("XYZ789", "Jane Smith", 4);
        Vehicle v3 = new Vehicle("LMN456", "Bob Brown", 1);

        lot.parkVehicle(v1);
        lot.parkVehicle(v2);
        lot.parkVehicle(v3);
		lot.removeVehicle("XYZ789");
        lot.displayAllVehicles();
    }
}


