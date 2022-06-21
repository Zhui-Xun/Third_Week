package MARKET;

import java.util.Scanner;

public class Customer_Shopping {

    public String Name;
    public double Money;
    public boolean IsDrivingCar;

    // 构造方法
    public Customer_Shopping(Customer_Create customer) {
        this.Name = customer.name;
        this.Money = customer.money;
        this.IsDrivingCar = customer.isDrivingCar;
    }

    // TODO 顾客消费
    public void Shopping(Market_Creat market, Commodity_Create[] All_Commodity) {
        Scanner scanner = new Scanner(System.in);
        // 顾客消费
        System.out.println("--------------------------------------------------------");
        // 是否接待顾客
        if (IsDrivingCar) {
            if (market.Get_MarketParkingNumber() > 0) {
                System.out.println("欢迎" + Name + "光临，本店已经为您安排了车位，车位编号为" + market.Market_Parking_Number);
                market.Market_Parking_Number--;
            } else {
                System.out.println("本店车位已满，欢迎下次光临！");
            }
        }
        // 开始接待顾客
        double TotalCost = 0;
        System.out.println("欢迎\"" + Name + "\"，请您随意选购!");
        while (true) {
            System.out.println("请输入商品编号：(商品编号范围为\"1-" + market.Market_Commodity_Number + "\"，输入\"-1\"结束购物)");
            int merchandiseId = scanner.nextInt() - 1;
            // 输入负数，结束购买
            if (merchandiseId < 0) {
                System.out.println("您本次共消费：\"" + TotalCost + "。欢迎再次光临!");
                break;
            }
            // 商品编号超出范围，重新选择
            if (merchandiseId > market.Market_Commodity_Number) {
                System.out.println("本店无此商品，欢迎继续挑选！\n");
                continue;
            }
            // 商品有，问顾客要购买多少个
            Commodity_Create Buy = All_Commodity[merchandiseId];
            // 判断是否为手机商品，如果是，限购5个
            boolean LimitBuy = "电子类".equals(Buy.getPro_Category().getChinese());
            if (LimitBuy) {
                System.out.println("\"" + Buy.getPro_name() + "\"，单价：\"" + Buy.getPro_soldprice() + "\"。请问购买几个？(商品为电子类，限购5个)");
            } else {
                System.out.println("\"" + Buy.getPro_name() + "\"，单价：\"" + Buy.getPro_soldprice() + "\"。请问购买几个？");
            }
            int numToBuy = scanner.nextInt();
            // 购买数量有误
            if (numToBuy <= 0) {
                System.out.println("不买看看也好，欢迎继续选购！\n");
                continue;
            }
            // 限购商品，限制购买数量
            if (LimitBuy) {
                if (numToBuy >= 5) {
                    System.out.println("商品限购5个！");
                    continue;
                }
            }
            // 买的太多，库存不够
            if (Buy.getPro_count() < numToBuy) {
                System.out.println("\"" + Buy.getPro_name() + "\"库存只有\"" + Buy.getPro_count() + "\"个，数量不足\"" + numToBuy + "\"个。欢迎继续选购。");
                continue;
            }
            // 顾客钱不够
            if (numToBuy * Buy.getPro_soldprice() + TotalCost > Money) {
                System.out.println("您带的钱不够结账，请您理智消费!\n");
                continue;
            }

            // 钱也够，货也够。更新顾客此次消费的总额：
            TotalCost += numToBuy * Buy.getPro_soldprice();
            System.out.println("您当前共消费：" + TotalCost + "。\n");
            // 更新商品库存
            Buy.Change_Count(numToBuy);
            // System.out.println("\"" + Buy.Get_Pro_name() + "\"的剩余库存为：\""+Buy.Get_Pro_count()+"\"个。");
            // 更新今日销货数据
            market.Market_Commodity_Sold[merchandiseId] += numToBuy;
        }
        // 当前顾客消费结束，归还车位
        if (IsDrivingCar) {
            market.Market_Parking_Number++;
        }

        // 更新数据
        Money -= TotalCost;
        market.Market_incomingSum += TotalCost;
        System.out.println("\"" + Name + "\"共消费: \"" + TotalCost + "\"。欢迎再次光临。");
        System.out.println("--------------------------------------------------------\n");
    }


}
