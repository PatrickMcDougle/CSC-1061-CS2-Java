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
package edu.csc1061.ch14;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    private static final double TWO_PI = 2 * Math.PI;

    /** Construct a default clock with the current time */
    public ClockPane() {
        setCurrentTime();
    }

    /** Construct a clock with specified hour, minute, and second */
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /** Return hour */
    public int getHour() {
        return hour;
    }

    /** Set a new hour */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /** Return minute */
    public int getMinute() {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /** Return second */
    public int getSecond() {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    /** Set the current time for the clock */
    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); // Repaint the clock
    }

    /** Paint the clock */
    private void paintClock() {
        // Initialize clock parameters
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.4;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radians;

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // add numbers
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // Draw second hand
        double secondR = clockRadius * 0.8;
        radians = second * (TWO_PI / 60);
        double secondX = centerX + secondR * Math.sin(radians);
        double secondY = centerY - secondR * Math.cos(radians);
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        // Draw minute hand
        double minuteR = clockRadius * 0.65;
        radians = minute * (TWO_PI / 60);
        double minuteX = centerX + minuteR * Math.sin(radians);
        double minuteY = centerY - minuteR * Math.cos(radians);
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.BLUE);

        // Draw hour hand
        double hourR = clockRadius * 0.5;
        radians = (hour % 12 + minute / 60.0) * (TWO_PI / 12);
        double hourX = centerX + hourR * Math.sin(radians);
        double hourY = centerY - hourR * Math.cos(radians);
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().clear(); // Clear the pane
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}
