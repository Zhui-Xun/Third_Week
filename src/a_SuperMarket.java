import MARKET.*;

import java.util.Date;
import java.util.Scanner;

public class a_SuperMarket {
    public static void main(String[] args) {

        // 超市创建
        Market_Creat market = new Market_Creat("大超市", "未来市666号", 500, 200);
        // 商品生成
        Commodity_Create[] All_Commodity = market.MK_Products_Generate_with_Category(market.Get_MarketProductsNumber());
        // 超市介绍
        //market.describe();            // 无商品类别描述
        market.describe_Category();     // 含有商品类别描述

        System.out.println("\n超市开门营业啦！\n");
        System.out.println("今日推荐商品：");
        market.Manual_Add_Merchandise();  // 手动添加的商品
        System.out.println("=========== 1 号商品（编号为：1）===========");
        All_Commodity[0].describe();
        System.out.println("=========== 2 号商品（编号为：2）===========");
        All_Commodity[1].describe();
        System.out.println("=========== 3 号商品（编号为：3）===========");
        All_Commodity[2].describe();

        //  TODO 测试 protected 访问控制符
        System.out.println("\n====== 测试 protected 访问控制符（外部访问） ======");
        System.out.println("1 号手机属性");
        System.out.println("public OS: "+((Phone_Create) All_Commodity[0]).OS);             // public, 可访问
        //System.out.println("protected CPU: "+((Phone_Create) All_Commodity[0]).CPU);           // protected, 不在同一个包下，不0可访问
        //System.out.println("private Memeory: "+((Phone_Create) All_Commodity[0]).Memory);    // private, 私有属性，不可访问
        System.out.println("================== 测试结束 ==================");

        // TODO 测试接口方法
        Phone_Create_Interface HuaWei = new Phone_Create_Interface("P30", "ANH00", 10, 5000,
                5499, Merchandise_Category.ELECTRICAL, 6.6, 3.8, 10, 128, "HuaWei", "鸿蒙");
        System.out.println("\n=========== Test Interface ===========");
        System.out.println("手机的生产日期为：" + HuaWei.getProducedDate(new Date()));
        System.out.println("手机的剩余价值为：" + HuaWei.leftActualValue(0.9));

        // TODO 测试引用赋值
        System.out.println("\n=========== 测试引用赋值 ===========");
        Phone_Create AppalePhone = new Phone_Create("Appale 13", "OO6", 100,
                5999, 7999, Merchandise_Category.ELECTRICAL, 6,
                3.25, 4, 256, "Appale", "IOS");

        Commodity_Create m1 = AppalePhone;         // 可以用子类的引用给父类的引用赋值，也就是说，父类的引用可以指向子类的对象;
        Commodity_Create m2 = new Phone_Create();  // 但是反之则不行，不能让子类的引用指向父类的对象。因为父类并没有子类的属性和方法.

        System.out.println("AppalePhone的品牌为：" + AppalePhone.getBrand()); //  AppalePhone 和 m1 都指向同一个对象，但是 m1 不可以调用getBrand方法;
        //System.out.println("m1的品牌为：" + m1.getBrand());                 // 因为 m1 的类型是Commodity_Create，Commodity_Create里没有你定义getBrand方法.

        Phone_Create aPhone = (Phone_Create) m2; // 如果确定一个父类的引用指向的对象，实际上就是一个子类的对象（或者子类的子类的对象），可以强制类型转换



        // >> TODO 超市主程序
        boolean open = false;
        if (!open) {
            System.out.println("\n************* 超市暂停营业中 ***************\n");
        }
        // 创建输入
        Scanner scanner = new Scanner(System.in);

        // 主程序循环
        while (open) {
            // 创建顾客
            Customer_Create customer = Customer_Create.Customer_init();
            //System.out.println(customer.name);

            // 创建顾客消费实例
            Customer_Shopping customer_shopping = new Customer_Shopping(customer);
            // 顾客开始消费
            customer_shopping.Shopping(market, All_Commodity);

            // 继续营业？
            System.out.println("\n请问继续营业吗？ \"true\" or \"false\"");
            String continueopen = scanner.next();
            if ("true".equals(continueopen)) {
                open = true;
            } else if ("false".equals(continueopen)) {
                open = false;
            } else {
                System.out.println("非法输入，超市关闭！");
                open = false;
            }

        }

        // 营业总结
        Business_Records day1 = new Business_Records();
        day1.Records_describe(market);

    }
}
