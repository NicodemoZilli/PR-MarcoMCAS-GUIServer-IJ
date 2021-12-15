package gui;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI_SMMCAS extends Application {

    private double xOffset =0;
	private double yOffset =0;	

	@Override
	public void start(final Stage stage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		           loader.setLocation(GUI_SMMCAS.class.getResource("Server.fxml"));

		Parent root = loader.load();

		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset= event.getSceneX();
				yOffset= event.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stage.setX(event.getScreenX()-xOffset);
				stage.setY(event.getScreenY()-yOffset);

			}
		});
		stage.centerOnScreen();
		Scene sc = new Scene(root);
		sc.getStylesheets().add("gui/application.css");
		stage.initStyle(StageStyle.TRANSPARENT);
		sc.setFill(Color.TRANSPARENT);
		stage.setScene(sc);
		stage.show();
	}
	
	public static void main(String [] args) {
		launch(args);
	}
	
	
}