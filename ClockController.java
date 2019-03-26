import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class ClockController extends Application {

    //private ClockModel model
    private ClockView view;

    public ClockController(){
        //model = new clockModel();
        view = new ClockView();

        view.setButtonAction(this::changeButtonLabel);
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

    private void changeButtonLabel(ActionEvent event){
        view.setButtonLabel((Button)event.getSource());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
