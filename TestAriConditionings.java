package Homework07;

public class TestAriConditionings {
    public static void main(String[] args) {

        CreateAirConditionings gree1 = new Gree("16 ~ 30",200);//实例化变量及参数的初始化
        CreateAirConditionings midea1 = new Midea("17 ~ 31",500);

        gree1.turnOn();  //格力空调开启
        midea1.turnOff();//美的空调关闭

        gree1.setWindDirection("左上");//风向赋值
        gree1.setWindLevel(50);//风速赋值

        gree1.print(gree1);//调用print函数输出状态
        System.out.println();
        midea1.print(midea1);

    }
}
