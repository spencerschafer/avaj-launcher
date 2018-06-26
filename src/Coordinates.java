public class Coordinates {
    private int latitude;
    private int longitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    //parameters are the values that it needs to add to the already existing values
    public void changeCoordinates(int longitude, int latitude, int height) {
        this.latitude += longitude;
        this.latitude += latitude;
        this.height += height;
    }

    public void setUpperLimit() {
        this.height = 100;
    }

    //checks if height is below or equal to zero, otherwise it checks if it is above 100
    public int checkHeight() {
        if (this.height <= 0) {
            return (-1);
        } else if (this.height > 100) {
            return (1);
        }
        return (0);
    }
}
