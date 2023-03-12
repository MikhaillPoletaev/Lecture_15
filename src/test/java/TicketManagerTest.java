import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    @Test

    public void whenFewTicketsFound() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 300, "DME", "LED", 80);
        Ticket t2 = new Ticket(2, 500, "DME", "LED", 85);
        Ticket t3 = new Ticket(3, 500, "DME", "EVN", 240);
        Ticket t4 = new Ticket(4, 1_000, "DME", "TLV", 300);
        Ticket t5 = new Ticket(5, 200, "VKO", "KGD", 180);
        Ticket t6 = new Ticket(6, 700, "SVO", "IST", 210);
        Ticket t7 = new Ticket(7, 500, "VKO", "SAW", 80);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);

        Ticket[] expected = {t1, t2};
        Ticket[] actual = manager.searchBy("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void removeTicket() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 300, "DME", "LED", 80);
        Ticket t2 = new Ticket(2, 500, "DME", "LED", 85);
        Ticket t3 = new Ticket(3, 500, "DME", "EVN", 240);
        Ticket t4 = new Ticket(4, 1_000, "DME", "TLV", 300);
        Ticket t5 = new Ticket(5, 200, "VKO", "KGD", 180);
        Ticket t6 = new Ticket(6, 700, "SVO", "IST", 210);
        Ticket t7 = new Ticket(7, 500, "VKO", "SAW", 80);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        repo.removeById(7);

        Ticket[] expected = {t1, t2, t3, t4, t5, t6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void removeTicket2() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 300, "DME", "LED", 80);
        Ticket t2 = new Ticket(2, 500, "DME", "LED", 85);
        Ticket t3 = new Ticket(3, 500, "DME", "EVN", 240);
        Ticket t4 = new Ticket(4, 1_000, "DME", "TLV", 300);
        Ticket t5 = new Ticket(5, 200, "VKO", "KGD", 180);
        Ticket t6 = new Ticket(6, 700, "SVO", "IST", 210);
        Ticket t7 = new Ticket(7, 500, "VKO", "SAW", 80);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);


        Assertions.assertThrows(NonFoundException.class, () -> {
            repo.removeById(12);
        });
    }

    @Test

    public void addTickets() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 300, "DME", "LED", 80);
        Ticket t2 = new Ticket(2, 500, "DME", "LED", 85);
        Ticket t3 = new Ticket(3, 500, "DME", "EVN", 240);
        Ticket t4 = new Ticket(4, 1_000, "DME", "TLV", 300);
        Ticket t5 = new Ticket(5, 200, "VKO", "KGD", 180);
        Ticket t6 = new Ticket(6, 700, "SVO", "IST", 210);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Ticket[] expected = {t1, t2, t3, t4, t5, t6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void whenOneTicketsFound() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 300, "DME", "IST", 80);
        Ticket t2 = new Ticket(2, 500, "DME", "LED", 85);
        Ticket t3 = new Ticket(3, 500, "DME", "EVN", 240);
        Ticket t4 = new Ticket(4, 1_000, "DME", "TLV", 300);
        Ticket t5 = new Ticket(5, 200, "VKO", "KGD", 180);
        Ticket t6 = new Ticket(6, 700, "SVO", "IST", 210);
        Ticket t7 = new Ticket(7, 500, "VKO", "SAW", 80);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);

        Ticket[] expected = {t1};
        Ticket[] actual = manager.searchBy("DME", "IST");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void whenFewTicketsFound2() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 500, "DME", "LED", 80);
        Ticket t2 = new Ticket(2, 500, "DME", "LED", 85);
        Ticket t3 = new Ticket(3, 500, "DME", "EVN", 240);
        Ticket t4 = new Ticket(4, 1_000, "DME", "TLV", 300);
        Ticket t5 = new Ticket(5, 200, "VKO", "KGD", 180);
        Ticket t6 = new Ticket(6, 700, "SVO", "IST", 210);
        Ticket t7 = new Ticket(7, 500, "VKO", "SAW", 80);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);

        Ticket[] expected = {t1, t2};
        Ticket[] actual = manager.searchBy("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void getFlyTime() {

        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 500, "DME", "LED", 80);

        manager.add(t1);

        int actual = 80;
        int expected = t1.getFlyTime();

        Assertions.assertEquals(actual, expected);


    }

    @Test

    public void getPrice() {

        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 500, "DME", "LED", 80);

        manager.add(t1);

        int actual = 500;
        int expected = t1.getPrice();

        Assertions.assertEquals(actual, expected);


    }

    @Test

    public void whenNoTicketsFound() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket t1 = new Ticket(1, 500, "DME", "LED", 80);
        Ticket t2 = new Ticket(2, 500, "DME", "LED", 85);
        Ticket t3 = new Ticket(3, 500, "DME", "EVN", 240);
        Ticket t4 = new Ticket(4, 1_000, "DME", "TLV", 300);
        Ticket t5 = new Ticket(5, 200, "VKO", "KGD", 180);
        Ticket t6 = new Ticket(6, 700, "SVO", "IST", 210);
        Ticket t7 = new Ticket(7, 500, "VKO", "SAW", 80);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchBy("DME", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }


}
