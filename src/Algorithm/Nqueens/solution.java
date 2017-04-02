package Algorithm.Nqueens;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/4/2.
 */
public class solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        if(n<=0){
            return res;
        }
        search(res,new ArrayList<Integer>(),n);
        return res;
    }
    private void search(ArrayList<ArrayList<String>> res,ArrayList<Integer> cols,int n){
        if(cols.size()==n){
            res.add(draw(cols));
            return;
        }
        for(int colIndex=0;colIndex<n;++colIndex){
            if(!isValid(cols,colIndex))
                continue;
            cols.add(colIndex);
            search(res,cols,n);
            cols.remove(cols.size()-1);
        }
    }
    private ArrayList<String> draw(ArrayList<Integer> cols){
        ArrayList<String> aSolution=new ArrayList<>();
        for(int i=0;i<cols.size();++i){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<cols.size();++j){
                if(j!=cols.get(i))
                    sb.append('.');
                else
                    sb.append('Q');
            }
            aSolution.add(sb.toString());
        }
        return aSolution;
    }
    private Boolean isValid(ArrayList<Integer> cols,int column){
        int row=cols.size();//待检测的行
        for(int rowIndex=0;rowIndex<row;++rowIndex){
            if(cols.get(rowIndex)==column){
                return false;
            }
            if(rowIndex+cols.get(rowIndex)==row+column){
                return false;
            }
            if(rowIndex-cols.get(rowIndex)==row-column){
                return false;
            }
        }
        return true;
    }
}
