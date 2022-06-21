// 电脑商城

import MARKET.Commodity_Create;
import MARKET.Market_Creat;
import MARKET.Merchandise_Category;
import MARKET.Phone_Create_Interface;

import java.util.Date;

public class b_Computer_Mall {
    public static void main(String[] args) {

        // 超市创建
        Market_Creat Computer_market = new Market_Creat("电子商城", "未来市666号", 100, 50);
        // 商品生成
        Commodity_Create[] All_Commodity = Computer_market.MK_Products_Generate_Specific_Category(Computer_market.Get_MarketProductsNumber(),Merchandise_Category.ELECTRICAL);
        // 超市介绍
        //Computer_market.describe();            // 无商品类别描述
        Computer_market.describe_Category();     // 含有商品类别描述


        System.out.println("\n超市开门营业啦！\n");
        System.out.println("今日推荐商品：");
        Computer_market.Manual_Add_Merchandise();  // 手动添加的商品
        // 手机商品
        System.out.println("=========== 1 号商品（编号为：1）===========");
        All_Commodity[0].describe();
        System.out.println("=========== 2 号商品（编号为：2）===========");
        All_Commodity[1].describe();
        System.out.println("=========== 3 号商品（编号为：3）===========");
        All_Commodity[2].describe();

        // 电脑商品
        System.out.println("=========== 4 号商品（编号为：4）===========");
        All_Commodity[3].describe();
        System.out.println("=========== 5 号商品（编号为：5）===========");
        All_Commodity[4].describe();
        System.out.println("=========== 6 号商品（编号为：6）===========");
        All_Commodity[5].describe();

    }
}
