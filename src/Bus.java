public class Bus {
    private int busNumber;
    private int capacity;
    Bus(int busNumber, int capacity) {
        this.busNumber = busNumber;
        this.capacity = capacity;
    }

    public int getCapacity(){
        return  capacity;
    }

    public  void setCapacity(int capacity){

        this.capacity = capacity;
    }

    public int getBusNumber(){
        return busNumber;
    }

    public void setBusNumber(int busNumber){
        this.busNumber = busNumber;
    }

    public static void display(){
        System.out.println("1.View Available Buses: ");
        System.out.println("----------------------------------");
        System.out.println("Bus No : 101   | Route: Chennai → Madurai   | Seats Available: 32 | AC:yes");
        System.out.println("Bus No : 102   | Route: Bangalore → Coimbatore | Seats Available: 20 | AC:no");
        System.out.println("Bus No : 103   | Route: Hyderabad → Vizag   | Seats Available: 15 | AC:yes");
    }




}
