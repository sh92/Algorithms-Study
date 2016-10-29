import java.math.BigInteger;

public class Matrix {

    private BigInteger[][] matrix;
    private int row, col;


    Matrix(int row, int col)
    {
        this.row = row;
        this.col = col;
        matrix = new BigInteger[row][col];
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                matrix[i][k] = new BigInteger("0");
            }
        }
    }

    public Matrix(BigInteger[][] temp)
    {
        this.matrix = temp;
        row = temp.length;
        col = temp[0].length;
    }

    public static Matrix zeros(int row, int col) {
        Matrix temp = new Matrix(row, col);
        temp.setZeroMatrix();
        return temp;
    }

    public void setZeroMatrix() {
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                matrix[i][k] = new BigInteger("0");
            }
        }
    }

    public BigInteger[][] getMatrix() {
        return matrix;
    }

    public void setRecursiveMatrix(){
        for(int i =0;i<row;i++){
            for(int k=0;k<col;k++)
            {
                if(i==row-1 && k==col-1)
                    matrix[i][k]=new BigInteger("0");
                else
                    matrix[i][k]=new BigInteger("1");
            }
        }
    }

    public Matrix multiply(Matrix targetMatrix)
    {
        BigInteger[][] temp;
        if (this.col == targetMatrix.row) {
            temp = Matrix.zeros(this.row, targetMatrix.col).getMatrix();
            BigInteger[][] A = this.getMatrix();
            BigInteger[][] B = targetMatrix.getMatrix();
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < targetMatrix.col; j++) {
                    for (int a = 0; a < this.col; a++) {
                        temp[i][j] = temp[i][j].add(A[i][a].multiply(B[a][j]));
                    }
                }
            }
            return new Matrix(temp);
        } else {
            System.out.println("계산할 수 없습니다.");
            return null;
        }
    }
}
