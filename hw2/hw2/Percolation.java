package hw2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;

public class Percolation {
    private int[][] grid;
    private boolean[][] status;
    private int opensize;
    private int head;
    private int tail;

    private WeightedQuickUnionUF WQU;

    public Percolation(int N) {
        if (N<=0) {
            throw new IllegalArgumentException(N+"can't be smaller than zero");
        }
        grid =new int[N][N];
        status=new boolean[N][N]; //default is false
        opensize=0;
        WQU= new WeightedQuickUnionUF(N*N+2);
        head=N*N;
        tail=N*N+1;
    }
    /*helper function*/
    private void validate(int p) {
        int n=grid.length;
        if(p<0 || p>=n) {
            throw new IndexOutOfBoundsException("index"+p+"is out of range");
        }
    }
    private int matrix2vector(int p, int q) {
        int n=grid.length;
        return p*n+q;
    }

    private void Connect(int p, int q){
        int onedimension=matrix2vector(p,q);
        List<Integer> neighbors =new ArrayList<>();
        if (p==0) WQU.union(head,onedimension);
        if (p==grid.length-1) WQU.union(tail,onedimension);
        if(p!=0 &&isOpen(p-1,q)) neighbors.add(matrix2vector(p-1,q));
        if(p!=grid.length-1 &&isOpen(p+1,q)) neighbors.add(matrix2vector(p+1,q));
        if(q!=grid.length-1 &&isOpen(p,q+1)) neighbors.add(matrix2vector(p,q+1));
        if(q!=0 &&isOpen(p,q-1)) neighbors.add(matrix2vector(p,q-1));

        for (int i:neighbors) {
            WQU.union(i,onedimension);
        }
    }
    public void open(int row, int col) {
        validate(row);
        validate(col);
        if(!isOpen(row,col)) {
            grid[row][col]=1;
            opensize+=1;
            Connect(row,col);
            status[row][col]=true;
        }
    }
    public boolean isOpen(int row,int col) {
        validate(row);
        validate(col);
        return status[row][col];
    }
    public boolean isFull(int row, int col) {
        validate(row);
        validate(col);
        return WQU.connected(head,matrix2vector(row, col));
    }
    public boolean percolates(){
        return WQU.connected(head,tail);
    }
    public int numberOfOpenSites(){
        return opensize;
    }
}
