module com.kensoftph.pagination {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.kensoftph.pagination to javafx.fxml;
    exports com.kensoftph.pagination;
}