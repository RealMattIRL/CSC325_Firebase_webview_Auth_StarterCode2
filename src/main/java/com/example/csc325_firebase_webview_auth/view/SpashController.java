package com.example.csc325_firebase_webview_auth.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpashController {

    @FXML
    private ProgressIndicator spinner;

    @FXML
    private void handleContinue(ActionEvent event) {
        try {
            // Load main scene
            Parent main = FXMLLoader.load(getClass().getResource("/files/AccessFBView.fxml"));
            Scene colorScreen = new Scene(main);
            colorScreen.getStylesheets().add(getClass().getResource("/files/style.css").toExternalForm());

            // Get the current stage from any node in the scene
            Stage stage = (Stage) spinner.getScene().getWindow();
            stage.setScene(colorScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
