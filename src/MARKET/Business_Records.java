package MARKET;

public class Business_Records {

    // Ӫҵ��¼
    public void Records_describe(Market_Creat market) {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("���й�������");
        System.out.println("---------------------------------------");
        System.out.println("�������۶�Ϊ" + market.Market_incomingSum + "��Ӫҵ��¼���£�");
        for (int i = 0; i < market.Market_Commodity_Sold.length; i++) {
            int sold = market.Market_Commodity_Sold[i];
            if (sold > 0) {
                Commodity_Create m = market.Market_Commodity[i];
                double netIncoming = sold * (m.profit());
                double incoming = sold * m.getPro_soldprice();
                System.out.println("\"" + market.Market_Commodity[i].getPro_name() + "\"�۳���\"" + sold + "\"����" +
                        "���۶�Ϊ��\"" + incoming + "\"��ë����Ϊ��\"" + netIncoming + "\"��");
            }
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

}
