import java.util.*;

public class PracticeSolutions {

    public static void main(String[] args) {
        System.out.println("--- Часть 1: Работа с HashSet (1-10) ---");
        runSetPractice();

        System.out.println("\n--- Часть 2: Работа с ArrayDeque (11-21) ---");
        runDequePractice();
    }

    private static void runSetPractice() {
        // 1.
        List<Integer> inputList = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
        HashSet<Integer> uniqueNums = new HashSet<>(inputList);
        System.out.println("1. Unique values: " + uniqueNums);

        // 2.
        HashSet<String> allowedUsers = new HashSet<>(Arrays.asList("admin", "guest", "student"));
        System.out.println("2. Is 'admin' allowed? " + isAllowed("admin", allowedUsers));

        // 3.
        HashSet<Integer> set3 = new HashSet<>();
        set3.add(10); set3.add(20);
        System.out.println("3. Size: " + set3.size());
        set3.clear();
        System.out.println("3. Is empty after clear: " + set3.isEmpty());

        // 4.
        HashSet<String> names = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));
        boolean removed = names.remove("Bob");
        System.out.println("4. Removal success: " + removed + ". Set: " + names);

        // 5.
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        set1.addAll(set2);
        System.out.println("5. After addAll: " + set1);

        // 6.
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        setA.removeAll(setB);
        System.out.println("6. After removeAll: " + setA);

        // 7.
        HashSet<Integer> setX = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> setY = new HashSet<>(Arrays.asList(2, 3, 4));
        setX.retainAll(setY);
        System.out.println("7. After retainAll: " + setX);

        // 8.
        HashSet<Integer> mainSet = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> subSet = new HashSet<>(Arrays.asList(2, 3));
        if (mainSet.containsAll(subSet)) {
            System.out.println("8. Friendly message: mainSet contains all elements of subSet!");
        }

        // 9.
        String sentence = "java is fun and java is powerful";
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(sentence.split(" ")));
        System.out.println("9. Unique words from sentence: " + uniqueWords);

        // 10.
        String[] mixedCase = {"Apple", "apple", "APPLE", "Banana"};
        HashSet<String> caseInsensitiveSet = new HashSet<>();
        for (String s : mixedCase) {
            caseInsensitiveSet.add(s.toLowerCase());
        }
        System.out.println("10. Case-insensitive: " + caseInsensitiveSet);
    }

    private static void runDequePractice() {
        // 11.
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(100); queue.offer(200);
        System.out.println("11. Peek: " + queue.peek());
        while (!queue.isEmpty()) System.out.println("Polled: " + queue.poll());

        // 12.
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("First"); stack.push("Second"); stack.push("Third");
        while (!stack.isEmpty()) System.out.println("Popped: " + stack.pop());

        // 13.
        ArrayDeque<Integer> flDeque = new ArrayDeque<>();
        flDeque.addFirst(1); flDeque.addLast(2);
        System.out.println("13. Order: " + flDeque);

        // 14.
        System.out.println("14. OfferFirst success: " + flDeque.offerFirst(0));
        System.out.println("Deque content: " + flDeque);

        // 15.
        ArrayDeque<String> empty = new ArrayDeque<>();
        System.out.println("15. peekFirst on empty: " + empty.peekFirst());

        // 16.
        ArrayDeque<Integer> pollDeq = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        System.out.print("16. Polling: ");
        while (!pollDeq.isEmpty()) System.out.print(pollDeq.pollFirst() + " ");
        System.out.println();

        // 17.
        ArrayDeque<String> dups = new ArrayDeque<>(Arrays.asList("a", "b", "c", "b", "a"));
        dups.removeFirstOccurrence("b");
        dups.removeLastOccurrence("a");
        System.out.println("17. After removeOccurrence: " + dups);

        // 18.
        System.out.println("18. Size: " + dups.size() + ", Is empty: " + dups.isEmpty());

        // 19.
        dups.clear();
        System.out.println("19. After clear, peek: " + dups.peek() + ", isEmpty: " + dups.isEmpty());

        // 20.
        System.out.println("20. Is 'racecar' a palindrome? " + checkPalindrome("racecar"));

        // 21.
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("Buy milk", false);
        scheduler.addTask("Fix critical bug", true);
        scheduler.processTask(); // Выполнит "Fix critical bug"
        scheduler.processTask(); // Выполнит "Buy milk"
    }

    //
    public static boolean isAllowed(String name, HashSet<String> set) {
        return set.contains(name);
    }

    //
    public static boolean checkPalindrome(String text) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

//
class TaskScheduler {
    private ArrayDeque<String> tasks = new ArrayDeque<>();

    public void addTask(String task, boolean highPriority) {
        if (highPriority) tasks.addFirst(task);
        else tasks.addLast(task);
    }

    public void processTask() {
        if (!tasks.isEmpty()) {
            System.out.println("21. Processing task: " + tasks.pollFirst());
        }
    }
}