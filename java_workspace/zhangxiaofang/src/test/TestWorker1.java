package test;

import java.util.HashSet;
import java.util.Iterator;

import worker.worker;

public class TestWorker1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<worker> h_worker = new HashSet<worker>();
		
		int ID = 002;
		String name="muz";
		int age=18;
		double salary=5000.0;
		
		worker w1 = new worker(ID,name,age,salary);
		h_worker.add(new worker(001,"zxf",20,2000.0));
		
		for (worker worker : h_worker) {
			if(worker.equals(w1)) {
				continue;
			}
			else {
				h_worker.add(w1);
			}
		}

		Iterator it = h_worker.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
	}

}
