/*
 * Author: Dawson Eichhorn <Daw2000@uab.edu>
 * Assignment:  Qr_gui - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.daw2000.qr_gui;

import java.util.Scanner;
import java.util.regex.Pattern;

/** */
public class backendCode {

  private String url;
  private String description;
  private String output;

  public backendCode(String description) {
    this.url = url;
  }

  String getUrl() {
    System.out.println("Enter a valid URL to be stored on the QR code:");

    Scanner scanUrl = new Scanner(System.in);
    output = scanUrl.nextLine();
    //    scanUrl.close();

    return output;
  }

  public boolean isValid() {
    // regular expression test does not like to be fed a null url
    if (output == null) {
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
    var m = p.matcher(output);
    return m.matches();
  }

  @Override
  public String toString() {
    return getQrText();
    //      return "URL <" + output + "> is not valid" +
    //    return isValid() ? output : "URL is not valid!";
  }

  public String getDescription() {
    return description;
  }

  /**
   * Supply QR text for a WAP
   *
   * @return URL: *url*
   */
  public String getQrText() {
    return "URL: " + output;
  }

  public String setDescription(String description) {
    return this.description;
  }

  public String setUrl(String url) {
    return this.url;
  }
}
