package MARKET;

import java.util.Scanner;

public class Customer_Shopping {

    public String Name;
    public double Money;
    public boolean IsDrivingCar;

    // ���췽��
    public Customer_Shopping(Customer_Create customer) {
        this.Name = customer.name;
        this.Money = customer.money;
        this.IsDrivingCar = customer.isDrivingCar;
    }

    // TODO �˿�����
    public void Shopping(Market_Creat market, Commodity_Create[] All_Commodity) {
        Scanner scanner = new Scanner(System.in);
        // �˿�����
        System.out.println("--------------------------------------------------------");
        // �Ƿ�Ӵ��˿�
        if (IsDrivingCar) {
            if (market.Get_MarketParkingNumber() > 0) {
                System.out.println("��ӭ" + Name + "���٣������Ѿ�Ϊ�������˳�λ����λ���Ϊ" + market.Market_Parking_Number);
                market.Market_Parking_Number--;
            } else {
                System.out.println("���공λ��������ӭ�´ι��٣�");
            }
        }
        // ��ʼ�Ӵ��˿�
        double TotalCost = 0;
        System.out.println("��ӭ\"" + Name + "\"����������ѡ��!");
        while (true) {
            System.out.println("��������Ʒ��ţ�(��Ʒ��ŷ�ΧΪ\"1-" + market.Market_Commodity_Number + "\"������\"-1\"��������)");
            int merchandiseId = scanner.nextInt() - 1;
            // ���븺������������
            if (merchandiseId < 0) {
                System.out.println("�����ι����ѣ�\"" + TotalCost + "����ӭ�ٴι���!");
                break;
            }
            // ��Ʒ��ų�����Χ������ѡ��
            if (merchandiseId > market.Market_Commodity_Number) {
                System.out.println("�����޴���Ʒ����ӭ������ѡ��\n");
                continue;
            }
            // ��Ʒ�У��ʹ˿�Ҫ������ٸ�
            Commodity_Create Buy = All_Commodity[merchandiseId];
            // �ж��Ƿ�Ϊ�ֻ���Ʒ������ǣ��޹�5��
            boolean LimitBuy = "������".equals(Buy.getPro_Category().getChinese());
            if (LimitBuy) {
                System.out.println("\"" + Buy.getPro_name() + "\"�����ۣ�\"" + Buy.getPro_soldprice() + "\"�����ʹ��򼸸���(��ƷΪ�����࣬�޹�5��)");
            } else {
                System.out.println("\"" + Buy.getPro_name() + "\"�����ۣ�\"" + Buy.getPro_soldprice() + "\"�����ʹ��򼸸���");
            }
            int numToBuy = scanner.nextInt();
            // ������������
            if (numToBuy <= 0) {
                System.out.println("���򿴿�Ҳ�ã���ӭ����ѡ����\n");
                continue;
            }
            // �޹���Ʒ�����ƹ�������
            if (LimitBuy) {
                if (numToBuy >= 5) {
                    System.out.println("��Ʒ�޹�5����");
                    continue;
                }
            }
            // ���̫�࣬��治��
            if (Buy.getPro_count() < numToBuy) {
                System.out.println("\"" + Buy.getPro_name() + "\"���ֻ��\"" + Buy.getPro_count() + "\"������������\"" + numToBuy + "\"������ӭ����ѡ����");
                continue;
            }
            // �˿�Ǯ����
            if (numToBuy * Buy.getPro_soldprice() + TotalCost > Money) {
                System.out.println("������Ǯ�������ˣ�������������!\n");
                continue;
            }

            // ǮҲ������Ҳ�������¹˿ʹ˴����ѵ��ܶ
            TotalCost += numToBuy * Buy.getPro_soldprice();
            System.out.println("����ǰ�����ѣ�" + TotalCost + "��\n");
            // ������Ʒ���
            Buy.Change_Count(numToBuy);
            // System.out.println("\"" + Buy.Get_Pro_name() + "\"��ʣ����Ϊ��\""+Buy.Get_Pro_count()+"\"����");
            // ���½�����������
            market.Market_Commodity_Sold[merchandiseId] += numToBuy;
        }
        // ��ǰ�˿����ѽ������黹��λ
        if (IsDrivingCar) {
            market.Market_Parking_Number++;
        }

        // ��������
        Money -= TotalCost;
        market.Market_incomingSum += TotalCost;
        System.out.println("\"" + Name + "\"������: \"" + TotalCost + "\"����ӭ�ٴι��١�");
        System.out.println("--------------------------------------------------------\n");
    }


}
