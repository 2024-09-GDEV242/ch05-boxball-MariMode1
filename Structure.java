
/**
 * Write a description of class Structure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Structure {
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

    // Function to print the maze
    public static void printStructure(Player player) {
        // Clear the screen (works on most terminals)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < MAZE_HEIGHT; i++) {
            for (int j = 0; j < MAZE_WIDTH; j++) {
                if (i == player.getY() && j == player.getX()) {
                    System.out.print("P"); // Player position
                } else {
                    System.out.print(maze[i][j]);
                }
            }
            System.out.println();
        }
    }

    // Function to check if the exit is reached
    public static boolean checkExit(Player player) {
        return maze[player.getY()][player.getX()] == 'E';
    }
}
