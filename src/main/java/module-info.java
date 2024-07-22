module fr.afpa.javafxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.afpa.javafxml to javafx.fxml;
    exports fr.afpa.javafxml;
}
