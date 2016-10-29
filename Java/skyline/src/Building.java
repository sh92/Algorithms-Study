/**
 * Created by withGod on 10/17/16.
 */
public class Building {

    private int l;
    private int r;
    private int h;

    public Building() {
        l=0;
        h=0;
        r=0;
    }

    public Building(int l, int h, int r) {
        this.l=l;
        this.h=h;
        this.r=r;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setH(int h) {
        this.h = h;
    }
    public int getL() {
        return l;
    }

    public int getR() {
        return r;
    }

    public int getH() {
        return h;
    }
}
