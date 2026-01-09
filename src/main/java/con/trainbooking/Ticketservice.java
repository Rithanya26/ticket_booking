package com.example.trainbooking;

import java.util.List;

public class TicketService {
    private final TicketDAO ticketDAO;

    public TicketService() {
        this.ticketDAO = new TicketDAO();
    }

    public boolean bookTicket(String name, int age, int seatNumber) {
        Ticket ticket = new Ticket(name, age, seatNumber);
        return ticketDAO.bookTicket(ticket);
    }

    public void showAllTickets() {
        List<Ticket> tickets = ticketDAO.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            tickets.forEach(System.out::println);
        }
    }

    public boolean cancelTicket(int ticketId) {
        return ticketDAO.cancelTicket(ticketId);
    }
}
