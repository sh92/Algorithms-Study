import java.io.*;
import java.util.Scanner;

public class skyline_project {
    public static void main(String[] args) throws IOException {
        new skyline_project();
    }

    public skyline_project() throws IOException {

        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        Building[] B= new Building[n];
        for(int i =0;i<n;i++) {
            B[i] = new Building();
        }

        int lastIndex = 0;
        int index=-1;

        while(index<n-1) {
            int val = scan.nextInt();
            if(lastIndex%3==0) {
                index++;
                B[index].setL(val);
            }else if(lastIndex%3==1) {
                B[index].setH(val);
            }else if(lastIndex%3==2){
                B[index].setR(val);
            }
            lastIndex++;
        }

        Skyline skyline = findSkyline(B,0,index);
        ArrayQueue arr = skyline.getLineList();

        int prevL=0;
        int prevH=0;
        if(!arr.empty()){
            Line line = arr.remove();
            System.out.print(line.L()+",");
            System.out.print(line.H()+",");
            prevL=line.L();
            prevH=line.H();
        }
        while(!arr.empty()){
            Line line = arr.remove();
            if(prevL!=line.L() && prevH!=line.H()) {
                System.out.print(line.L() + ",");
                System.out.print(line.H());
                if(!arr.empty())
                    System.out.print(",");
            }
            prevL=line.L();
            prevH=line.H();
        }

    }

    private Skyline findSkyline(Building[] B, int s, int e) {

        Skyline skyline = new Skyline();
        if(s==e) {
            skyline.append(B[s].getL(), B[s].getH());
            skyline.append(B[e].getR(), 0);
            return skyline;
        }

        int mid = (s+e)/2;
        Skyline sky1 = findSkyline(B,s,mid);
        Skyline sky2 = findSkyline(B,mid+1,e);
        return mergeSkyline(sky1,sky2);
    }

    private Skyline mergeSkyline(Skyline sky1, Skyline sky2) {
        int currentH1=0;
        int currentH2=0;
        Skyline skyline = new Skyline();
        while(sky1.count()>0 && sky2.count()>0){
            if(sky1.First().L()< sky2.First().L()){
                int currentX = sky1.First().L();
                currentH1=sky1.First().H();
                int maxH = currentH1;
                if(currentH2 > maxH){
                    maxH = currentH2;
                }
                skyline.append(currentX,maxH);
                sky1.removeFirst();
            }else{
                int currentX=sky2.First().L();
                currentH2 = sky2.First().H();
                int maxH = currentH1;
                if(currentH2>maxH)
                {
                    maxH=currentH2;
                }
                skyline.append(currentX,maxH);
                sky2.removeFirst();
            }
        }
        while(sky1.count()>0){
            skyline.append(sky1.First().L(),sky1.First().H());
            sky1.removeFirst();
        }
        while(sky2.count()>0){
            skyline.append(sky2.First().L(),sky2.First().H());
            sky2.removeFirst();
        }
        return skyline;
    }


}

