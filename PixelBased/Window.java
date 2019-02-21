package Truss.PixelBased;
import java.util.List;

/*
* For java array, the longest length is 2 to the 31 (32 bits signed integer), 2000,000,000
* Typical desktop has window size as 1024×768 pixels, 786432
*
* */
public class Window {
    List<Integer> xCoordinates, yCoordinates;
    Window(List<Integer> xCoordinates, List<Integer> yCoordinates){
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }
}

class Rectangle{
    int topLeftX, topLeftY, bottomRightX, bottomRightY;
    Rectangle(int x1, int y1, int x2, int y2){
        this.topLeftX = x1;
        this.topLeftY = y1;
        this.bottomRightX = x2;
        this.bottomRightY = y2;
    }
}
