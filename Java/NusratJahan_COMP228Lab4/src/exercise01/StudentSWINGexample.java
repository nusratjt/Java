package exercise01;

// import classes and interfaces used by StudentSWINGexample Class
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.util.List;
import java.util.ArrayList;


// StudentSWINGexample class starts that extends JFrame
public class StudentSWINGexample extends JFrame{

    // instance variables for labels
    private final JLabel jLabel_Name = new JLabel("Name");
    private final JLabel jLabel_Address = new JLabel("Address");
    private final JLabel jLabel_Province = new JLabel("Province");
    private final JLabel jLabel_City = new JLabel("City");
    private final JLabel jLabel_PostalCode = new JLabel("Postal Code");
    private final JLabel jLabel_PhoneNumber = new JLabel("Phone Number");
    private final JLabel jLabel_Email = new JLabel("Email");

    // labels for academic purpose
    private final JLabel jLabel_CheckBtn = new JLabel("Extra-curricular Activity");
    private final JLabel jLabel_RadioBtn = new JLabel("Select a program");
    private final JLabel jLabel_Combobox = new JLabel("Coursers");

    // instance variables for textbox
    private final JTextField jTextField_Name = new JTextField(25);
    private final JTextField jTextField_Address = new JTextField(25);
    private final JTextField jTextField_Province = new JTextField(25);
    private final JTextField jTextField_City = new JTextField(25);
    private final JTextField jTextField_PostalCode = new JTextField(25);
    private final JTextField jTextField_PhoneNumber = new JTextField(25);
    private final JTextField jTextField_Email = new JTextField(25);

    // instance variables for check box
    private final JCheckBox jCheckBox_StdCouncil = new JCheckBox("Student Council");
    private final JCheckBox jCheckBox_volWork = new JCheckBox("Volunteer Work");


    // instance variables for radiobutton
    private final JRadioButton jRadioButton_CScience = new JRadioButton("Computer Science");
    private final JRadioButton jRadioButton_Business = new JRadioButton("Business");

    // instance variables for holding courses of computer science and business
    String[] cScienceCourses = {"","Programming I", "Programming II","Java","Web Interface Design","Database","Methodology"};
    String[] businessCourses = {"","Accounting","Marketing","Finance","Management","Statistics","Business"};

    // instance variables for buttongroup
    private final ButtonGroup buttonGroup = new ButtonGroup();

    // instance variables for JComboBox
    private JComboBox<String> jComboBox_Courses = new JComboBox<String>();
    private final JList<String> jList_Courses = new JList<>();

    // create a list to hold the courses
    private List<String> selectedCourses = new ArrayList<>();

    // instance variable to convert the collection list to array of Strings
    String[] coursesArray;

    // button to display student Information
    private final JButton button_display = new JButton("Display");

    // text area
    private final JTextArea textArea_Display = new JTextArea();


    // StudentSWINGexample constructor that adds all the JPanel
    public StudentSWINGexample(){
        super("Student Information - using SWING");

        // create JPanel object
        JPanel panel_WholeFrame = new JPanel();  // main JPanel that holds other JPanels
        JPanel panel_PersonalInfo = new JPanel();
        JPanel panel_AccademicInfo = new JPanel();
        JPanel panel_TextArea = new JPanel();

        //adding main panel to the frame
        add(panel_WholeFrame);

        // adding other panels to the main frame
        panel_WholeFrame.add(panel_PersonalInfo);
        panel_WholeFrame.add(panel_AccademicInfo);
        panel_WholeFrame.add(panel_TextArea);

        // setting main panel layout, background and border
        panel_WholeFrame.setLayout(new GridLayout(3,1,5,5));
        panel_WholeFrame.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_WholeFrame.setBackground(Color.BLACK);

        // calling methods that hold panel and components
        addPComponentsToPanel(panel_PersonalInfo);
        addAComponentsToPanel(panel_AccademicInfo);
        addJTextBoxToPanel(panel_TextArea);

    }

