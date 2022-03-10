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
    url = this.url;
  }

  String getUrl() {

    System.out.println("Enter the URL to be stored on the QR code:");

    Scanner scanUrl = new Scanner(System.in);
    output = scanUrl.nextLine();

    scanUrl.close();

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

  public String toString() {

    return isValid() ? output : null;
  }

  public String getDescription() {
    return description;
  }

  public String setDescription(String description) {
    return this.description;
  }

  public String setUrl(String url) {
    return this.url;
  }
}
