package catchimage;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * 
 * @author
 * 
 */
public class Jexample implements ActionListener {
    private String path;
    JFrame frame = new JFrame("请选择保存路径");// 框架布局
    JTextField text1 = new JTextField();// TextField 目录的路径
    JButton button1 = new JButton("...");// 选择
    JFileChooser jfc = new JFileChooser();// 文件选择器
    JButton button3 = new JButton("确定");//

    Jexample() {
        jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘

        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置
        frame.setSize(280, 200);// 设定窗口大小
        frame.setLayout(null);
        text1.setBounds(30, 30, 120, 20);
        button1.setBounds(160, 30, 60, 20);
        button3.setBounds(160, 70, 60, 20);
        button1.addActionListener(this); // 添加事件处理
        button3.addActionListener(this); // 添加事件处理
        frame.add(text1);
        frame.add(button1);
        frame.add(button3);
        frame.setVisible(true);// 窗口可见
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 时间监听的方法
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(button1)) {// 判断触发方法的按钮是哪个
            jfc.setFileSelectionMode(1);// 设定只能选择到文件夹
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
            if (state == 1) {
                return;
            } else {
                File f = jfc.getSelectedFile();// f为选择到的目录
                text1.setText(f.getAbsolutePath());
            }
        }
        if (e.getSource().equals(button3)) {
            // 弹出对话框可以改变里面的参数具体得靠大家自己去看，时间很短
            path = text1.getText();
            frame.dispose();
            CatchImage cm = new CatchImage();
            cm.setMypath(path);
            String URL = "https://www.251ee.com/htm/piclist3/";
            // 获得html文本内容
            try {
                cm.getHTML(URL);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }
}
