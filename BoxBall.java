import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * A model of balls that bounce off the walls of a box.
 *
 * @author Mari Modebadze
 * @version 2024.10.20
 */
public class BoxBall
{
    
    private int x, y; // Position of the ball.
    private int speedX, speedY; // Speed 
    private int diameter;
    private Color color;

    private static final Random rand = new Random();

    /**
     * Constructor to create BoxBall with random start position and speed.
     * 
     * @param boxWidth The width of the box.
     * @param boxHeight The height of the box.
     * @param diameter The diameter of the ball.
     */
    public BoxBall(int boxWidth, int boxHeight, int diameter)
    {
        this.diameter = diameter;
        this.x = rand.nextInt(boxWidth - diameter);
        this.y = rand.nextInt(boxHeight - diameter);
        
        // Random speed between -7 and +7, ensuring neither value is zero
        do {
            speedX = rand.nextInt(15) - 7; // Values from -7 to +7
        } while (speedX == 0);

        do {
            speedY = rand.nextInt(15) - 7; // Values from -7 to +7
        } while (speedY == 0);

        // Generate a random color avoiding white
        this.color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        while (isColorTooBright(color)) {
            this.color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        }
    }

    /**
     * Update the position of the ball and check for wall collisions.
     * 
     * @param boxWidth  The width of the box.
     * @param boxHeight The height of the box.
     */
    public void update(int boxWidth, int boxHeight) {
        x += speedX;
        y += speedY;

        // Bounce off left and right walls
        if (x < 0 || x + diameter > boxWidth) {
            speedX = -speedX; // Reverse x speed
            x = Math.max(0, Math.min(x, boxWidth - diameter)); // Keep ball inside box
        }

        // Bounce off top and bottom walls
        if (y < 0 || y + diameter > boxHeight) {
            speedY = -speedY; // Reverse y speed
            y = Math.max(0, Math.min(y, boxHeight - diameter)); // Keep ball inside box
        }
    }

    /**
     * Draw the ball on the canvas.
     * 
     * @param canvas The canvas to draw on.
     */
    public void draw(Canvas canvas) {
        canvas.setForegroundColor(color);
        canvas.fillCircle(x, y, diameter);
    }

    /**
     * Check if the color is too close to white.
     * 
     * @param color The color to check.
     * @return true if the color is too bright, false otherwise.
     */
    private boolean isColorTooBright(Color color) {
        return (color.getRed() > 200 && color.getGreen() > 200 && color.getBlue() > 200);
    }
    } 

