package Backjoon;

import java.io.*;
import java.util.*;

public class Main19236 {
    static int n,m,k;
    static Posi map[][];
    static Posi shark[];
    static int ans;
    static int dx[]= {0,-1,-1,0,1,1,1,0,-1};
    static int dy[]= {0,0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        map=new Posi [4][4];
        shark=new Posi[17];
        for(int i=0;i<4;i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0;j<4;j++) {
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                map[i][j]=new Posi(i,j,x,y,true);
                shark[x]=map[i][j];
            }
        }

        int tmp=map[0][0].size;
        map[0][0].alive=false;
        ans=0;
        dfs(0,0,tmp,map[0][0].d, map);

        System.out.println(ans);
    }


    static void dfs(int cx, int cy, int sum,int dir ,Posi map[][]) {
        if(sum>ans) {
            ans=sum;

        }

        Posi copymap[][]= new Posi[4][4];
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                copymap[i][j]=new Posi(i,j,map[i][j].size,map[i][j].d,map[i][j].alive);
            }
        }

        fish(cx, cy , copymap);


        for(int k=1;k<4;k++) {
            int nx=cx+k*dx[dir];
            int ny=cy+k*dy[dir];
            if(nx<0 || ny<0 || nx>=4 || ny>=4 || copymap[nx][ny].alive==false) continue;
            int tmp=copymap[nx][ny].size;
            copymap[nx][ny].alive=false;
            dfs(nx,ny,sum+tmp,copymap[nx][ny].d,copymap);
            copymap[nx][ny].alive=true;
        }
    }
    static void fish(int sx, int sy , Posi map[][]) {
        Posi shark[]=new Posi [17];
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                shark[map[i][j].size]=map[i][j];
            }
        }


        for(int i=1;i<=16;i++) {
            if(shark[i].alive) {
                for(int j=0;j<=8;j++) {
                    int nx=shark[i].x+dx[(shark[i].d+j)%9];
                    int ny=shark[i].y+dy[(shark[i].d+j)%9];
                    if(nx<0 || ny<0 || nx>=4 || ny>=4) continue;
                    if(shark[i].x==map[nx][ny].x && shark[i].y==map[nx][ny].y) continue;
                    if(nx!=sx || ny!=sy) {
                        shark[i].d= (shark[i].d+j)%9;
                        int aa=map[nx][ny].size;
                        swap(shark[i], shark[aa]);
                        map[shark[i].x][shark[i].y]=shark[i];
                        map[shark[aa].x][shark[aa].y]=shark[aa];

                        break;
                    }
                }
            }
        }



    }

    static void swap(Posi p, Posi q) {
        int tx=p.x;
        p.x=q.x;
        q.x=tx;

        int ty=p.y;
        p.y=q.y;
        q.y=ty;


    }

    static class Posi{
        int x,y,size, d;
        boolean alive;

        public Posi(int x, int y,int size,int d, boolean alive) {
            super();
            this.x = x;
            this.y = y;
            this.size=size;
            this.d=d;
            this.alive=alive;
        }
    }

}