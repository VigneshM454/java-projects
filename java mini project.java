package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.ImageInput;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.stage.Modality;
//import java.time.LocalDate;
public class fxassign extends Application{
	public void start(final Stage p){
		GridPane root=new GridPane();
		DatePicker d=new DatePicker();
		Text l=new Text("   Login form");
		l.setFont(Font.font("serif",FontWeight.BOLD,40));
		l.setFill(Color.RED);
		l.setStrokeWidth(2);
		l.setStroke(Color.BROWN);
		
		Label fn=new Label("First Name:");
		TextField tff=new TextField();
		Label ln=new Label("Last Name:");
		TextField tfl=new TextField();
		Label dob =new Label("Date of Birth:");
		Text t1=new Text("Email:");
		TextField tf1=new TextField();
		Label l1=new Label("Password:");
		TextField tf2=new PasswordField();
		Label l2=new Label("ConfirmPassword:");
		TextField tf3=new PasswordField();
		Button sub=new Button("Login");
		Button clear=new Button("clear");
		Alert a=new Alert(AlertType.NONE);
		
		sub.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String name=tf1.getText();
				String str=tf2.getText();
				String str1= tf3.getText();
				String str2=tff.getText();
				String date=d.getPromptText();
				if(str.isEmpty()||name.isEmpty()||str2.isEmpty()) {
					a.setAlertType(AlertType.WARNING);
					a.setContentText("please enter necessary details");
					a.show();
				}
				else if(str.equals(str1)) {
					a.setAlertType(AlertType.CONFIRMATION);
					a.setContentText("welcome"+name);
					a.show();
				//	root.addRow(3,l1,tf2);
					Label lab=new Label("Im a label on new window");
					Image i=new Image("https://www.bing.com/th/id/OGC.696a0870efa6da28576dd6d95678772e?pid=1.7&rurl=https%3a%2f%2fvignette.wikia.nocookie.net%2fharuhi-suzumiya%2fimages%2fe%2fe7%2fWelcome!_gif_azul.gif%2frevision%2flatest%3fcb%3d20160409204014%26path-prefix%3des&ehk=mT6EQ0u9MWZILsDjI32WHsUvvStQedORbqjX%2bWMaR7o%3d");
					Rectangle rect=new Rectangle();
					ImageInput ip=new ImageInput();
					ip.setX(100);
					ip.setY(150);
					ip.setSource(i);
					rect.setEffect(ip);
					Button out=new Button("Logout");
					out.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent o){
							Platform.exit();
						}
					});

					BorderPane lot=new BorderPane();
					lot.setTop(rect);
					lot.setBottom(out);
					//css styling
					lot.setStyle("-fx-background-color: BEIGE; ");
					out.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-border-color:red ; -fx-border-width: 2px; -fx-font-weight: bold");

					Scene sscene=new Scene(lot,300,450);
					Stage newwin=new Stage();
					newwin.setTitle("Second stage");
					newwin.setScene(sscene);
					newwin.setX(p.getX()+200);
					newwin.setY(p.getY()+100);
					newwin.show();
				}
				else {
					tf2.clear();
					tf3.clear();
					a.setAlertType(AlertType.ERROR);
					a.setContentText("password mismatch");
					a.show();
				}
			}
		});

		clear.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tf1.clear();
				tf2.clear();
			}
		});
		
		root.setHgap(5);
		root.setVgap(5);
		root.addRow(0,l);
		root.addRow(1,fn,tff);
		root.addRow(2,ln,tfl);
		root.addRow(3,dob,d);
		root.addRow(4, t1,tf1);
		root.addRow(5,l1,tf2);
		root.addRow(6,l2,tf3);
		root.addRow(7,clear,sub);
		//css styling
		root.setStyle("-fx-background-color: BEIGE; ");
		sub.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-border-color: red; -fx-border-width: 2px; -fx-font-weight: bold");
		clear.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-border-color:blue ; -fx-border-width: 2px; -fx-font-weight: bold");
		fn.setStyle("-fx-font:normal bold 20px 'serif' ");
		ln.setStyle("-fx-font:normal bold 20px 'serif' ");
		dob.setStyle("-fx-font:normal bold 20px 'serif' ");
		l1.setStyle("-fx-font:normal bold 20px 'serif' ");
		l2.setStyle("-fx-font:normal bold 20px 'serif' ");
		fn.setStyle("-fx-font:normal bold 20px 'serif' ");
		t1.setStyle("-fx-font:normal bold 20px 'serif' ");
		
		Scene scene =new Scene(root,300,400);
		p.setScene(scene);
		p.setTitle("Login");
		p.show();
	}
		public static void main(String[] args)
		{
			launch(args);
		}
	}