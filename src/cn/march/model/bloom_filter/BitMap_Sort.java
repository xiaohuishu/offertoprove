package cn.march.model.bloom_filter;

/**
 * Created by antsmarth on 15-8-25.
 *
 * 问题描述：
 *
 *      利用位图(bitMap)对数组进行排序：
 *      位图：
 *          简单来讲就是数组存放数据，若存在这个数据则将值置为1或者true
 *          比如现在有数组int[]{4,3,2,6} 利用位图来进行存储的话：
 *          arrays[2] = 1, arrays[3] = 1, arrays[4] = 1, arrays[6] = 1
 *          这样可以通过数组index表示值，1代表其值存在
 *
 *
 */
public class BitMap_Sort {


    //测试方法
    public static void main(String[] args) {

        int[] arrays = new int[]{4,3,2,9,8,10,12};

        bitmap_sort(arrays);

        for(int array : arrays)
            System.out.print(array + " ");

    }

    /**
     * 基本思路：
     *
     *      首先计算数组的最值：max和min
     *      通过max-min+1计算得到位图数组的实际容量new int[max-min+1]
     *      通过arrays的值对bit_arrays进行初始化;
     *      考虑到arrays的值存在负数，比如：{1,4,-3,2}
     *      最小值是-3,所以在对bit_arrays计算的时候：
     *             for(int array : arrays)
     *                  bit_arrays[array-min]++;
     *      这样就消除了负数的影响i
     *      之后就根据位图来排序arrays
     *
     * @param arrays
     */
    public static void bitmap_sort(int[] arrays) {

        int max = arrays[0];
        int min = max;

        //求arrays的最值
        for(int array : arrays) {

            if(max < array)
                max = array;

            if(min > array)
                min = array;

        }


        //对bit_arrays位图数组进行初始化
        int[] bit_arrays = new int[max-min+1];

        for(int array : arrays)
            bit_arrays[array-min]++;

        int index = 0;

        //对arrays进行排序;
        for(int i = 0; i < bit_arrays.length; i++) {

            while(bit_arrays[i] > 0) {

                arrays[index] = i + min;
                index++;
                bit_arrays[i]--;

            }

        }

    }

}
