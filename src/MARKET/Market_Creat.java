package MARKET;

import Computer.Computer_Create;

import java.util.Arrays;

public class Market_Creat {

    // ˽�г�Ա����
    private String Market_Name;         // ��������
    private String Market_Address;      // ���е�ַ
    public int Market_Commodity_Number; // ��Ʒ����
    public int Market_Parking_Number;  // ͣ��λ����
    // ������Ա����
    public double Market_incomingSum;           // Ӫҵ����
    public Commodity_Create[] Market_Commodity; // ��Ʒ����
    public int[] Market_Commodity_Sold;         // �۳���Ʒ
    public Merchandise_Category_Record[] Market_Category_Record; // ��Ʒ���ͳ��


    // >> TODO ���췽��
    public Market_Creat(String MarketName, String MarketAddress, int MarketProductsNumber, int MarketParkingNumber) {

        this.Market_Name = MarketName;
        this.Market_Address = MarketAddress;
        this.Market_Commodity_Number = MarketProductsNumber;
        this.Market_Parking_Number = MarketParkingNumber;
        this.Market_incomingSum = 0;
        this.Market_Commodity = new Commodity_Create[MarketProductsNumber];
        this.Market_Commodity_Sold = new int[MarketProductsNumber];
        this.Market_Category_Record = new Merchandise_Category_Record[Merchandise_Category.values().length];

    }

    // >> TODO ����

    // Method:��Ʒ����
    public Commodity_Create[] MK_Products_Generate(int ProductsNumber) {

        for (int i = 0; i < ProductsNumber; i++) {
            String name = "" + (i + 1);
            String id = "" + (i + 1);
            Commodity_Create product = new Commodity_Create(name, id, 200);
            Market_Commodity[i] = product;
        }
        Merchandise_Category_Record record = new Merchandise_Category_Record("δ֪���", ProductsNumber, 1, ProductsNumber);
        // ��ǰ��Ʒ����¼
        Market_Category_Record[Merchandise_Category.values().length - 1] = record;
        return Market_Commodity;

    }

    // �����ض�������Ʒ
    public Commodity_Create[] MK_Products_Generate_Specific_Category(int ProductsNumber, Merchandise_Category Category) {

        for (int i = 0; i < ProductsNumber; i++) {
            String name = "" + (i + 1);
            String id = "" + (i + 1);
            Commodity_Create product = new Commodity_Create(name, id, 200, Category);
            Market_Commodity[i] = product;
        }
        Merchandise_Category_Record record = new Merchandise_Category_Record(Category.getChinese(), ProductsNumber, 1, ProductsNumber);
        // ��ǰ��Ʒ����¼
        Market_Category_Record[Category.getId()] = record;
        return Market_Commodity;

    }


    // Method:��������Զ�������Ʒ
    public Commodity_Create[] MK_Products_Generate_with_Category(int ProductsNumber) {

        // ��ͬ��Ʒ����𡰵ı�ŷ�Χ
        int[] Sequence = new int[Merchandise_Category.values().length + 1];
        Sequence[0] = 0; // ���������һ��ֵΪ��Ʒ����Ŀ
        // ��ö���б������Ʒ��������ַ���������
        int[] CategoryId = new int[Merchandise_Category.values().length];
        String[] CategoryName = new String[Merchandise_Category.values().length];
        int Category_i = 0;
        for (Merchandise_Category Category : Merchandise_Category.values()) {
            Sequence[Category_i + 1] = (int) (Math.random() * ProductsNumber);
            CategoryId[Category_i] = Category.getId();
            CategoryName[Category_i] = Category.name();
            Category_i++;
        }
        Sequence[Merchandise_Category.values().length] = ProductsNumber; // �����������һ��ֵΪ��Ʒ����Ŀ
        Arrays.sort(Sequence); // �����������

        int Merchandise_i = 0;
        Category_i = 0;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("���г�ʼ����......");
        int SequenceStart = 0;
        int SequenceEnd = 0;
        for (int ran = 0; ran < Merchandise_Category.values().length; ran++) {
            Merchandise_Category Category = Merchandise_Category.valueOf(CategoryName[Category_i]);
            SequenceStart = Sequence[ran];
            SequenceEnd = Sequence[ran + 1] - 1;
            for (int i = SequenceStart; i < SequenceEnd; i++) {
                String name = "" + (i + 1);
                String id = "" + (i + 1);
                Commodity_Create product = new Commodity_Create(name, id, 200, Category);
                Market_Commodity[i] = product;
            }
            Merchandise_Category_Record record = new Merchandise_Category_Record(Category.getChinese(),
                    (SequenceEnd - SequenceStart + 1), (SequenceStart + 1), (SequenceEnd + 1));
            // ��ǰ��Ʒ����¼
            Market_Category_Record[ran] = record;

            //
            Category_i++;
            //System.out.println("��Ʒ���\"" + Category.getChinese() + "\"����" + (SequenceEnd - SequenceStart + 1) + "�֣���Ŵ�(" + (SequenceStart + 1) + "," + (SequenceEnd + 1) + ");");
        }

        System.out.println("���г�ʼ����ϣ�");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        return Market_Commodity;
    }

