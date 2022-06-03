package com.javaExpriment;
/*
本次实验将为披萨店创建一个交易处理应用程序。 该程
序允许用户选择不同的 pizza，做一些基本的输入验证确保用户输入
的值正确有效。本次实验使用标准 Java IO（输入/输出）和 Scanner
类，并且创建新的类。 类似我们上次的作业 3，在此程序中，如果
用户输入了无效值，程序将正常终止（而不是崩溃，报一大堆错）。

 */

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Pizza {
    //返回选择商品的价格
    private static String getPrice(String choice, int size) {
        String price = "";
        switch (choice) {
            case "M":
            case "m":
                if (size == 12) {
                    price = "11.50";
                } else if (size == 16) {
                    price = "15.50";
                }
                break;
            case "V":
            case "v":
                if (size == 12) {
                    price = "9.50";
                } else if (size == 16) {
                    price = "13.50";
                }
                break;
            case "H":
            case "h":
                if (size == 12) {
                    price = "10.50";
                } else if (size == 16) {
                    price = "14.50";
                }
                break;
        }
        return price;

    }
    private static String getChoice(String choice) {
        //获取用户选择的商品
        return switch (choice) {
            case "M", "m" -> "Mega-Meaty";
            case "V", "v" -> "Very Vegetarian";
            case "H", "h" -> "Heaping Hawaiian";
            default -> "";
        };
    }
    //根据用户选择的商品，大小和数量，返回商品的价格
    private static double getSize(String size, String sizeChoice, int numPizzas, String bread) {
        //获取用户选择的商品的大小
        double sizePrice = 0;
        switch (size) {
            case "12":
                if(sizeChoice.equals("M") || sizeChoice.equals("m")) {
                    sizePrice = 11.50 * numPizzas;
                }
                else if(sizeChoice.equals("V") || sizeChoice.equals("v")) {
                    sizePrice = 9.50 * numPizzas;
                }
                else if(sizeChoice.equals("H") || sizeChoice.equals("h")) {
                    sizePrice = 10.50 * numPizzas;
                }
                break;
            case "16":
                if(sizeChoice.equals("M") || sizeChoice.equals("m")) {
                    sizePrice = 15.50 * numPizzas;
                }
                else if(sizeChoice.equals("V") || sizeChoice.equals("v")) {
                    sizePrice = 13.50 * numPizzas;
                }
                else if(sizeChoice.equals("H") || sizeChoice.equals("h")) {
                    sizePrice = 14.50 * numPizzas;
                }
                break;
        }
        if (bread.equals("Y") || bread.equals("y")) {
            sizePrice = sizePrice + 3.00;
        }
        return sizePrice;
    }
    //初始化函数
    public void init(){
        /*
        首先向用户问好，并询问用户的姓名。然后程序读取姓名，该
        姓名将在整个程序的其余部分中使用。
         */
        System.out.println("Welcome to the Java and a Slice Pizza Parlor.");
        System.out.print("Please enter a name for our transaction records: ");
        String name = new java.util.Scanner(System.in).nextLine();
        System.out.println();
        System.out.println("Thank you, " + name + ".");
        /*
        该程序接下来会提示用户在三种不同的披萨类型中进行选择：
        超级多肉（Mega-Meaty），非常非常素（Very Vegetarian）、一大堆夏威夷
        （Heaping Hawaiian）。 用户可以通过输入其名称的第一个字母来选择披萨
         */

        System.out.println("Which type of pizza would you like?");
        System.out.println("---------------------------------");
        System.out.println("\t(M)Mega-Meaty");
        System.out.println("\t(V)Very Vegetarian");
        System.out.println("\t(H)Heaping Hawaiian");
        System.out.println("---------------------------------");
        System.out.print("Enter pizza choice:");
        String choice = new java.util.Scanner(System.in).nextLine();
        System.out.println();
        System.out.println("Price list for pizza type: " + getChoice(choice));
        /*
        显示所选择的披萨的价格。
         */
        System.out.println("---------------------------------");
        System.out.println("\t12-inch: $"+ getPrice(choice, 12));
        System.out.println("\t16-inch: $"+ getPrice(choice, 16));

        System.out.println("---------------------------------");
        System.out.println();
        /*
        然后程序将提示用户选择披萨的大小，显示他们选择的披萨类
        型的价格（而不是其他类型的披萨）。然后程序将询问用户 pizza 的大小，大小必须是整数值（12 或
        16）。
         */
        System.out.println("What size of pizza would you like?");
        System.out.print("Enter size in inches: ");
        //判断输入的数是12或16
        String size = new java.util.Scanner(System.in).nextLine();
        if (size.equals("12") || size.equals("16")) {

        }
        else {
            System.out.println("Invalid size. Please enter 12 or 16.");
            return;
        }
        System.out.println();

        /*
        程序接下来会提示用户他们想要的比萨数量，其中必须是 1 到
        12 之间的整数值（包括 1 和 12）
         */
        System.out.println("How many pizzas would you like?");
        //判断输入的数是否在1到12之间
        int numPizzas = new java.util.Scanner(System.in).nextInt();
        if (numPizzas >= 1 && numPizzas <= 12) {

        }
        else {
            System.out.println("Invalid number of pizzas. Please enter 1 to 12.");
            return;
        }
        /*
        最后，该程序将询问用户是否需要再点一个 Cheezy Bread（以
        3 美元的合理价格提供）。 用户将回答 Y 表示是或 N 表示否。 答案
        可以是大写或小写; 任何其他答案都会导致程序终止（不会崩溃）
         */
        System.out.println();
        System.out.println("Would you like to add Cheezy Bread to that, for a $3.00 charge?");
        System.out.print("Please enter Y for yes or N for no:");
        String bread = new java.util.Scanner(System.in).nextLine();
        System.out.println();
        /*
        在用户做出所有必要的选择之后，程序首先表示感谢，再打印
        出他们的点单信息，包括数量，大小和披萨类型，以及最终价格。 （如
        果用户选择了 Cheezy Bread，这一项将包含在点单信息和价格中。）
         */
        System.out.println("---------------------------------");
        System.out.println("Thank you, " + name +"." + "Here is a record of your purchase.");
        System.out.println("---------------------------------");
        System.out.println(numPizzas + " " + size+"-inch" + " " + getChoice(choice)+ " pizza(s)");
        //判断是否需要加入cheezy bread
        if (bread.equals("Y") || bread.equals("y")) {
            System.out.println("1 order Cheezy Bread.");
        }
        System.out.println("---------------------------------");
        //根据数量，名称，大小和是否需要cheezy bread计算价格
        double price = getSize(size,choice,numPizzas,bread);
        /*
        要求将最后统计的价格以货币格式化的形式输出，
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MMMMdd日HH时mm分ss秒z", Locale.CHINA);
        //价格以货币格式化的形式输出
        System.out.println("the price is: " + NumberFormat.getCurrencyInstance(new Locale("en","AU")).format(price));
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("---------------------------------");
        /*
        使用 SimpleDateFormat 类并设计 pattern 显示当前日期和时间，其
        中月份用中文显示
         */
        System.out.println(sdf.format(new Date()));
        System.out.println("---------------------------------");

    }
}
