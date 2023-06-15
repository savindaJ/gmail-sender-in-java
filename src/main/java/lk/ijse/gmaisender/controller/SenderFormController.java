package lk.ijse.gmaisender.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SenderFormController {
    @FXML
    private Hyperlink hypGmail;
    @FXML
    private TextArea ariaMessage;
    @FXML
    private TextField txtGmail;
    @FXML
    private ImageView btnSend;

    public void mouseExit(MouseEvent event) {
    }

    public void mouseEnter(MouseEvent event) {
    }

    public void btnSendOnAction(MouseEvent event) {

    }
}
