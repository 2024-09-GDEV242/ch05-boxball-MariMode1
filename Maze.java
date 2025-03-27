
/**
 * The maze is represented by a 2D array of characters 
 * (# for walls, for paths, and E for the exit)
 *
 * @author (Mari Modebadze)
 * @version (03/23/25)
 */

import java.util.Scanner;

public class Maze
{
    // Maze size
    static final int MAZE_WIDTH = 10;
    static final int MAZE_HEIGHT = 10;

    // Maze representation
    static char[][] maze = {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', ' ', '#', ' ', '#', '#', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#'},
        {'#', '#', '#', '#', '#', '#', '#', 'E', '#', '#'} // 'E' is the exit
    };

    // Player state
    static class GameState {
        int x, y;
    }

    // Constructor for the Maze class
    public Maze()
    {
        // Initialize any variables if needed
    }

    // Function to print the maze
    public static void printMaze(GameState state) {
        // Clear the screen (works on most terminals)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < MAZE_HEIGHT; i++) {
            for (int j = 0; j < MAZE_WIDTH; j++) {
                if (i == state.y && j == state.x) {
                    System.out.print("P"); // Player position
                } else {
                    System.out.print(maze[i][j]);
                }
            }
            System.out.println();
        }
    }

    // Function to move the player
    public static void move(GameState state, char direction) {
        int newX = state.x;
        int newY = state.y;

        // Calculate new player position based on direction
        switch (direction) {
            case 'w': newY--; break;  // Move up
            case 's': newY++; break;  // Move down
            case 'a': newX--; break;  // Move left
            case 'd': newX++; break;  // Move right
            default: break;
        }

        // Check if the new position is within bounds and not a wall
        if (newX >= 0 && newX < MAZE_WIDTH && newY >= 0 && newY < MAZE_HEIGHT && maze[newY][newX] != '#') {
            state.x = newX;
            state.y = newY;
        }
    }

    // Function to check if the player has reached the exit
    public static boolean checkExit(GameState state) {
        return maze[state.y][state.x] == 'E';
    }

    // Main game loop
    public static void main(String[] args) {
        GameState state = new GameState();
        state.x = 1; // Starting position (1,1)
        state.y = 1;

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        // Game loop
        while (gameRunning) {
            // Print the maze
            printMaze(state);

            // Check for exit
            if (checkExit(state)) {
                System.out.println("You win!");
                gameRunning = false;
                break;
            }

            // Get player input (w = up, s = down, a = left, d = right, q = quit)
            System.out.println("Enter move (w/a/s/d to move, q to quit): ");
            char move = scanner.next().charAt(0);

            if (move == 'q') {
                System.out.println("You quit the game.");
                gameRunning = false;
            } else {
                move(state, move);
            }
        }

        scanner.close();
    }
}


