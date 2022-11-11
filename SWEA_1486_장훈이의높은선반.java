package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,B;
	static int key[];
	static boolean v[];
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			key=new int[N];
			v= new boolean[N];
			min=Integer.MAX_VALUE;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				key[i]=Integer.parseInt(st.nextToken());
			}
			set(0);
			System.out.println("#"+tc+" "+min);
			
			
		}
	}
	static void set(int idx) {
		if(min==0)return;
		if(idx==N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(v[i]) {
					sum+=key[i];
				}
			}
			int res = sum-B;
			if(res<0) return;
			min=Math.min(min, res);
			return;
		}
		
		v[idx]=true;
		set(idx+1);
		v[idx]=false;
		set(idx+1);
	}

}
