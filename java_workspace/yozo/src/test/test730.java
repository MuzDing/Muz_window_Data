package test;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;

import org.omg.PortableInterceptor.INACTIVE;

public class test730 {
	JPanel panel;
	JFrame jframe;
	JTree tree =  null;
	JScrollPane jsp = null;
	
	static String filePath = "";//路径
	DefaultMutableTreeNode noderoot ,tempnode;
	

	public test730()
	{
		//主窗体
		jframe = new JFrame("demo");
		jframe.setSize(500, 450);
		jframe.setLocation(300, 150);
		jframe.setVisible(true);
		
		//文件选择器
		JFileChooser fd = new JFileChooser();
		
		//菜单栏
		JMenuBar mentBar1 = new JMenuBar();
		jframe.setJMenuBar(mentBar1);
		
		JMenu file = new JMenu("file");
		mentBar1.add(file);
		file.setMnemonic('f');
		
		JMenu help = new JMenu("help");
		mentBar1.add(help);
		help.setMnemonic('h');
		
		//菜单栏内容
		JMenuItem open = new JMenuItem("open");
		open.setMnemonic('o');
		file.add(open);
		
		JMenuItem close = new JMenuItem("close");
		open.setMnemonic('c');
		file.add(close);
		
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				if(f != null)
				{
					filePath = f.getAbsolutePath();
					if(jsp !=null)
					{
						jframe.remove(jsp);
					}
					long statrtime = System.currentTimeMillis();
					handle();
					
					long endtime = System.currentTimeMillis();
					System.out.println("时间为:"+(endtime-statrtime)+"ms");
				}
			}
		});
		drag();
	}
	long wenjianfenpeibiao = 0;
	long genrukou = 0;
	long shujuwenjian = 0;
	long genrukouvalue = 0;
	long wjpage = 0;
	List kuailist = null;
	List sjkuailist = null;
	List wjlist = null;
	RandomAccessFile raf = null;
	int tempkuaihao = 0;
	String liuname ="";
	
	private void handle()
	{
		raf = readFile(filePath); //读文件
		genrukou = handleFilePath(raf,0x30);
		wenjianfenpeibiao = handleFilePath(raf,0x4c);
		shujuwenjian = handleFilePath(raf,0x3c);
		wjlist = new ArrayList<>();
		
		noderoot = new DefaultMutableTreeNode(filePath);
		genrukouvalue = handleInt(raf, 0x30);
		
		System.err.println("公共数据:"+genrukou+"文件分配表："+wenjianfenpeibiao);
		
		long templistvalue = handleInt(raf, wenjianfenpeibiao +genrukouvalue * 0x4);
		long tempvalue = genrukouvalue * 0x200 + 0x200;
		
		wjpage = handleInt(raf, 0x2c);
		
		kuailist = new ArrayList<>();
		sjkuailist = new ArrayList<>();
		System.err.println(kuailist);
		kuailist(raf, tempvalue, templistvalue);
		
		sjkuailist(raf);
//		
//		templistvalue = (long)kuailist.get((int) genrukouvalue);
//		
//		wjlist = wjList(raf,wjlist,tempvalue, templistvalue);
//		String tstr = handleString(raf, genrukou);
//		
//		int temp = handleLong(raf,genrukou + 0x4c);
//		
//		pre_order(raf,temp, wjlist, tstr, noderoot);
		
		try {
			raf.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tree = new JTree(noderoot);
		jsp = new JScrollPane(tree);
		jframe.add(jsp);
		tree.revalidate();
		
		tree.addTreeWillExpandListener(new TreeWillExpandListener() {
			
			@Override
			public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
				TreePath selPath = event.getPath(); 
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
				if(node.getFirstChild().toString().equals("signal"))
				{
					node.removeAllChildren();
				}
				Object object = node.getUserObject();
				if(node.isLeaf() && !object.getClass().getName().equals("java.lang.String"))
				{
					node no = (node)object;
					addnodeintree(no,node);
				}
			}
			
			@Override
			public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
				// TODO 自动生成的方法存根
				
			}
		});
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node.getFirstChild().toString().equals("signal"))
				{
					node.removeAllChildren();
				}
				Object object = node.getUserObject();
				if(node.isLeaf() && !object.getClass().getName().equals("java.lang.String"))
				{
					node no = (node)object;
					addnodeintree(no,node);
				}
				
			}
		});
		jframe.revalidate();
	}
	
	private void addnodeintree(node no,DefaultMutableTreeNode node)
	{
		List wjlist2 = no.getWjlist2();
		int j = no.getJ();
		long tempsize = no.getTempsize();
		int i = no.getI();
		String datatype = no.getDatatype();
		boolean streamname = no.isBo();
		
		
		RandomAccessFile raf = null;
		raf = readFile(filePath);
		int lenght = 0;
		StringBuilder strLineValue = new StringBuilder();
		byte[] b = new byte[16];
		byte by = 0;
		j = j+8;
		int tempflag = 0;
		if(streamname)
		{
			for(; i<wjlist2.size(); i++)
			{
				for(; j<128; j++)
				{
					tempflag +=1;
					if(tempflag % 16 ==0)
					{
						tempflag =0;
						strLineValue.append(String.format(" %02x", by));
						DefaultMutableTreeNode tnode = new DefaultMutableTreeNode((strLineValue).toString());
						node.add(tnode);
						strLineValue.delete(0, strLineValue.length());
						lenght +=1;
					}
					else
					{
						lenght +=1;
						by = handleByte(raf,
								j + Integer.parseInt(wjlist2.get(i).toString()));
						strLineValue.append(String.format(" %02x", by));
					}
					if(lenght == tempsize)
					{
						if(strLineValue.length() != 0)
						{
							DefaultMutableTreeNode tnode = new DefaultMutableTreeNode((strLineValue).toString());
							node.add(tnode);
							strLineValue.delete(0, strLineValue.length());
						}
						break;
					}
				}
				j = 0;
				if(lenght == tempsize)
				{
					if(strLineValue.length() != 0)
					{
						DefaultMutableTreeNode tnode = new DefaultMutableTreeNode((strLineValue).toString());
						node.add(tnode);
						strLineValue.delete(0, strLineValue.length());
					}
					break;
				}
			}
		}
		else
		{
			for(; i<wjlist2.size(); i++)
			{
				for(j = 0; j<128; j++)
				{
					tempflag +=1;
					if(tempflag % 16 ==0)
					{
						tempflag =0;
						strLineValue.append(String.format(" %02x", by));
						DefaultMutableTreeNode tnode = new DefaultMutableTreeNode((strLineValue).toString());
						node.add(tnode);
						strLineValue.delete(0, strLineValue.length());
						lenght +=1;
					}
					else
					{
						lenght +=1;
						by = handleByte(raf,
								j + Integer.parseInt(wjlist2.get(i).toString()));
						strLineValue.append(String.format(" %02x", by));
					}
					if(lenght == tempsize)
					{
						if(strLineValue.length() != 0)
						{
							DefaultMutableTreeNode tnode = new DefaultMutableTreeNode((strLineValue).toString());
							node.add(tnode);
							strLineValue.delete(0, strLineValue.length());
						}
						break;
					}
				}
				j = 0;
				if(lenght == tempsize)
				{
					if(strLineValue.length() != 0)
					{
						DefaultMutableTreeNode tnode = new DefaultMutableTreeNode((strLineValue).toString());
						node.add(tnode);
						strLineValue.delete(0, strLineValue.length());
					}
					break;
				}
			}
		}
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void kuailist(RandomAccessFile raf, long tempvalue, long templistvalue)
	{
		long addwjlist = handleInt(raf, 0x48);
		long addfristpath = handleInt(raf, 0x44);
		long addwjlistkuai = wjpage - 109;
		
		long addfristpashrukou = addfristpath * 0x200 + 0x200;
		long tempkuai =  handleInt(raf, addfristpashrukou);
		long frist = tempkuai * 0x200 + 0x200;
		int num = 0;
		int i1 = 0;
		
		for(int page = 0; page <wjpage; page ++)
		{
			if(page < 109)
			{
				long path = handleFilePath(raf, 0x4c + page * 0x4);
				for(int i =0; i < 128; i++)
				{
					long tempvalue1 = handleInt(raf, path + i * 0x4);
					kuailist.add(tempvalue1);
					i1++;
				}
			}
			else
			{
				for(int i = 0; i < 128; i++)
				{
					long tempkuai1 = handleInt(raf ,frist + 0x4 * i);
					kuailist.add(tempkuai1);
					i1++;
				}
				num +=1;
				tempkuai = handleInt(raf,addfristpashrukou + 0x4 * num);
				if(num == 127)
				{
					addfristpashrukou = tempkuai * 0x200  + 0x200;
					tempkuai = 	handleInt(raf, addfristpashrukou);
					frist = tempkuai * 0x200 + 0x200;
					num =0;
					page --;
				}
				else
				{
					frist = tempkuai * 0x200 + 0x200;
				}
			}
		}
	}
	
	private List wjList(RandomAccessFile raf, List wlist, long tempvalue, long templistvalue)
	{
		for( int i = 0; i < 4; i++)
		{
			wjlist.add(tempvalue + i * 0x80);
		}
		while((int)templistvalue > 0)
		{
			if((int)templistvalue > 0)
			{
				long tempvalue1 = templistvalue * 0x200 + 0x200;
				for(int i = 0; i < 4; i++)
				{
					wjlist.add(tempvalue + i * 0x80);
				}
			}
			templistvalue = (long)kuailist.get((int)templistvalue);
		}
		return wjlist;
	}
	
	
	private List wjList1(RandomAccessFile raf, List wjlist1, long tempvalue, long templistvalue)
	{
		List temp = new ArrayList<>();
		for(int page = 0; page < wjpage; page ++)
		{
			if(page <= 109)
			{
				for(int i = 0 ; i < 128; i++)
				{
					long path = handleFilePath(raf, 0x4c + page * 0x4);
					long tempvalue1 = handleInt(raf, path + i * 0x4);
					temp.add(tempvalue1);
				}
			}
		}
		
		for(int i = 0; i < 8; i++)
		{
			wjlist1.add(tempvalue + i * 0x40);
		}
		
		while((int)templistvalue > 0)
		{
			if((int)templistvalue > 0)
			{
				long tempvalue1 = templistvalue * 0x200 + 0x200;
				for(int i = 0; i < 8; i++)
				{
					wjlist.add(tempvalue + i * 0x40);
				}
			}
			templistvalue = (long)kuailist.get((int)templistvalue);
		}
		return wjlist1;
	}
	private void sjkuailist(RandomAccessFile raf)
	{
		long templistvalue = 0;
		long sjpath = handleInt(raf,0x3c) * 0x200 +0x200;
		System.err.println(sjpath);
		for(int i = 0; i < 128; i++)
		{
			templistvalue = handleInt(raf, sjpath + 0x4 * i);
			sjkuailist.add(templistvalue);
		}
		sjpath = (sjpath - 0x200) / 0x200;
		for(int j = 0; j < handleInt(raf, 0x40); j++)
		{
			sjpath = (long)kuailist.get((int) sjpath) * 0x200 + 0x200;
			for(int i = 0; i < 128; i++)
			{
				templistvalue = handleInt(raf, sjpath + 0x4 * i);
				sjkuailist.add(templistvalue);
			}
			sjpath = (sjpath -512) / 512;
		}
	}
	
	private List sjwjlist(RandomAccessFile raf, List sjwjlist, long templistvalue)
	{
		sjwjlist.add(templistvalue);
		templistvalue = (long)sjkuailist.get((int) templistvalue);
		while((int)templistvalue > 0)
		{
			if((int)templistvalue > 0)
			{
				
				for(int i = 0; i < 8; i++)
				{
					wjlist.add(templistvalue + i * 0x40);
				}
			}
			templistvalue = (long)sjkuailist.get((int)templistvalue);
		}
		return sjwjlist;
	}
	
	private void pre_order(RandomAccessFile raf, int temp, List wjlist, String str, DefaultMutableTreeNode rnode)
	{
		if(temp > -1)
		{
			pre_order(raf , handleLong(raf, Integer.parseInt(wjlist.get(temp).toString()) + 0x44),
					wjlist,str,rnode);
			str = handleString(raf, (long)wjlist.get(temp)).toString();
			
			str = handleString(raf, (long)wjlist.get(temp)).toString();
			long l = handleInt(raf,  0x78 +(long)wjlist.get(temp));
			DefaultMutableTreeNode t =null;
			if(l != 0)
			{
				t = new DefaultMutableTreeNode(str +",size:"+l);
			}
			else
			{
				t = new DefaultMutableTreeNode(str);
			}
			rnode.add(t);
			pre_order(raf , handleLong(raf, Integer.parseInt(wjlist.get(temp).toString()) + 0x4c),
					wjlist,str,t);
			findData(raf, wjlist, temp, t, str);
			str = handleString(raf, (long)wjlist.get(temp)).toString();
			
			pre_order(raf , handleLong(raf, Integer.parseInt(wjlist.get(temp).toString()) + 0x48),
					wjlist,str,t);
			str = handleString(raf, (long)wjlist.get(temp)).toString();
		}
	}
	
	private void findClass(RandomAccessFile raf ,int temp,List wjlist,String str,long l)
	{
		tempnode = new DefaultMutableTreeNode(str + ",size:" + l);
		noderoot.add(tempnode);
		findData(raf,wjlist,temp,tempnode,str);
	}
	
	private void findData(RandomAccessFile raf , List wjlist, int kuaihao, 
			DefaultMutableTreeNode tempnode, String str)
	{
		long steamsize = handleInt(raf, (long)wjlist.get(kuaihao) + 0x78);
		if(steamsize < 0x1000)
		{
			long tempsj = handleInt(raf, (long)wjlist.get(kuaihao) + 0x74);
			List sjwjlist = new ArrayList<>();
			List wjlist1 = new ArrayList<>();
			
			long tmp = handleInt(raf, genrukou + 0x74);
			long templistvalue = (long)kuailist.get((int) tmp);
			long tempvalue = tmp * 0x200 +0x200;
			
			wjlist1 = wjList1(raf, wjlist1, tempvalue, templistvalue);
			sjwjlist = sjwjlist(raf, sjwjlist, tempsj);
					
			int lenght = 0;
			StringBuilder strLineValue = new StringBuilder(" ");
			int j = 0;
			long temppptsize =0;
			for(int i = 0; i < sjwjlist.size(); i++)
			{
				int tempflag = 0;
				byte by = 0;
				for(j = 0; j<steamsize; j++)
				{
					lenght ++;
					tempflag ++;
					by = handleByte(raf, j+ Integer.parseInt(
							wjlist1.get(Integer.parseInt(sjwjlist.get(i).toString())).toString()));
					if(tempflag % 16 ==0)
					{
						strLineValue.append(String.format(" %02x", by));
						DefaultMutableTreeNode tnode = new DefaultMutableTreeNode(strLineValue.toString());
						tempnode.add(tnode);
						tnode = null;
						strLineValue.delete(0, strLineValue.length());
					}
					else
					{
						strLineValue.append(String.format(" %02x", by));
					}
					if(lenght == steamsize)
					{
						if(strLineValue.length()!=0)
						{
							DefaultMutableTreeNode tnode = new DefaultMutableTreeNode(strLineValue.toString());
							tempnode.add(tnode);
							tnode = null;
							break;
						}
					}
					if(tempflag == 64)
					{
						break;
					}
				}
				if(lenght == steamsize)
				{
					break;
				}
			}
		}
		else
		{
			long tmp = handleInt(raf, Integer.parseInt(wjlist.get(kuaihao).toString()) + 0x74);
			List wjlist2 = new ArrayList<>();
			long templistvalue = (long)kuailist.get((int)tmp);
			long tempvalue = tmp * 0x200 + 0x200;
			
			wjlist2 = wjList(raf, wjlist2, tempvalue,templistvalue);
			int lenght = 0;
			int j = 0;
			StringBuilder strLineValue = new StringBuilder();
			long tempsize = 0;
			int jishu = 0;
			int baocun = 0;
			int baocunj = 0;
			DefaultMutableTreeNode datanode = null;
			if(str.trim().equals("PowerPoint Document"))
			{
				for(int i = 0; i < wjlist2.size(); i++)
				{
					int kuaidaxiao  =0;
					int tempflag1 = 0;
					tempflag1 = baocun;
					byte by = 0;
					for(j = 0; j < 128; j++)
					{
						lenght++;
						kuaidaxiao +=1;
						if(baocunj >=128)
						{
							j = baocunj -128;
							baocunj = 0;
						}
						if(jishu == tempsize)
						{
							tempsize = handleInt(raf,
									4 + j + Integer.parseInt(wjlist2.get(i).toString()));
							if(tempsize != 0)
							{
								int io = 8 + j + Integer.parseInt(wjlist2.get(i).toString());
								int type1 = handleByte1(raf,
										2 + j +Integer.parseInt(wjlist2.get(i).toString()));
								int type2 = handleByte1(raf,
										3 + j +Integer.parseInt(wjlist2.get(i).toString()));
								String datatype = Integer.toHexString(type2)
										+Integer.toHexString(type1);
								node no = new node(wjlist2, j, tempsize, i,datatype, filePath,true);
								DefaultMutableTreeNode node = new DefaultMutableTreeNode(no);
								node.add(new DefaultMutableTreeNode("signal"));
								tempnode.add(node);
								j =j+7;
								jishu =0;
								lenght +=7;
								if(j >=128)
								{
									baocunj = j+1;
									break;
								}
							}
						}
						else
						{
							jishu++;
						}
						if(tempflag1 == 128)
							break;
						
					}
					if(lenght == steamsize)
					{
						break;
					}
				}
			}
			else{
				int type1 = handleByte1(raf,
						2 + j +Integer.parseInt(wjlist2.get(0).toString()));
				int type2 = handleByte1(raf,
						3 + j +Integer.parseInt(wjlist2.get(0).toString()));
				String datatype = Integer.toHexString(type2)
						+Integer.toHexString(type1);
				node no = new node(wjlist2, j, tempsize, 0,datatype, filePath,true);
				tempnode.setUserObject(no);
				tempnode.add(new DefaultMutableTreeNode("signal"));
				
			}
		}
			
	}
	private RandomAccessFile readFile(String filepath)
	{
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(filepath, "rw");
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return raf;
	}
	private long handleFilePath(RandomAccessFile raf, long obj)
	{
		obj = handleInt(raf, (int)obj);
		return obj * 0x200 +0x200;
	}
	private String handleString(RandomAccessFile raf, long temp)
	{
		byte[] by = new byte[80];
		String str = "";
		int k=0;
		try {
			raf.seek(temp);
			while(true)
			{
				long point = raf.getFilePointer();
				if(raf.readByte() == 0 && raf.readByte() == 0 &&
						raf.readByte() == 0 && raf.readByte() == 0 )
				{
					break;
				}
				raf.seek(point);
				byte temp2 = raf.readByte();
				if(temp2 !=0)
				{
					by[k] = temp2;
					k++;
				}
			}
			str = new String(by, "utf-8");
			str = str.trim();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return str;
	}
	private long handleInt(RandomAccessFile raf,long temp)
	{
		long tempcount = 0;
		try {
			raf.seek(temp);
			tempcount = raf.read() +raf.read() *256+raf.read() *256 *256
					+raf.read() *256*256*256;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempcount;
	}
	private long handleInt1(RandomAccessFile raf,long temp)
	{
		long tempcount = 0;
		try {
			raf.seek(temp);
			tempcount = raf.read() +raf.read() *256+raf.read() *256 *256
					+raf.read() *256*256*256;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempcount;
	}
	private int handleLong(RandomAccessFile raf,long temp)
	{
		int tempcount = 0;
		try {
			raf.seek(temp);
			tempcount = raf.readByte() +raf.read() *256+raf.read() *256 *256
					+raf.read() *256*256*256;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempcount;
	}
	
	private byte handleByte(RandomAccessFile raf, int temp)
	{
		byte by =0;
		try {
			raf.seek(temp);
			by = (byte)raf.read();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return by;
	}
	private int handleByte1(RandomAccessFile raf, int temp)
	{
		int by =0;
		try {
			raf.seek(temp);
			by = raf.read();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return by;
	}

	private void drag()
	{
		new DropTarget(jframe, DnDConstants.ACTION_COPY_OR_MOVE,
	            new DropTargetAdapter()
	            {
	               @Override
	               public void drop(DropTargetDropEvent dtde)
	               {
						try {
							// 如果拖入的文件格式受支持
							if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
								dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
								List<File> list = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
								String temp = "";
								filePath = list.get(0).getAbsolutePath();
								System.err.println(filePath);
								dtde.dropComplete(true);
							} else {
								// 拒绝拖拽来的数据
								dtde.rejectDrop();
							}
						}
	                  catch (Exception e)
	                  {
	                     e.printStackTrace();
	                  }
	                  if(jsp!=null)
							jframe.remove(jsp);
						long start = System.currentTimeMillis();
						handle();
						long end = System.currentTimeMillis();
						
						System.err.println("时间为"+(end-start)+"ms");
	               }
	            });
	}
	public static void main(String[] arg0) {
		test730 t = new test730();
	}
}
	

