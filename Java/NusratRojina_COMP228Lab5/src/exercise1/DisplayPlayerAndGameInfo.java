package exercise1;

// import API
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// DisplayPlayerAndGameInfo class that extends Application class
public class DisplayPlayerAndGameInfo extends Application {

    //==========instance variables=================================

    // instance of PlayerAndGame class
    private PlayerAndGame currentEntry;
    // instance of PlayerAndGameQueries class
    private PlayerAndGameQueries playerAndGameQueries;
    // hold a list of PlayerAndGame instances
    private ObservableList<PlayerAndGame> allEntries;
    //determines no of entries
    private int numberOfEntries = 0;
    private int currentEntryIndex;

    // instances of all the components
    // all the panes to hold the components
    private BorderPane mainFramePane = new BorderPane();
    private GridPane queryPane = new GridPane();
    private GridPane navigatePane = new GridPane();
    private GridPane displayPane = new GridPane();
    private TitledPane gameInfoTitledPane = new TitledPane();
    private GridPane displayGameInfoPane = new GridPane();
    private TitledPane playerInfoTitledPane = new TitledPane();
    private GridPane displayPlayerInfoPane = new GridPane();
    private TitledPane playerAndGameInfoTitledPane = new TitledPane();
    private GridPane displayerAndGamePane = new GridPane();
    private GridPane comboBoxPane = new GridPane();
    private GridPane buttonPane = new GridPane();

    // buttons
    private Button browseButton = new Button();
    private Button insertButton = new Button();
    private Button insertGameButton = new Button();
    private Button insertPlayerButton = new Button();
    private Button nextButton = new Button();
    private Button previousButton = new Button();
    private Button updateButton = new Button();
    private Button deleteButton = new Button();
    private Button deleteGameButton = new Button();
    private Button deletePlayerButton = new Button();

    // label, TextField and comboBox
    private Label gameIdLabel = new Label();
    private TextField gameIdTextField = new TextField();
    private Label gameTitleLabel = new Label();
    private TextField gameTitleTextField = new TextField();
    private Label playerIdLabel = new Label();
    private TextField playerIdField = new TextField();
    private Label firstNameLabel = new Label();
    private TextField firstNameTextField = new TextField();
    private Label lastNameLabel = new Label();
    private TextField lastNameTextField = new TextField();
    private Label addressLabel = new Label();
    private TextField addressTextField = new TextField();
    private Label postalCodeLabel = new Label();
    private TextField postalCodeTextField = new TextField();
    private Label provinceLabel = new Label();
    private TextField provinceTextField = new TextField();
    private Label phoneNumberLabel = new Label();
    private TextField phoneNumberTextField = new TextField();
    private Label playingDateLabel = new Label();
    private TextField playingDateTextField = new TextField();
    private DatePicker datePicker = new DatePicker();
    private Label scoreLabel = new Label();
    private TextField scoreTextField = new TextField();
    private Label ofLabel = new Label();
    private TextField indexTextField = new TextField();
    private TextField maxTextField = new TextField();
    private Label queryPlayerIdLabel = new Label();
    private Label queryGameIdLabel = new Label();
    private Label gameMsgLabel = new Label();
    private Label playerMsgLabel = new Label();
    private Label playerAndGameMsgLabel = new Label();
    private Label searchIdMsgLabel = new Label();
    private Label queryMsgLabel = new Label();
    private ComboBox<Integer> queryPlayerIdComboBox = new ComboBox<>();
    private ComboBox<Integer> queryGameIdComboBox = new ComboBox<>();
    Alert errorAlert = new Alert(AlertType.ERROR);



    // main method
    public static void main(String[] args){

        // create a DisplayPlayerAndGameInfo object and call its start method
        launch(args);

    }

