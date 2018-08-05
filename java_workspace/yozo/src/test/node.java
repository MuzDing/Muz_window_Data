package test;

import java.util.List;

public class node {

	List wjlist2 = null;
	int j = 0;
	long tempsize = 0;
	int i = 0;
	String datatype = "";
	String filePath = "";
	boolean bo;
	
	
	
	public node(List wjlist2, int j, long tempsize, int i, String datatype, String filePath, boolean bo) {
		super();
		this.wjlist2 = wjlist2;
		this.j = j;
		this.tempsize = tempsize;
		this.i = i;
		this.datatype = datatype;
		this.filePath = filePath;
		this.bo = bo;
	}
	public List getWjlist2() {
		return wjlist2;
	}
	public void setWjlist2(List wjlist2) {
		this.wjlist2 = wjlist2;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public long getTempsize() {
		return tempsize;
	}
	public void setTempsize(long tempsize) {
		this.tempsize = tempsize;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public boolean isBo() {
		return bo;
	}
	public void setBo(boolean bo) {
		this.bo = bo;
	}
	
}
