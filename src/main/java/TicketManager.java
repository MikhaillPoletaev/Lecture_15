import java.lang.reflect.Array;
import java.util.Arrays;

public class TicketManager {

    Repository repo;

    public TicketManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public Ticket[] searchBy(String departure, String arrival) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, departure, arrival)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String departure, String arrival) {
        if (ticket.getDeparture().equals(departure)) {
            if (ticket.getArrival().equals(arrival)) {
                return true;
            }
        }
        return false;
    }


}





