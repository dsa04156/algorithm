package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int D,W,K;
	static int map[][],map2[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st=new StringTokenizer(br.readLine());
			D=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map= new int[D][W];
			map2=new int[D][W];
			for(int i=0;i<D;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			v=new boolean[D];
			min= Integer.MAX_VALUE;
			if(check(map)) {
				System.out.println(0);
				continue;
			}else {
				set(0);
			}
			System.out.println(min);
			
		}
	}
	static void copy() {
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				map2[i][j]=map[i][j];
			}
		}
	}
	static boolean[] v;
	static int min;
	static void set(int idx) {
		if(idx==D) {
			int cnt=0;
			for(int i=0;i<D;i++) {
				if(v[i]) {
					for(int y=0;y<W;y++) {
						map2[i][y]=0;
					}
					cnt++;
				}
			}
			if(check(map2)) {
				min=Math.min(min, cnt);
			}
			copy();
			cnt=0;
			for(int i=0;i<D;i++) {
				if(v[i]) {
					for(int y=0;y<W;y++) {
						map2[i][y]=1;
					}
					cnt++;
				}
			}
			if(check(map2)) {
				min=Math.min(min, cnt);
			}
			copy();
			return;
		}
		v[idx]=true;
		set(idx+1);
		v[idx]=false;
		set(idx+1);
	}
	static boolean check(int[][] map) {
		int k=0;
		
		for(int y=0;y<W;y++) {
			int c = map[0][y];
			int cnt=0;
			for(int x=0;x<D;x++) {
				if(cnt>=K) {
					k++;
					break;
				}
				if(c==map[x][y]) {
					cnt++;
				}else {
					c=map[x][y];
				}
			}
		}
		if(k==W) {
			return true;
		}
		return false;
	}

}
