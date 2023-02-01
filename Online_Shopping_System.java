package application;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Online_Shopping_System extends Application {
	static String CurrentUserID, CurrentUserInfoTogether;
	
    Stage window;
    Scene MainMenuScene;
    Scene ActorLogOnScene;
    Scene CustomerLogOnScene, SupplierLogOnScene;
    Scene ActorCreateAccountScene;
    Scene CustomerCreateAccountScene, SupplierCreateAccountScene;
    Scene CustomerAccountTypeScene;
    Scene LogOffScene;
    Scene catalogScene, breakfastScene, sportScene, addToCartScene, checkoutScene, orderPlacedScene, orders, shipOrderScene, invoiceScene, mainMScene, stockScene;
    
    private TextField CustomerLogOnUserIDTextField;
    private TextField CustomerLogOnUserPasswordTextField;
    private Label CustomerLogOnUserInfoVerification;
    private TextField SupplierLogOnUserIDTextField;
    private TextField SupplierLogOnUserPasswordTextField;
    private Label SupplierLogOnUserInfoVerification;
    
    private TextField CustomerCreateAccountUserIDTextField;
    private TextField CustomerCreateAccountUserPasswordTextField;
    private TextField CustomerCreateAccountUserNameTextField;
    private TextField CustomerCreateAccountUserAddressTextField;
    private TextField CustomerCreateAccountUserPhoneNumberTextField;
    private TextField CustomerCreateAccountUserCreditCardNumberTextField;
    private Label CustomerCreateAccountUserInfoVerification;
    private TextField SupplierCreateAccountUserIDTextField;
    private TextField SupplierCreateAccountUserPasswordTextField;
    private Label SupplierCreateAccountUserInfoVerification;
    
    //new
    
    Scene processOrderScene;
    Scene orderProcessedScene;

	public static void main(String[] args) {
    	launch(args);
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
//-----------------------------------------------------------------------------------------------------------------------------
		Label MainMenu_Label = new Label ("Log On or Create Account");
		Button MainMenu_LogOnButton = new Button ("Log On");
		MainMenu_LogOnButton.setOnAction(e -> window.setScene(ActorLogOnScene));
		Button MainMenu_CreateAccountButton = new Button ("Create Account");
		MainMenu_CreateAccountButton.setOnAction(e -> window.setScene(ActorCreateAccountScene));
		VBox layoutMainMenu = new VBox (20);
		layoutMainMenu.setPadding(new Insets(10));
		layoutMainMenu.getChildren().addAll(MainMenu_Label, MainMenu_LogOnButton, MainMenu_CreateAccountButton);
		MainMenuScene = new Scene (layoutMainMenu, 300, 200);
//-----------------------------------------------------------------------------------------------------------------------------
				Label ActorLogOn_Label = new Label ("Log On -> Actor");
				Button Customer_LogOnButton = new Button ("Customer");
				Customer_LogOnButton.setOnAction(e -> window.setScene(CustomerLogOnScene));
				Button Supplier_LogOnButton = new Button ("Supplier");
				Supplier_LogOnButton.setOnAction(e -> window.setScene(SupplierLogOnScene));
				VBox layoutLogOnActor = new VBox (20);
				layoutLogOnActor.setPadding(new Insets(10));
				layoutLogOnActor.getChildren().addAll(ActorLogOn_Label, Customer_LogOnButton, Supplier_LogOnButton);
				ActorLogOnScene = new Scene (layoutLogOnActor, 300, 200);
//-----------------------------------------------------------------------------------------------------------------------------
						Label CustomerLogOn_Label = new Label ("Log On -> Customer");
						Button CustomerLogOnCheckButton = new Button ("Log On");
						CustomerLogOnCheckButton.setOnAction(new CustomerLogOnCheckButtonHandler());
						Label CustomerLogOnUserIDLabel = new Label("ID:");
						CustomerLogOnUserIDTextField = new TextField();
						Label CustomerLogOnUserPasswordLabel = new Label("Password:");
						CustomerLogOnUserPasswordTextField = new TextField();
						CustomerLogOnUserInfoVerification = new Label();
						HBox hbox1_layoutLogOnCustomer = new HBox (20, CustomerLogOn_Label);
						HBox hbox2_layoutLogOnCustomer = new HBox (20, CustomerLogOnUserIDLabel, CustomerLogOnUserIDTextField);
						HBox hbox3_layoutLogOnCustomer = new HBox (20, CustomerLogOnUserPasswordLabel, CustomerLogOnUserPasswordTextField);
						HBox hbox4_layoutLogOnCustomer = new HBox (20, CustomerLogOnCheckButton);
						HBox hbox5_layoutLogOnCustomer = new HBox (20, CustomerLogOnUserInfoVerification);
						VBox layoutLogOnCustomer = new VBox (20);
						layoutLogOnCustomer.setPadding(new Insets(10));
						layoutLogOnCustomer.getChildren().addAll(hbox1_layoutLogOnCustomer, hbox2_layoutLogOnCustomer, hbox3_layoutLogOnCustomer, hbox4_layoutLogOnCustomer, hbox5_layoutLogOnCustomer);
						CustomerLogOnScene = new Scene (layoutLogOnCustomer, 300, 300);
//-----------------------------------------------------------------------------------------------------------------------------
						Label SupplierLogOn_Label = new Label ("Log On -> Supplier");
						Button SupplierLogOnCheckButton = new Button ("Log On");
						SupplierLogOnCheckButton.setOnAction(new SupplierLogOnCheckButtonHandler());
						Label SupplierLogOnUserIDLabel = new Label("ID:");
						SupplierLogOnUserIDTextField = new TextField();
						Label SupplierLogOnUserPasswordLabel = new Label("Password:");
						SupplierLogOnUserPasswordTextField = new TextField();
						SupplierLogOnUserInfoVerification = new Label();
						HBox hbox1_layoutLogOnSupplier = new HBox (20, SupplierLogOn_Label);
						HBox hbox2_layoutLogOnSupplier = new HBox (20, SupplierLogOnUserIDLabel, SupplierLogOnUserIDTextField);
						HBox hbox3_layoutLogOnSupplier = new HBox (20, SupplierLogOnUserPasswordLabel, SupplierLogOnUserPasswordTextField);
						HBox hbox4_layoutLogOnSupplier = new HBox (20, SupplierLogOnCheckButton);
						HBox hbox5_layoutLogOnSupplier = new HBox (20, SupplierLogOnUserInfoVerification);
						VBox layoutLogOnSupplier = new VBox (20);
						layoutLogOnSupplier.setPadding(new Insets(10));
						layoutLogOnSupplier.getChildren().addAll(hbox1_layoutLogOnSupplier, hbox2_layoutLogOnSupplier, hbox3_layoutLogOnSupplier, hbox4_layoutLogOnSupplier, hbox5_layoutLogOnSupplier);
						SupplierLogOnScene = new Scene (layoutLogOnSupplier, 300, 300);
//-----------------------------------------------------------------------------------------------------------------------------
				Label ActorCreateAccount_Label = new Label ("Create Account -> Actor");
				Button Customer_CreateAccountButton = new Button ("Customer");
				Customer_CreateAccountButton.setOnAction(e -> window.setScene(CustomerCreateAccountScene));
				Button Supplier_CreateAccountButton = new Button ("Supplier");
				Supplier_CreateAccountButton.setOnAction(e -> window.setScene(SupplierCreateAccountScene));
				VBox layoutCreateAccountActor = new VBox (20);
				layoutCreateAccountActor.setPadding(new Insets(10));
				layoutCreateAccountActor.getChildren().addAll(ActorCreateAccount_Label, Customer_CreateAccountButton, Supplier_CreateAccountButton);
				ActorCreateAccountScene = new Scene (layoutCreateAccountActor, 300, 200);
//-----------------------------------------------------------------------------------------------------------------------------
						Label CustomerCreateAccount_Label = new Label ("Create Account -> Customer");
						Button CustomerCreateAccountCheckButton = new Button ("Create Account");
						CustomerCreateAccountCheckButton.setOnAction(new CustomerCreateAccountCheckButtonHandler());
						Label CustomerCreateAccountUserIDLabel = new Label("ID:");
						CustomerCreateAccountUserIDTextField = new TextField();
						Label CustomerCreateAccountUserPasswordLabel = new Label("Password:");
						CustomerCreateAccountUserPasswordTextField = new TextField();
						Label CustomerCreateAccountUserNameLabel = new Label("Name:");
						CustomerCreateAccountUserNameTextField = new TextField();
						Label CustomerCreateAccountUserAddressLabel = new Label("Address:");
						CustomerCreateAccountUserAddressTextField = new TextField();
						Label CustomerCreateAccountUserPhoneNumberLabel = new Label("Phone Number:");
						CustomerCreateAccountUserPhoneNumberTextField = new TextField();
						Label CustomerCreateAccountUserCreditCardNumberLabel = new Label("Credit Card Number:");
						CustomerCreateAccountUserCreditCardNumberTextField = new TextField();
						CustomerCreateAccountUserInfoVerification = new Label();
						HBox hbox1_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccount_Label);
						HBox hbox2_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountUserIDLabel, CustomerCreateAccountUserIDTextField);
						HBox hbox3_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountUserPasswordLabel, CustomerCreateAccountUserPasswordTextField);
						HBox hbox4_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountUserNameLabel, CustomerCreateAccountUserNameTextField);
						HBox hbox5_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountUserAddressLabel, CustomerCreateAccountUserAddressTextField);
						HBox hbox6_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountUserPhoneNumberLabel, CustomerCreateAccountUserPhoneNumberTextField);
						HBox hbox7_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountUserCreditCardNumberLabel, CustomerCreateAccountUserCreditCardNumberTextField);
						HBox hbox8_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountCheckButton);
						HBox hbox9_layoutCreateAccountCustomer = new HBox (20, CustomerCreateAccountUserInfoVerification);
						VBox layoutCreateAccountCustomer = new VBox (20);
						layoutCreateAccountCustomer.setPadding(new Insets(10));
						layoutCreateAccountCustomer.getChildren().addAll(hbox1_layoutCreateAccountCustomer, hbox2_layoutCreateAccountCustomer, hbox3_layoutCreateAccountCustomer, hbox4_layoutCreateAccountCustomer, hbox5_layoutCreateAccountCustomer, hbox6_layoutCreateAccountCustomer, hbox7_layoutCreateAccountCustomer, hbox8_layoutCreateAccountCustomer, hbox9_layoutCreateAccountCustomer);
						CustomerCreateAccountScene = new Scene (layoutCreateAccountCustomer, 300, 400);
