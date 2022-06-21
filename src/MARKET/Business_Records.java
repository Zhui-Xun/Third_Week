package MARKET;

public class Business_Records {

    // 营业记录
    public void Records_describe(Market_Creat market) {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("超市关门啦！");
        System.out.println("---------------------------------------");
        System.out.println("今日销售额为" + market.Market_incomingSum + "。营业记录如下：");
        for (int i = 0; i < market.Market_Commodity_Sold.length; i++) {
            int sold = market.Market_Commodity_Sold[i];
            if (sold > 0) {
                Commodity_Create m = market.Market_Commodity[i];
                double netIncoming = sold * (m.profit());
                double incoming = sold * m.getPro_soldprice();
                System.out.println("\"" + market.Market_Commodity[i].getPro_name() + "\"售出：\"" + sold + "\"个。" +
                        "销售额为：\"" + incoming + "\"。毛利润为：\"" + netIncoming + "\"。");
            }
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

}
