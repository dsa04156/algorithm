package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,cnt;
	static char[][] map;
	static int[][] map2;
	static boolean[][] v;
	static int[] dx= {1,0,-1,0,1,-1,1,-1};
	static int[] dy= {0,1,0,-1,-1,1,1,-1};
	static ArrayList<Node> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map=new char[N][N];
			map2=new int[N][N];
			v=new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j]=s.charAt(j);
					if(map[i][j]=='*') {
						cnt+=1;
					}
				}
			}
			list = new ArrayList<>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					make(i,j);
				}
			}
			cnt=0;
			for(int i=0;i<list.size();i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				if(v[x][y]) continue;
//				System.out.println("0ÀÏ¶§ x: "+x+"y: "+y);
				v[x][y]=true;
				dfs(x,y);
				cnt++;
			}
//			System.out.println(cnt);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(v[i][j]) continue;
					if(map2[i][j]==9) continue;
					v[i][j]=true;
//					if(map2[i][j]==0) {
//						dfs(i,j);
//					}
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map2[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			
		}
	}
	static void make(int x,int y) {
		int k=0;
		if(map[x][y]=='*') {
			map2[x][y]=9;
			return;
		}
		for(int c=0;c<8;c++) {
			int nx=x+dx[c];
			int ny=y+dy[c];
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			if(map[nx][ny]=='*') {
				k+=1;
			}
		}
		map2[x][y]=k;
		if(k==0) {
			list.add(new Node(x, y));
		}
	}
	static void dfs(int x,int y) {
		if(map2[x][y]==9) {
			return;
		}
		for(int c=0;c<8;c++) {
			int nx=x+dx[c];
			int ny=y+dy[c];
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			if(v[nx][ny]) continue;
			v[nx][ny]=true;
			if(map2[nx][ny]==0) {
				dfs(nx,ny);
			}
		}
		
	}

}
class Node{
	int x,y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
