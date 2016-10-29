import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class closest_pair_of_point {
    private static final int sortByX=0;
    private static final int sortByY=1;
    private static final double MaximumDouble = 1.7976931348623157E308;
    public static void main(String[] args) throws IOException {
        new closest_pair_of_point();
    }
    public closest_pair_of_point() throws IOException {
        double[][] array = new double[10000001][2];
        int lastIndex=0;
        double[][] input = inputData(lastIndex,array);
        quickSort(input,0, input.length-1,sortByX);
        double minimumDist = findMinimumDistance(input);
        System.out.printf("%.3f ",minimumDist);
    }

    private double findMinimumDistance(double[][] input) {
        if(input.length < 2)
            return MaximumDouble;
        if(input.length == 2 )
            return getDistance(input,0,1);
        int mid=input.length/2;
        int remain = mid;
        if(input.length%2==1){
            remain = remain+1;
        }

        double[][] A = new double[mid][2];
        double[][] B = new double[remain][2];
        System.arraycopy(input,0,A,0,mid);
        System.arraycopy(input,mid,B,0,remain);

        double L_dist = findMinimumDistance(A);
        double R_dist = findMinimumDistance(B);

        double dist_betweenAandB = getDistanceXY(A[mid-1][0],A[mid-1][1],B[0][0],B[0][1]);

        double min_dist = Math.min(Math.min(L_dist,R_dist),dist_betweenAandB);

        double L = (input[mid][0]+input[mid+1][0])/2;
        double Left_L = L-min_dist;
        double Right_L = L +min_dist;

        double[][] result = new double[input.length][2];
        int r_idx=0;


        /** 범위안 **/
        for(int i =0;i<input.length;i++){
            if(Left_L<input[i][0] &&  input[i][0]<Right_L){
                result[r_idx][0] = input[i][0];
                result[r_idx][1] = input[i][1];
                r_idx++;
            }
        }

        //y축 퀵소트
        quickSort(result,0,r_idx-1, sortByY);

        //window 범위안에서 minimum찾기
        double min_dist_in_window = findMinimumDistanceInWindow(result,r_idx,min_dist);
        return Math.min(min_dist,min_dist_in_window);
    }

    private double getDistanceXY(double x, double y, double x2, double y2) {
        double distX = Math.pow(x2-x,2);
        double distY = Math.pow(y2-y,2);
        return Math.sqrt(distX+distY);
    }


    private double findMinimumDistanceInWindow(double[][] pre_result, int last_index, double min_dist) {

        if(last_index<2)
            return MaximumDouble;

        double block = min_dist/2;
        double x_left_start = pre_result[0][0];
        double y_below_start = pre_result[0][1];

        double x_end = x_left_start+block*4;
        double y_end = y_below_start+block*6;

        double[][] result = new double[last_index][2];

        int lm_index=0;
        double minimumDist=MaximumDouble;

        while (true) {
            if(lm_index==last_index)
                break;

            int getIdx=lm_index;
            for (int i = lm_index; i < last_index; i++) {
                if (pre_result[i][0] >= x_left_start && pre_result[i][0] <= x_end && pre_result[i][1] >= y_below_start && pre_result[i][1] <= y_end) {
                    result[lm_index][0] = pre_result[i][0];
                    result[lm_index][1] = pre_result[i][1];
                    lm_index++;
                } else {
                    break;
                }
            }

            for (int i = getIdx; i < lm_index - 1; i++) {
                for (int j = i + 1; j < lm_index; j++) {
                    double dist = getDistance(result,i,j);
                    if (minimumDist > dist) {
                        minimumDist = dist;
                    }
                }
            }

            y_below_start += block * 6;
            y_end = y_below_start + block * 6;
        }

        return minimumDist;
    }

    private double getDistance(double[][] result,int i ,int j) {
        return Math.sqrt(Math.pow(result[i][0]-result[j][0],2)+Math.pow(result[i][1]-result[j][1],2));
    }


    private double[][] inputData(int lastIndex, double[][] array) throws IOException {

        FileInputStream stream = new FileInputStream("data07_closest.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer token = new StreamTokenizer(reader);
        boolean isY=false;
        while(hasToken(token)){
            if(token.ttype==token.TT_NUMBER){
                double val = token.nval;
                if(isY) {
                    array[lastIndex][1] = val;
                    isY=false;
                    lastIndex++;
                }else{
                    array[lastIndex][0] = val;
                    isY=true;
                }

            }
        }
        double[][] paramArray = new double[lastIndex][2];
        System.arraycopy(array,0,paramArray,0,lastIndex);
        return paramArray;
    }

    private static boolean hasToken(StreamTokenizer token) throws IOException {
        return token.nextToken() != StreamTokenizer.TT_EOF;
    }

    public static void quickSort(double[][] arr, int low, int high,int sortBy) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        double pivot = arr[middle][sortBy];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i][sortBy] < pivot) {
                i++;
            }

            while (arr[j][sortBy] > pivot) {
                j--;
            }

            if (i <= j) {

                double temp = arr[i][0];
                arr[i][0] = arr[j][0];
                arr[j][0] = temp;

                double temp2 = arr[i][1];
                arr[i][1] = arr[j][1];
                arr[j][1] = temp2;

                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, low, j,sortBy);

        if (high > i)
            quickSort(arr, i, high,sortBy);
    }


}
