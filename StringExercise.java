package HomeWork08;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountE test = new CountE();

        System.out.print("请输入一串含'e'的字符串：" );
        String e = sc.nextLine();

        System.out.println("字符串中含有的'e'的个数为：" + test.conutE(e));
    }

}

class CountE{
    int conutE(String a)//返回类型为int型，入参为字符串
    {
        int num = 0;        //num用于表示下标
        int count = 0;      //count用于计录e出现的次数

       while (a.indexOf('e',num) > -1)   //从下标为num开始如果找到'e'则继续，找不到退出循环
       {
           num = a.indexOf('e',num ) + 1;  //num+1，下次循环从找到的'e'的下标位置的下一位开始
           count++; //计数器+1
       }

       return count;//返回计数器记录的数值
    }

}

