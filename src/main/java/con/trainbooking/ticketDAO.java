package con.trainbooking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public boolean bookTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (passenger_name, age, seat_number) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ticket.getPassengerName());
            pstmt.setInt(2, ticket.getAge());
            pstmt.setInt(3, ticket.getSeatNumber());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getString("passenger_name"),
                        rs.getInt("age"),
                        rs.getInt("seat_number")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return tickets;
    }

    public boolean cancelTicket(int ticketId) {
        String sql = "DELETE FROM tickets WHERE ticket_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ticketId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
