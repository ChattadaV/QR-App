/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package edu.uab.wmeeks.qr_gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Cade Meeks <wmeeks@uab.edu>
 */
public class QR_menuController implements Initializable {

  private String url;
  private String description;
  private String output;

  @FXML private TextField urlField;

  @FXML private Button generateButton;
  @FXML private Button galleryButton;
  @FXML private Button helpButton;


  /** Initializes the controller class. */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO

  }



  public boolean isValid() {
    // regular expression test does not like to be fed a null url
		url = urlField.getText();
    if (url == null) {
      return false;
    }

    /*
        * Regular Expression Test is from
    https://www.geeksforgeeks.org/check-if-an-url-is-valid-or-not-using-regular-expression/
        */
    var p =
        Pattern.compile(
            "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)");
    var m = p.matcher(url);
    return m.matches();
  }

  public void generate() throws Exception {


    if (isValid() == false) {
      App.setRoot("QR_error");
    } else App.setRoot("QR_successful");

		url = urlField.getText();
		displayQRCode(url);

  }


  /** @param args the command line arguments */
  //  public static void main(String[] args) throws WriterException, IOException, NotFoundException
  // {


  public static void displayQRCode(String item) {

    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();

    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    // createQR(data, path, charset, hashMap, 200, 200);
    int width = 200; // pixels
    int height = width; // pixels
    String charset = "UTF-8";
    String path = "Qr_GUI.png"; // put inside Qr_GUI // put into target so does not go to repository

    try {
      java.awt.Image picture = javax.imageio.ImageIO.read(new File("Qr_GUI.png")); // put into Qr_GUI
    } catch (IOException e) {
      String workingDir = System.getProperty("user.dir");
      System.out.println("Current working directory : " + workingDir);
      e.printStackTrace();
    }

    try {
      BitMatrix matrix =
          new MultiFormatWriter()
              .encode(
                  new String(item.getBytes(charset), charset),
                  BarcodeFormat.QR_CODE,
                  width,
                  height);

      MatrixToImageWriter.writeToFile(
          matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    } catch (Exception e) {
      System.out.println("Image rendering failed");
    }
  }

  public void help() throws Exception {

    App.setRoot("QR_help");
  }

  public void gallery() throws Exception {

    App.setRoot("QR_gallery");
  }
}


