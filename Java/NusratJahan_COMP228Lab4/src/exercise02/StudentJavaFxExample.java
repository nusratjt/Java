package exercise02;

// import classes and interfaces used by StudentJavaFxExample Class
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

// StudentJavaFxExample class starts that extends Application class
public class StudentJavaFxExample extends Application{

    // instance variables for labels
    private final Label label_Name = new Label("Name");
    private final Label label_Address = new Label("Address");
    private final Label label_Province = new Label("Province");
    private final Label label_City = new Label("City");
    private final Label label_PostalCode = new Label("Postal Code");
    private final Label label_PhoneNumber = new Label("Phone Number");
    private final Label label_Email = new Label("Email");

    // labels for academic purpose
    private final Label label_CheckBtn = new Label("Extra-curricular Activity");
    private final Label label_RadioBtn = new Label("Select a program");
    private final Label label_Combobox = new Label("Coursers");

    // instance variables for textbox
    private final TextField textField_Name = new TextField();
    private final TextField textField_Address = new TextField();
    private final TextField textField_Province = new TextField();
    private final TextField textField_City = new TextField();
    private final TextField textField_PostalCode = new TextField();
    private final TextField textField_PhoneNumber = new TextField();
    private final TextField textField_Email = new TextField();

    // instance variables for check box
    private final CheckBox checkBox_StdCouncil = new CheckBox("Student Council");
    private final CheckBox checkBox_volWork = new CheckBox("Volunteer Work");


    // instance variables for radiobutton
    private final RadioButton radioButton_CScience = new RadioButton("Computer Science");
    private final RadioButton radioButton_Business = new RadioButton("Business");

    // instance variables for holding courses of computer science and business
    String[] cScienceCourses = {"Programming I", "Programming II","Java","Web Interface Design","Database","Methodology"};
    String[] businessCourses = {"Accounting","Marketing","Finance","Management","Statistics","Business"};

    // instance variables for ToggleGroup
    private final ToggleGroup toggleGroup= new ToggleGroup();

    // instance variables for JComboBox
    private ComboBox<String> comboBox_Courses = new ComboBox<String>();
    private final ListView<String> listView_Courses = new ListView<>();

    // create a list to hold the courses
    private List<String> selectedCourses = new ArrayList<>();

    // instance variable to convert the collection list to array of Strings
    String[] coursesArray;

    // button to display student Information
    private final Button button_display = new Button("Display");

    // text area
    private final TextArea textArea_Display = new TextArea();



    // main method
    public static void main(String[] args){
        // create a StudentJavaFxExample object and call its start method
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        //create Border pane to hold other gridPane and borderPane
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setBorder(Border.EMPTY);
        pane.setStyle("-fx-background-color: black");

        // add the border pane to the scene
        Scene appScene = new Scene(pane,800,700);

        // creating more panes
        GridPane pane_PersonalInfo = new GridPane();
        GridPane pane_AcademicInfo = new GridPane();
        BorderPane pane_TextArea = new BorderPane();

        // adding the pane in the main Borderpane
        pane.setTop(pane_PersonalInfo);
        pane.setCenter(pane_AcademicInfo);
        pane.setBottom(pane_TextArea);

        // calling the methods
        addPComponentsToPane(pane_PersonalInfo);
        addAComponentsToPane(pane_AcademicInfo);
        addtextAreaToPane(pane_TextArea);

        // Application setup
        primaryStage.setTitle("Student Information - Using JavaFx");
        // add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
    }


       //method to add Personal information components to panel

