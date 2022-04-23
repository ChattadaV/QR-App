/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package edu.uab.wmeeks.qr_gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Cade Meeks <wmeeks@uab.edu>
 */
public class QR_helpController /*implements Initializable*/ {

  //  /** Initializes the controller class. */
  //  @Override
  //  public void initialize(URL url, ResourceBundle rb) {
  //    // TODO
  //  }

  //  @FXML
  //  private void switchToHelp() throws IOException {
  //    App.setRoot("QR_help");
  //  }

  @FXML
  private void switchToMenu() throws IOException {
    App.setRoot("QR_menu");
  }
}
