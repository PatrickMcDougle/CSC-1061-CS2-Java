package edu.csc1061.ch31;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ch31JavaFX02 extends Application {

  private static final int INPUT_COLUMN_SIZE = 4;
  private static final NumberFormat NUMBER_FORMATTER = new DecimalFormat("#0.00");

  private TextField textFieldNumber1 = new TextField();
  private TextField textFieldNumber2 = new TextField();
  private TextField textFieldResults = new TextField();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    MenuBar menuBar = createMenuBar();
    Pane paneInputs = createTextInputArea();
    Pane paneButtons = createButtonArea();

    VBox vBox = new VBox(10);
    vBox.getChildren().addAll(menuBar, paneInputs, paneButtons);
    Scene scene = new Scene(vBox, 400, 250);
    primaryStage.setTitle("Menu Demo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  /**
   * This method just creates the button row in our UI.
   *
   * @return an HBox (Pane) that contains all our buttons.
   */
  private HBox createButtonArea() {
    HBox hBox = new HBox(5);

    Button buttonAdd = new Button("Add");
    Button buttonSubtract = new Button("Subtract");
    Button buttonMultiply = new Button("Multiply");
    Button buttonDivide = new Button("Divide");

    hBox.getChildren().addAll(buttonAdd, buttonSubtract, buttonMultiply, buttonDivide);
    hBox.setAlignment(Pos.CENTER);

    // Handle button actions
    buttonAdd.setOnAction(e -> perform('+'));
    buttonSubtract.setOnAction(e -> perform('-'));
    buttonMultiply.setOnAction(e -> perform('*'));
    buttonDivide.setOnAction(e -> perform('/'));

    return hBox;
  }

  /**
   * This method creates the input row in our UI.
   *
   * @return an HBox (Pane) that contains all the inputs and their labels.
   */
  private HBox createTextInputArea() {
    HBox hBox = new HBox(5);

    textFieldNumber1.setPrefColumnCount(INPUT_COLUMN_SIZE);
    textFieldNumber2.setPrefColumnCount(INPUT_COLUMN_SIZE);
    textFieldResults.setPrefColumnCount(INPUT_COLUMN_SIZE);

    Label label1 = new Label("Number 1:");
    Label label2 = new Label("Number 2:");
    Label label3 = new Label("Results:");

    hBox.getChildren().addAll(label1, textFieldNumber1, label2, textFieldNumber2, label3,
        textFieldResults);
    hBox.setAlignment(Pos.CENTER);

    return hBox;
  }

  /**
   * This method creates the MenuBar that is in our UI.
   *
   * @return a MenuBar that contains all our menu items.
   */
  private MenuBar createMenuBar() {
    MenuBar menuBar = new MenuBar();

    Menu menuOperation = new Menu("Operation");
    Menu menuExit = new Menu("Exit");
    menuBar.getMenus().addAll(menuOperation, menuExit);

    MenuItem menuItemAdd = createMenuItem("Add", '+', "Ctrl+A");
    MenuItem menuItemSubtract = createMenuItem("Subtract", '-', "Ctrl+S");
    MenuItem menuItemMultiply = createMenuItem("Multiply", '*', "Ctrl+M");
    MenuItem menuItemDivide = createMenuItem("Divide", '/', "Ctrl+D");
    MenuItem menuItemClose = new MenuItem("Close");

    menuOperation.getItems().addAll(menuItemAdd, menuItemSubtract, menuItemMultiply,
        menuItemDivide);
    menuExit.getItems().add(menuItemClose);

    // Handle menu actions
    menuItemClose.setOnAction(e -> System.exit(0));

    return menuBar;
  }

  private MenuItem createMenuItem(String name, char operator, String keyCombo) {
    MenuItem menuItem = new MenuItem(name);

    // give menu items short cut keys.
    menuItem.setAccelerator(KeyCombination.keyCombination(keyCombo));

    // Handle menu actions
    menuItem.setOnAction(e -> perform(operator));

    return menuItem;
  }

  private void perform(char operator) {
    String message = "OPPs";
    try {
      double number1 = Double.parseDouble(textFieldNumber1.getText());
      double number2 = Double.parseDouble(textFieldNumber2.getText());

      double result = perform(operator, number1, number2);

      message = NUMBER_FORMATTER.format(result);
    } catch (NumberFormatException ex) {
      message = "NAN";
      System.err.println(ex.getMessage());
    } catch (IllegalArgumentException ex) {
      message = "ERR";
      System.err.println(ex.getMessage());
    } catch (Exception ex) {
      // catch all other exceptions.
      System.err.println(ex.getMessage());
    } finally {
      textFieldResults.setText(message);
    }
  }

  private double perform(char operator, double number1, double number2) {
    double result = 0;
    switch (operator) {
      case '+':
        result = number1 + number2;
        break;
      case '-':
        result = number1 - number2;
        break;
      case '*':
        result = number1 * number2;
        break;
      case '/':
        result = number1 / number2;
        break;
      default:
        throw new IllegalArgumentException(
            "Operator value not valid.  Expected [+-*/]  Actual '" + operator + "'");
    }

    return result;
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for running
   * from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