    @Override
    public void start(Stage primaryStage){

        // establish database connection and set up PreparedStatements
        playerAndGameQueries = new PlayerAndGameQueries();
        mainFramePane = new BorderPane();
        // add the border pane to the scene
        Scene appScene = new Scene(mainFramePane,1000,1000);
        mainFramePane.setPadding(new Insets(10,10,10,10));

        navigatePane = new GridPane();
        displayPane = new GridPane();
        queryPane = new GridPane();

        // main pane holding other panes
        mainFramePane.setTop(navigatePane);
        mainFramePane.setCenter(displayPane);
        mainFramePane.setBottom(queryPane);

        // calling all necessary methods
        this.displayNavigationPanel(navigatePane);
        this.displayPlayerAndGameInfo(displayPane);
        this.displayQueryPanel(queryPane);
        this.resetAllComponents();

        // Application setup
        primaryStage.setTitle("Student Information - Using JavaFx");
        // add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
    }

    // method that functions with navigatePane and it's components
    public void displayNavigationPanel(GridPane navigatePane){

        // set navigatePane's layout
        navigatePane.setPadding(new Insets(10,10,10,250));
        navigatePane.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        BorderPane.setMargin(navigatePane,new Insets(0,0,10,0));
        navigatePane.setHgap(20);
        navigatePane.setVgap(10);
        navigatePane.setStyle("-fx-background-color: lightgray");

        // hold components
        navigatePane.add(previousButton,0,0);
        navigatePane.add(indexTextField,1,0);
        navigatePane.add(ofLabel,2,0);
        ofLabel.setText("of");
        ofLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        navigatePane.add(maxTextField,3,0);
        maxTextField.setEditable(false);
        maxTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        navigatePane.add(nextButton,4,0);


        // previousButton functions when browseButton actions
        previousButton.setText("Previous");
        previousButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        previousButton.setDisable(true);
        previousButton.setOnAction(new EventHandler<ActionEvent>() {
                                       @Override
                                       public void handle(ActionEvent evt) {
                                           previousButtonActionPerformed(evt);
                                       }
                                   }
        );


        // indextextField holds minimum index of entries
        indexTextField.setOnAction(new EventHandler<ActionEvent>() {
                                       @Override
                                       public void handle(ActionEvent evt) {
                                           indexTextFieldActionPerformed(evt);
                                       }
                                   }
        );



        // nextButton functions when browse button funtion to show all entries
        nextButton.setText("Next");
        nextButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        nextButton.setDisable(true);
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent evt) {
                                       nextButtonActionPerformed(evt);
                                   }
                               }
        );



    }//end of displayNavigationPanel()


    // method that functions with Player and Game information pane and it's components
    public void displayPlayerAndGameInfo(GridPane displayPane) {


        // set the layout of displayPane
        displayPane.setPadding(new Insets(10,10,10,50));
        displayPane.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        BorderPane.setMargin(displayPane,new Insets(0,0,10,0));
        displayPane.setHgap(10);
        displayPane.setVgap(10);
        displayPane.setStyle("-fx-background-color: lightgray");

        // displayPane holds and set layout of other panes to show Player, Game and PlayerAndGame Information
        playerInfoTitledPane.setText("Player Info");
        playerInfoTitledPane.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        gameInfoTitledPane.setText("Game Info");
        gameInfoTitledPane.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        playerAndGameInfoTitledPane.setText("Match Information of the Player");
        playerAndGameInfoTitledPane.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        playerInfoTitledPane.setContent(displayPlayerInfoPane);
        gameInfoTitledPane.setContent(displayGameInfoPane);
        playerAndGameInfoTitledPane.setContent(displayerAndGamePane);
        displayPane.add(playerInfoTitledPane,0,0);
        displayPlayerInfoPane.setMinWidth(800);
        displayPlayerInfoPane.setVgap(5);
        displayPlayerInfoPane.setHgap(10);
        displayPane.add(gameInfoTitledPane, 0,1);
        displayGameInfoPane.setMinWidth(800);
        displayGameInfoPane.setVgap(5);
        displayGameInfoPane.setHgap(10);
        displayPane.add(playerAndGameInfoTitledPane, 0,2);
        displayerAndGamePane.setMinWidth(800);
        displayerAndGamePane.setVgap(5);
        displayerAndGamePane.setHgap(10);

        // pane to hold player information
        playerMsgLabel.setText("Note: This section is used to add or delete only Player Information");
        displayPlayerInfoPane.add(playerMsgLabel, 0, 0);
        playerMsgLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        playerIdLabel.setText("Player Id");
        playerIdLabel.setMinWidth(400);
        displayPlayerInfoPane.add(playerIdLabel, 0, 1);
        playerIdLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        playerIdField.setEditable(true);
        displayPlayerInfoPane.add(playerIdField, 1, 1);
        playerIdField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        playerIdField.setMinWidth(400);
        playerIdField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        // firstName
        firstNameLabel.setText("First name");
        firstNameLabel.setMinWidth(400);
        firstNameLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayPlayerInfoPane.add(firstNameLabel, 0, 2);
        firstNameLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayPlayerInfoPane.add(firstNameTextField, 1, 2);
        firstNameTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        firstNameTextField.setMinWidth(400);
        firstNameTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        //lastName
        lastNameLabel.setText("Last name");
        lastNameLabel.setMinWidth(400);
        displayPlayerInfoPane.add(lastNameLabel, 0, 3);
        lastNameLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayPlayerInfoPane.add(lastNameTextField, 1, 3);
        lastNameTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        lastNameTextField.setMinWidth(400);
        lastNameTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        // address
        addressLabel.setText("Address");
        addressLabel.setMinWidth(400);
        displayPlayerInfoPane.add(addressLabel, 0, 4);
        addressLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayPlayerInfoPane.add(addressTextField, 1, 4);
        addressTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        addressTextField.setMinWidth(400);
        addressTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        //postalCode
        postalCodeLabel.setText("Postal code");
        postalCodeLabel.setMinWidth(400);
        displayPlayerInfoPane.add(postalCodeLabel, 0, 5);
        postalCodeLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayPlayerInfoPane.add(postalCodeTextField, 1, 5);
        postalCodeTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        postalCodeTextField.setMinWidth(400);
        postalCodeTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        //province
        provinceLabel.setText("Province");
        provinceLabel.setMinWidth(400);
        displayPlayerInfoPane.add(provinceLabel, 0, 6);
        provinceLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayPlayerInfoPane.add(provinceTextField, 1, 6);
        provinceTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        provinceTextField.setMinWidth(400);
        provinceTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        //phoneNumber
        phoneNumberLabel.setText("Phone number");
        phoneNumberLabel.setMinWidth(400);
        displayPlayerInfoPane.add(phoneNumberLabel, 0, 7);
        phoneNumberLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayPlayerInfoPane.add(phoneNumberTextField, 1, 7);
        phoneNumberTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        phoneNumberTextField.setMinWidth(400);
        phoneNumberTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        //buttons
        displayPlayerInfoPane.add(insertPlayerButton,0,8);
        insertPlayerButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        insertPlayerButton.setStyle("-fx-background-color: lightblue");
        insertPlayerButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        displayPlayerInfoPane.add(deletePlayerButton,1,8);
        deletePlayerButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        deletePlayerButton.setStyle("-fx-background-color: lightblue");
        deletePlayerButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));


        // pane to hold game Information
        gameMsgLabel.setText("Note: This section is used to add or delete only Game Information");
        displayGameInfoPane.add(gameMsgLabel, 0, 0);
        gameMsgLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        gameIdLabel.setText("Game id");
        gameIdLabel.setMinWidth(200);
        displayGameInfoPane.add(gameIdLabel, 0, 1);
        gameIdLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayGameInfoPane.add(gameIdTextField, 1, 1);
        gameIdTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        gameIdTextField.setMinWidth(400);
        gameIdTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        // gametitle
        gameTitleLabel.setText("Game title");
        gameTitleLabel.setMinWidth(200);
        displayGameInfoPane.add(gameTitleLabel, 0, 2);
        gameTitleLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayGameInfoPane.add(gameTitleTextField, 1, 2);
        gameTitleTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        gameTitleTextField.setMinWidth(400);
        gameTitleTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        //buttons

        displayGameInfoPane.add(insertGameButton,0,3);
        insertGameButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        insertGameButton.setStyle("-fx-background-color: lightblue");
        insertGameButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));

        displayGameInfoPane.add(deleteGameButton,1,3);
        deleteGameButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        deleteGameButton.setStyle("-fx-background-color: lightblue");
        deleteGameButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));


        // playingDate
        playerAndGameMsgLabel.setText("Note: This section is used to add or delete only date \n" +
                "and score of a player and a game that already exist in the system");
        displayerAndGamePane.add(playerAndGameMsgLabel, 0, 0);
        playerAndGameMsgLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        playingDateLabel.setText("Date");
        playingDateLabel.setMinWidth(200);
        displayerAndGamePane.add(playingDateLabel, 0, 1);
        playingDateLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayerAndGamePane.add(datePicker, 1, 1);
        datePicker.setMinWidth(300);
        datePicker.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),BorderWidths.DEFAULT)));
        datePicker.setStyle("-fx-font-size: 13");

        //score
        scoreLabel.setText("Score");
        scoreLabel.setMinWidth(200);
        displayerAndGamePane.add(scoreLabel, 0, 2);
        scoreLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        displayerAndGamePane.add(scoreTextField, 1, 2);
        scoreTextField.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        scoreTextField.setMinWidth(300);
        scoreTextField.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),BorderWidths.DEFAULT)));
        displayerAndGamePane.add(insertButton,1,3);
        insertButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        insertButton.setStyle("-fx-background-color: lightblue");
        insertButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));

        displayerAndGamePane.add(deleteButton,2,3);
        deleteButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        deleteButton.setStyle("-fx-background-color: lightblue");
        deleteButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));


    }//end of displayPlayerAndGameInfo()


    // method that functions with the query of Player and Game information pane and it's components
    public void displayQueryPanel(GridPane queryPane){

        // set layout of queryPane
        queryPane.setPadding(new Insets(10,10,10,10));
        queryPane.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        BorderPane.setMargin(queryPane,new Insets(0,0,10,0));
        queryPane.setHgap(10);
        queryPane.setVgap(15);
        queryPane.setStyle("-fx-background-color: lightgray");

        //queryPane holds comboBox and button that are used to search for Player and game info
        queryPane.add(comboBoxPane,0,0);
        comboBoxPane.setMinWidth(800);
        comboBoxPane.setHgap(15);
        comboBoxPane.setVgap(15);
        queryPane.add(buttonPane,0,1);
        buttonPane.setMinWidth(800);
        buttonPane.setHgap(15);
        buttonPane.setVgap(10);

        //combobox to hold playerId that can be used to search for individual player
        searchIdMsgLabel.setText("Note: Search an entry by player id and game id --");
        comboBoxPane.add(searchIdMsgLabel,0,0);
        searchIdMsgLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        comboBoxPane.add(queryPlayerIdLabel,0,1);
        queryPlayerIdLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        //queryPlayerIdLabel.setMinWidth(100);
        comboBoxPane.add(queryPlayerIdComboBox, 1,1);
        queryPlayerIdComboBox.setMinWidth(300);


        //eventHandler to hold the playerId in the comboxBox
        queryPlayerIdComboBox.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        updatePlayerIdComboBox(event);
                    }
                }
        );

        //combobox to hold gameId that can be used to search for games played by an individual player
        comboBoxPane.add(queryGameIdLabel,2,1);
        queryGameIdLabel.setMinWidth(100);
        queryGameIdLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        comboBoxPane.add(queryGameIdComboBox,3,1);
        queryGameIdComboBox.setMinWidth(300);



        // buttons to make query that shows all Player and GAme info
        queryMsgLabel.setText("Note: This section is used to add, update and browse \nall player," +
                " Game and match information all together.");
        buttonPane.add(queryMsgLabel,0,0);
        queryMsgLabel.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        buttonPane.add(updateButton,0,1);
        updateButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        updateButton.setStyle("-fx-background-color: lightblue");
        updateButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));

        buttonPane.add(browseButton,1,1);
        browseButton.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        browseButton.setStyle("-fx-background-color: lightblue");
        browseButton.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));


        buttonPane.setPadding(new Insets(0,0,0,200));

        //label
        queryPlayerIdLabel.setText("Player-id");
        queryGameIdLabel.setText("Game-id");


        //updateButton to update all Player and Game Info in three tables at a time
        updateButton.setText("Update entries");
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
                                     @Override
                                     public void handle(ActionEvent evt) {
                                         updateButtonActionPerformed(evt);

                                         // prevents doing the same action
                                         resetAllComponents();
                                         updateButton.setDisable(true);
                                     }
                                 }
        );


        // deleteButton to delete all Player and game info from three tables at a time
        deleteButton.setText("Delete an entry");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                                     @Override
                                     public void handle(ActionEvent evt) {
                                         deleteButtonActionPerformed(evt);

                                         // prevents doing the same action
                                         resetAllComponents();
                                         deleteButton.setDisable(true);
                                     }
                                 }
        );

        //deleteGameButton to delete only game info from Game and PlayerAndGame tables at a time
        deleteGameButton.setText("Delete a game");
        deleteGameButton.setOnAction(new EventHandler<ActionEvent>() {
                                         @Override
                                         public void handle(ActionEvent evt) {
                                             deleteGameButtonActionPerformed(evt);
                                             // prevents doing the same action
                                             gameIdTextField.clear();
                                             gameTitleTextField.clear();
                                             deleteGameButton.setDisable(true);
                                         }
                                     }
        );

        //deletePlayerButton to delete only game info from Player and PlayerAndGame tables at a time

        deletePlayerButton.setText("Delete a Player");
        deletePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
                                           @Override
                                           public void handle(ActionEvent evt) {
                                               deletePlayerButtonActionPerformed(evt);
                                               playerIdField.clear();
                                               firstNameTextField.clear();
                                               lastNameTextField.clear();
                                               addressTextField.clear();
                                               postalCodeTextField.clear();
                                               provinceTextField.clear();
                                               phoneNumberTextField.clear();
                                               deletePlayerButton.setDisable(true);
                                           }
                                       }
        );



        // browsebutton to browse all Player and Game information from the Player, Game and PlayerAndGame tables
        browseButton.setText("Browse All Entries");
        browseButton.setOnAction(new EventHandler<ActionEvent>() {
                                     @Override
                                     public void handle(ActionEvent evt){
                                         queryPlayerIdComboBox.getItems().clear();
                                         browseButtonActionPerformed(evt);


                                     }
                                 }
        );



        // insert buttons to insert game and player info PlayerAndGame table when a
        // playerId and a gameId are already in the Player and Game table

        insertButton.setText("Insert New Entry");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
                                     @Override
                                     public void handle(ActionEvent evt) {
                                         insertButtonActionPerformed(evt);
                                         resetAllComponents();
                                     }
                                 }
        );


        // insertGameButton to insert game info in the Game table only
        insertGameButton.setText("Insert New Game");
        insertGameButton.setOnAction(new EventHandler<ActionEvent>() {
                                         @Override
                                         public void handle(ActionEvent evt) {
                                             insertGameButtonActionPerformed(evt);
                                             gameIdTextField.clear();
                                             gameTitleTextField.clear();
                                             insertGameButton.setDisable(true);
                                         }
                                     }
        );


        // insertPlayerButton  to insert Player info in the Player table only
        insertPlayerButton.setText("Insert New Player");
        insertPlayerButton.setOnAction(new EventHandler<ActionEvent>() {
                                           @Override
                                           public void handle(ActionEvent evt) {
                                               insertPlayerButtonActionPerformed(evt);
                                               playerIdField.clear();
                                               firstNameTextField.clear();
                                               lastNameTextField.clear();
                                               addressTextField.clear();
                                               postalCodeTextField.clear();
                                               provinceTextField.clear();
                                               phoneNumberTextField.clear();
                                               insertPlayerButton.setDisable(true);
                                           }
                                       }
        );


