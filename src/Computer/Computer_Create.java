// 创建电脑类
package Computer;

import MARKET.Commodity_Create;
import MARKET.Merchandise_Category;

public class Computer_Create extends Commodity_Create {


    // 电脑的专属特征
    private String Brand;    // 品牌
    private String Model;    // 型号
    private double Screen_Size;          // 屏幕尺寸
    private String Screen_Refresh_Rate;  // 屏幕刷新率
    private String Screen_Resolution;    // 屏幕分辨率
    private String CPU;
    private String GPU;
    private int Memory;
    private String Disk;


    // 构造方法
    public Computer_Create(String Pro_name, String Pro_id, int Pro_count, double Pro_purchaseprice,
                           double Pro_soldprice, Merchandise_Category Category, String Brand, String Model, double ScreenSize,
                           String ScreenRefreshRate, String ScreenResolution, String CPU, String GPU, int Memory, String Disk) {

        // 设置电脑的特有属性
        this.Brand = Brand;
        this.Model = Model;
        this.Screen_Size = ScreenSize;
        this.Screen_Refresh_Rate = ScreenRefreshRate;
        this.Screen_Resolution = ScreenResolution;
        this.CPU = CPU;
        this.GPU = GPU;
        this.Memory = Memory;
        this.Disk = Disk;


        // 设置商品的基本属性
        this.setPro_name(Pro_name);
        this.setPro_id(Pro_id);
        this.setPro_count(Pro_count);
        this.setPro_purchaseprice(Pro_purchaseprice);
        this.setPro_soldprice(Pro_soldprice);
        this.setPro_Category(Category);

    }

    // 调用父类方法
    public Computer_Create() {
        super("杂牌电脑", "000", 0, 1, 1.1, Merchandise_Category.ELECTRICAL);
        init("Levo", "小新", 15.6, "60Hz", "1080P",
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

    // 商品描述
    public void describe() {
        // 父类方法
        super.describe();
        // 子类描述
        System.out.println("商品属性如下：");
        System.out.println("品牌: " + Brand + "；型号: " + Model + "；\"硬件配置\"-> " +
                "屏幕尺寸: " + Screen_Size + "寸，刷新率：" + Screen_Refresh_Rate + "，分辨率：" + Screen_Resolution +
                "cpu型号: " + CPU + " ，GPU型号：" + GPU + "，内存：" + Memory + "G，磁盘： " + Disk + "。\n");

    }

    // 访问专属特征属性
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
