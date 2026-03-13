package com.example.csc325_firebase_webview_auth.view;


import com.example.csc325_firebase_webview_auth.model.FirestoreContext;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Firestore fstore;
    public static FirebaseAuth fauth;
    public static Scene scene;
    private final FirestoreContext contxtFirebase = new FirestoreContext();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent splash = FXMLLoader.load(getClass().getResource("/files/splash.fxml"));
        Scene sScene = new Scene(splash);
        primaryStage.setScene(sScene);
        primaryStage.show();

        fstore = contxtFirebase.firebase();
        fauth = FirebaseAuth.getInstance();

        Parent colors = FXMLLoader.load(getClass().getResource("/files/AccessFBView.fxml"));
        scene = new Scene(colors);
        scene.getStylesheets().add(App.class.getResource("/files/style.css").toExternalForm());

        //primaryStage.setScene(scene);
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml ));
        Parent root = fxmlLoader.load();

        root.getStylesheets().add(App.class.getResource("/files/style.css").toExternalForm());

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
