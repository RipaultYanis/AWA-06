/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa;


import fr.entities.EvaluationConvive;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author root
 */
public class awajaba extends Application {
    
    public TextArea TACom= new TextArea();
    
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);

        Label Evaluer = new Label("Evaluer votre Convive :");
        Label Commentaire = new Label("Commentaire : ");
        Label Note= new Label("Note :");
        
        Spinner spinnerNote= new Spinner();

        SpinnerValueFactory.IntegerSpinnerValueFactory valeurNote = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,2);
        spinnerNote.setValueFactory(valeurNote);
        
        CheckBox checkBoxBloquer =new CheckBox("Voulez-vous bloqué le Convive ?");

        Button Valider = new Button("Valider");
        Button Annuler = new Button("Annuler");
        Annuler.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                TACom.setText("");
                valeurNote.setValue(2);
                checkBoxBloquer.setSelected(false);
            }
        });
        Valider.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                EvaluationConvive leConvive= new EvaluationConvive(valeurNote.getValue(),TACom.getText(),checkBoxBloquer.isSelected());
                Alert dlgNok = new Alert (Alert.AlertType.INFORMATION);
                dlgNok.setTitle("Comfirmation");
                dlgNok.setHeaderText("Vous avez bien evalué votre repas");
                dlgNok.setContentText("Note : "+leConvive.getNote()+" Commentaire : "+leConvive.getCommentaire()+" Bloqué : "+leConvive.isBloquer());
                dlgNok.showAndWait();
            }
                
               
        });
       
 
        
        root.add(Evaluer, 0, 0,2,1);
        GridPane.setHalignment(Commentaire, HPos.LEFT);
        root.add(Commentaire, 0, 1);
        root.add(TACom, 0,2,6,1);

        root.add(Note, 0,3);
        root.add(spinnerNote,1,3);
        root.add(checkBoxBloquer,0,4,3,1);
        GridPane.setHalignment(Valider, HPos.RIGHT);
        root.add(Valider, 4, 5);
        GridPane.setHalignment(Annuler, HPos.LEFT);
        root.add(Annuler, 0, 5);
        
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("AWA_04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
}
