package com.basic.exer4;

public class EcmDef {

    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);

            int res = ecm(i, j);
            System.out.println(res);
        } catch (NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println("除0");
        } catch (EcDef e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行完毕");
        }
    }

    public static int ecm(int i, int j) throws EcDef {
        if (i < 0 || j < 0) {
            throw new EcDef("不能为负数");
        }
        return i / j;
    }
}
