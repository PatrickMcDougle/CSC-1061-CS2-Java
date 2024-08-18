/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch20;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

class MultipleBallPane extends Pane {
    private Timeline animation;

    public MultipleBallPane() {
        // Create an animation for moving the ball
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play(); // Start animation
    }

    public void add() {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        getChildren().add(new Ball(30, 30, 20, color));
    }

    public void subtract() {
        // original if statement way to do this.
        // (getChildren().size() > 0)
        if (!getChildren().isEmpty()) {
            getChildren().remove(getChildren().size() - 1);
        }
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {
        for (Node node : this.getChildren()) {
            Ball ball = (Ball) node;
            // Check boundaries
            if (ball.getCenterX() < ball.getRadius()
                    || ball.getCenterX() > getWidth() - ball.getRadius()) {
                ball.dx *= -1; // Change ball move direction
            }
            if (ball.getCenterY() < ball.getRadius()
                    || ball.getCenterY() > getHeight() - ball.getRadius()) {
                ball.dy *= -1; // Change ball move direction
            }

            // Adjust ball position
            ball.setCenterX(ball.dx + ball.getCenterX());
            ball.setCenterY(ball.dy + ball.getCenterY());
        }
    }
}
