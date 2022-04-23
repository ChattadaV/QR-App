module edu.uab.wmeeks.qr_gui {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.google.zxing;
  requires com.google.zxing.javase;
  requires java.desktop;
  // requires java.base;

  opens edu.uab.wmeeks.qr_gui to
      javafx.fxml;

  exports edu.uab.wmeeks.qr_gui;
}
