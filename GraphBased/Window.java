package Truss.GraphBased;

import java.util.List;

public class Window {
    List<Rectangle> components;
    Window(List<Rectangle> list){
        this.components = list;
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
//class Ractangle{
//    double topLeftX, topLeftY = 0;
//    double width;
//    double height;
//    Ractangle(double x, double y, double width, double height){
//        this.topLeftX = x;
//        this.topLeftY = y;
//        this.width = width;
//        this.height = height;
//    }
//}
