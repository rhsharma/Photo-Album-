import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PhotoAlbum extends Application
{    
    //**************************************start()**************************************
    public void start(Stage stg)
    {
        ObservableList<String> ol = FXCollections.observableArrayList("San Francisco", "New York", "Fiji Islands", "New Zealand", "Paris", "Dubai");
        ListView<String> lv = new ListView<String> (ol);
        lv.setPrefSize(150,  200);
        
        stg.setTitle("Photo Album");
        FlowPane root = new FlowPane();
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);
        Scene sc = new Scene(root, 500, 250);
        
        Image SF = new Image("SF.png");
        Image Fiji = new Image("Fji.png");
        Image NY = new Image("NY.png");
        Image NZ = new Image("NZ.png");
        Image Paris = new Image("Paris.png");
        Image Dubai = new Image("Dubai.png");
        ImageView iv = new ImageView(SF);
        
        MultipleSelectionModel<String> msm = lv.getSelectionModel();
        msm.selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> changed, String oldValue, String newVal)
            {
                System.out.println(newVal);
                switch(newVal)
                {
                    case "San Francisco": iv.setImage(SF); break;
                    case "New York": iv.setImage(NY); break;
                    case "Fiji Islands": iv.setImage(Fiji); break;
                    case "New Zealand": iv.setImage(NZ); break;
                    case "Paris": iv.setImage(Paris); break;
                    case "Dubai": iv.setImage(Dubai); break;
                }
            }
        });
        
        root.getChildren().addAll(lv, iv);
        stg.setScene(sc);
        stg.show();
    }
    
    //**************************************main()**************************************
    public static void main(String[] args)
    {
        launch(args);
    }
}
