import java.util.ArrayList;
import java.util.Scanner;

/**
 * 利用Wilf tree列出所有在给定整数内的有理数
 */

public class FindRationalNumber {
    public static void main(String[] args){
        System.out.println("Please input an integer:");
        Scanner scanner = new Scanner(System.in);//给定整数
        int stopNumber = scanner.nextInt();
        ArrayList<RationalNumber> list = new ArrayList();//存储所有符合要求的有理数
        if(stopNumber>0){//当给定整数大于0，将1加入list并且开始搜寻符合要求的其他有理数
            RationalNumber rationalNumber1 = new RationalNumber();
            rationalNumber1.setNum1(1);
            rationalNumber1.setNum2(1);
            rationalNumber1.setLayer(1);
            list.add(rationalNumber1);
            for(int i =0; i < Math.pow(2,stopNumber-1);i++){
                list = find(list.get(i),list,stopNumber);
            }
        }
        System.out.println("Rational Numbers:");
        System.out.print("0"+"  ");//单独将0输出，也可将其化为RationalNumber类加入list
        for(RationalNumber r : list){//输出结果
            System.out.print(r.getNum1()+"/"+r.getNum2()+"  ");
        }
    }

    /**
     * 计算节点rationlNumber的两个子节点并且存入list
     * @param rationalNumber
     * @param list
     * @param stopNumber
     * @return
     */
    public static ArrayList<RationalNumber> find(RationalNumber rationalNumber, ArrayList<RationalNumber> list, int stopNumber){
        if(rationalNumber.isFlag()|| rationalNumber.getLayer()>=stopNumber){
            return list;
        }
        RationalNumber nextRationalNumber = new RationalNumber();
        int temple = rationalNumber.getNum1()+ rationalNumber.getNum2();
        nextRationalNumber.setNum1(rationalNumber.getNum1());
        nextRationalNumber.setNum2(temple);
        nextRationalNumber.setLayer(rationalNumber.getLayer()+1);
        list.add(nextRationalNumber);//加入左子节点
        RationalNumber nextRationalNumber2 = new RationalNumber();
        nextRationalNumber2.setNum2(rationalNumber.getNum2());
        nextRationalNumber2.setNum1(temple);
        nextRationalNumber2.setLayer(rationalNumber.getLayer()+1);
        list.add(nextRationalNumber2);//加入右子节点
        rationalNumber.setFlag(true);//标记rationalNumber的子节点已计算过
        return list;
    }

}
