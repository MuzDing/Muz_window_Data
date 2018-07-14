package ex4;
import java.awt.*;
import java.awt.event.*;
public class L11_11_Face extends Frame {
    private static final long serialVersionUID = 1L;
    Button clientBtn, serverBtn;
    TextArea ta;
    TextField tfaddress, tfport, tftype;
    Label lbl1,lbl2,lbl3;
    int port;
    L11_11_Client client;
    L11_11_Server server;
    boolean iamserver;
    static L11_11_Face frm;
    public L11_11_Face() {  //实例化组件
        clientBtn = new Button("客户端");
        serverBtn = new Button("服务器");
        ta = new TextArea("", 10, 50, TextArea.SCROLLBARS_BOTH);
        lbl1 = new Label("IP地址:");
        tfaddress = new TextField("127.0.0.1", 10);
        lbl2 = new Label("端口:");
        tfport = new TextField("8888");
        lbl3 = new Label("发送内容:");
        tftype = new TextField(40);
        tftype.addKeyListener(new TFListener());
        ta.setEditable(false);
        //向容器中加入以上组件
        setLayout(new FlowLayout());
        add(lbl1);
        add(tfaddress);
        add(lbl2);
        add(tfport);
        add(serverBtn);
        add(clientBtn);
        add(ta);
        add(lbl3);
        add(tftype);
        //设置格式
        setLocation(350, 250); //窗口显示在屏幕的位置坐标
        setSize(400, 300);  //设置窗体大小
        setTitle("图形界面的聊天程序");
        this.setVisible(true);  //设置窗体可见
        clientBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                port = Integer.parseInt(tfport.getText());
                client = new L11_11_Client(tfaddress.getText(), port, frm);
                client.start();
                tfaddress.setEnabled(false);
                tfport.setEnabled(false);
                serverBtn.setEnabled(false);
                clientBtn.setEnabled(false);
            }
        }); //客户端事件响应
        serverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                port = Integer.parseInt(tfport.getText());
                server = new L11_11_Server(port, frm);
                server.start();
                iamserver = true;
                tfaddress.setText("成为服务器");
                tfaddress.setEnabled(false);
                tfport.setEnabled(false);
                serverBtn.setEnabled(false);
                clientBtn.setEnabled(false);
            }
        }); //服务器端事件响应
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });  //窗口事件响应
    }
      public static void main(String[] args) {  //主方法
             frm = new L11_11_Face();
      }
      private class TFListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) { //按Enter输出显示聊天内容
                ta.append(">" + tftype.getText() + "\n");
                if (iamserver)
                    server.dataout(tftype.getText());
                else
                    client.dataout(tftype.getText());
                tftype.setText("");
            }
        }
        public void keyTyped(KeyEvent e) {
        }
        public void keyReleased(KeyEvent e) {
        }
    }
}