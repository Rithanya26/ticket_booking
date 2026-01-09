package con.trainbooking;

public class Ticket {
    private int ticketId;
    private String passengerName;
    private int age;
    private int seatNumber;

    public Ticket(int ticketId, String passengerName, int age, int seatNumber) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    public Ticket(String passengerName, int age, int seatNumber) {
        this.passengerName = passengerName;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    // Getters
    public int getTicketId() { return ticketId; }
    public String getPassengerName() { return passengerName; }
    public int getAge() { return age; }
    public int getSeatNumber() { return seatNumber; }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", passengerName='" + passengerName + '\'' +
                ", age=" + age +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
