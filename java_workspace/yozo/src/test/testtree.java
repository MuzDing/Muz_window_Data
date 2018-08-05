package test;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 文件拖拽选择示例
 * 
 * @author jianggujin
 * 
 */
@SuppressWarnings("serial")
public class testtree extends JFrame
{
   public testtree()
   {

      final JTextArea area = new JTextArea();
      area.setLineWrap(true);
      add(new JScrollPane(area));

      

      setSize(300, 300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args)
   {
      new testtree();
   }
}