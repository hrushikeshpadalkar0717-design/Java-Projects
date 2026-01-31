package BASICS.JAVA_PROJECTS;

import java.util.*;

class Event {
    private int id;
    private String description;
    private long timestamp;

    public Event(int id, String description) {
        this.id = id;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}


class EventProcessingSystem {
    private Queue<Event> eventQueue;

    public EventProcessingSystem() {
        eventQueue = new LinkedList<>();
    }

   
    public void addEvent(Event event) {
        eventQueue.add(event);
        System.out.println("Event added: " + event);
    }

    
    public void processNextEvent() {
        if (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            System.out.println("Processing event: " + event);
        } else {
            System.out.println("No events to process.");
        }
    }

    public void displayPendingEvents() {
        if (eventQueue.isEmpty()) {
            System.out.println("No pending events.");
        } else {
            System.out.println("Pending Events:");
            for (Event e : eventQueue) {
                System.out.println(e);
            }
        }
    }

    public void cancelEvent(int eventId) {
        boolean removed = false;
        Iterator<Event> iterator = eventQueue.iterator();
        while (iterator.hasNext()) {
            Event e = iterator.next();
            if (e.getId() == eventId) {
                iterator.remove();
                removed = true;
                System.out.println("Event canceled: " + e);
                break;
            }
        }
        if (!removed) {
            System.out.println("Event not found or already processed.");
        }
    }
}

public class EventManagement {
    public static void main(String[] args) {
        EventProcessingSystem system = new EventProcessingSystem();

        Event e1 = new Event(1, "User Login");
        Event e2 = new Event(2, "File Uploaded");
        Event e3 = new Event(3, "Email Sent");

        system.addEvent(e1);
        system.addEvent(e2);
        system.addEvent(e3);

        system.displayPendingEvents();

        system.processNextEvent();
        system.displayPendingEvents();

        system.cancelEvent(3);
        system.displayPendingEvents();

        system.cancelEvent(5);
    }
}
