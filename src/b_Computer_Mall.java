// �����̳�

import MARKET.Commodity_Create;
import MARKET.Market_Creat;
import MARKET.Merchandise_Category;
import MARKET.Phone_Create_Interface;

import java.util.Date;

public class b_Computer_Mall {
    public static void main(String[] args) {

        // ���д���
        Market_Creat Computer_market = new Market_Creat("�����̳�", "δ����666��", 100, 50);
        // ��Ʒ����
        Commodity_Create[] All_Commodity = Computer_market.MK_Products_Generate_Specific_Category(Computer_market.Get_MarketProductsNumber(),Merchandise_Category.ELECTRICAL);
        // ���н���
        //Computer_market.describe();            // ����Ʒ�������
        Computer_market.describe_Category();     // ������Ʒ�������


        System.out.println("\n���п���Ӫҵ����\n");
        System.out.println("�����Ƽ���Ʒ��");
        Computer_market.Manual_Add_Merchandise();  // �ֶ���ӵ���Ʒ
        // �ֻ���Ʒ
        System.out.println("=========== 1 ����Ʒ�����Ϊ��1��===========");
        All_Commodity[0].describe();
        System.out.println("=========== 2 ����Ʒ�����Ϊ��2��===========");
        All_Commodity[1].describe();
        System.out.println("=========== 3 ����Ʒ�����Ϊ��3��===========");
        All_Commodity[2].describe();

        // ������Ʒ
        System.out.println("=========== 4 ����Ʒ�����Ϊ��4��===========");
        All_Commodity[3].describe();
        System.out.println("=========== 5 ����Ʒ�����Ϊ��5��===========");
        All_Commodity[4].describe();
        System.out.println("=========== 6 ����Ʒ�����Ϊ��6��===========");
        All_Commodity[5].describe();

    }
}
