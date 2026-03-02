import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {

        TicketService service = new TicketService();

        // Create ticket
        IncidentTicket t = service.createTicket(
                "TCK-1001",
                "reporter@example.com",
                "Payment failing on checkout"
        );

        System.out.println("Created: " + t);

        // Since ticket is immutable, updates return NEW object
        t = service.assign(t, "agent@example.com");
        t = service.escalateToCritical(t);

        System.out.println("\nAfter service updates (new instance created): " + t);

        // Attempt external mutation
        List<String> tags = t.getTags();

        try {
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (Exception e) {
            System.out.println("\nExternal modification blocked: " + e);
        }

        System.out.println("\nFinal Ticket: " + t);
    }
}