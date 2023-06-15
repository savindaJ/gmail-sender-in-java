package lk.ijse.gmaisender.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HomeFormController {
    public AnchorPane root;
    @FXML
    private TextField txtGmail;
    @FXML
    private ImageView btnNext;

    public void txtGmailKeyTyped(KeyEvent keyEvent) {
        if (!txtGmail.getText().equals("")){
            for (int i = 0; i < txtGmail.getText().length(); i++) {
                char ansible = txtGmail.getText().charAt(i);
                if (ansible == '@'){
                    txtGmail.setStyle("-fx-border-color: green");
                    btnNext.setDisable(false);
                    break;
                }
                else {
                    txtGmail.setStyle("-fx-border-color: red");
                    btnNext.setDisable(true);
                }
            }
        }
    }

    public void btnNextOnAction(MouseEvent event) {
        if (txtGmail.getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"enter valid gmail address !").show();
            return;
        }
        Parent root = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("/view/sender_form.fxml"));
            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mouseEnter(MouseEvent event) {
        if (event.getSource() instanceof javafx.scene.image.ImageView) {
            javafx.scene.image.ImageView icon = (ImageView) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
//            glow.setColor(Color.valueOf("#EF233C"));
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(15);
            glow.setHeight(15);
            glow.setRadius(15);
            icon.setEffect(glow);
        }
    }

    public void mouseExit(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }
    }
}
