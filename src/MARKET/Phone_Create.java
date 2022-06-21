package MARKET;

public class Phone_Create extends Commodity_Create {

    // Phone的专属特征
    protected double ScreenSize;
    protected double CPU;
    private int Memory;
    private int Storage;
    private String Brand;
    public String OS;

    // 构造方法
    public Phone_Create(String Pro_name, String Pro_id, int Pro_count, double Pro_purchaseprice,
                        double Pro_soldprice, Merchandise_Category Category, double ScreenSize, double CPU,
                        int Memory, int Storage, String Brand, String OS) {

        // 设置手机的专属属性
        this.ScreenSize = ScreenSize;
        this.CPU = CPU;
        this.Memory = Memory;
        this.Storage = Storage;
        this.Brand = Brand;
        this.OS = OS;

        // 设置商品的基本属性
        this.setPro_name(Pro_name);
        this.setPro_id(Pro_id);
        this.setPro_count(Pro_count);
        this.setPro_purchaseprice(Pro_purchaseprice);
        this.setPro_soldprice(Pro_soldprice);
        this.setPro_Category(Category);

    }
    // 调用父类方法
    public Phone_Create() {
        super("杂牌", "000", 0, 1, 1.1,Merchandise_Category.ELECTRICAL);
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

    // 商品描述
    public void describe() {
        // 父类方法
        super.describe();
        // 子类描述
        System.out.println("此手机商品属性如下：");
        System.out.println("手机品牌为: " + Brand + "；系统为: " + OS + "；硬件配置: " +
                "屏幕: " + ScreenSize + "寸；" + "cpu主频: " + CPU + " GHz；" +
                "内存: " + Memory + "Gb；" + "存储空间: " + Storage + "Gb。\n");

    }

    // 访问专属特征属性
    public double getScreenSize() { return ScreenSize; }
    public double getCpu() { return CPU; }
    public int getMemory() { return Memory; }
    public int getStorage() { return Storage; }
    public String getBrand() { return Brand; }
    public String getOS() { return OS; }
}
