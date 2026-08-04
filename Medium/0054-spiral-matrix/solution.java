import java.util.ArrayList;

class solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int sr = 0;                 // sr -> Starting Row
        int ec = n-1;               // ec -> Ending Column
        int er = m-1;               // er -> Ending Row
        int sc = 0;                 // sc -> Starting Column

        int count = m*n;
        
        ArrayList<Integer> list = new ArrayList<>();

        while (count > 0) {
            for(int i = sc; i <= ec; i++) {
                list.add(matrix[sr][i]);
                count--;
            }
            sr++;
            if (count == 0) {
                break;
            }
            for(int i = sr; i <= er; i++){
                list.add(matrix[i][ec]);
                count--;
            }
            ec--;
            if (count == 0) {
                break;
            }
            for(int i = ec; i >= sc; i--){
                list.add(matrix[er][i]);
                count--;
            }
            er--;
            if (count == 0) {
                break;
            }
            for(int i = er; i >= sr; i--){
                list.add(matrix[i][sc]);
                count--;
            }
            sc++;
            if (count == 0) {
                break;
            }
        }
        return list;
    }
}