//-----------------------------------------------------------------------------------------------------------------------------
								Label CustomerAccountType_Label = new Label ("Create Account -> Customer -> Account Type");
								Label CustomerAccountType_Label1= new Label ("Premium Membership Fee -> $40/year");
								Label CustomerAccountType_Label2= new Label ("Membership Fee Will Be Included In The First Purchase You Make On This Account");
								Button CustomerPremiumAccountTypeButton = new Button ("Premium");
								CustomerPremiumAccountTypeButton.setOnAction(new CustomerAccountTypeHandler1());
								Label CustomerAccountType_Label3 = new Label ("Regular Membership Fee -> Free");
								Button CustomerRegularAccountTypeButton = new Button ("Regular");
								CustomerRegularAccountTypeButton.setOnAction(new CustomerAccountTypeHandler2());
								HBox hbox1_layoutAccountTypeCustomer = new HBox (20, CustomerAccountType_Label);
								HBox hbox2_layoutAccountTypeCustomer = new HBox (20, CustomerAccountType_Label1);
								HBox hbox3_layoutAccountTypeCustomer = new HBox (20, CustomerAccountType_Label2);
								HBox hbox4_layoutAccountTypeCustomer = new HBox (20, CustomerPremiumAccountTypeButton);
								HBox hbox5_layoutAccountTypeCustomer = new HBox (20, CustomerAccountType_Label3);
								HBox hbox6_layoutAccountTypeCustomer = new HBox (20, CustomerRegularAccountTypeButton);
								VBox layoutAccountTypeCustomer = new VBox (20);
								layoutAccountTypeCustomer.setPadding(new Insets(10));
								layoutAccountTypeCustomer.getChildren().addAll(hbox1_layoutAccountTypeCustomer, hbox2_layoutAccountTypeCustomer, hbox3_layoutAccountTypeCustomer, hbox4_layoutAccountTypeCustomer, hbox5_layoutAccountTypeCustomer, hbox6_layoutAccountTypeCustomer);
								CustomerAccountTypeScene = new Scene (layoutAccountTypeCustomer, 500, 400);
