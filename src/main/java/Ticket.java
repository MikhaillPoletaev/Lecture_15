public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int flyTime;

    public Ticket(int id, int price, String departure, String arrival, int flyTime) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.flyTime = flyTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getFlyTime() {
        return flyTime;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}