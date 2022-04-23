/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package edu.uab.wmeeks.qr_gui;

// import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
// import java.util.HashMap;
// import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
// import javafx.scene.image.Image;
// import javafx.scene.input.Clipboard;
// import javafx.scene.input.ClipboardContent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
// import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cade Meeks <wmeeks@uab.edu>
 */
public class QR_successfulController implements Initializable {

  private String url;
  @FXML private TextField urlField;
  @FXML private ImageView imageView;

  /** Initializes the controller class. */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

  @FXML
  private void clipboard() throws IOException {
    //        final Clipboard clipboard = Clipboard.getSystemClipboard();
    //        final ClipboardContent content = new ClipboardContent();
    //
    //        content.putString(s);
    //        clipboard.setContent(content);
  }

  @FXML
  private void loadTheImage() throws FileNotFoundException {
    imageView.setImage(new Image(new FileInputStream("Qr_GUI.png")));
  }

  @FXML
  private void switchToGallery() throws IOException {
    App.setRoot("QR_gallery");
  }

  @FXML
  private void switchToHelp() throws IOException {
    App.setRoot("QR_help");
  }

  @FXML
  private void switchToMenu() throws IOException {
    App.setRoot("QR_menu");
  }
}