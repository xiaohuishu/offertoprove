package cn.march.model.bloom_filter;

/**
 * Created by antsmarth on 15-8-25.
 */
public class BitMap_Sort {


    public static void main(String[] args) {

        int[] arrays = new int[]{4,3,2,9,8,10,12};

        bitmap_sort(arrays);

        for(int array : arrays)
            System.out.print(array + " ");

    }


    public static void bitmap_sort(int[] arrays) {

        int max = arrays[0];
        int min = max;


        for(int array : arrays) {

            if(max < array)
                max = array;

            if(min > array)
                min = array;

        }


        int[] bit_arrays = new int[max-min+1];

        for(int array : arrays)
            bit_arrays[array-min]++;

        int index = 0;

        for(int i = 0; i < bit_arrays.length; i++) {

            while(bit_arrays[i] > 0) {

                arrays[index] = i + min;
                index++;
                bit_arrays[i]--;

            }

        }





    }

}
