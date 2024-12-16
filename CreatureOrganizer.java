import java.util.Stack;

public class CreatureOrganizer {

    // Class representing a creature with a name and power level
    static class Creature {
        String name;
        int powerLevel;

        Creature(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }

        @Override
        public String toString() {
            return name + " - " + powerLevel;
        }
    }

    public static void main(String[] args) {
        // Initialize an array of creatures with fixed names and power levels
        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Phoenix", 92),
            new Creature("Griffin", 88),
            new Creature("Centaur", 85),
            new Creature("Unicorn", 78)
        };

        // Display the creatures sorted in descending order using Bubble Sort
        System.out.println("*** Bubble Sort: Descending order by Power Level ***");
        bubbleSortDescending(creatures);
        printCreatures(creatures);

        // Display the creatures sorted in ascending order using Selection Sort
        System.out.println("\n*** Selection Sort: Ascending Order by Power Level ***");
        selectionSortAscending(creatures);
        printCreatures(creatures);

        // Use a stack to store and display creatures in descending order
        System.out.println("\n*** Stack Implementation: Popping Creatures ***");
        Stack<Creature> stack = new Stack<>();

        // Push all creatures onto the stack after sorting in descending order
        bubbleSortDescending(creatures);
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        // Pop all creatures from the stack and display them
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    // Bubble Sort: Sort the creatures in descending order by power level
    private static void bubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current creature's power level is less than the next creature's
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort: Sort the creatures in ascending order by power level
    private static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the current index has the minimum power level
            for (int j = i + 1; j < n; j++) {
                // Update minIndex if a smaller power level is found
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap the current creature with the one at minIndex
            Creature temp = creatures[i];
            creatures[i] = creatures[minIndex];
            creatures[minIndex] = temp;
        }
    }

    // Utility method to print the list of creatures
    private static void printCreatures(Creature[] creatures) {
        for (Creature creature : creatures) {
            System.out.println(creature); // Print each creature's name and power level
        }
    }
}
