

package cn.march.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by antsmarth on 15-8-31.
 */
public class Find_ConnectedOfArrays {


    public static void main(String[] args) {

        int[][] arrays = new int[][]{ {1,2,3,4} , {3,2,2,6} , {1,3,2,7}};
        find_ConnectedOfArrays(arrays, 4, 1, 1);

    }



    private static void find_ConnectedOfArrays(int[][] arrays, int n, int x, int y) {

        if(arrays == null || n == 0)
            throw new RuntimeException("设置参数不合法...");

        if(n == 1) {
            if (x == 0 && y == 0)
                System.out.println("(" + x + ", " + y + ")");
            else
                throw new RuntimeException("设置坐标越界...");
        }else {

            if(x > n-1 || y > n-1)
                throw new RuntimeException("设置坐标越界...");

            int value = arrays[x][y];

            boolean [] booleans = new boolean[]{true, true, true, true};

            Map<Integer, Integer> maps = new HashMap<Integer, Integer>(n*n);

            System.out.println("初始坐标: (" + x + ", " + y + ")");

            maps.put(x, x+y);

            find_ElementsOfArrays(arrays, n, x, y, value, booleans, maps);

        }



    }

    private static void find_ElementsOfArrays(int[][] arrays,int n, int x, int y,int value, boolean[] booleans, Map<Integer,Integer> maps) {

            if(x-1 > 0)
                if (arrays[x - 1][y] == value && booleans[0] && !maps.containsValue((x-1)+y)) {
                    System.out.println("(" + (x - 1) + ", " + y + ")");
                    find_ElementsOfArrays(arrays,n, x-1, y, value, booleans, maps);
                }
                else
                    booleans[0] = false;

            if(x+1 < n)
                if(arrays[x + 1][y] == value && booleans[1] && !maps.containsValue((x+1)+y)) {
                    System.out.println("(" + (x + 1) + ", " + y + ")");
                    find_ElementsOfArrays(arrays,n, x+1, y,value, booleans, maps);
                }
                else
                    booleans[1] = false;

            if(y-1 > 0)
                if(arrays[x][y-1] == value && booleans[2] && !maps.containsValue(x+(y-1))) {
                    System.out.println("(" + x + ", " + (y - 1) + ")");
                    find_ElementsOfArrays(arrays,n, x, y-1, value, booleans, maps);
                }
                else
                    booleans[2] = false;
            if(y+1 < n)
                if(arrays[x][y+1] == value && booleans[3] && !maps.containsValue(x+(y+1))) {
                    System.out.println("(" + x + ", " + (y + 1) + ")");
                    find_ElementsOfArrays(arrays,n, x, y+1,value, booleans, maps);
                }
                else
                    booleans[3] = false;



    }

}
