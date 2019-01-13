package exercise3;

// GameObject class that contains instance variables and methods to get its values
public class GameObject
{
    // private instance variables
    private double xAxis;
    private double yAxis;
    private String center;
    private double velocity;
    private String state;
    private boolean rotation;

    // declaring a constructor with multiple parameters to initialize the variables
    public GameObject(double xAxis,double yAxis , double velocity, String state, boolean rotation)
    {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.velocity = velocity;
        this.state = state;
        this.rotation = rotation;
    }

    //method to set the x-axis of the object
    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    // method to retrieve the value of x-axis from user
    public double getxAxis()
    {
        return xAxis;
    }

    //method to set the y-axis of the object
    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    // method to retrieve the value of y-axis from user
    public double getyAxis() {
        return yAxis;
    }

    public String getCenter()
    {
        return getxAxis()+ ", "+ getyAxis();
    }

    //method to set the velocity of the object
    public void setVelocity(double velocity)
    {
        this.velocity = velocity;
    }

    // method to retrieve the value of velocity variable from user
    public double getVelocity()
    {
        return velocity;
    }

    // method to set state of the object
    public void setState(String state)
    {
        this.state = state;
    }

    // method to set the rotation of the object
    public void setRotation(boolean rotation) {
        this.rotation = rotation;
    }

    // method to retrieve the value of state variable from user
    public String getState()
    {
        return state;
    }

    // method to retrieve the value of rotation variable from user
    public String isRotation()
    {
        return rotation ? "Can rotate" : "Can't rotate";
    }

    // method to get all game object information in a nicely formatted string
    public String getGameObjectInfo()
    {
        return "Game Object Information" + "\n==================================" + "\n\tCenter (x, y): " + getCenter()+
                "\n\tVelocity: " + "   "+ getVelocity()+ "\n\tState (alive or dead): "+ "   "+ getState()+ "\n\tIs the object rotate?: "+ "   " + isRotation();
    }

}//end of GameObject class
