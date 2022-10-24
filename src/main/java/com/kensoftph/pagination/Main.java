package com.kensoftph.pagination;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // using the Scene Builder
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pagination.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Understanding the Pagination");
        stage.show();

        // Without using the Scene Builder
        /*Pagination pagination = new Pagination(10);
        pagination.setPageFactory(this::getPage);
        pagination.setMaxPageIndicatorCount(5);
        StackPane layout = new StackPane(pagination);
        Scene scene = new Scene(layout, 500, 500);
        stage.setTitle("Understanding the Pagination");
        stage.setScene(scene);
        stage.show();*/
    }

    /*private Label getPage(int pageIndex){
        Label content = new Label("This is the content for page "+(pageIndex + 1));
        return content;
    }*/

    public static void main(String[] args) {
        launch();
    }
}