/*
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent evt) {
                        playerAndGameQueries.close();  // close database connection
                        System.exit(0);
                    }
                }
        );*/

        //setVisible(true);


    }

    //handles call when previousButton is clicked
    private void previousButtonActionPerformed(ActionEvent evt) {
        currentEntryIndex--;
        if (currentEntryIndex < 0)
            currentEntryIndex = numberOfEntries - 1;

        indexTextField.setText("" + (currentEntryIndex + 1));
        indexTextFieldActionPerformed(evt);
    }


    // handles call when nextButton is clicked
    private void nextButtonActionPerformed(ActionEvent evt) {
        currentEntryIndex++;

        if (currentEntryIndex >= numberOfEntries)
            currentEntryIndex = 0;

        indexTextField.setText("" + (currentEntryIndex + 1));
        indexTextFieldActionPerformed(evt);
    }


    // handles call when a new value is entered in indexTextField
    private void indexTextFieldActionPerformed(ActionEvent evt) {

        currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);

        if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries) {
            currentEntry = allEntries.get(currentEntryIndex);
            gameIdTextField.setText("" + currentEntry.getGameId());
            gameTitleTextField.setText("" + currentEntry.getGameTitle());
            playerIdField.setText("" + currentEntry.getPlayerId());
            firstNameTextField.setText("" + currentEntry.getFirstName());
            lastNameTextField.setText("" + currentEntry.getLastName());
            addressTextField.setText("" + currentEntry.getAddress());
            postalCodeTextField.setText("" + currentEntry.getPostalCode());
            provinceTextField.setText("" + currentEntry.getProvince());
            phoneNumberTextField.setText("" + currentEntry.getPhoneNumber());
            datePicker.getEditor().toString();
            scoreTextField.setText("" + currentEntry.getScore());
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryIndex + 1));

        }
    }

    // handles call when browsebutton is clicked
    private void browseButtonActionPerformed(ActionEvent evt) {

        try {

            allEntries = playerAndGameQueries.getAllList();
            numberOfEntries = allEntries.size();

            if (numberOfEntries != 0) {
                currentEntryIndex = 0;
                currentEntry = allEntries.get(currentEntryIndex);
                gameIdTextField.setText("" + currentEntry.getGameId());
                gameTitleTextField.setText("" + currentEntry.getGameTitle());
                playerIdField.setText("" + currentEntry.getPlayerId());
                firstNameTextField.setText("" + currentEntry.getFirstName());
                lastNameTextField.setText("" + currentEntry.getLastName());
                addressTextField.setText("" + currentEntry.getAddress());
                postalCodeTextField.setText("" + currentEntry.getPostalCode());
                provinceTextField.setText("" + currentEntry.getProvince());
                phoneNumberTextField.setText("" + currentEntry.getPhoneNumber());
                datePicker.getEditor().toString();
                scoreTextField.setText("" + currentEntry.getScore());
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" + (currentEntryIndex + 1));

                nextButton.setDisable(false);
                previousButton.setDisable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // updatePlayerIdComboBox eventhandler to hold playerId
    private void updatePlayerIdComboBox(ActionEvent evt){

        int[] playerIdArray = playerAndGameQueries.getPlayerById();

        try {

            for (int playerId : playerIdArray)
                queryPlayerIdComboBox.getItems().addAll(playerId);

            // eventHandler to hold gameIds played by an individual player
            queryPlayerIdComboBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent evt) {
                            queryGameIdComboBox.getItems().clear();
                            int pId = (int)queryPlayerIdComboBox.getValue();
                            int[] gameArray = playerAndGameQueries.getAllGamesOfAPlayer(pId);

                            for (int gameId : gameArray){
                                queryGameIdComboBox.getItems().addAll(gameId);}
                        }
                    }
            );


        }catch (Exception e){
            e.printStackTrace();
        }

    }


    // handles call when insertButton is clicked
    private void insertButtonActionPerformed(ActionEvent evt) {
        int result = playerAndGameQueries.insertIntoPlayerAndGame(
                Integer.parseInt(playerIdField.getText()),
                Integer.parseInt(gameIdTextField.getText()),datePicker.getValue().toString(),
                scoreTextField.getText());

        if (result == 1) {

            errorAlert.setHeaderText("New entry added!");
            errorAlert.setContentText("New player and game added successfully");
            errorAlert.showAndWait();
        }

        else{
             errorAlert.setHeaderText("Error!");
             errorAlert.setContentText("Player and game not added!");
             errorAlert.showAndWait();
        }

        browseButtonActionPerformed(evt);

    }

    // handles call when insertGameButton is clicked

    private void insertGameButtonActionPerformed(ActionEvent evt) {
        int result = playerAndGameQueries.insertIntoGame(Integer.parseInt(gameIdTextField.getText()),
                gameTitleTextField.getText());

        if (result == 1) {
            errorAlert.setHeaderText("New game added!");
        errorAlert.setContentText("New game added successfully");
        errorAlert.showAndWait();
        }

        else{
        errorAlert.setHeaderText("Error!");
        errorAlert.setContentText("Game not added!");
        errorAlert.showAndWait();}

        browseButtonActionPerformed(evt);

    }

    //  handles call when insertPlayerButton is clicked

    private void insertPlayerButtonActionPerformed(ActionEvent evt) {
        int result = playerAndGameQueries.insertIntoPlayer(Integer.parseInt(playerIdField.getText()),
                firstNameTextField.getText(),lastNameTextField.getText(),
                addressTextField.getText(),postalCodeTextField.getText(),
                provinceTextField.getText(),phoneNumberTextField.getText());

        if (result == 1) {
            errorAlert.setHeaderText("New player added!");
        errorAlert.setContentText("New player added successfully");
        errorAlert.showAndWait();
        }

        else{
        errorAlert.setHeaderText("Error!");
        errorAlert.setContentText("Player not added!");
        errorAlert.showAndWait();}

        browseButtonActionPerformed(evt);

    }


    // handles call when updateButton is clicked
    private void updateButtonActionPerformed(ActionEvent evt) {

        int result = playerAndGameQueries.updatePlayerAndGame(
                Integer.parseInt(playerIdField.getText()),
                firstNameTextField.getText(), lastNameTextField.getText(),
                addressTextField.getText(), postalCodeTextField.getText(),
                provinceTextField.getText(), phoneNumberTextField.getText(),
                Integer.parseInt(gameIdTextField.getText()), gameTitleTextField.getText(),
                datePicker.getValue().toString(),scoreTextField.getText());

        if (result == 1) {
            errorAlert.setHeaderText("Information updated!");
        errorAlert.setContentText("Information updated successfully");
        errorAlert.showAndWait();}

        else{
        errorAlert.setHeaderText("Error!");
        errorAlert.setContentText("PInformation not updated!");
        errorAlert.showAndWait();
         }
    }

    // deleteButton action handler
    private void deleteButtonActionPerformed(ActionEvent evt) {

        int result = playerAndGameQueries.deletePlayerAndGame(Integer.parseInt(playerIdField.getText()),
                Integer.parseInt(gameIdTextField.getText()));

        if (result == 1) {
            errorAlert.setHeaderText("Player and game deleted!");
        errorAlert.setContentText("Player and game deleted successfully");
        errorAlert.showAndWait();}

        else{
        errorAlert.setHeaderText("Error!");
        errorAlert.setContentText("Player and game not deleted!");
        errorAlert.showAndWait();
        }
    }


    // deleteGameButton Action handler
    private void deleteGameButtonActionPerformed(ActionEvent evt) {

        int result = playerAndGameQueries.deleteGame(Integer.parseInt(gameIdTextField.getText()));

        if (result == 1) {
            errorAlert.setHeaderText("Game deleted!");
        errorAlert.setContentText("Game deleted successfully");
        errorAlert.showAndWait();
        }

        else{
        errorAlert.setHeaderText("Error!");
        errorAlert.setContentText("Game not deleted!");
        errorAlert.showAndWait();
        }
    }

    // deletePlayerButton Action handler
    private void deletePlayerButtonActionPerformed(ActionEvent evt) {

        int result = playerAndGameQueries.deletePlayer(Integer.parseInt(playerIdField.getText()));

        if (result == 1) {
            errorAlert.setHeaderText("Player deleted!");
        errorAlert.setContentText("Player deleted successfully");
        errorAlert.showAndWait();
        }

        else{
        errorAlert.setHeaderText("Error!");
        errorAlert.setContentText("Player not deleted!");
        errorAlert.showAndWait();
        }
    }

    // method to reset the components when necessary
    public void resetAllComponents(){
        gameIdTextField.clear();
        gameTitleTextField.clear();
        playerIdField.clear();
        firstNameTextField.clear();
        lastNameTextField.clear();
        addressTextField.clear();
        postalCodeTextField.clear();
        provinceTextField.clear();
        phoneNumberTextField.clear();
        playingDateTextField.clear();
        datePicker.setValue(null);
        scoreTextField.clear();
    }



}//end of displayPlayerAndGameInfo class