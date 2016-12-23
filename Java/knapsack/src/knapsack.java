import java.io.*;
import java.util.Scanner;

public class knapsack {
    public static void main(String[] args) throws IOException {
        new knapsack();
    }
    public  knapsack() throws IOException {
        FileInputStream stream = new FileInputStream("data11.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer token = new StreamTokenizer(reader);
        int idx=0;
        int size=100;
        int item[] = new int[size];
        int value[] = new int[size];
        int weight[] = new int[size];


        while (token.nextToken() != StreamTokenizer.TT_EOF) {
            switch (token.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    int temp = idx%3;
                    switch (temp) {
                        case 0:
                            item[idx/3+1]= (int)token.nval;
                            break;
                        case 1:
                            value[(idx-1)/3+1]= (int)token.nval;
                            break;
                        case 2:
                            weight[(idx-2)/3+1]= (int)token.nval;
                            break;
                    }
                    idx++;
                    break;
            }
        }
        int n=idx/3;


        Scanner scanner = new Scanner(System.in);
        System.out.println("배낭의 크기를 입력하세요 (0~50) : ");
        int w =scanner.nextInt();
        if(w>50 ||w<0){
            return;
        }
        int bag[][]= new int[n+2][w+2]; // item weight

        int max = 0;
        int index=0;
        int selectedItem[]=new int[n+2];

        for(int j =0;j<=w;j++){
            for(int i=0;i<=n;i++){
                index=0;
                for (int k=1;k<=i;k++){
                    if (weight[k]>j){
                        bag[k][j]=bag[k-1][j];
                    }else{
                        int t1=bag[k-1][j];
                        int t2=value[k]+bag[k-1][j-weight[k]];
                        bag[k][j]=Math.max(t1,t2);
                    }
                }
            }
        }
        max = findMax(n, w, bag);
        printBag(n, w, bag);
        printSelectedItem(value, n, w, bag, max, index, selectedItem);

    }

    private void printSelectedItem(int[] value, int n, int w, int[][] bag, int max, int index, int[] selectedItem) {
        int remainValue = max;
        int nn=n;
        int ww=w;
        while(remainValue>0){
            while(nn>0){
                nn--;
                if(remainValue!=bag[nn][ww]) {
                    selectedItem[index]=nn+1;
                    remainValue -= value[nn+1];
                    index++;
                    break;
                }
            }
            while(ww>0){
                if(remainValue==bag[nn][ww]){
                    break;
                }
                ww--;
            }
        }
        System.out.print("Item :");
        int i;
        for( i=index-1;i>=0;i--){
            System.out.print(selectedItem[i]+" ");
        }
    }

    private void printBag(int n, int w, int[][] bag) {
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                System.out.printf("%3d",bag[i][j]);
            }
            System.out.println();
        }
    }

    private int findMax(int n, int w, int[][] bag) {
        int max;
        max = bag[n][w];
        System.out.println("max is "+max);
        return max;
    }
}
