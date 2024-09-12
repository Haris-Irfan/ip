package kietwoforone.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import kietwoforone.KieTwoForOne;
import kietwoforone.exceptions.KieTwoForOneException;
import kietwoforone.ui.UI;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private KieTwoForOne kie;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/userImage.png"));
    private Image chatbotImage = new Image(this.getClass().getResourceAsStream("/images/chatbotImage.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getKieDialog("Hello! I'm KieTwoForOne.\n" + "What can I do for you?", chatbotImage)
        );
    }

    /** Injects the KieTwoForOne instance */
    public void setKie(KieTwoForOne k) {
        kie = k;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = kie.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getKieDialog(response, chatbotImage)
        );
        userInput.clear();
    }
}
