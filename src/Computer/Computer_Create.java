// ����������
package Computer;

import MARKET.Commodity_Create;
import MARKET.Merchandise_Category;

public class Computer_Create extends Commodity_Create {


    // ���Ե�ר������
    private String Brand;    // Ʒ��
    private String Model;    // �ͺ�
    private double Screen_Size;          // ��Ļ�ߴ�
    private String Screen_Refresh_Rate;  // ��Ļˢ����
    private String Screen_Resolution;    // ��Ļ�ֱ���
    private String CPU;
    private String GPU;
    private int Memory;
    private String Disk;


    // ���췽��
    public Computer_Create(String Pro_name, String Pro_id, int Pro_count, double Pro_purchaseprice,
                           double Pro_soldprice, Merchandise_Category Category, String Brand, String Model, double ScreenSize,
                           String ScreenRefreshRate, String ScreenResolution, String CPU, String GPU, int Memory, String Disk) {

        // ���õ��Ե���������
        this.Brand = Brand;
        this.Model = Model;
        this.Screen_Size = ScreenSize;
        this.Screen_Refresh_Rate = ScreenRefreshRate;
        this.Screen_Resolution = ScreenResolution;
        this.CPU = CPU;
        this.GPU = GPU;
        this.Memory = Memory;
        this.Disk = Disk;


        // ������Ʒ�Ļ�������
        this.setPro_name(Pro_name);
        this.setPro_id(Pro_id);
        this.setPro_count(Pro_count);
        this.setPro_purchaseprice(Pro_purchaseprice);
        this.setPro_soldprice(Pro_soldprice);
        this.setPro_Category(Category);

    }

    // ���ø��෽��
    public Computer_Create() {
        super("���Ƶ���", "000", 0, 1, 1.1, Merchandise_Category.ELECTRICAL);
        init("Levo", "С��", 15.6, "60Hz", "1080P",
                "i5-12400", "MX450", 16, "128G_SSD+500G_HDD");
    }

    public void init(String Brand, String Model, double ScreenSize, String ScreenRefreshRate, String ScreenResolution,
                     String CPU, String GPU, int Memory, String Disk) {
        this.Brand = Brand;
        this.Model = Model;
        this.Screen_Size = ScreenSize;
        this.Screen_Refresh_Rate = ScreenRefreshRate;
        this.Screen_Resolution = ScreenResolution;
        this.CPU = CPU;
        this.GPU = GPU;
        this.Memory = Memory;
        this.Disk = Disk;
    }

    // ��Ʒ����
    public void describe() {
        // ���෽��
        super.describe();
        // ��������
        System.out.println("��Ʒ�������£�");
        System.out.println("Ʒ��: " + Brand + "���ͺ�: " + Model + "��\"Ӳ������\"-> " +
                "��Ļ�ߴ�: " + Screen_Size + "�磬ˢ���ʣ�" + Screen_Refresh_Rate + "���ֱ��ʣ�" + Screen_Resolution +
                "cpu�ͺ�: " + CPU + " ��GPU�ͺţ�" + GPU + "���ڴ棺" + Memory + "G�����̣� " + Disk + "��\n");

    }

    // ����ר����������
    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public double getScreen_Size() {
        return Screen_Size;
    }

    public String getScreen_Refresh_Rate() {
        return Screen_Refresh_Rate;
    }

    public String getScreen_Resolution() {
        return Screen_Resolution;
    }

    public String getCPU() {
        return CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public int getMemory() {
        return Memory;
    }

    public String getDisk() {
        return Disk;
    }
}