    //method to add Personal information components to panel
    public void addPComponentsToPanel(JPanel panel){

        // set layout, background and border of the panel_PersonalInfo
        panel.setLayout(new GridLayout(7,2,0,5));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.gray),"Student-Personal Info"));

        // adding labels and textfields to the panel
        panel.add(jLabel_Name);
        jLabel_Name.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jTextField_Name);
        panel.add(jLabel_Address);
        jLabel_Address.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jTextField_Address);
        panel.add(jLabel_City);
        jLabel_City.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jTextField_City);
        panel.add(jLabel_Province);
        jLabel_Province.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jTextField_Province);
        panel.add(jLabel_PostalCode);
        jLabel_PostalCode.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jTextField_PostalCode);
        panel.add(jLabel_PhoneNumber);
        jLabel_PhoneNumber.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jTextField_PhoneNumber);
        panel.add(jLabel_Email);
        jLabel_Email.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jTextField_Email);

    }


    //method to add Academic information components to panel
    public void addAComponentsToPanel(JPanel panel){

        // set layout, background and border of the panel_AcademicInfo
        panel.setLayout(new GridLayout(4,3,15,15));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.gray),"Student-Academic Info"));


        // adding checkbox and label to the panel
        panel.add(jLabel_CheckBtn);
        jLabel_CheckBtn.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jCheckBox_StdCouncil);
        jCheckBox_StdCouncil.setBackground(Color.LIGHT_GRAY);
        panel.add(jCheckBox_volWork);
        jCheckBox_volWork.setBackground(Color.LIGHT_GRAY);


        // adding radio buttons to the radio group
        buttonGroup.add(jRadioButton_CScience);
        buttonGroup.add(jRadioButton_Business);

        // adding radio buttons to the panel
        panel.add(jLabel_RadioBtn);
        jLabel_RadioBtn.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jRadioButton_CScience);
        jRadioButton_CScience.setBackground(Color.LIGHT_GRAY);
        panel.add(jRadioButton_Business);
        jRadioButton_Business.setBackground(Color.LIGHT_GRAY);

        // adding combo box and jlist to the panel
        panel.add(jLabel_Combobox);
        jLabel_Combobox.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        panel.add(jComboBox_Courses);
        panel.add(jList_Courses);
        jList_Courses.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));


        // add a scroll bar to JList component
        JScrollPane listScroller = new JScrollPane();
        listScroller.setViewportView(jList_Courses);
        jList_Courses.setLayoutOrientation(JList.VERTICAL);
        panel.add(listScroller);


        // EventHandler for radioButton_CScience, if it is pressed computer science courses are shown in comboBox
        jRadioButton_CScience.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox_Courses.removeAllItems();
                for(String courses : cScienceCourses){
                    jComboBox_Courses.addItem(courses);
                }

            }
        });


        // EventHandler for jRadioButton_Business, if it is pressed business courses are shown in comboBox
        jRadioButton_Business.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jComboBox_Courses.removeAllItems();

                for(String courses : businessCourses){
                    jComboBox_Courses.addItem(courses);
                }

            }
        });

        // EventHandler for comboBox, if an item is selected that is shown in list box
        jComboBox_Courses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                // getting selected course
                String selectedCourse = jComboBox_Courses.getSelectedItem().toString();

                // course adds to the list box if it does not already exit in the list box
                if(!selectedCourses.contains(selectedCourse)) {
                    // adding selected course in to collection list "selectedCourses"
                    selectedCourses.add(selectedCourse);
                    // convert the collection list to array list
                    coursesArray = new String[selectedCourses.size()];
                    for (int i = 0; i < coursesArray.length; i++)
                        coursesArray[i] = selectedCourses.get(i);
                    //pass array into the list box
                    jList_Courses.removeAll();
                    jList_Courses.setListData(coursesArray);
                }

            }
        });



        // adding display button to the panel
        panel.add(button_display);

        // Event Handler ActionListener to display information
        button_display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInformation();
            }
        });


    }


    // Event handler for display button that calls displayInformation method and shows all student information
    public void addJTextBoxToPanel(JPanel panel) {

        // set layout, background and border of the panel_TextArea
        panel.setLayout(new GridLayout(1,1));
        panel.setBackground(Color.LIGHT_GRAY);
        textArea_Display.setForeground(Color.BLACK);
        textArea_Display.setFont(new Font("sans-serif",Font.BOLD,12));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.gray),"Student Information"));

        //add text area field to display all the information
        panel.add(textArea_Display);

    }

    //method to display all the information
    public  void displayInformation(){
        String studentInfo = jTextField_Name.getText()+
                ", " + jTextField_Address.getText()+
                ", " + jTextField_City.getText()+
                ", " + jTextField_Province.getText()+
                ", " + jTextField_PostalCode.getText()+
                ", " + jTextField_PhoneNumber.getText()+
                ", " + jTextField_Email.getText()+ "\n";

        studentInfo += "\nExtra-curricular activities are :  ";
        if(jCheckBox_StdCouncil.isSelected())
            studentInfo += "Student Council\n";
        if(jCheckBox_volWork.isSelected())
            studentInfo += "Volunteer Work\n";

        studentInfo += "\nRegistered courses are :\n";
        for (int i = 0; i < coursesArray.length; i++)
            studentInfo += coursesArray[i] + "\n";


        textArea_Display.setText(studentInfo);

    }


}// StudentSWINGexample class ends
