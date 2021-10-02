import java.util.Scanner;

/**
 * Project name(项目名称)：StringBuffer替换特殊字符  replace-special-characters
 * Package(包名): PACKAGE_NAME
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/2
 * Time(创建时间)： 19:58
 * Version(版本): 1.0
 * Description(描述)： 在本实例中为保证学生输入的 Java 文件名合格，将利用 StringBuffer 类实现对 Java 文件名中的特殊符号进行替换，
 * 包括将中文状态下的“。”和全角状态下的“.”替换为英文状态下的“.”。
 */

public class test
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入文件名：");
        String filename = input.next();

        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------



        StringBuffer file = new StringBuffer(filename);
        // 获取英文状态下的"."是否存在
        int index = file.lastIndexOf(".");
        // 判断中文状态下的"。"和"."是否存在
        int errIndex1 = file.lastIndexOf("。");
        int errIndex2 = file.lastIndexOf(".");
        if (index != -1 && file.substring(index + 1, file.length()).equals("java"))
        {
            System.out.println("作业提交成功!");
        }
        else if (errIndex1 != -1 && file.substring(errIndex1 + 1, file.length()).equals("java"))
        {
            file.setCharAt(errIndex1, '.');
            System.out.println("你的书写有误，已改正为：" + file + "\r\n提交成功！");
        }
        else if (errIndex2 != -1 && file.substring(errIndex2 + 1, file.length()).equals("java"))
        {
            // 将全角状态下的"."改为英文状态下的"."
            file.setCharAt(errIndex2, '.');
            System.out.println("你的书写有误，已改正为：" + file + "\r\n提交成功！");
        }
        else
        {
            System.out.println("你提供的java文件名称有误，请核实！");
        }


        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
    }
}
