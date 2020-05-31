package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {

    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save application file");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All types", "*.*")
        );
        List<File> files = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("Chooser was cancelled");
        }
    }

    @FXML
    public void handleLinkClick() {
        String osName = System.getProperty("os.name");
        String urlString = "http://www.javafx.com";

//        try {
//            if (osName.equals("Linux")) {
//                if (Runtime.getRuntime().exec(new String[]{"which", "xdg-open"}).getInputStream().read() != -1) {
//                    Runtime.getRuntime().exec(new String[]{"xdg-open", urlString});
//                }
//            } else {
//                Desktop.getDesktop().browse(new URI(urlString));
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        } catch (URISyntaxException uriSyntaxException) {
//            uriSyntaxException.printStackTrace();
//        }
        WebEngine webEngine = webView.getEngine();
        webEngine.load(urlString);
    }


}