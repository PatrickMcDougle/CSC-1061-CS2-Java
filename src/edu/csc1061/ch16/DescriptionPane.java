/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch16;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

// a description pane
public class DescriptionPane extends BorderPane {
  /** Label for displaying an image and a title */
  private Label labelImageTitle = new Label();

  /** Text area for displaying text */
  private TextArea textAreaDescription = new TextArea();

  public DescriptionPane() {
    // Center the icon and text and place the text under the icon
    labelImageTitle.setContentDisplay(ContentDisplay.TOP);
    labelImageTitle.setPrefSize(200, 100);

    // Set the font in the label and the text field
    labelImageTitle.setFont(new Font("SansSerif", 16));
    textAreaDescription.setFont(new Font("Serif", 14));

    textAreaDescription.setWrapText(true);
    textAreaDescription.setEditable(false);

    // Create a scroll pane to hold the text area
    ScrollPane scrollPane = new ScrollPane(textAreaDescription);

    // Place label and scroll pane in the border pane
    setLeft(labelImageTitle);
    setCenter(scrollPane);
    setPadding(new Insets(5, 5, 5, 5));
  }

  /** Set the title */
  public void setTitle(String title) {
    labelImageTitle.setText(title);
  }

  /** Set the image view */
  public void setImageView(ImageView icon) {
    labelImageTitle.setGraphic(icon);
  }

  /** Set the text description */
  public void setDescription(String text) {
    textAreaDescription.setText(text);
  }
}
