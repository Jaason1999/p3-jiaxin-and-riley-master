import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
 
public class Test extends Application {
	//Making the Sliders for 1
	final Slider users = new Slider(1,100,50);
	final Label value = new Label(Double.toString(users.getValue()));
	
	//Making the Sliders for 2
	final Slider msg = new Slider(1,100,50);
	final Label value2 = new Label(Double.toString(users.getValue()));
	
	//Slider Labels
	final Label userLabel = new Label("Amount of Users:");
	final Label parseMsg = new Label("Amount of Messages:");
 
	@Override
	public void start(Stage stage) {
		// Outline of each area
		VBox shell = new VBox(10);
		VBox label1 = new VBox(10);
		VBox label2 = new VBox(10);
		HBox radio = new HBox(10);
		
		//Setting Scene
		stage.setTitle("Twitter Parser");
		Scene scene = new Scene(shell, 500, 300);
		stage.setScene(scene);
		stage.show();
		
		//Label 1
		users.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    //System.out.println("Value for users: " + Math.round(new_val.doubleValue()));
                    value.setText(String.format("%.0f", new_val));
			}
		});	
		
		//Label 2
		msg.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    //System.out.println("Value for messages: " + Math.round(new_val.doubleValue()));
                    value2.setText(String.format("%.0f", new_val));
			}
		});	
		
		//Radio Buttons for Language
		ToggleGroup language = new ToggleGroup();
		RadioButton english = new RadioButton("English");
		english.setToggleGroup(language);
		english.setSelected(true);
		RadioButton other = new RadioButton("Other");
		other.setToggleGroup(language);
		RadioButton all = new RadioButton("All");
		all.setToggleGroup(language);
		
		//Button for Parse
		Button btParse = new Button("Parse");
		btParse.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				
				//Closing the old Program
				System.out.println("Parse Button Clicked");
				stage.close();
				
				//Getting Value From Slider
				long temp1 = Math.round(users.getValue());
				int userValue = Math.toIntExact(temp1);
				
				//ArrayList<ArrayList<User>> UserId = UserParser.parseUser("iranian_users_csv_hashed.csv");
				
				//Image
				Image default_avatar = new Image("default_avatar.jpg");
				Circle image = new Circle(100,100,50);
				image.setFill(new ImagePattern(default_avatar));
				
				//userFollowers
				Text userFollowers = new Text ();
				userFollowers.setText("Followers Temp");
				
				//Username
				Text username = new Text ();
				username.setText("Username Temp");
				
				//User Id
				Text UserUserid = new Text ();
				UserUserid.setText("UserId Temp");
				
				//User Profile Description
				Text UPD = new Text ();
				UPD.setText("UPD Temp");
				//UPD.setPrefWidth(80);
				
				//User Location
				Text userLocation = new Text ();
				userLocation.setText("User Location Temp");
				
				//Following
				Text userFollowing = new Text ();
				userFollowing.setText("Following Temp");
				
				//Tweets
				Text userTweets = new Text ();
				userTweets.setText("Tweets Temp");
				
				//Button To Cancel
				Button userbtCancel = new Button("Cancel");
				userbtCancel.setOnAction(new EventHandler<ActionEvent>(){
				@Override
					public void handle(ActionEvent e){
						System.out.println("Cancel Button Clicked");
						stage.close();
					}
				});
				userbtCancel.setCancelButton(true);
				
				//Create Stage
				HBox twitterShell = new HBox(10);
				HBox userAll = new HBox(10);
				Pane userPane = new Pane();
				VBox user1 = new VBox(10);
				VBox user2 = new VBox(10);
				user2.setSpacing(26);
				VBox user3 = new VBox(10);
				user3.setSpacing(95);
				VBox userData = new VBox(10);
				
				//Stage for user opens when Parsed
				Stage user = new Stage();
				user.setTitle("Twitter Parser: Users");
				Scene scene = new Scene(twitterShell, 1000, 600);
				stage.setScene(scene);
				stage.show();
				
				//Panes for user
				user1.getChildren().addAll(image,userFollowers,userbtCancel);
				userData.getChildren().addAll(username,UserUserid);
				user2.getChildren().addAll(userData, UPD, userFollowing);
				user3.getChildren().addAll(userLocation, userTweets);
				userAll.getChildren().addAll(user1,user2,user3);
				userPane.getChildren().add(userAll);
				twitterShell.getChildren().addAll(userPane);
			}
		});
		btParse.setDefaultButton(true);
		
		//Button for Cancel
		Button btCancel = new Button("Cancel");
		btCancel.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				System.out.println("Cancel Button Clicked");
				stage.close();
			}
		});
		btCancel.setCancelButton(true);
		
		//Putting the groups together
		label1.getChildren().addAll(userLabel, users, value);
		label2.getChildren().addAll(parseMsg, msg, value2);
		radio.getChildren().addAll(english, other, all);
		shell.getChildren().addAll(label1, label2, radio, btParse, btCancel);
	}
		
	public static void main(String[] args) {
		Application.launch(args);
	}
}