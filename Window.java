package Truss;

import java.util.List;

public class Window {
    List<Rectangle> components;
    Window(List<Rectangle> list){
        this.components = list;
    }
}
//
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

class Rectangle{
    double topLeftX, topLeftY, bottomRightX, bottomRightY;

    Rectangle(double x1, double y1, double x2, double y2){
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
