package worker;

public class worker implements Comparable<worker>{
	int ID;
	String name;
	int age;
	double salary;
	
	public worker(int ID, String name , int age ,double salary) {
		this.ID=ID;
		this.name=name;
		this.age = age;
		this.salary = salary;
	}
	
	public int hashCode() {
		return (int)(name.hashCode()+age+salary);
		
	}
	public boolean equals(worker worker) {
		if(worker.ID ==ID && worker.name ==name && worker.salary == salary && worker.age == age) 
			return true;
		
		else
			return false;
	}
	public worker() {
		
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
        return "工号：" + ID + "\t姓名：" + name +"\t年龄:" + age + "\t工资:" + salary;
    }

	@Override
	public int compareTo(worker o) {
		if(this.age!=o.age) {
			return this.age-o.age;
		}
		else if(this.salary!=o.salary) {
			return new Double(this.salary).compareTo(new Double(o.salary));
		}
		else if(this.name.equals(o.name)) {
			return this.name.compareTo(o.name);
		}
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(this == null) {
			return true;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		worker other  = (worker)obj;
		if(age != other.age) {
			return false;
		}
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		}else if(!name.equals(other.name)) {
			return false;
		}
		if(Double.doubleToLongBits(salary)!=Double.doubleToLongBits(other.salary)) {
			return false;
		}
		return true;
	}
}
