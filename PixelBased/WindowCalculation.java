package Truss.PixelBased;
import java.util.ArrayList;
import java.util.List;

public class WindowCalculation {
  //  public int[][] desktop = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
    public int[][] desktop = new int[1024][768]; // 786432
    public List<Window> calculateWindow(List<Rectangle> orderedList){
        List<Window> windows = new ArrayList();
        int x1, y1, x2, y2;
        for(int i = 0; i < orderedList.size(); i++){
            int index = i + 1;
            x1 = orderedList.get(i).topLeftX;
            y1 = orderedList.get(i).topLeftY;
            x2 = orderedList.get(i).bottomRightX;
            y2 = orderedList.get(i).bottomRightY;
            List<Integer> xCoordinates = new ArrayList <>();
            List<Integer> yCoordinates = new ArrayList <>();
            for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    if(desktop[x][y] == 0){
                        desktop[x][y] = index;
                        xCoordinates.add(x);
                        yCoordinates.add(y);
                    }
                }
            }
            windows.add(new Window(xCoordinates, yCoordinates));
        }
        return windows;
    }
    public static void main(String[] arg){
        List<Rectangle> orderedList = new ArrayList();
        Rectangle r1 = new Rectangle(2,2,4,4);
        //  Rectangle r2 = new Rectangle(2,2,4,0);
        Rectangle r2 = new Rectangle(3,3,5,5);
        Rectangle r3 = new Rectangle(4,3,6,5);
        orderedList.add(r1);
        orderedList.add(r2);
        orderedList.add(r3);
        List<Window> windows =  new WindowCalculation().calculateWindow(orderedList);

    }

}
