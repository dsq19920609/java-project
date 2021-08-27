package com.iwhalecloud.offer.ZClass;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("请输入2个加数");
        int result;
        try
        {
            result = add();
            System.out.println("结果:"+result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取输入的2个整数返回
    private static List<Integer> getInputNumbers()
    {
        List<Integer> nums = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        nums.add(new Integer(num1));
        nums.add(new Integer(num2));
        return nums;
    }

    //执行加法计算
    private static int add() throws Exception
    {
        int result;
        List<Integer> nums =getInputNumbers();
        result = nums.get(0)  + nums.get(1);
        return  result;
    }
}
