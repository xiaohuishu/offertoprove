

    package cn.march.algo.array;

    import java.util.HashSet;
    import java.util.Set;

    /**
     * Created by antsmarth on 15-8-31.
     *
     * 问题描述：
     *
     *      给定一个二维数组：
     *              1 2 3 4
     *              3 2 2 6
     *              1 3 2 7
     *              1 5 2 9
     *      和数组维度n = 4,指定初始坐标(x, y) --> (1, 1);
     *      输出(x, y)相连续且与(x, y)实际值想等的序列
     *      如下：
     *           2
     *           2 2
     *             2
     *             2
     *      则输出： (1, 1) (0, 1) (1, 2) (2, 2) (3,2)
     *
     *
     */
    public class Find_ConnectedOfArrays {

        //测试方法
        public static void main(String[] args) {

            int[][] arrays = new int[][]{ {1,2,3,4} , {3,2,2,6} , {1,3,2,7}, {1,5,2,9}};
            find_ConnectedOfArrays(arrays, 4, 1, 1);

        }


        /**
         * 递归实现：
         *      设置一个Set集合存放与(x,y)相同值的不同坐标点
         *      对于数组每个元素进行其周围上下左右相邻元素进行判断：
         *          若值想等,判断set集合中是否存在此坐标点
         *              若存在,则不做处理
         *              若不存在,输出其坐标并且将点加入到Set集合中
         *
         * @param arrays
         * @param n
         * @param x
         * @param y
         */
        private static void find_ConnectedOfArrays(int[][] arrays, int n, int x, int y) {

            //进行边界处理
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

                //制定坐标点
                int value = arrays[x][y];

                //Set集合
                Set<Integer[]> sets = new HashSet<>(n*n);

                System.out.println("初始坐标: (" + x + ", " + y + ")");

                //加载初始化点
                sets.add(new Integer[]{x, y});

                find_ElementsOfArrays(arrays, n, x, y, value, sets);

            }



        }

        private static void find_ElementsOfArrays(int[][] arrays,int n, int x, int y,int value, Set<Integer[]> sets) {

                //对x,y坐标点 左相邻节点进行判断处理
                if(x-1 >= 0)

                    if (arrays[x - 1][y] == value && !isContains(sets, x-1, y)) {
                        System.out.println("(" + (x - 1) + ", " + y + ")");
                        sets.add(new Integer[]{x-1, y});
                        find_ElementsOfArrays(arrays, n, x - 1, y, value, sets);
                    }

                //对x,y坐标点 右相邻节点进行判断处理
                if(x+1 < n)

                    if(arrays[x + 1][y] == value && !isContains(sets, x+1, y)) {
                        System.out.println("(" + (x + 1) + ", " + y + ")");
                        sets.add(new Integer[]{x+1, y});
                        find_ElementsOfArrays(arrays, n, x + 1, y, value, sets);
                    }

                //对x,y坐标点 上相邻节点进行判断处理
                if(y-1 >= 0)

                    if(arrays[x][y-1] == value && !isContains(sets, x, y-1)) {
                        System.out.println("(" + x + ", " + (y - 1) + ")");
                        sets.add(new Integer[]{x, y-1});
                        find_ElementsOfArrays(arrays, n, x, y - 1, value, sets);
                    }

               //对x,y坐标点 下相邻节点进行判断处理
               if(y+1 < n)

                   if (arrays[x][y + 1] == value && !isContains(sets, x, y + 1)) {
                       System.out.println("(" + x + ", " + (y + 1) + ")");
                       sets.add(new Integer[]{x, y + 1});
                       find_ElementsOfArrays(arrays, n, x, y + 1, value, sets);
                   }

        }


        /**
         * 判断set集合中是否包含x,y结点
         * @param sets
         * @param x
         * @param y
         * @return
         */
        private static boolean isContains(Set<Integer[]> sets, int x, int y) {

            for(Integer[] array : sets) {

                if(array[0] == x && array[1] == y)
                    return true;

            }

            return false;

        }

    }
