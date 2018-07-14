package team;

import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
/** 请完成下面这个process函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
private static int process(Box box, Box[] items) 
{   
	for(Box b : items){
	    if(max(box.length, box.width, box.height) < max(b.length, b.width, b.height))
	    	return -1;
	}
	int num=0;
	int box_max = box.length*box.height*box.width;
	int box_shengyu=box_max;
	for(int i=0;i<items.length;i++)
	{
		//int shengyu;	
		for(int j=i;j<items.length;j++)
		{	
			if(items[j].sign == false)
				continue;
			if(items[j].height*items[j].width*items[j].length<box_shengyu)
			{
				num++;
				box_shengyu=box_shengyu-(items[i].height*items[i].width*items[i].length);
				items[j].sign=false;
				System.out.println(items[j].price);
			}
			else{
				box_shengyu=box_max;
				break;
			}
		}
	}
/*	for(Box b:items){
		for(Box b1:items){
			if((b1.height*b1.width*b1.length)<box_shengyu){
				num++;
				box_shengyu=box_shengyu-(b1.height*b1.width*b1.length);
			}
			else{
				box_shengyu = box_max;
			}
		}
	}
	*/
	return num;
	
		
}
private static int max(int a, int b, int c){
	int t = Math.max(a,b);
	return Math.max(t,c);
}
public static void main(String args[]){
	int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
        Scanner scanner = new Scanner(System.in);
        Box boxTemplate = new Box();
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()){
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                item.sign = true;
                items[i] = item;
            }
//            long startTime = System.currentTimeMillis();
//            boxMinNum = Integer.MAX_VALUE;
          System.out.println (process(boxTemplate, items));
        
}
}

    }

class Box{
	public int length;
	public int width;
	public int height;
	public int price;
	public boolean sign;
}

class Model extends Box{
	
}