//----------------------------------------------------------------------------------------------------------------------------
						Label SupplierCreateAccount_Label = new Label ("Create Account -> Supplier");
						Button SupplierCreateAccountCheckButton = new Button ("Create Account");
						SupplierCreateAccountCheckButton.setOnAction(new SupplierCreateAccountCheckButtonHandler());
						Label SupplierCreateAccountUserIDLabel = new Label("ID:");
						SupplierCreateAccountUserIDTextField = new TextField();
						Label SupplierCreateAccountUserPasswordLabel = new Label("Password:");
						SupplierCreateAccountUserPasswordTextField = new TextField();
						SupplierCreateAccountUserInfoVerification = new Label();
						HBox hbox1_layoutCreateAccountSupplier = new HBox (20, SupplierCreateAccount_Label);
						HBox hbox2_layoutCreateAccountSupplier = new HBox (20, SupplierCreateAccountUserIDLabel, SupplierCreateAccountUserIDTextField);
						HBox hbox3_layoutCreateAccountSupplier = new HBox (20, SupplierCreateAccountUserPasswordLabel, SupplierCreateAccountUserPasswordTextField);
						HBox hbox4_layoutCreateAccountSupplier = new HBox (20, SupplierCreateAccountCheckButton);
						HBox hbox5_layoutCreateAccountSupplier = new HBox (20, SupplierCreateAccountUserInfoVerification);
						VBox layoutCreateAccountSupplier = new VBox (20);
						layoutCreateAccountSupplier.setPadding(new Insets(10));
						layoutCreateAccountSupplier.getChildren().addAll(hbox1_layoutCreateAccountSupplier, hbox2_layoutCreateAccountSupplier, hbox3_layoutCreateAccountSupplier, hbox4_layoutCreateAccountSupplier, hbox5_layoutCreateAccountSupplier);
						SupplierCreateAccountScene = new Scene (layoutCreateAccountSupplier, 300, 300);
//-----------------------------------------------------------------------------------------------------------------------------	
				Label LogOff = new Label ("Successfully Logged Off");
				VBox layoutLogOff = new VBox (20);
				layoutLogOff.setPadding(new Insets(10));
				layoutLogOff.getChildren().addAll(LogOff);
				LogOffScene = new Scene (layoutLogOff, 300, 100);
//-----------------------------------------------------------------------------------------------------------------------------	
						Label catalog = new Label("Select a Catalog");
						Button LogOffButton = new Button ("Log Off");
						LogOffButton.setOnAction(new LogOffButtonHandler());
						catalog.setFont(new Font("Arial", 30));
						Button breakfastButton = new Button("Breakfast Catalog");
						breakfastButton.setLayoutX(100);
						
						breakfastButton.setOnAction(e -> primaryStage.setScene(breakfastScene));
						HBox hbox1_layoutAshish = new HBox (310, catalog, LogOffButton);
						VBox catalogLayout = new VBox(20);
						catalogLayout.getChildren().addAll(hbox1_layoutAshish, breakfastButton);
						catalogScene = new Scene(catalogLayout, 600, 300);						
//-----------------------------------------------------------------------------------------------------------------------------		
							Button LogOffButton2 = new Button ("Log Off");
							LogOffButton2.setOnAction(new LogOffButtonHandler());
				
							CheckStock c = new CheckStock();
							int z = c.stock("Cereal");
							int d = c.stock("Oatmeal");
							int s = c.stock("Yogurt");
							ChoiceBox<Integer> cerealQ = new ChoiceBox<>();
							for(int e = 0; e <= z; e++) {
								cerealQ.getItems().add(e);
								cerealQ.setValue(0);
							}
							ChoiceBox<Integer> oatmealQ = new ChoiceBox<>();
							for(int e = 0; e <= d; e++) {
								oatmealQ.getItems().add(e);
								oatmealQ.setValue(0);
							}
							ChoiceBox<Integer> yogurtQ = new ChoiceBox<>();
							for(int e = 0; e <= s; e++) {
								yogurtQ.getItems().add(e);
								yogurtQ.setValue(0);
							}
							Label breakfastLabel = new Label("Breakfast Catalog");
							Label breakfastNames = new Label("Name              Quantity            Regular Price            Premium Price ");
							Label cerealLabel = new Label("Cereal        ");
							Label oatmealLabel = new Label("Oatmeal       ");
							Label yogurtLabel = new Label("Yogurt        ");
							Label cerealPrice = new Label("        $4.99                           $2.99");
							Label oatmealPrice = new Label("           $3.99                           $1.99");
							Label yogurtPrice = new Label("         $1.99                           $0.99");
							breakfastLabel.setFont(new Font("Arial", 30));
							breakfastNames.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
							Button addToCartButton = new Button("Add to Cart");
							addToCartButton.setOnAction(e -> choiceBoxSelectionCereal(cerealQ, oatmealQ, yogurtQ));
							VBox breakfastLayoutV = new VBox(10);
							HBox cerealLayoutH = new HBox(22);
							HBox oatmealLayoutH = new HBox(14);
							HBox yogurtLayoutH = new HBox(20);
							HBox headerH = new HBox(300);
							headerH.getChildren().addAll(breakfastLabel, LogOffButton2);
							cerealLayoutH.getChildren().addAll(cerealLabel, cerealQ, cerealPrice);
							oatmealLayoutH.getChildren().addAll(oatmealLabel, oatmealQ, oatmealPrice);
							yogurtLayoutH.getChildren().addAll(yogurtLabel, yogurtQ, yogurtPrice);
							breakfastLayoutV.getChildren().addAll(headerH, breakfastNames, cerealLayoutH, oatmealLayoutH, yogurtLayoutH, addToCartButton);
							breakfastScene = new Scene(breakfastLayoutV, 600, 300);									
//-----------------------------------------------------------------------------------------------------------------------------							
							Label mainM = new Label("Main Menu");
							Button LogOffButton7 = new Button ("Log Off");
							LogOffButton7.setOnAction(new LogOffButtonHandler());
							mainM.setFont(new Font("Arial", 30));
							Button stock = new Button("View Stock");
							Button process = new Button("Process Orders");
							
							stock.setOnAction(e -> viewStock(e));
							process.setOnAction(e -> processOrders(e));
							
							HBox hbox1_layoutStock = new HBox (310, mainM, LogOffButton7);
							VBox stockLayout = new VBox(20);
							stockLayout.getChildren().addAll(hbox1_layoutStock, stock, process);
							mainMScene = new Scene(stockLayout, 600, 300);			
