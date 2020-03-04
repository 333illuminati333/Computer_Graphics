package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250);


        Ellipse ellipse = new Ellipse(200, 125, 15, 45);
        ellipse.setFill(Color.rgb(165, 255, 0));

        Polygon triangle1 = new Polygon(200.0, 125.0,  40.0, 100.0,
                130.0, 30.0);
        Polygon triangle2 = new Polygon(200.0, 125.0,  40.0, 150.0,
                100.0, 220.0);
        Polygon triangle3 = new Polygon(200.0, 125.0,  360.0, 100.0,
                270.0, 30.0);
        Polygon triangle4 = new Polygon(200.0, 125.0,  360.0, 150.0,
                270.0, 220.0);

        triangle1.setFill(Color.rgb(0, 255, 255));
        triangle2.setFill(Color.rgb(0, 255, 255));
        triangle3.setFill(Color.rgb(0, 255, 255));
        triangle4.setFill(Color.rgb(0, 255, 255));

        Line line1 = new Line(195,100, 180, 10);
        Line line2 = new Line(205,100, 220, 10);

        line1.setStrokeWidth(0.8);
        line2.setStrokeWidth(0.8);

        root.getChildren().add(ellipse);
        root.getChildren().add(triangle1);
        root.getChildren().add(triangle2);
        root.getChildren().add(triangle3);
        root.getChildren().add(triangle4);
        root.getChildren().add(line1);
        root.getChildren().add(line2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
