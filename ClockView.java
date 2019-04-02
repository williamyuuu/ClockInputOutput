import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import javafx.application.*;
import javafx.scene.layout.*;

public class ClockView {

    //MenuBar menuBar;
    //Menu menuFile, menuSettings, menuContact;
    HBox mainBox;
    Button buttonSlot1,buttonSlot2;
    Label labelSlot1, labelSlot2;
    private final int BUTTON_WIDTH = 220, BUTTON_HEIGHT = 220;


    public ClockView(){

        //MenuBar
        /*
        menuFile = new Menu("Files");
        menuSettings = new Menu("Settings");
        menuContact = new Menu("Contact Us");
        menuBar = new MenuBar(menuFile, menuSettings, menuContact);
        */

        buttonSlot1 = new Button();
        buttonSlot1.setPrefSize(BUTTON_WIDTH,BUTTON_HEIGHT);
        labelSlot1 = new Label("button 1");

        buttonSlot2 = new Button();
        buttonSlot2.setPrefSize(BUTTON_WIDTH,BUTTON_HEIGHT);
        labelSlot2 = new Label("button 2");

        //Image settings
        Image image = new Image(getClass().getResourceAsStream("/images/norman.jpg"), 220, 220, false, true);
        buttonSlot1.setGraphic(new ImageView(image));

        VBox slot1 = new VBox(buttonSlot1, labelSlot1);
        slot1.setAlignment(Pos.CENTER);
        slot1.setSpacing(20);
        VBox slot2 = new VBox(buttonSlot2, labelSlot2);
        slot2.setAlignment(Pos.CENTER);
        slot2.setSpacing(20);

        //Main box
        mainBox = new HBox(slot1, slot2);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(120);
        mainBox.setStyle("-fx-background-color: LIGHTGREY"); //CSS for background color

    }

    public Parent getParent(){
        return mainBox;
    }

    public void setLeftButtonAction(EventHandler<ActionEvent> handler){
        buttonSlot1.setOnAction(handler);
    }
    public void setRightButtonAction(EventHandler<ActionEvent> handler){
        buttonSlot2.setOnAction(handler);
    }
    public Button getButton(){
        return buttonSlot1;
    }
    public void setButtonLabel(Button button, String string){
        if(button == buttonSlot1){
            labelSlot1.setText(string);
        }
        else{
            labelSlot2.setText(string);
        }
    }
}
