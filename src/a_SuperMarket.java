import MARKET.*;

import java.util.Date;
import java.util.Scanner;

public class a_SuperMarket {
    public static void main(String[] args) {

        // ���д���
        Market_Creat market = new Market_Creat("����", "δ����666��", 500, 200);
        // ��Ʒ����
        Commodity_Create[] All_Commodity = market.MK_Products_Generate_with_Category(market.Get_MarketProductsNumber());
        // ���н���
        //market.describe();            // ����Ʒ�������
        market.describe_Category();     // ������Ʒ�������

        System.out.println("\n���п���Ӫҵ����\n");
        System.out.println("�����Ƽ���Ʒ��");
        market.Manual_Add_Merchandise();  // �ֶ���ӵ���Ʒ
        System.out.println("=========== 1 ����Ʒ�����Ϊ��1��===========");
        All_Commodity[0].describe();
        System.out.println("=========== 2 ����Ʒ�����Ϊ��2��===========");
        All_Commodity[1].describe();
        System.out.println("=========== 3 ����Ʒ�����Ϊ��3��===========");
        All_Commodity[2].describe();

        //  TODO ���� protected ���ʿ��Ʒ�
        System.out.println("\n====== ���� protected ���ʿ��Ʒ����ⲿ���ʣ� ======");
        System.out.println("1 ���ֻ�����");
        System.out.println("public OS: "+((Phone_Create) All_Commodity[0]).OS);             // public, �ɷ���
        //System.out.println("protected CPU: "+((Phone_Create) All_Commodity[0]).CPU);           // protected, ����ͬһ�����£���0�ɷ���
        //System.out.println("private Memeory: "+((Phone_Create) All_Commodity[0]).Memory);    // private, ˽�����ԣ����ɷ���
        System.out.println("================== ���Խ��� ==================");

        // TODO ���Խӿڷ���
        Phone_Create_Interface HuaWei = new Phone_Create_Interface("P30", "ANH00", 10, 5000,
                5499, Merchandise_Category.ELECTRICAL, 6.6, 3.8, 10, 128, "HuaWei", "����");
        System.out.println("\n=========== Test Interface ===========");
        System.out.println("�ֻ�����������Ϊ��" + HuaWei.getProducedDate(new Date()));
        System.out.println("�ֻ���ʣ���ֵΪ��" + HuaWei.leftActualValue(0.9));

        // TODO �������ø�ֵ
        System.out.println("\n=========== �������ø�ֵ ===========");
        Phone_Create AppalePhone = new Phone_Create("Appale 13", "OO6", 100,
                5999, 7999, Merchandise_Category.ELECTRICAL, 6,
                3.25, 4, 256, "Appale", "IOS");

        Commodity_Create m1 = AppalePhone;         // ��������������ø���������ø�ֵ��Ҳ����˵����������ÿ���ָ������Ķ���;
        Commodity_Create m2 = new Phone_Create();  // ���Ƿ�֮���У����������������ָ����Ķ�����Ϊ���ಢû����������Ժͷ���.

        System.out.println("AppalePhone��Ʒ��Ϊ��" + AppalePhone.getBrand()); //  AppalePhone �� m1 ��ָ��ͬһ�����󣬵��� m1 �����Ե���getBrand����;
        //System.out.println("m1��Ʒ��Ϊ��" + m1.getBrand());                 // ��Ϊ m1 ��������Commodity_Create��Commodity_Create��û���㶨��getBrand����.

        Phone_Create aPhone = (Phone_Create) m2; // ���ȷ��һ�����������ָ��Ķ���ʵ���Ͼ���һ������Ķ��󣨻������������Ķ��󣩣�����ǿ������ת��



        // >> TODO ����������
        boolean open = false;
        if (!open) {
            System.out.println("\n************* ������ͣӪҵ�� ***************\n");
        }
        // ��������
        Scanner scanner = new Scanner(System.in);

        // ������ѭ��
        while (open) {
            // �����˿�
            Customer_Create customer = Customer_Create.Customer_init();
            //System.out.println(customer.name);

            // �����˿�����ʵ��
            Customer_Shopping customer_shopping = new Customer_Shopping(customer);
            // �˿Ϳ�ʼ����
            customer_shopping.Shopping(market, All_Commodity);

            // ����Ӫҵ��
            System.out.println("\n���ʼ���Ӫҵ�� \"true\" or \"false\"");
            String continueopen = scanner.next();
            if ("true".equals(continueopen)) {
                open = true;
            } else if ("false".equals(continueopen)) {
                open = false;
            } else {
                System.out.println("�Ƿ����룬���йرգ�");
                open = false;
            }

        }

        // Ӫҵ�ܽ�
        Business_Records day1 = new Business_Records();
        day1.Records_describe(market);

    }
}
