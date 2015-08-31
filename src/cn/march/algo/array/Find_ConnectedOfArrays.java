package cn.march.algo.array;

/**
 * Created by antsmarth on 15-8-31.
 */
public class Find_ConnectedOfArrays {



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


            find_ElementsOfArrays(arrays,n, x, y, value, booleans);

        }



    }



    private static void find_ElementsOfArrays(int[][] arrays,int n, int x, int y,int value, boolean[] booleans) {
            if(x-1 > 0)
                if (arrays[x - 1][y] == value && booleans[0]) {
                    System.out.println("(" + (x - 1) + ", " + y + ")");
                    find_ElementsOfArrays(arrays,n, x-1, y, value, booleans);
                }
                else
                    booleans[0] = false;

            if(x+1 < n)
                if(arrays[x + 1][y] == value && booleans[1]) {
                    System.out.println("(" + (x + 1) + ", " + y + ")");
                    find_ElementsOfArrays(arrays,n, x+1, y,value, booleans);
                }
                else
                    booleans[1] = false;

            if(y-1 > 0)
                if(arrays[x][y-1] == value && booleans[2]) {
                    System.out.println("(" + x + ", " + (y - 1) + ")");
                    find_ElementsOfArrays(arrays,n, x, y-1, value, booleans);
                }
                else
                    booleans[2] = false;
            if(y+1 < n)
                if(arrays[x][y+1] == value && booleans[3]) {
                    System.out.println("(" + x + ", " + (y + 1) + ")");
                    find_ElementsOfArrays(arrays,n, x, y+1,value, booleans);
                }
                else
                    booleans[3] = false;



    }

}
