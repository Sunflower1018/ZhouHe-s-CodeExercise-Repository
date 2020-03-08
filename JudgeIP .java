/*
 *String中split方法的和强制类型转化的练习
 *用来判断输入的IP地址是否合法
 */

public class JudgeIP 
{
    //--------------判断IP地址是否合法-------------
    public static boolean isIp(String ip) {

        String[] split = ip.split("\\."); //用'.'分割得到的字符串

        boolean flag = false;
        //talse：IP地址不合法，true：IP地址合法

        if (split.length == 4)//分割得到的ip地址为四位则继续进行剩余条件的判断
        {
            flag = true;            //暂时为true，接下来的条件不成立变为flase
            int[] s = new int[4];   //String转化成int类型要用的数组
            int index = 0;          //s【】数组的下标

            while (index < 4)   //while循环遍历转化后的数组
            {
                s[index] = Integer.parseInt(split[index]); //将字符串类型转化为int类型

                if (s[index] < 0 || s[index] > 255) //判断ip地址是否合法
                { flag = false; break; }//不合法则flag变为false，退出循环
                index++;
            }  //while循环的结束，判断都合法flag为true，有一个条件不满足则为false

        }
        return flag;  //返回flag
    }

}
