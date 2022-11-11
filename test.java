package algorithm;

public class test {
static int arr[];
static boolean[] v= new boolean[4];
	public static void main(String[] args) {
		arr = new int[]{1,2,3,4}; 
		set(0);
	}
	static void set(int idx) {
		if(idx==4) {
			for(int i=0;i<4;i++) {
				if(v[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		v[idx]=true;
		set(idx+1);
		v[idx]=false;
		set(idx+1);
	}
}
