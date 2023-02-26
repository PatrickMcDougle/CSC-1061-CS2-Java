package edu.csc1061.ch16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// combo box
public class JavaFx007Program extends Application {
  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"Canada", "China", "Denmark", "France", "Germany", "India",
      "Norway", "United Kingdom", "United States of America",};

  // Declare an ImageView array for the national flags of 9 countries
  private ImageView[] flagImages = {new ImageView("file:resources/images/ca.gif"),
      new ImageView("file:resources/images/china.gif"),
      new ImageView("file:resources/images/denmark.gif"),
      new ImageView("file:resources/images/fr.gif"),
      new ImageView("file:resources/images/germany.gif"),
      new ImageView("file:resources/images/india.gif"),
      new ImageView("file:resources/images/norway.gif"),
      new ImageView("file:resources/images/uk.gif"),
      new ImageView("file:resources/images/us.gif"),};

  // Declare an array of strings for flag descriptions
  private String[] flagDescription = new String[9];

  // Declare and create a description pane
  private DescriptionPane descriptionPane = new DescriptionPane();

  // Create a combo box for selecting countries
  private ComboBox<String> comboBoxFlags = new ComboBox<>(); // flagTitles

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Set text description
    // flagDescription[0] = "The Canadian national flag ..."
    // flagDescription[1] = "Description for China ... "
    // flagDescription[2] = "Description for Denmark ... "
    // flagDescription[3] = "Description for France ... "
    // flagDescription[4] = "Description for Germany ... "
    // flagDescription[5] = "Description for India ... "
    // flagDescription[6] = "Description for Norway ... "
    // flagDescription[7] = "Description for UK ... "
    // flagDescription[8] = "Description for US ... "

    // https://www.javatpoint.com/java-string-format
    for (int i = 0; i < flagDescription.length && i < flagTitles.length; ++i) {
      flagDescription[i] = String.format("The %s national flag ...%nBlah blah blah", flagTitles[i]);
    }

    // Set the first country (Canada) for display
    setDisplay(0);

    // Add combo box and description pane to the border pane
    BorderPane pane = new BorderPane();

    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setLeft(new Label("Select a country: "));
    paneForComboBox.setCenter(comboBoxFlags);
    pane.setTop(paneForComboBox);
    comboBoxFlags.setPrefWidth(400);
    comboBoxFlags.setValue("Canada");

    ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
    comboBoxFlags.getItems().addAll(items); // Add items to combo box
    pane.setCenter(descriptionPane);

    // Lambda Expression:
    // parameter -> expression
    // https://www.w3schools.com/java/java_lambda.asp

    // Display the selected country
    comboBoxFlags.setOnAction(e -> setDisplay(items.indexOf(comboBoxFlags.getValue())));

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 450, 170);
    primaryStage.setTitle("ComboBoxDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /** Set display information on the description pane */
  public void setDisplay(int index) {
    descriptionPane.setTitle(flagTitles[index]);
    descriptionPane.setImageView(flagImages[index]);
    descriptionPane.setDescription(flagDescription[index]);
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for running
   * from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