//-----------------------------------------------------------------------------------------------------------------------------	
		window.setScene(MainMenuScene);
		window.setTitle("Online Shopping System");
		window.show();
		
	}
		
		public void choiceBoxSelectionCereal(ChoiceBox<Integer> cerealQ, ChoiceBox<Integer> oatmealQ, ChoiceBox<Integer> yogurtQ) {
			
			FileRecords f = new FileRecords();
			f.openFile("CustomerInfo.txt");
			
			double total = 0;
			double[] regPrice = {4.99, 3.99, 1.99};
			double[] pPrice = {2.99, 1.99, 0.99};
			int cereal = cerealQ.getValue();
			int oatmeal = oatmealQ.getValue();
			int yogurt = yogurtQ.getValue();
			double cerealPrice = 0;
			double oatmealPrice = 0;
			double yogurtPrice = 0;
			
			if (cereal == 0 && oatmeal == 0 && yogurt == 0) {
				window.setScene(LogOffScene);
			}
			else {
				
				int i = 0;
				while(true) {
					String str = f.arr1[i];
					if (str == null) {
						break;
					}
					else {
						
						String[] strArray = str.split("/");
						String tmp = strArray[0];
						String tmp2 = strArray[6];
						String tmp3 = strArray[7];
						if (tmp.compareTo(CurrentUserID) == 0 && tmp2.compareTo("regular") == 0) {
							cerealPrice = (cereal * regPrice[0]);
							oatmealPrice = (oatmeal * regPrice[1]);
							yogurtPrice = (yogurt * regPrice[2]); 
							total = cerealPrice + oatmealPrice + yogurtPrice;
							total = Math.round(total*100.0)/100.0;
							
							break;
						}
						if (tmp.compareTo(CurrentUserID) == 0 && tmp2.compareTo("premium") == 0 && tmp3.compareTo("0") == 0) {
							cerealPrice = (cereal * pPrice[0]);
							oatmealPrice = (oatmeal * pPrice[1]); 
							yogurtPrice = (yogurt * pPrice[2]); 
							total = cerealPrice + oatmealPrice + yogurtPrice + 40;
							total = Math.round(total*100.0)/100.0;
							
							break;
						}
						if (tmp.compareTo(CurrentUserID) == 0 && tmp2.compareTo("premium") == 0) {
							cerealPrice = (cereal * pPrice[0]);
							oatmealPrice = (oatmeal * pPrice[1]); 
							yogurtPrice = (yogurt * pPrice[2]); 
							total = cerealPrice + oatmealPrice + yogurtPrice;
							total = Math.round(total*100.0)/100.0;
							
							break;
						}
						else {
							i++;
						}
					}
				}
				
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10 , 10));
				grid.setVgap(8);
				grid.setHgap(40);
				
				Button LogOffButton3 = new Button ("Log Off");
				LogOffButton3.setOnAction(new LogOffButtonHandler());
				GridPane.setConstraints(LogOffButton3, 4, 0);
				
				Label addToCartLabel = new Label("Cart");
				addToCartLabel.setFont(new Font("Arial", 30));
				GridPane.setConstraints(addToCartLabel, 0, 0);
				
				Label name = new Label("Name");
				name.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
				GridPane.setConstraints(name, 0, 1);
				
				Label quan = new Label("Quantity");
				quan.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
				GridPane.setConstraints(quan, 1, 1);
				
				Label price = new Label("Price");
				price.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
				GridPane.setConstraints(price, 2, 1);
				
				Label del = new Label("Delivery Options");
				del.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
				GridPane.setConstraints(del, 3, 1);
				
				ChoiceBox<String> delivery = new ChoiceBox<>();
				delivery.getItems().addAll("Ship To Me", "Store Pick Up");
				delivery.setValue("Ship To Me");
				GridPane.setConstraints(delivery, 3, 2);
				
				Label cartCerealLabel = new Label("Cereal");
				GridPane.setConstraints(cartCerealLabel, 0, 2);
				
				Label cartOatmealLabel = new Label("Oatmeal");
				GridPane.setConstraints(cartOatmealLabel, 0, 3);
				
				Label cartYogurtLabel = new Label("Yogurt");
				GridPane.setConstraints(cartYogurtLabel, 0, 4);
				
				Label cerealQuan = new Label();
				cerealQuan.setText(Integer.toString(cereal));
				GridPane.setConstraints(cerealQuan, 1, 2);
				
				Label oatmealQuan = new Label();
				oatmealQuan.setText(Integer.toString(oatmeal));
				GridPane.setConstraints(oatmealQuan, 1, 3);
				
				Label yogurtQuan = new Label();
				yogurtQuan.setText(Integer.toString(yogurt));
				GridPane.setConstraints(yogurtQuan, 1, 4);
				
				Label cPrice = new Label();
				cPrice.setText(Double.toString(cerealPrice));
				GridPane.setConstraints(cPrice, 2, 2);
				
				Label oPrice = new Label();
				oPrice.setText(Double.toString(oatmealPrice));
				GridPane.setConstraints(oPrice, 2, 3);
				
				Label yPrice = new Label();
				yPrice.setText(Double.toString(yogurtPrice));
				GridPane.setConstraints(yPrice, 2, 4);
				
				Label cartTotal = new Label("Subtotal:");
				cartTotal.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				GridPane.setConstraints(cartTotal, 1, 5);
				
				Label cartNumTotal = new Label();
				cartNumTotal.setText(Double.toString(total) + "*");
				cartNumTotal.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				GridPane.setConstraints(cartNumTotal, 2, 5);
				
				Label info = new Label("*$40 added to total for new premium customers*");
				GridPane.setConstraints(info, 3, 6);
				
				Button checkout = new Button("Checkout");
				GridPane.setConstraints(checkout, 0, 6);
				
				grid.getChildren().addAll(addToCartLabel, name, LogOffButton3, cartCerealLabel, cartOatmealLabel, cartYogurtLabel, info, cerealQuan, oatmealQuan, yogurtQuan, quan, price, oPrice, cPrice, yPrice, cartTotal, cartNumTotal, checkout, del, delivery);
				double finalP = total;
				
				checkout.setOnAction(e -> choiceBoxD(delivery, finalP, cereal, oatmeal, yogurt));
				
				addToCartScene = new Scene(grid, 700, 300);
				window.setScene(addToCartScene);
				
			}
		}
		
		public void choiceBoxD (ChoiceBox<String> delivery, double x, int a, int b, int c) {
			int cereal = a;
			int oatmeal = b;
			int yogurt = c;
			
			String deliveryOption = delivery.getValue();
			double price = x;
			double finalPrice = x;
			double dPrice = 0;
			
			if (deliveryOption.compareTo("Ship To Me") == 0) {
				finalPrice = finalPrice + 3;
				dPrice = 3.00;
				dPrice = Math.round(dPrice*100.0)/100.0;
			}
			
			if (deliveryOption.compareTo("Store Pick Up") == 0) {
				finalPrice = finalPrice + 0;
				dPrice = 0.00;
				dPrice = Math.round(dPrice*100.0)/100.0;
			}
			
			GridPane g = new GridPane();
			g.setPadding(new Insets(10, 10, 10 , 10));
			g.setVgap(8);
			g.setHgap(40);
			
			Button LogOffButton4 = new Button ("Log Off");
			LogOffButton4.setOnAction(new LogOffButtonHandler());
			GridPane.setConstraints(LogOffButton4, 4, 0);
			
			Label checkoutLabel = new Label("Checkout");
			checkoutLabel.setFont(new Font("Arial", 30));
			GridPane.setConstraints(checkoutLabel, 0, 0);
			
			Label cardInfo = new Label("Payment");
			cardInfo.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
			GridPane.setConstraints(cardInfo, 0, 1);
			
			Label prompt = new Label("Enter Card Info");
			GridPane.setConstraints(prompt, 0, 2);
			
			Label PriceLabel = new Label("Prices");
			PriceLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
			GridPane.setConstraints(PriceLabel, 4, 1);
			
			Label subTotalPrice = new Label();
			subTotalPrice.setText(Double.toString(price));
			GridPane.setConstraints(subTotalPrice, 4, 2);
			
			Label subTotal = new Label("Subtotal:");
			GridPane.setConstraints(subTotal, 3, 2);
			
			Label del = new Label("Delivery:");
			GridPane.setConstraints(del, 3, 3);
			
			Label delPrice = new Label();
			delPrice.setText(Double.toString(dPrice) + "0");
			GridPane.setConstraints(delPrice, 4, 3);
			
			Label totalLabel = new Label("Total");
			totalLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
			GridPane.setConstraints(totalLabel, 3, 4);
			
			Label finalPriceLabel = new Label();
			finalPriceLabel.setText(Double.toString(finalPrice));
			finalPriceLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
			GridPane.setConstraints(finalPriceLabel, 4, 4);
			
			TextField creditCardTextField = new TextField();
			GridPane.setConstraints(creditCardTextField, 0, 3);
			
			Label creditCardVerification = new Label();
			GridPane.setConstraints(creditCardVerification, 0, 5);
			
			Button b1 = new Button("Place Order");
			GridPane.setConstraints(b1, 0, 4);
			
			double fP = finalPrice;

			g.getChildren().addAll(checkoutLabel, cardInfo, creditCardTextField, PriceLabel, subTotalPrice, subTotal, del, delPrice, prompt, totalLabel, LogOffButton4, finalPriceLabel, b1, creditCardVerification);
			checkoutScene = new Scene(g, 450, 300);
			b1.setOnAction(e -> OrderTxtAndCreditCard(e, creditCardTextField, creditCardVerification, fP, cereal, oatmeal, yogurt));
			window.setScene(checkoutScene);
			
		}
		
		public void OrderTxtAndCreditCard (ActionEvent event, TextField f, Label l, double finalP, int a, int b, int c) {
			int cereal = a;
			int oatmeal = b;
			int yogurt = c;
			int newOrderTotal;
			double finalPrice = finalP;
			FileRecords ob1 = new FileRecords();
			ob1.openFile("CustomerInfo.txt");
			String tmpCreditCard = f.getText();
			Label tmpl = l;
			int i = 0;
			while(true) {
				String str = ob1.arr1[i];
				if (str == null) {
					break;
				}
				else {
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime now = LocalDateTime.now();   
					
					String[] strArray = str.split("/");
					String tmp = strArray[5];
					String orderStr = strArray[7];
					int orderNum = Integer.parseInt(orderStr);
					
					if (tmp.compareTo(tmpCreditCard) == 0) {
						newOrderTotal = orderNum + 1;
						String intToString = String.valueOf(newOrderTotal);
						String doubleToString = String.valueOf(finalPrice);
						String intToStringCereal = String.valueOf(cereal);
						String intToStringOatmeal = String.valueOf(oatmeal);
						String intToStringYogurt = String.valueOf(yogurt);
						
						String orderInfo = CurrentUserID + "," + dtf.format(now) + "," + intToStringCereal + "," + intToStringOatmeal + "," +intToStringYogurt + "," + doubleToString + "," + tmp;
						ob1.writeFile("CustomerOrders.txt", orderInfo);
						window.setScene(orderPlacedScene);
						break;
					}
					else {
						tmpl.setText("Credit Card Not Valid");
						i++;
						continue;
					}
				}
				
			}
			viewOrder(CurrentUserID);
		}
		
		public void viewOrder(String user) {
			String userName = user;
			String[] tempArr = new String[500];
			int count = 0;
			FileRecords ob2 = new FileRecords();
			ob2.openFile("CustomerOrders.txt");
			int x = 0;
			while(true) {
				String str2 = ob2.arr1[x];
				if (str2 == null) {
					break;
				}
				else {
					String[] strArray2 = str2.split(",");
					String tmp = strArray2[0];
					if (tmp.compareTo(userName) == 0) {
						String temp0 = strArray2[0];
						String temp1 = strArray2[1];
						String temp2 = strArray2[2];
						String temp3 = strArray2[3];
						String temp4 = strArray2[4];
						String temp5 = strArray2[5];
						String temp6 = strArray2[6];
						String tempStr = "User: " + temp0 + "\n" + "Date: " + temp1 + "\n" + "Cereal Quantity: " + temp2 + "\n" + "Oatmeal Quantity: " + temp3 + "\n" + "Yogurt Quantity: " + temp4 + "\n" + "Order Total: " + temp5 + "\n" + "Credit Card: " + temp6 + "\n" + "Status: Preparing";
						tempArr[count] = tempStr;
						count = count + 1;
						x++;
					}
					else {
						
						x++;
						continue;
					}
				}
			}
			
			GridPane gridP = new GridPane();
			gridP.setPadding(new Insets(10, 10, 10 , 10));
			gridP.setVgap(8);
			gridP.setHgap(40);
			
			Button LogOffButton6 = new Button ("Log Off");
			LogOffButton6.setOnAction(new LogOffButtonHandler());
			GridPane.setConstraints(LogOffButton6, 2, 0);
			
			Label orderPlaceLabel = new Label("View Order");
			orderPlaceLabel.setFont(new Font("Arial", 30));
			GridPane.setConstraints(orderPlaceLabel, 0, 0);
			
			Label whichOrder = new Label("Which Order");
			whichOrder.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
			GridPane.setConstraints(whichOrder, 0, 1);
			
			ChoiceBox<String> whichInvoiceBox = new ChoiceBox<>();
			
			for (int xy = 1; xy <= count; xy++) {
				whichInvoiceBox.getItems().add("Order " + xy);
			}
			GridPane.setConstraints(whichInvoiceBox, 0, 2);
			
			Label invoiceLabel = new Label();
			GridPane.setConstraints(invoiceLabel, 0, 3);
			
			whichInvoiceBox.setOnAction(event -> {
				String tmp5 = "";
				String strTemp = whichInvoiceBox.getValue();
				for (int w = 0; w < strTemp.length(); w++) {
					char c = strTemp.charAt(w);
					if(Character.isDigit(c)) {
						 tmp5 += c;
					}
				}
				int intTemp = Integer.parseInt(tmp5);  
				String order = tempArr[intTemp - 1];
				invoiceLabel.setText(order);
			});
			
			Button newB = new Button("View Shipment");
			GridPane.setConstraints(newB, 3, 3);
			
			gridP.getChildren().addAll(orderPlaceLabel, invoiceLabel, whichOrder, whichInvoiceBox, LogOffButton6, newB);
			
			newB.setOnAction(e -> shipOrder(e, userName));
			
			orderPlacedScene = new Scene(gridP, 500, 300);
			window.setScene(orderPlacedScene);	
		}
		
		public void shipOrder(ActionEvent e, String y) {
		
			FileRecords ob2 = new FileRecords();
			ob2.openFile("CustomerInfo.txt");
			String userName = y;
			int x = 0;
			String addy = "";
			while(true) {
				String str2 = ob2.arr1[x];
				if (str2 == null) {
					break;
				}
				else {
					String[] strArray2 = str2.split("/");
					String tmp = strArray2[0];
					if (tmp.compareTo(userName) == 0) {
						addy = "Your order is being shipped to " + strArray2[3];
						break;
					}
					else {
						
						x++;
						continue;
					}
				}
			}
			
			GridPane gridP = new GridPane();
			gridP.setPadding(new Insets(10, 10, 10 , 10));
			gridP.setVgap(8);
			gridP.setHgap(40);
			
			Label shipLabel = new Label("Order Shipment");
			shipLabel.setFont(new Font("Arial", 30));
			GridPane.setConstraints(shipLabel, 0, 0);
			
			Label shipAddy = new Label();
			shipAddy.setText(addy);
			GridPane.setConstraints(shipAddy, 0, 1);
			
			Button invoiceButton = new Button("View Invoice");
			GridPane.setConstraints(invoiceButton, 2, 4);
			
			invoiceButton.setOnAction(ev -> viewInvoice(e, userName));
			
			gridP.getChildren().addAll(shipLabel, shipAddy, invoiceButton);
			
			shipOrderScene = new Scene(gridP, 700, 300);
			window.setScene(shipOrderScene);
		}
		
		public void viewInvoice(ActionEvent e, String user) {
			String userName = user;
			String[] tempArr = new String[500];
			int count = 0;
			FileRecords ob2 = new FileRecords();
			ob2.openFile("CustomerOrders.txt");
			int x = 0;
			while(true) {
				String str2 = ob2.arr1[x];
				if (str2 == null) {
					break;
				}
				else {
					String[] strArray2 = str2.split(",");
					String tmp = strArray2[0];
					if (tmp.compareTo(userName) == 0) {
						String temp0 = strArray2[0];
						String temp1 = strArray2[1];
						String temp2 = strArray2[2];
						String temp3 = strArray2[3];
						String temp4 = strArray2[4];
						String temp5 = strArray2[5];
						String temp6 = strArray2[6];
						String tempStr = "User: " + temp0 + "\n" + "Date: " + temp1 + "\n" + "Cereal Quantity: " + temp2 + "\n" + "Oatmeal Quantity: " + temp3 + "\n" + "Yogurt Quantity: " + temp4 + "\n" + "Order Total: " + temp5 + "\n" + "Credit Card: " + temp6;
						tempArr[count] = tempStr;
						count = count + 1;
						x++;
					}
					else {
						
						x++;
						continue;
					}
				}
			}
			
			GridPane gridP = new GridPane();
			gridP.setPadding(new Insets(10, 10, 10 , 10));
			gridP.setVgap(8);
			gridP.setHgap(40);
			
			Button LogOffButton6 = new Button ("Log Off");
			LogOffButton6.setOnAction(new LogOffButtonHandler());
			GridPane.setConstraints(LogOffButton6, 2, 0);
			
			Label orderPlaceLabel = new Label("View Invoice");
			orderPlaceLabel.setFont(new Font("Arial", 30));
			GridPane.setConstraints(orderPlaceLabel, 0, 0);
			
			Label whichOrder = new Label("Which Invoice");
			whichOrder.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
			GridPane.setConstraints(whichOrder, 0, 1);
			
			ChoiceBox<String> whichInvoiceBox = new ChoiceBox<>();
			
			for (int xy = 1; xy <= count; xy++) {
				whichInvoiceBox.getItems().add("Order " + xy);
			}
			GridPane.setConstraints(whichInvoiceBox, 0, 2);
			
			Label invoiceLabel = new Label();
			GridPane.setConstraints(invoiceLabel, 0, 3);
			
			whichInvoiceBox.setOnAction(event -> {
				String tmp5 = "";
				String strTemp = whichInvoiceBox.getValue();
				for (int w = 0; w < strTemp.length(); w++) {
					char c = strTemp.charAt(w);
					if(Character.isDigit(c)) {
						 tmp5 += c;
					}
				}
				int intTemp = Integer.parseInt(tmp5);  
				String order = tempArr[intTemp - 1];
				invoiceLabel.setText(order);
			});
			
			Button newB = new Button();
			GridPane.setConstraints(newB, 3, 3);
			
			gridP.getChildren().addAll(orderPlaceLabel, invoiceLabel, whichOrder, whichInvoiceBox, LogOffButton6);
			
			invoiceScene = new Scene(gridP, 500, 300);
			window.setScene(invoiceScene);	
		}
		
		public void viewStock(ActionEvent event) {
			String[] arr2 = new String[500];
			int a = 0;
			String line2;
			try (BufferedReader b = new BufferedReader(new FileReader("Stock.txt"))) {
	            while ((line2 = b.readLine()) != null) {
	                if(!line2.isEmpty()){
	                	arr2[a] = line2;
	                	a++;
	                } 
	                else {
	                	break;
	                }
	            }
	        } 
			catch(Exception e) {
				e.printStackTrace();
	        }
			
			String finalStock = "";
			
			int i = 0;
			while (true) {
				String s = arr2[i];
				if (s == null) {
					break;
				}
				else {
					String[] strArray = s.split("/");
					String itemName = strArray[0];
					String itemQuan = strArray[1];
					String itemRes = strArray[2];
					
					String stock = "\n" + "Name: " + itemName + " \t " + "In Stock: " + itemQuan + " \t " + "Reserved: " + itemRes + "\n";
					finalStock += stock;
					i++;
				}
			}
			
			GridPane gridPa = new GridPane();
			gridPa.setPadding(new Insets(10, 10, 10 , 10));
			gridPa.setVgap(8);
			gridPa.setHgap(40);
			
			Label stockLabel = new Label("Stock");
			stockLabel.setFont(new Font("Arial", 30));
			GridPane.setConstraints(stockLabel, 0, 0);
			
			Label stockL = new Label();
			stockL.setText(finalStock);
			GridPane.setConstraints(stockL, 0, 1);
			gridPa.getChildren().addAll(stockLabel, stockL);

			stockScene = new Scene(gridPa, 600, 300);
			
			window.setScene(stockScene);
		}
		
		public void processOrders(ActionEvent e) {
			
			String[] tempArr = new String[500];
			int count = 0;
			FileRecords ob2 = new FileRecords();
			ob2.openFile("CustomerOrders.txt");
			int x = 0;
			while(true) {
				String str2 = ob2.arr1[x];
				if (str2 == null) {
					break;
				}
				else {
					String[] strArray2 = str2.split(",");
					
						String temp0 = strArray2[0];
						String temp1 = strArray2[1];
						String temp2 = strArray2[2];
						String temp3 = strArray2[3];
						String temp4 = strArray2[4];
						String temp5 = strArray2[5];
						
						String tempStr = "User: " + temp0 + "\n" + "Date: " + temp1 + "\n" + "Cereal Quantity: " + temp2 + "\n" + "Oatmeal Quantity: " + temp3 + "\n" + "Yogurt Quantity: " + temp4 + "\n" + "Order Total: " + temp5;
						tempArr[count] = tempStr;
						count = count + 1;
						x++;
					}
			}

			System.out.println(x);
			
			GridPane gridP = new GridPane();
			gridP.setPadding(new Insets(10, 10, 10 , 10));
			gridP.setVgap(8);
			gridP.setHgap(40);
			
			Button LogOffButton6 = new Button ("Log Off");
			LogOffButton6.setOnAction(new LogOffButtonHandler());
			GridPane.setConstraints(LogOffButton6, 2, 0);
			
			Label orderPlaceLabel = new Label("Process Order");
			orderPlaceLabel.setFont(new Font("Arial", 30));
			GridPane.setConstraints(orderPlaceLabel, 0, 0);
			
			Label whichOrder = new Label("Which Order");
			whichOrder.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
			GridPane.setConstraints(whichOrder, 0, 1);
			
			ChoiceBox<String> whichInvoiceBox = new ChoiceBox<>();
			
			for (int xy = 1; xy <= count; xy++) {
				whichInvoiceBox.getItems().add("Order " + xy);
			}
			GridPane.setConstraints(whichInvoiceBox, 0, 2);
			
			Label invoiceLabel = new Label();
			GridPane.setConstraints(invoiceLabel, 0, 3);
			
			Button newB = new Button("Process Order");
			GridPane.setConstraints(newB, 3, 3);
			
			gridP.getChildren().addAll(orderPlaceLabel, invoiceLabel, whichOrder, whichInvoiceBox, LogOffButton6, newB);
			
			newB.setOnAction(ev -> handleProcess(e, whichInvoiceBox, tempArr));

			
			processOrderScene = new Scene(gridP, 500, 300);
			window.setScene(processOrderScene);	
		}
		
		public void handleProcess(ActionEvent e, ChoiceBox<String> x, String[] tempArr) {
			
			String findOrderNum = x.getValue();
			System.out.println(tempArr[0]);
			
			String num = "";
			
			for (int i = 0; i < findOrderNum.length(); i++) {
				char c = findOrderNum.charAt(i);
				if(Character.isDigit(c)) {
					num += c;
				}
			}
			
			int y = Integer.parseInt(num);  
		
			GridPane gridP = new GridPane();
			gridP.setPadding(new Insets(10, 10, 10 , 10));
			gridP.setVgap(8);
			gridP.setHgap(40);
			
			Button LogOffButton6 = new Button ("Log Off");
			LogOffButton6.setOnAction(new LogOffButtonHandler());
			GridPane.setConstraints(LogOffButton6, 2, 0);
			
			Label orderPlaceLabel = new Label("Order Processed");
			orderPlaceLabel.setFont(new Font("Arial", 30));
			GridPane.setConstraints(orderPlaceLabel, 0, 0);
			
			Label processedOrderLabel = new Label();
			processedOrderLabel.setText(tempArr[y-1] + "\n" + "Status: Order is Ready!");
			GridPane.setConstraints(processedOrderLabel, 0, 1);
			
			gridP.getChildren().addAll(orderPlaceLabel,  LogOffButton6, processedOrderLabel);

			
			orderProcessedScene = new Scene(gridP, 500, 300);
			window.setScene(orderProcessedScene);	
		
		}

	class CustomerLogOnCheckButtonHandler implements EventHandler<ActionEvent> {
		String UserID_tmp;
		@Override
		public void handle (ActionEvent event) {
			FileRecords ob1 = new FileRecords();
			String UserID = (CustomerLogOnUserIDTextField.getText());
			UserID_tmp = UserID;
			String UserPassword = (CustomerLogOnUserPasswordTextField.getText());
			String UserIDandPassword = UserID + "/" + UserPassword;
			ob1.openFile("CustomerInfo.txt");
			int i = 0;
			while(true) {
				String str = ob1.arr1[i];
				if (str == null) {
					break;
				}
				else {
					String[] strArray = str.split("/");
					String tmp = strArray[0] + "/" +strArray[1];
					if (tmp.compareTo(UserIDandPassword) == 0) {
						CustomerLogOnUserInfoVerification.setText("Welcome");
						CurrentUserID = UserID_tmp;
						window.setScene(catalogScene);
						break;
					}
					else {
						CustomerLogOnUserInfoVerification.setText("Account Not Found");
						i++;
						continue;
					}
				}
			}
		}
	}
	
	static class FileRecords {
		String[] arr1 = new String[500];
		int abc;
		String x;
		public void openFile(String a) {
			try (BufferedReader br = new BufferedReader(new FileReader(a))) {
				String line;
	            while ((line = br.readLine()) != null) {
	                if(!line.isEmpty()){
	                	arr1[abc] = line;
	                	abc++;
	                } 
	                else {
	                	br.close();
	                	break;
	                }
	            }
	        } 
			catch(Exception e) {
				e.printStackTrace();
	        }
		}
		public void writeFile (String x, String y) {
			try {
				File file = new File (x);
				FileWriter fw = new FileWriter(file, true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(y);
				pw.close();
			}
			catch (Exception e) {
				System.out.println("File Not Found");
			}
		}
	}
	
	class SupplierLogOnCheckButtonHandler implements EventHandler<ActionEvent> {
		String UserID_tmp;
		@Override
		public void handle (ActionEvent event) {
			FileRecords ob1 = new FileRecords();
			String UserID = (SupplierLogOnUserIDTextField.getText());
			UserID_tmp = UserID;
			String UserPassword = (SupplierLogOnUserPasswordTextField.getText());
			String UserIDandPassword = UserID + "/" + UserPassword;
			ob1.openFile("SupplierInfo.txt");
			int i = 0;
			while(true) {
				String str = ob1.arr1[i];
				if (str == null) {
					break;
				}
				else {
					String[] strArray = str.split("/");
					String tmp = strArray[0] + "/" +strArray[1];
					if (tmp.compareTo(UserIDandPassword) == 0) {
						SupplierLogOnUserInfoVerification.setText("Welcome");
						CurrentUserID = UserID_tmp;
						window.setScene(mainMScene);
						break;
					}
					else {
						SupplierLogOnUserInfoVerification.setText("Account Not Found");
						i++;
						continue;
					}
				}
			}
		}
	}
	
	class CustomerCreateAccountCheckButtonHandler implements EventHandler<ActionEvent> {
		String UserID_tmp;
		String UserInfoTogether_tmp;
		@Override
		public void handle (ActionEvent event) {
			FileRecords ob1 = new FileRecords();
			String UserID = (CustomerCreateAccountUserIDTextField.getText());
			UserID_tmp = UserID;
			String UserPassword = (CustomerCreateAccountUserPasswordTextField.getText());
			String UserName = (CustomerCreateAccountUserNameTextField.getText());
			String UserAddress = (CustomerCreateAccountUserAddressTextField.getText());
			String UserPhoneNumber = (CustomerCreateAccountUserPhoneNumberTextField.getText());
			String UserCreditCardNumber = (CustomerCreateAccountUserCreditCardNumberTextField.getText());
			String UserInfoTogether = UserID + "/" + UserPassword + "/" + UserName + "/" + UserAddress + "/" + UserPhoneNumber + "/" + UserCreditCardNumber;
			UserInfoTogether_tmp = UserInfoTogether;
			ob1.openFile("CustomerInfo.txt");
			int i = 0;
			while (true) {
				String str = ob1.arr1[i];
				if (str == null) {
					CustomerCreateAccountUserInfoVerification.setText("New Account");
					// ob1.writeFile("CustomerInfo.txt", UserInfoTogether);
					window.setScene(CustomerAccountTypeScene);
					CurrentUserID = UserID_tmp;
					CurrentUserInfoTogether = UserInfoTogether_tmp;
					break;
				}
				else {
					String[] strArray = str.split("/");
					String tmp = strArray[0];
					if (tmp.compareTo(UserID) == 0) {
						CustomerCreateAccountUserInfoVerification.setText("Error: Enter A Different ID");
						break;
					}
					else {
						i++;
					}
				}
			}
		}
	}
	
	class CustomerAccountTypeHandler1 implements EventHandler<ActionEvent> {
		@Override
		public void handle (ActionEvent event) {
			String UserInfoTogether = CurrentUserInfoTogether + "/" + "premium" + "/" + "0";
			FileRecords ob1 = new FileRecords();
			ob1.openFile("CustomerInfo.txt");
			int i = 0;
			while (true) {
				String str = ob1.arr1[i];
				if (str == null) {
					ob1.writeFile("CustomerInfo.txt", UserInfoTogether);
					window.setScene(catalogScene);
					break;
				}
				else {
					i++;
				}
			}
		}
	}

	class CustomerAccountTypeHandler2 implements EventHandler<ActionEvent> {
		@Override
		public void handle (ActionEvent event) {
			String UserInfoTogether = CurrentUserInfoTogether + "/" + "regular" + "/" + "0" ;
			FileRecords ob1 = new FileRecords();
			ob1.openFile("CustomerInfo.txt");
			int i = 0;
			while (true) {
				String str = ob1.arr1[i];
				if (str == null) {
					ob1.writeFile("CustomerInfo.txt", UserInfoTogether);
					window.setScene(catalogScene);
					break;
				}
				else {
					i++;
				}
			}
		}
	}
	
	class SupplierCreateAccountCheckButtonHandler implements EventHandler<ActionEvent> {
		String UserID_tmp;
		@Override
		public void handle (ActionEvent event) {
			FileRecords ob1 = new FileRecords();
			String UserID = (SupplierCreateAccountUserIDTextField.getText());
			UserID_tmp = UserID;
			String UserPassword = (SupplierCreateAccountUserPasswordTextField.getText());
			String UserInfoTogether = UserID + "/" + UserPassword;
			ob1.openFile("SupplierInfo.txt");
			int i = 0;
			while (true) {
				String str = ob1.arr1[i];
				if (str == null) {
					SupplierCreateAccountUserInfoVerification.setText("New Account");
					ob1.writeFile("SupplierInfo.txt", UserInfoTogether);
					CurrentUserID = UserID_tmp;
					window.setScene(mainMScene);
					break;
				}
				else {
					String[] strArray = str.split("/");
					String tmp = strArray[0];
					if (tmp.compareTo(UserID) == 0) {
						SupplierCreateAccountUserInfoVerification.setText("Error: Enter A Different ID");
						break;
					}
					else {
						i++;
					}
				}
			}
		}
	}
	
	class LogOffButtonHandler implements EventHandler<ActionEvent> {
		String UserID_tmp;
		
		public void handle (ActionEvent event) {
			window.setScene(LogOffScene);
		}
	}
	
	class CheckStock{
		public int stock(String name) {
			String[] arr2 = new String[500];
			int a = 0;
			String line2;
			try (BufferedReader b = new BufferedReader(new FileReader("Stock.txt"))) {
	            while ((line2 = b.readLine()) != null) {
	                if(!line2.isEmpty()){
	                	arr2[a] = line2;
	                	a++;
	                } 
	                else {
	                	break;
	                }
	            }
	        } 
			catch(Exception e) {
				e.printStackTrace();
	        }
			
			
			int i = 0;
			while (true) {
				String s = arr2[i];
				if (s == null) {
					break;
				}
				else {
					String[] strArray = s.split("/");
					String itemName = strArray[0];
					String itemQuan = strArray[1];
					if (itemName.compareTo(name) == 0) {
						return (Integer.parseInt(itemQuan));
					}
					else {
						i++;
					}
				}
			}
			return 999;
		}
	}
}