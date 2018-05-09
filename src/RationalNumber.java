/**
 * 有理数结点类
 */
public class RationalNumber {
    private int num1;
    private int num2;
    private boolean flag = false;
    int layer;
    public void setNum1(int num1){
        this.num1 = num1;
    }
    public void setNum2(int num2){
        this.num2 = num2;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public void setLayer(int layer){
        this.layer = layer;
    }
    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }
    public boolean isFlag(){
        return flag;
    }
    public int getLayer(){
        return layer;
    }
}
