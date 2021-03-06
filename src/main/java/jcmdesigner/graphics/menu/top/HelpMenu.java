package jcmdesigner.graphics.menu.top;

import jcmdesigner.graphics.gui.CustomStage;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import jcmdesigner.program.App;

public class HelpMenu extends Menu
{
	private static final MenuItem	instructions	= new MenuItem("How To Use");
	private static final MenuItem	about			= new MenuItem("About");

	public HelpMenu(MenuBar top_menu, String text)
	{
		super(text);
		HelpMenu.instructions.setOnAction(event ->
		{
		});
		this.getItems().add(instructions);
		
		HelpMenu.about.setOnAction(event ->
		{
			VBox main_comp = new VBox();
			main_comp.setId("pane");
			main_comp.setAlignment(Pos.TOP_CENTER);
			
			Label[] headers = new Label[5];
			headers[0] = new Label("About");
			headers[1] = new Label("Full Name");
			headers[2] = new Label("Use");
			headers[3] = new Label("GitHub Project");
			headers[4] = new Label("Developer");
			for (int i = 0; i < headers.length; i++)
				headers[i].setUnderline(true);
			
			main_comp.getChildren().add(headers[0]);
			main_comp.getChildren().add(headers[1]);
			main_comp.getChildren().add(new Label("Java Fuzzy Cognitive Maps Design Application"));			
			main_comp.getChildren().add(headers[2]);
			main_comp.getChildren().add(new Label("It is an app to construct fuzzy cognitive maps"));
			main_comp.getChildren().add(new Label("You can add concepts and relate each other providing weights,"));
			main_comp.getChildren().add(new Label("either as numeric values or fuzzy values"));
			main_comp.getChildren().add(headers[3]);
			Hyperlink git_hub = new Hyperlink("https://github.com/ziqushru/JFCM-Design-App");
		    git_hub.setOnAction(event2 -> App.host_services.showDocument(git_hub.getText().toString()));
			main_comp.getChildren().add(git_hub);
			main_comp.getChildren().add(headers[4]);
			main_comp.getChildren().add(new Label("Jason Koutoulias"));
			
			new CustomStage("About", 670, 695, main_comp, "/stylesheets/pop_up.css");
		});
		this.getItems().add(about);
		top_menu.getMenus().add(this);
	}
}
