/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojfx;

import com.uisrael.jfx.controller.EspecialidadController;
import com.uisrael.modelo.Dao.EspecialidadDao;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PC
 */
public class ProyectoJFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        URL location = getClass().getResource("/com/uisrael/jfx/view/CrudMedicos.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        
       //Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Parent root = (Parent) fxmlLoader.load(location.openStream());
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
           EspecialidadController espe = new EspecialidadController();
        System.out.println(espe.getListEspecialidad().toString());
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
