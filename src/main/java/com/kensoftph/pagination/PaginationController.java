package com.kensoftph.pagination;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaginationController implements Initializable {

    @FXML
    private Pagination pagination;
    private File files[];

    @FXML
    void getImages(ActionEvent event) {
        Stage stage = (Stage) pagination.getScene().getWindow();
        openImages(stage);
        pagination.setPageFactory(this::getPages);
    }

    public VBox getPages(int pageIndex){
        ImageView imageView = new ImageView();
        File pngs = files[pageIndex];
        try{
            BufferedImage bi = ImageIO.read(pngs);
            Image image = SwingFXUtils.toFXImage(bi,null);
            imageView.setFitWidth(500);
            imageView.setFitHeight(500);
            imageView.setImage(image);
            imageView.setSmooth(true);
        }catch (IOException e){

        }
        VBox layout = new VBox(imageView);
        return layout;

    }

    private void openImages(Stage parentStage){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select a folder");
        chooser.setInitialDirectory(new File("C:\\"));
        File getFiles = chooser.showDialog(parentStage);
        if(getFiles != null){
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".png");
                }
            };
            files = getFiles.listFiles(filter);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pagination.setPageCount(12);

    }
}