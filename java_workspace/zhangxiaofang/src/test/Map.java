package test;

import java.util.HashMap;
import java.util.Map.Entry;

public class Map {
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        HashMap<String, Integer> Employee = new HashMap<String, Integer>();
	        // 添加几条信息
	        Employee.put("muz", 2000);
	        Employee.put("zxf", 3000);
	        Employee.put("Jack", 500);
	        Employee.put("Tom", 800);
	        // 列出所有的员工姓名
	        System.out.println("列出所有员工的姓名：");
	        for (String s1 : Employee.keySet()) {
	            System.out.println(s1);
	        }
	        // 列出所有员工姓名及其工资
	        System.out.println("列出所有员工的姓名及其工资：");
	        for (Entry<String, Integer> e : Employee.entrySet()) {
	            System.out.print(e.getKey() + "工资是");
	            System.out.println(e.getValue());
	        }
	        // 删除名叫“Tom”的员工信息
	        System.out.println("删除名叫“Tom”的员工信息！");
	        Employee.remove("Tom");
	        // 重新列出所有员工姓名及其工资
	        System.out.println("列出所有员工的姓名及其工资：");
	        for (Entry<String, Integer> e : Employee.entrySet()) {
	            System.out.print(e.getKey() + "工资是");
	            System.out.println(e.getValue());
	        }
	        // 输出Jack的工资，并将其工资改为1500元
	        System.out.println("输出Jack的工资，并将其工资改为1500元：");
	        System.out.println(Employee.get("Jack"));
	        Employee.put("Jack", 1500);
	        // 输出更改工资后的Jack新工资
	        System.out.println("输出更改工资后的Jack新工资：");
	        System.out.println(Employee.get("Jack"));
	        // 将所有工资低于1000元的员工的工资上涨20%
	        System.out.println("将所有工资低于1000元的员工的工资上涨20%：");
	        for (double in : Employee.values()) {
	            if (in <= 1000) {
	                in = in + in * 0.2;
	                System.out.println(in);
	            }
	        }
	    }
}
