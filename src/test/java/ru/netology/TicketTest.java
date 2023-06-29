package ru.netology;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class TicketTest {
    Ticket ticket1 = new Ticket("MSK", "BGD", 2000, 7, 9); //2-1
    Ticket ticket2 = new Ticket("MSK", "SPB", 5500, 10, 6);//4
    Ticket ticket3 = new Ticket("MSK", "BGD", 16000, 5, 10);//5-4
    Ticket ticket4 = new Ticket("MSK", "BGD", 3000, 15, 18);//3-2
    Ticket ticket5 = new Ticket("MSK", "BGD", 27000, 7, 19);//12-6
    Ticket ticket6 = new Ticket("MSK", "BGD", 5000, 10, 18);//8-5

    @Test
    public void testComparator() {
        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket4, ticket3, ticket6, ticket5};
        Ticket[] actual = repo.searchCompo("MSK", "BGD", comparator);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareTo() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] expected = {ticket1, ticket4, ticket6, ticket3, ticket5};
        Ticket[] actual = repo.search("MSK", "BGD");
        Assert.assertArrayEquals(expected, actual);
    }
}