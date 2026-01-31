package BASICS.JAVA_PROJECTS;
import java.util.*;

public class LibraryRecords {
    static Map<String, Map<String, Integer>> libraryRecords = new HashMap<>();

    static {
        libraryRecords.put("Hrushi", new HashMap<>(Map.of("Book A", 2, "Book B", 1)));
        libraryRecords.put("Shreyash", new HashMap<>(Map.of("Book A", 0, "Book C", 3)));
        libraryRecords.put("Yash", new HashMap<>(Map.of("Book D", 0, "Book E", 0)));
        libraryRecords.put("sidd", new HashMap<>(Map.of("Book B", 4, "Book C", 1)));
    }

    static double averageBooksBorrowed() {
        int totalBooks = 0;
        for (Map<String, Integer> books : libraryRecords.values()) {
            for (int count : books.values()) totalBooks += count;
        }
        return (double) totalBooks / libraryRecords.size();
    }

    static Map.Entry<String, Integer>[] highestLowestBorrowedBooks() {
        Map<String, Integer> borrowCounts = new HashMap<>();
        for (Map<String, Integer> books : libraryRecords.values()) {
            for (Map.Entry<String, Integer> entry : books.entrySet()) {
                borrowCounts.put(entry.getKey(), borrowCounts.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        Map.Entry<String, Integer> highest = Collections.max(borrowCounts.entrySet(), Map.Entry.comparingByValue());
        Map.Entry<String, Integer> lowest = Collections.min(borrowCounts.entrySet(), Map.Entry.comparingByValue());
        return new Map.Entry[]{highest, lowest};
    }

    static int countMembersNoBorrow() {
        int count = 0;
        for (Map<String, Integer> books : libraryRecords.values()) {
            int sum = 0;
            for (int val : books.values()) sum += val;
            if (sum == 0) count++;
        }
        return count;
    }

    static int mostFrequentBorrowCount() {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Map<String, Integer> books : libraryRecords.values()) {
            for (int val : books.values()) freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        System.out.println("Average books borrowed: " + averageBooksBorrowed());
        Map.Entry<String, Integer>[] res = highestLowestBorrowedBooks();
        System.out.println("Highest borrowed book: " + res[0].getKey() + " (" + res[0].getValue() + " times)");
        System.out.println("Lowest borrowed book: " + res[1].getKey() + " (" + res[1].getValue() + " times)");
        System.out.println("Members with 0 borrowings: " + countMembersNoBorrow());
        System.out.println("Most frequent borrow count (mode): " + mostFrequentBorrowCount());
    }
}
