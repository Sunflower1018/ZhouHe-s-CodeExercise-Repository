/*
 *一个随机点名点小游戏
 *swing图形绘制及定时器Timer的练习
 *用到了一个小小的异常处理
 */

package swing;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class WhoGame extends JPanel {
    public static void main(String[] args) {
     creatPanel();
    }

    public static void creatPanel()
    {
        JFrame jFrame = new JFrame();//画板

        jFrame.setSize(340,100);//尺寸
        jFrame.setTitle("点名表");//标题
        jFrame.setResizable(false);//不可更改尺寸
        jFrame.setLocationRelativeTo(null);//居中对齐
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式

        WhoGame whoGame = new WhoGame();
        whoGame.setLayout(null);
        jFrame.add(whoGame);

        JButton start = new JButton("开始点名");
        start.setBounds(10,20,100,40);
        JButton stop = new JButton("停止");
        stop.setBounds(230,20,100,40);

        JTextField name = new JTextField();
//        textField.setVisible(true);
        name.setBounds(120,20,100,40);

        whoGame.add(start);
        whoGame.add(stop);
        whoGame.add(name);


        //----------按钮点击反馈部分---------
        MouseAdapter mouseAdapter = new MouseAdapter() {
            Timer timer;    //小全局变量timer定时任务
            @Override
            public void mouseClicked(MouseEvent e) {    //鼠标点击事件e

                JButton source = (JButton)e.getSource();//获取事件源

                if(source.getText().equals("开始点名"))
                {
                    timer = new Timer();//创建一个新的事件

                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            name.setText(getWhoSName());//获取一个String类型的getWhoSName
                        }
                    };

                    timer.schedule(task,10,60);//开始定时任务
                }
                else if(source.getText().equals("停止"))
                {
                     try {
                         timer.cancel();
                     }catch (NullPointerException e1) {//异常处理
                        name.setText("点名还未开始");
                     }
                }
            }
        };

        start.addMouseListener(mouseAdapter);
        stop.addMouseListener(mouseAdapter);

        jFrame.setVisible(true);//可视化
    }


    //--------名字--------
    static String getWhoSName()
    {
        String[] name = {"曹操","西施","牛魔王","海绵宝宝","派大星","蟹老板","钢铁侠","绿巨人","皮诺曹","小鱼人","雪獒铠甲"};
        Random random = new Random();
        int index = random.nextInt(name.length);
        return name[index];
    }

}
