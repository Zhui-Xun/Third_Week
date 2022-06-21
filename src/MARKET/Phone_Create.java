package MARKET;

public class Phone_Create extends Commodity_Create {

    // Phone��ר������
    protected double ScreenSize;
    protected double CPU;
    private int Memory;
    private int Storage;
    private String Brand;
    public String OS;

    // ���췽��
    public Phone_Create(String Pro_name, String Pro_id, int Pro_count, double Pro_purchaseprice,
                        double Pro_soldprice, Merchandise_Category Category, double ScreenSize, double CPU,
                        int Memory, int Storage, String Brand, String OS) {

        // �����ֻ���ר������
        this.ScreenSize = ScreenSize;
        this.CPU = CPU;
        this.Memory = Memory;
        this.Storage = Storage;
        this.Brand = Brand;
        this.OS = OS;

        // ������Ʒ�Ļ�������
        this.setPro_name(Pro_name);
        this.setPro_id(Pro_id);
        this.setPro_count(Pro_count);
        this.setPro_purchaseprice(Pro_purchaseprice);
        this.setPro_soldprice(Pro_soldprice);
        this.setPro_Category(Category);

    }
    // ���ø��෽��
    public Phone_Create() {
        super("����", "000", 0, 1, 1.1,Merchandise_Category.ELECTRICAL);
        init(4.5, 4.6, 6, 128, "Uknown", "Uknown");
    }

    public void init(double ScreenSize, double CPU, int Memory, int Storage, String Brand, String OS) {
        this.ScreenSize = ScreenSize;
        this.CPU = CPU;
        this.Memory = Memory;
        this.Storage = Storage;
        this.Brand = Brand;
        this.OS = OS;
    }

    // ��Ʒ����
    public void describe() {
        // ���෽��
        super.describe();
        // ��������
        System.out.println("���ֻ���Ʒ�������£�");
        System.out.println("�ֻ�Ʒ��Ϊ: " + Brand + "��ϵͳΪ: " + OS + "��Ӳ������: " +
                "��Ļ: " + ScreenSize + "�磻" + "cpu��Ƶ: " + CPU + " GHz��" +
                "�ڴ�: " + Memory + "Gb��" + "�洢�ռ�: " + Storage + "Gb��\n");

    }

    // ����ר����������
    public double getScreenSize() { return ScreenSize; }
    public double getCpu() { return CPU; }
    public int getMemory() { return Memory; }
    public int getStorage() { return Storage; }
    public String getBrand() { return Brand; }
    public String getOS() { return OS; }
}