    public void addPComponentsToPane(GridPane pane_Personal){

        // set layout, background and border of the panel_PersonalInfo
        pane_Personal.setPadding(new Insets(20,10,20,30));
        pane_Personal.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        BorderPane.setMargin(pane_Personal,new Insets(0,0,10,0));
        pane_Personal.setHgap(200);
        pane_Personal.setVgap(10);
        pane_Personal.setStyle("-fx-background-color: lightgray");



        // place components into pane
        pane_Personal.add(label_Name,0,0);
        label_Name.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        pane_Personal.add(textField_Name,1,0);
        textField_Name.setMinWidth(400);
        textField_Name.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        pane_Personal.add(label_Address,0,1);
        label_Address.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        pane_Personal.add(textField_Address,1,1);
        textField_Address.setMinWidth(400);
        textField_Address.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));


        pane_Personal.add(label_City,0,2);
        label_City.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        pane_Personal.add(textField_City,1,2);
        textField_City.setMinWidth(400);
        textField_City.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        pane_Personal.add(label_Province,0,3);
        label_Province.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        pane_Personal.add(textField_Province,1,3);
        textField_Province.setMinWidth(400);
        textField_Province.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        pane_Personal.add(label_PostalCode,0,4);
        label_PostalCode.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        pane_Personal.add(textField_PostalCode,1,4);
        textField_PostalCode.setMinWidth(400);
        textField_PostalCode.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        pane_Personal.add(label_PhoneNumber,0,5);
        label_PhoneNumber.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        pane_Personal.add(textField_PhoneNumber,1,5);
        textField_PhoneNumber.setMinWidth(400);
        textField_PhoneNumber.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        pane_Personal.add(label_Email,0,6);
        label_Email.setFont(Font.font("sans-serif",FontWeight.BLACK,13));

        pane_Personal.add(textField_Email,1,6);
        textField_Email.setMinWidth(400);
        textField_Email.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

    }

    //method to add Academic information components to panel

    public void addAComponentsToPane(GridPane pane_Academic){

        // set layout, background and border of the panel_AcademicInfo
        pane_Academic.setPadding(new Insets(10,10,10,30));
        pane_Academic.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        BorderPane.setMargin(pane_Academic,new Insets(0,0,10,0));
        pane_Academic.setHgap(100);
        pane_Academic.setVgap(10);
        pane_Academic.setStyle("-fx-background-color: lightgray");



        // adding checkbox and label to the pane
        pane_Academic.add(label_CheckBtn,0,0);
        label_CheckBtn.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        pane_Academic.add(checkBox_StdCouncil,1,0);
        checkBox_StdCouncil.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        pane_Academic.add(checkBox_volWork,2,0);
        checkBox_volWork.setFont(Font.font("sans-serif",FontWeight.BLACK,13));


        // adding radiobuttons to the Toggle group
        radioButton_CScience.setToggleGroup(toggleGroup);
        radioButton_Business.setToggleGroup(toggleGroup);

        // adding radiobuttons to the pane
        pane_Academic.add(label_RadioBtn,0,1);
        label_RadioBtn.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        pane_Academic.add(radioButton_CScience,1,1);
        radioButton_CScience.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        pane_Academic.add(radioButton_Business,2,1);
        radioButton_Business.setFont(Font.font("sans-serif",FontWeight.BLACK,13));


        // adding comboBox and listView to the panel
        pane_Academic.add(label_Combobox,0,2);
        label_Combobox.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        pane_Academic.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        pane_Academic.add(comboBox_Courses,1,2);
        comboBox_Courses.setMinWidth(200);
        comboBox_Courses.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        pane_Academic.add(listView_Courses,2,2);
        listView_Courses.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));


        // EventHandler for radioButton_CScience, if it is pressed computer science courses are shown in comboBox
        radioButton_CScience.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                comboBox_Courses.getItems().clear();

                for(String courses : cScienceCourses){
                    comboBox_Courses.getItems().addAll(courses);
                }

            }
        });

        // EventHandler for radioButton_Business, if it is pressed business courses are shown in comboBox
        radioButton_Business.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                comboBox_Courses.getItems().clear();

                for(String courses : businessCourses){
                    comboBox_Courses.getItems().addAll(courses);
                }

            }
        });

        // EventHandler for comboBox, if an item is selected that is shown in listView
        comboBox_Courses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // getting selected course
                String selectedCourse = comboBox_Courses.getValue().toString();

                // course adds to the list view if it does not already exit in the list view
                if(!selectedCourses.contains(selectedCourse)) {

                    // adding selected course in to collection list "selectedCourses"
                    selectedCourses.add(selectedCourse);

                    // convert the collection list to array list
                    coursesArray = new String[selectedCourses.size()];
                    for (int i = 0; i < coursesArray.length; i++)
                        coursesArray[i] = selectedCourses.get(i);

                    //pass array into the list box
                    listView_Courses.getItems().clear();
                    listView_Courses.getItems().addAll(coursesArray);
                }

            }
        });



        // adding display button to the pane
        pane_Academic.add(button_display,1,3);
        button_display.setFont(Font.font("sans-serif",FontWeight.BLACK,13));
        button_display.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        // Event handler for display button that calls displayInformation method and shows all student information
        button_display.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayInformation();
            }
        });


    }


    // method to add text area to main BorderPane
    public void addtextAreaToPane(BorderPane pane_TextArea) {

        // set layout, background and border of the panel_TextArea
        pane_TextArea.setCenter(textArea_Display);
        pane_TextArea.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(3))));
        pane_TextArea.setStyle("-fx-background-color: lightgray");

    }

    //method to display all the information
    public void displayInformation(){
        String studentInfo = textField_Name.getText()+
                ", " + textField_Address.getText()+
                ", " + textField_City.getText()+
                ", " + textField_Province.getText()+
                ", " + textField_PostalCode.getText()+
                ", " + textField_PhoneNumber.getText()+
                ", " + textField_Email.getText()+ "\n";

        studentInfo += "\nExtra-curricular activities are :  ";

        if(checkBox_StdCouncil.isSelected())
            studentInfo += "Student Council\n";

        if(checkBox_volWork.isSelected())
            studentInfo += "Volunteer Work\n";


        studentInfo += "\nRegistered courses are :\n";
        for (int i = 0; i < coursesArray.length; i++)
            studentInfo += coursesArray[i] + "\n";

        textArea_Display.setText(studentInfo);
        textArea_Display.setFont(Font.font("sans-serif",FontWeight.BLACK,13));


    }


}// StudentJavaFxExample Class ends




