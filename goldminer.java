import java.util.*;

class GoldMinerGame {
    private static final int MAX_GOLD = 100;
    private static final int MAX_DEPTH = 10;

    private int currentGold;
    private int currentDepth;
    private PriorityQueue<Integer> undergroundLayers;

    public GoldMinerGame() {
        currentGold = 0;
        currentDepth = 0;
        undergroundLayers = new PriorityQueue<>();

        // Initialize random underground layers with gold values
        Random random = new Random();
        for (int i = 0; i < MAX_DEPTH; i++) {
            undergroundLayers.offer(random.nextInt(MAX_GOLD) + 1);
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (currentDepth < MAX_DEPTH) {
            System.out.println("Current Depth: " + (currentDepth + 1));
            System.out.println("Current Gold: " + currentGold);
            System.out.println("Underground Layer: " + undergroundLayers.peek());

            System.out.print("Do you want to mine? (y/n): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("y")) {
                int minedGold = undergroundLayers.poll();
                currentGold += minedGold;
                currentDepth++;

                System.out.println("You mined " + minedGold + " gold!");
            } else if (input.equals("n")) {
                System.out.println("You decided not to mine. Moving to the next layer.");
                currentDepth++;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }

        System.out.println("Game Over!");
        System.out.println("Total Gold Mined: " + currentGold);
    }

    public static void main(String[] args) {
        GoldMinerGame minerGame = new GoldMinerGame();
        minerGame.play();
    }
}
