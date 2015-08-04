package tb;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * Created by Someonepic on 07/31/2015.
 */
public class fileDialog {

    public static void Displayopen(final Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        System.out.println(file);
    }
    public static void Displaysave(final Stage primaryStage) {
        FileChooser choose = new FileChooser();
        choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File f = choose.showSaveDialog(primaryStage);
        if(!f.getName().contains(".")) {
            f = new File(f.getAbsolutePath() + ".txt");
        }
    }
}
