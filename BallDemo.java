import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Mari Modebadze
 * @version 2024.10.20
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate bouncing balls inside a box 
     * 
     * @param numballs created inside the box.
     */
    public void boxBounce(int numBalls)
    {
        int boxX = 50; // x position of the box
        int boxY = 50; // y position of the box
        int boxWidth = 500; // width of the box
        int boxHeight = 400; // height of the box
        
        myCanvas.setVisible(true);
        
        // Draw the box
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawRectangle(boxX, boxY, boxWidth, boxHeight);

        // Create balls
        BoxBall[] balls = new BoxBall[numBalls];
        for (int i = 0; i < numBalls; i++) {
            balls[i] = new BoxBall(boxWidth, boxHeight, 20);
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            myCanvas.clear();

            // Redraw the box
            myCanvas.setForegroundColor(Color.BLACK);
            myCanvas.drawRectangle(boxX, boxY, boxWidth, boxHeight);

            // Update and draw each ball
            for (BoxBall ball : balls) {
                ball.update(boxWidth, boxHeight);
                ball.draw(myCanvas);
            }

            // Stopping condition
            finished = (balls[0].getXPosition() >= boxWidth - 20); // Stop when the first ball reaches the right edge
        }
    }
    
    public static void main(String[] args) {
        BallDemo demo = new BallDemo();
        demo.boxBounce(10); // Create 10 balls
    }
}
            
        
    

