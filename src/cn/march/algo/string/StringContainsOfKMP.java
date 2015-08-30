



    package cn.march.algo.string;

    /**
     * 问题描述：
     *
     *      匹配字符串
     *
     *      基本解决思路：
     *             1.传统的移位循环方式
     *             2.KMP
     *
     * Created by antsmarth on 15-8-29.
     *
     */
    public class StringContainsOfKMP {

        //测试方法
        public static void main(String [] args) {

            System.out.println(stringContainsOfKMP("shuxiaohui@gmail.com", "iaohui1", 20, 7));

        }


        /**
         * 基本思路：
         *
         *      1.首先对传入的查找字符串contain_string与匹配字符串origin_string进行边界处理
         *      2.
         *
         * @param origin_string
         * @param contain_string
         * @param origin_length
         * @param contain_length
         * @return
         */
        private static boolean stringContainsOfKMP(String origin_string, String contain_string, int origin_length, int contain_length) {

            //边界处理
            if(origin_length <= 0 || contain_length <= 0 || origin_string == null || contain_string == null)
                throw new RuntimeException("设置参数不正确!");

            //先转换成char数组进行操作
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


            //i代表origin_string字符串匹配位置
            //j代表contain_string字符串匹配位置
            int i = 0;
            int j = 0;
            //flag代表是否匹配成功
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
            //k代表已匹配成功几个字符
            int k = 0;

            //开始循环匹配查找
            while (i < origin_length && j < contain_length) {
                //若匹配成功,i++,j++,k++,flag=true操作
                if(origin_chars[i] == contain_chars[j]) {
                    i++;
                    j++;
                    k++;
                    flag = true;
                }else {
                    //若匹配不成功,判断k是否为0(即之前没有已匹配成功字符)
                    if(k == 0)
                        i++;
                    else {
                        //开始计算已匹配成功的字符的最大公共字符串字符个数
                        System.out.println(k);
                        int kmp_index = caculKmp_Index(contain_chars, k);
                        i = i + k - kmp_index;
                    }
                    //对j,k,flag进行初始操作
                    j=0;
                    k=0;
                    flag = false;

                }

            }

            if(j != contain_length)
                return false;

            return flag;

        }

        /**
         *
         * 计算已匹配成功字符串的前缀与后缀数组公共字符串的字符数
         *
         * @param contain_chars
         * @param k
         * @return
         */
        private static int caculKmp_Index(char[] contain_chars, int k) {

            //字符数
            int index = 0;
            //声明定义前缀,后缀数组
            char [][] fornt_chars = new char[k-1][];
            char [][] last_chars = new char[k-1][];

            //开始遍历已匹配字符串
            for(int i = 0; i < k-1; i++) {

                fornt_chars[i] = new char[i+1];
                last_chars[k-i-2] = new char[k-i-1];

                //前缀数组计算
                for(int j = 0; j < i+1; j++)
                    fornt_chars[i][j] = contain_chars[j];
                //后缀数组计算
                for (int s = i + 1; s < k; s++)
                    last_chars[k-i-2][s-i-1] = contain_chars[s];
            }

            //找出公共字符串字符数
            for(char[] chars : fornt_chars) {

                for(char[] chars_last: last_chars)
                    if(chars == chars_last)
                        //System.out.println(chars);
                        index = chars.length;

            }


            //输出前缀数组
            for(int j = 0; j < fornt_chars.length; j++) {

                System.out.print(String.valueOf(fornt_chars[j]) + " ");

            }

            System.out.println();

            //输出后缀数组
            for (int j = 0; j < last_chars.length; j++) {

                System.out.print(String.valueOf(last_chars[j]) + " ");

            }

            return index;
        }


    }
