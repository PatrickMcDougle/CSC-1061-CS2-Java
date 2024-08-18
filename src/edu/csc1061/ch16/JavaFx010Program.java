/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * <p>
 * ********** DON'T FORGET TO add javafx.media to the VM Arguments **********
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch16;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

// Media Example
public class JavaFx010Program extends Application {
    private static final String MEDIA_URL_1 = "resources/videos/AirPlaneDemo.mp4";

    private static final String MEDIA_BUTTON_PLAY_TEXT = ">";
    private static final String MEDIA_BUTTON_PAUSE_TEXT = "||";
    private static final String MEDIA_BUTTON_REWIND_TEXT = "<<";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws MalformedURLException {
        File videoFile = new File(MEDIA_URL_1);

        URI videoFileUri = videoFile.toURI();
        URL videoFileUrl = videoFileUri.toURL();
        Media media = new Media(videoFileUrl.toString());
        // Media media = new Media(videoFile.toURI().toURL().toString())

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitHeight(400);

        Button playButton = new Button(MEDIA_BUTTON_PLAY_TEXT);

        // Lambda Expression:
        // parameter -> expression
        // https://www.w3schools.com/java/java_lambda.asp
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(MEDIA_BUTTON_PLAY_TEXT)) {
                mediaPlayer.play();
                playButton.setText(MEDIA_BUTTON_PAUSE_TEXT);
            } else {
                mediaPlayer.pause();
                playButton.setText(MEDIA_BUTTON_PLAY_TEXT);
            }
        });

        Button rewindButton = new Button(MEDIA_BUTTON_REWIND_TEXT);
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider sliderVolume = new Slider();
        sliderVolume.setPrefWidth(150);
        sliderVolume.setMaxWidth(Region.USE_PREF_SIZE);
        sliderVolume.setMinWidth(30);
        sliderVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(sliderVolume.valueProperty().divide(100));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton, new Label("Volume"), sliderVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("MediaDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method should always be present so that the code is compilable and runnable on
     * different computers. Make sure you have the main method in the application so others can
     * compile the code.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
