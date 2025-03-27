
/**
 * Write a description of class player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player {
    private int x, y;

    // Constructor to initialize player position
    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    // Getters for player's position
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters for player's position
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Function to move the player based on the direction
    public void move(char direction) {
        int newX = this.x;
        int newY = this.y;

        // Calculate new position based on input
        switch (direction) {
            case 'w': newY--; break;  // Move up
            case 's': newY++; break;  // Move down
            case 'a': newX--; break;  // Move left
            case 'd': newX++; break;  // Move right
            default: break;
        }

        // Validate the new position (can't move into walls or out of bounds)
        if (newX >= 0 && newX < Maze.MAZE_WIDTH && newY >= 0 && newY < Maze.MAZE_HEIGHT && Maze.maze[newY][newX] != '#') {
            this.x = newX;
            this.y = newY;
        }
    }
}
