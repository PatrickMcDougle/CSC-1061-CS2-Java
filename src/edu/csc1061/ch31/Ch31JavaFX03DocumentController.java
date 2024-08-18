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
package edu.csc1061.ch31;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Ch31JavaFX03DocumentController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private void handleButtonAction001(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello CSC 1061!");
    }

    @FXML
    private void handleButtonAction002(ActionEvent event) {
        System.out.println("Why?!?!");
        label.setText("I told you not to click me!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
