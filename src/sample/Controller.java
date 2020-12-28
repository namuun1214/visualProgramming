package sample;

import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;

public class Controller {

        @FXML
    private Label cardOne;

    @FXML
    private Label cardTwo;

    @FXML
    private Label cardThree;

    @FXML
    private Label cardFour;

    @FXML
    private Label cardFive;

    @FXML
    private Label cardSix;

    @FXML
    private Label cardSeven;

    @FXML
    private Label cardEight;

    @FXML
    private Label cardNine;

    @FXML
    private Label cardZero;

    @FXML
    private Label space1;

    @FXML
    private Label space2;

    @FXML
    private Label space3;

    @FXML
    private Label space4;

    @FXML
    private Label space5;

    @FXML
    private Label space6;

    @FXML
    private Label space7;

    @FXML
    private Label space8;

    @FXML
    private Label space9;
    @FXML
    private Label space0;

    @FXML
    private HBox containerBox2;

    @FXML
    private HBox containerBox1;

    @FXML
    void close(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
    @FXML
    void reset(ActionEvent event) {
        putRandomNumbers();
        cleanup();
    }
    String style = "-fx-background-color: white; -fx-border-width: 2; -fx-border-style: dotted;-fx-background-radius: 10; -fx-border-color:  #545775";
    private void cleanup() {


        containerBox2.getChildren().forEach(space->{
            space.setStyle(style);
            space.setDisable(false);
//            space.setText("?"); Энд ингэж болохгүй байгаа. Уул нь ингэчихвэл зүгээр
        });
//тэгвэл энэ доор байгаа хэсгийг бичих хэрэггүй болно
        space1.setText(" ");
        space2.setText(" ");
        space3.setText(" ");
        space4.setText(" ");
        space5.setText(" ");
        space6.setText(" ");
        space7.setText(" ");
        space8.setText(" ");
        space9.setText(" ");
        space0.setText(" ");
        String style2 = "-fx-background-color: #718F94;-fx-text-fill:white;-fx-border-radius:10;-fx-border-color: #545775;-fx-background-radius:10";
        containerBox1.getChildren().forEach(card->{
            card.setStyle(style2);
        });
    }

    @FXML
    void submit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //Энд нэг арай гоёоор шалгадаг болох хэрэгтэй
        if(space1.getText().equals("1")
                && space2.getText().equals("2")
                && space3.getText().equals("3")
                && space4.getText().equals("4")
                && space5.getText().equals("5")
                && space6.getText().equals("6")
                && space7.getText().equals("7")
                && space8.getText().equals("8")
                && space9.getText().equals("9")
                && space0.getText().equals("0"))
        {

            alert.setContentText("Баяр хүргэе зөв байна");
            alert.showAndWait();
            reset(event);
        }
        else
        {
            alert.setContentText("Арай л буруу байна даа");
            alert.showAndWait();
        }

    }
    Label lbl = new Label();
    @FXML
    void dragDetect(MouseEvent event) {
        Label source = (Label) event.getSource();
        lbl = source;
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText());
            db.setContent(content);
            event.consume();
    }

    @FXML
    void dragDone(DragEvent event) {
        Label source = (Label) event.getSource();
        if (event.getTransferMode() == TransferMode.MOVE) {
            if(source.getId().contains("space"))
                source.setStyle(style);
            else
                source.setStyle("-fx-background-color:  #BFC8AD;");
            source.setText(" ");
        }
        event.consume();
    }
//    List<String> colors = Arrays.asList("#DAF7A6","#FFC300","#FF5733","#C70039", "#85E8F9", "#F885F9", "#F985C2", "#F98598", "#F9DD85", "#F99C85");
    @FXML
    void dragDropped(DragEvent event) {
        Label target = (Label) event.getSource();
        Dragboard db = event.getDragboard();
        boolean success = false;

        if (db.hasString()) {
            target.setText(db.getString());
            success = true;
        }

        if(target.getId().contains(lbl.getText())){
            //Зөв байрандаа орсон
            target.setDisable(true);
        }
        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    void dragEntered(DragEvent event) {
        Label target = (Label) event.getSource();
        if (event.getDragboard().hasString()) {
            target.setStyle("-fx-border-color: yellow; -fx-border-width: 3; -fx-border-radius: 10 ");
        }
        event.consume();
    }

    @FXML
    void dragExited(DragEvent event) {
        Label target = (Label) event.getSource();

            target.setStyle("-fx-background-color: white; -fx-border-width: 2; -fx-border-style: dotted;-fx-background-radius: 10; -fx-border-color:  #545775; -fx-border-radius: 10");

        event.consume();
    }

    @FXML
    void dragOver(DragEvent event) {
        event.acceptTransferModes(TransferMode.MOVE);
        event.consume();
    }


    @FXML
    void initialize() {
        putRandomNumbers();


    }

    private void putRandomNumbers() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        Collections.shuffle(list);
        //энийг бас ингээд биччихмээр байна. ГЭхдээ setText хийж болохгүй байна
//        for(int i = 0; i < 10; i++){
//            containerBox1.getChildren().get(i).setText(String.valueOf(list.get(0)));
//        }
        cardOne.setText(String.valueOf(list.get(0)));
        cardTwo.setText(String.valueOf(list.get(1)));
        cardThree.setText(String.valueOf(list.get(2)));
        cardFour.setText(String.valueOf(list.get(3)));
        cardFive.setText(String.valueOf(list.get(4)));
        cardSix.setText(String.valueOf(list.get(5)));
        cardSeven.setText(String.valueOf(list.get(6)));
        cardEight.setText(String.valueOf(list.get(7)));
        cardNine.setText(String.valueOf(list.get(8)));
        cardZero.setText(String.valueOf(list.get(9)));

    }
}
