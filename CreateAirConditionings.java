package Homework07;

class CreateAirConditionings extends AirConditioning{//继承最终空调抽象超类，重写抽象方法turnOn、turnOff

    //功率制冷的初始化
    public CreateAirConditionings(String refrigeration, int power) {
        super(refrigeration, power);
    }

    //重写turnOn 、 turnOff方法
    @Override
    void turnOn() {
       condition = true;
    }

    @Override
    void turnOff() {
        condition = false;
    }

    //-------print方法用判断空调的状态（on or off）来实现不同的输出----------
    void print(CreateAirConditionings kong)
    {
        String name = null;

        if(kong instanceof Gree) {name = "格力";} //这三句是无论空调开不开启都会输出的
        else {name = "美的";}
            System.out.println(name + "空调制冷参数：" + kong.Refrigeration + "度  功率：" + kong.power);

        if(kong.condition)//先判断空调开启或关闭的状态，再分别输出空调的当前状态
            System.out.println("当前空调状态：开启" + "\n风力大小：" + kong.getWindLevel() + "  风向：" + kong.getWindDirection());
        else
            System.out.println("当前空调状态：关闭");

    }

}//继承抽象类'AirConditioning'的结束


//格力类空调继承CreateAirConditionings类
class Gree extends CreateAirConditionings implements TurnWind
{
    //--------初始化'格力'空调参数-------
    public Gree(String refrigeration, int power) {
        super(refrigeration, power);
    }

    //------继承接口，重写'格力'改变风向的方法-----
    @Override
    public void turnWind() {
        System.out.println("格力专属改变风向模式");
    }

}

//美的类空调继承CreateAirConditionings类
class Midea extends CreateAirConditionings implements TurnWind
{

    //--------初始化'美的'空调参数-------
    public Midea(String refrigeration, int power) {
        super(refrigeration, power);
    }

    //------继承接口，重写'格力'改变风向的方法-----
    @Override
    public void turnWind() {
        System.out.println("美的专属改变风向模式");
    }
}
