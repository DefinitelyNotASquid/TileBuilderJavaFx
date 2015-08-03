package tb;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * Created by Someonepic on 07/31/2015.
 */
public class SaveDialog {

    public static void Display(final Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        System.out.println(file);
    }
}
