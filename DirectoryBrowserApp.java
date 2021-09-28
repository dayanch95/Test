package DirBrowser;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

 public class DirectoryBrowserApp extends Application {
    // private Object String;

    @Override
    public void start(Stage stage) {

        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent(){
        ListView<String> listView = new ListView<>();
        var btn = new Button("Browse...");
        btn.setOnAction(e ->{
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(Paths.get(System.getProperty("user.dir")).toFile());
        var directory = chooser.showDialog(null);
        if (directory != null) {
            var startDir = directory.toPath();
            try{
                listView.getItems().clear();
                Files.walk(startDir)
                        .filter(Files::isDirectory)
                        .forEach(dir -> listView.getItems().add(dir.toString()));
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
          });
        var root = new VBox(btn, listView);
        root.setPrefSize(800, 600);
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
