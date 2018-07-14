package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import worker.worker;

public class TestWorker2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<worker> t_worker = new TreeSet<worker>();
		
		t_worker.add(new worker(001,"muz",21,2100.0));
		t_worker.add(new worker(002,"a",20,2000.0));
		t_worker.add(new worker(003,"b",20,2050.0));
		t_worker.add(new worker(004,"c",20,2010.0));
		
		System.out.println(t_worker.size());
		for (worker worker : t_worker) {
			System.out.println(worker);
		}
		
	}

}