    // Method: �ֶ���ӣ��޸ģ���Ʒ
    public void Manual_Add_Merchandise() {
        // ����ֻ���Ʒ
        Market_Commodity[0] = new Phone_Create("��ΪMate40 Pro", "NOH-ANOO", 100,
                5999,6999, Merchandise_Category.ELECTRICAL, 6.6,
                3.6, 8, 256, "HuaWei", "HarmoneyOS");
        Market_Commodity[1] = new Phone_Create("��ΪMate9 Pro", "LON-AHOO", 50,
                4999,5499, Merchandise_Category.ELECTRICAL, 5,
                3.2, 4, 128, "HuaWei", "Android");
        Market_Commodity[2] = new Phone_Create();

        //  TODO ���� protected ���ʿ��Ʒ�

        System.out.println("\n===== ���� protected ���ʿ��Ʒ����ڲ����ʣ� =====");
        System.out.println("public OS: " + ((Phone_Create) Market_Commodity[0]).OS);             // public, �ɷ���
        System.out.println("protected CPU: " + ((Phone_Create) Market_Commodity[0]).CPU);           // protected, ��ͬһ�����£��ɷ���
        //System.out.println("private Memeory: "+((Phone_Create) Market_Commodity[0]).Memory);    // private, ˽�����ԣ����ɷ���
        System.out.println("================== ���Խ��� ==================\n");

        // ��ӵ�����Ʒ
        Market_Commodity[3] = new Computer_Create("����Ӷ���", "004", 10, 13000,
                14999, Merchandise_Category.ELECTRICAL, "ACER", "500SE", 15.6,
                "165Hz", "2K", "i7-12700K", "RTX 3070Ti", 32, "1T_SSD+2T_HDD");
        Market_Commodity[4] = new Computer_Create("����������", "005", 10, 11000,
                12999, Merchandise_Category.ELECTRICAL, "LENOVO", "R9000P", 15.6,
                "165Hz", "2K", "i7-12700K", "RTX 3070Ti", 32, "1T_SSD+1T_HDD");
        Market_Commodity[5] = new Computer_Create();

    }


    // Method:��������
    public void describe() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\"" + Market_Name + "\"��ҵ��������ַ��\"" + Market_Address + "\"��" +
                "���й���\"" + Market_Commodity_Number + "\"����Ʒ��ͣ��λ��\"" + Market_Parking_Number + "\"������ӭ���ѡ����");
        System.out.println("-----------------------------------------------------------------------------------");
    }

    // ������Ʒ��������
    public void describe_Category() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\"" + Market_Name + "\"��ҵ��������ַ��\"" + Market_Address + "\"��" +
                "���й���\"" + Market_Commodity_Number + "\"����Ʒ��ͣ��λ��\"" + Market_Parking_Number + "\"������ӭ���ѡ����");
        for (int i = 0; i < Market_Category_Record.length; i++) {
            if (Market_Category_Record[i] == null) {
                continue;
            } else {
                System.out.println("\"" + Market_Category_Record[i].category_name + "\"����\"" + Market_Category_Record[i].count +
                        "\"�֣���ŷ�ΧΪ(" + Market_Category_Record[i].id_start + "," + Market_Category_Record[i].id_end + ")");
            }
        }

        System.out.println("-----------------------------------------------------------------------------------");

    }


    // >> TODO ˽�б����鿴
    public String Get_MarketName() {
        return Market_Name;
    }

    public String Get_MarketAddress() {
        return Market_Address;
    }

    public int Get_MarketProductsNumber() {
        return Market_Commodity_Number;
    }

    public int Get_MarketParkingNumber() {
        return Market_Parking_Number;
    }


}
