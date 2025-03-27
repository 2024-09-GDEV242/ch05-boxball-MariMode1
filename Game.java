
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Game {
    private Player player;

    public Game() {
        // Initialize the player at the start position (1,1)
        player = new Player(1, 1);
    }

    // Function to start the game loop
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        // Game loop
        while (gameRunning) {
            // Print the maze
            Maze.printMaze(player);

            // Check if the player has reached the exit
            if (Maze.checkExit(player)) {
                System.out.println("Congratulations! You've reached the exit!");
                gameRunning = false;
                break;
            }

            // Ask for input
            System.out.println("Enter your move (w = up, s = down, a = left, d = right, q = quit): ");
            char move = scanner.next().charAt(0);

            if (move == 'q') {
                System.out.println("You quit the game.");
                gameRunning = false;
            } else {
                player.move(move); // Move the player
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // Create and start the game
        Game game = new Game();
        game.start();
    }
}
