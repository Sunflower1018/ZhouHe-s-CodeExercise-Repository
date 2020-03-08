package HomeWork08;

public class Test05Tools {

//--------------判断IP地址-------------
    public static boolean isIp(String ip) {

        String[] split = ip.split("\\.");
        //用'.'分割得到的字符串

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


    //--------------判断端口-------------
    public static int checkPort(String port)
    {
        int i = Integer.parseInt(port);//还不会判断是不是整数类型，暂且这样写
        if( i >= 1024 && i <= 65535)
            return i;
        else
            return -1;
    }


    //--------------判断年龄-------------
    public static int checkAge(int age)
    {
        if( age >= 16 && age <= 150)
            return age;
        else
            return -1;
    }

}
