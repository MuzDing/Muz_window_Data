package test1;

public class aa {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[] = new int[50];
		for(int i=0;i<50;i++){
			a[i]=i+1;
		}
		for(int i=1;i<=50;i++){
			for(int j=0;j<50;j++){
				if(a[j]%i==0){
					a[j]=-1*a[j];
				}
			}
			}
		for(int i=0;i<50;i++){
			System.out.println(a[i]);
		}
		}
	}


