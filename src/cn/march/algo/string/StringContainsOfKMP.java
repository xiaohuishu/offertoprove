package cn.march.algo.string;

/**
 * Created by antsmarth on 15-8-29.
 */
public class StringContainsOfKMP {

    public static void main(String [] args) {

        System.out.println(stringContainsOfKMP("shuxiaohui@gmail.com", "iaohui1", 20, 7));

    }



    private static boolean stringContainsOfKMP(String origin_string, String contain_string, int origin_length, int contain_length) {

        if(origin_length <= 0 || contain_length <= 0 || origin_string == null || contain_string == null)
            throw new RuntimeException("设置参数不正确!");

        char [] origin_chars = origin_string.toCharArray();
        char [] contain_chars = contain_string.toCharArray();

        if(origin_length == 1 && contain_length == 1)
            if(origin_chars[0] == contain_chars[0])
                return true;

        if(origin_length > 1 && contain_length == 1)
            for(int i = 0; i < origin_length; i++)
                if(origin_chars[i] == contain_chars[0])
                    return true;
        if(origin_length == 1 && contain_length > 1)
            return false;


        int i = 0;
        int j = 0;

        boolean flag = true;


        /**
         * 传统的移位循环方式
         */
        /* while(i < origin_length && j < contain_length) {

            if(origin_chars[i] == contain_chars[j]) {
                i++;
                j++;
                flag = true;
            }else {
                i++;
                j=0;
                flag = false;
            }
        } */

        int k = 0;

        while (i < origin_length && j < contain_length) {

            if(origin_chars[i] == contain_chars[j]) {
                i++;
                j++;
                k++;
                flag = true;
            }else {

                if(k == 0)
                    i++;
                else {
                    System.out.println(k);
                    int kmp_index = caculKmp_Index(contain_chars, k);
                    i = i + k - kmp_index;
                }

                j=0;
                k=0;
                flag = false;

            }

        }

        if(j != contain_length)
            return false;

        return flag;

    }


    private static int caculKmp_Index(char[] contain_chars, int k) {

        int index = 0;
        char [][] fornt_chars = new char[k-1][];
        char [][] last_chars = new char[k-1][];

        for(int i = 0; i < k-1; i++) {

            fornt_chars[i] = new char[i+1];
            last_chars[k-i-2] = new char[k-i-1];

            for(int j = 0; j < i+1; j++)
                fornt_chars[i][j] = contain_chars[j];

            for (int s = i + 1; s < k; s++)
                last_chars[k-i-2][s-i-1] = contain_chars[s];
        }

        for(char[] chars : fornt_chars) {

            for(char[] chars_last: last_chars)
                if(chars == chars_last)
                    //System.out.println(chars);
                    index = chars.length;

        }


        for(int j = 0; j < fornt_chars.length; j++) {

            System.out.print(String.valueOf(fornt_chars[j]) + " ");

        }

        System.out.println();

        for (int j = 0; j < last_chars.length; j++) {

            System.out.print(String.valueOf(last_chars[j]) + " ");

        }

        return index;
    }


}
