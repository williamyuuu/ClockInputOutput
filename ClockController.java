import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import java.time.*;

public class ClockController extends Application {

    private ClockView view;
    private ClockModel model;


    public ClockController(){
        model = new ClockModel();
        view = new ClockView();

        view.setLeftButtonAction(this::changeLeftButtonLabel);
        view.setRightButtonAction(this::changeRightButtonLabel);
    }

    @Override
    public void start(Stage primaryStage){
        ClockController controller = new ClockController();

        Scene scene = new Scene(controller.view.getParent(), 800, 500, Color.TRANSPARENT);
        primaryStage.setTitle("Clock I/O");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void changeLeftButtonLabel(ActionEvent event){
        view.setButtonLabel((Button)event.getSource(), LocalTime.now().toString());
        model.setFile("Norman.txt"); //sets Norman to write in Norman.txt
        model.addTime();
    }
    private void changeRightButtonLabel(ActionEvent event){
        view.setButtonLabel((Button)event.getSource(), LocalTime.now().toString());
        model.setFile("NoName.txt"); //sets NoName to write in NoName.txt
        model.addTime();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
