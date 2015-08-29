package cn.march.algo.string;

/**
 * Created by antsmarth on 15-8-29.
 */
public class StringContainsOfKMP {

    public static void main(String [] args) {

        System.out.println(stringContainsOfKMP("shuxiaohui", "xiao1", 10, 5));

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

        while(i < origin_length && j < contain_length) {

            if(origin_chars[i] == contain_chars[j]) {

                i++;
                j++;
                flag = true;

            }else {

                i++;
                j=0;
                flag = false;

            }

        }

        return flag;

    }


}
