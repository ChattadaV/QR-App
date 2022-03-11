/*
 * Author: Dawson Eichhorn <Daw2000@uab.edu>
 * Assignment:  Qr_gui - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.daw2000.qr_gui;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import edu.uab.daw2000.qr_gui.backendCode;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.Scanner;

/** */
public class guiBackend {

  private String output;

  /** @param args the command line arguments */
  public static void main(String[] args) throws WriterException, IOException, NotFoundException {

    var test1 = new backendCode("");

    test1.getUrl();

    while (test1.isValid() == false) {
      System.out.println("Invalid URL!");
      test1.getUrl();
    }

    test1.toString(); // check if valid

    displayQRCode(test1);
  }

  public static void displayQRCode(backendCode test1) {
    if (!test1.isValid()) {
      System.out.println("Stored information was not a valid URL.");
      return;
    }

    System.out.println(test1.getQrText());

    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();

    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    // createQR(data, path, charset, hashMap, 200, 200);
    String data = test1.getQrText();
    int width = 200; // pixels
    int height = width; // pixels
    String charset = "UTF-8";
    String path = "target/backendCode.png"; // put into target so does not go to repository

    try {
      Image picture = ImageIO.read(new File("target/backendCode.png"));
    } catch (IOException e) {
      String workingDir = System.getProperty("user.dir");
      System.out.println("Current working directory : " + workingDir);
      e.printStackTrace();
    }

    try {
      BitMatrix matrix =
          new MultiFormatWriter()
              .encode(
                  new String(data.getBytes(charset), charset),
                  BarcodeFormat.QR_CODE,
                  width,
                  height);

      MatrixToImageWriter.writeToFile(
          matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    } catch (Exception e) {
      System.out.println("Image rendering failed");
    }
  }
}
