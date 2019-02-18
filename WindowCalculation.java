package Truss;

import java.util.ArrayList;
import java.util.List;
/*
* Say the area of the intersection is width * height, where width is the intersection of the rectangles projected onto the x-axis, and height is the same for the y-axis. We want both quantities to be positive.

The width is positive when min(rec1[2], rec2[2]) > max(rec1[0], rec2[0]), that is when the smaller of (the largest x-coordinates) is larger than the larger of (the smallest x-coordinates). The height is similar.
*
*
* */
public class WindowCalculation {

    public List<Window> calculateWindow(List<Rectangle> orderedList){
        List<Window> windows = new ArrayList();

        for(int i = 0; i < orderedList.size(); i++){
            // from the frontmost window
            List<Rectangle> subimages = new ArrayList();
            subimages.add(orderedList.get(i));
            // iterate through the orderedList reversely
            for(int j = i - 1; j >= 0; j--){
                Rectangle r1 = orderedList.get(j);
                // use newSubimages as a temporary list to store the list of regions after being partitioned by a upper layer rectangle
                List<Rectangle> newSubimages = new ArrayList();
                for(int k = 0; k < subimages.size(); k++){
                    Rectangle overlap= getOverlapArea(r1, subimages.get(k));
                    if(overlap != null){
                       List<Rectangle> partition = getNewWindow(subimages.get(k), overlap);
                        newSubimages.addAll(partition);
                    }
                    else{
                        newSubimages.add(subimages.get(k));
                    }
                }
                subimages = newSubimages;
            }
            windows.add(new Window(subimages));
        }
        return windows;
    }

    public Rectangle getOverlapArea(Rectangle r1, Rectangle r2){
        double topLeftX = Math.max(r1.topLeftX, r2.topLeftX);
        double bottomRightX = Math.min(r1.bottomRightX, r2.bottomRightX);

        double topLeftY = Math.min(r1.topLeftY, r2.topLeftY);
        double bottomRightY = Math.max(r1.bottomRightY, r2.bottomRightY);

        if(topLeftX < bottomRightX && topLeftY > bottomRightY){
            return new Rectangle(topLeftX, topLeftY, bottomRightX, bottomRightY);
        }
        else return null;
    }

    public List<Rectangle> getNewWindow(Rectangle ori, Rectangle overlap){
        List<Rectangle> list = new ArrayList();
        if(overlap.topLeftX > ori.topLeftX){
            // region 1 exist
            list.add(new Rectangle(ori.topLeftX, ori.topLeftY, overlap.topLeftX, ori.bottomRightY));
        }
        if(overlap.topLeftY < ori.topLeftY){
            // region 2 exist
            list.add(new Rectangle(overlap.topLeftX, ori.topLeftY, overlap.bottomRightX, overlap.topLeftY));
        }
        if(overlap.bottomRightY > ori.bottomRightY){
            // region 3 exist
            list.add(new Rectangle(overlap.topLeftX, overlap.bottomRightY, overlap.bottomRightX, ori.bottomRightY));
        }
        if(overlap.bottomRightX < ori.bottomRightX){
            // region 4 exist
            list.add(new Rectangle(overlap.bottomRightX, ori.topLeftY, ori.bottomRightX, ori.bottomRightY));
        }
        return list;

    }

    public static void main(String[] arg){
        List<Rectangle> orderedList = new ArrayList();
        Rectangle r1 = new Rectangle(2,2,4,0);
      //  Rectangle r2 = new Rectangle(2,2,4,0);
        Rectangle r3 = new Rectangle(3,3,5,1);
        Rectangle r2 = new Rectangle(4,4,6,2);
        orderedList.add(r1);
        orderedList.add(r2);
        orderedList.add(r3);
        List<Window> windows =  new WindowCalculation().calculateWindow(orderedList);

    }
}
