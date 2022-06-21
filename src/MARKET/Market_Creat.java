package MARKET;

import Computer.Computer_Create;

import java.util.Arrays;

public class Market_Creat {

    // 私有成员变量
    private String Market_Name;         // 超市名称
    private String Market_Address;      // 超市地址
    public int Market_Commodity_Number; // 商品数量
    public int Market_Parking_Number;  // 停车位数量
    // 公共成员变量
    public double Market_incomingSum;           // 营业收入
    public Commodity_Create[] Market_Commodity; // 商品数组
    public int[] Market_Commodity_Sold;         // 售出商品
    public Merchandise_Category_Record[] Market_Category_Record; // 商品类别统计


    // >> TODO 构造方法
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

    // >> TODO 方法

    // Method:商品生成
    public Commodity_Create[] MK_Products_Generate(int ProductsNumber) {

        for (int i = 0; i < ProductsNumber; i++) {
            String name = "" + (i + 1);
            String id = "" + (i + 1);
            Commodity_Create product = new Commodity_Create(name, id, 200);
            Market_Commodity[i] = product;
        }
        Merchandise_Category_Record record = new Merchandise_Category_Record("未知类别", ProductsNumber, 1, ProductsNumber);
        // 当前商品类别记录
        Market_Category_Record[Merchandise_Category.values().length - 1] = record;
        return Market_Commodity;

    }

    // 生成特定类别的商品
    public Commodity_Create[] MK_Products_Generate_Specific_Category(int ProductsNumber, Merchandise_Category Category) {

        for (int i = 0; i < ProductsNumber; i++) {
            String name = "" + (i + 1);
            String id = "" + (i + 1);
            Commodity_Create product = new Commodity_Create(name, id, 200, Category);
            Market_Commodity[i] = product;
        }
        Merchandise_Category_Record record = new Merchandise_Category_Record(Category.getChinese(), ProductsNumber, 1, ProductsNumber);
        // 当前商品类别记录
        Market_Category_Record[Category.getId()] = record;
        return Market_Commodity;

    }


    // Method:按照类别自动生成商品
    public Commodity_Create[] MK_Products_Generate_with_Category(int ProductsNumber) {

        // 不同商品”类别“的编号范围
        int[] Sequence = new int[Merchandise_Category.values().length + 1];
        Sequence[0] = 0; // 序列数组第一个值为商品总数目
        // 将枚举列表里的商品类别存放至字符串数组中
        int[] CategoryId = new int[Merchandise_Category.values().length];
        String[] CategoryName = new String[Merchandise_Category.values().length];
        int Category_i = 0;
        for (Merchandise_Category Category : Merchandise_Category.values()) {
            Sequence[Category_i + 1] = (int) (Math.random() * ProductsNumber);
            CategoryId[Category_i] = Category.getId();
            CategoryName[Category_i] = Category.name();
            Category_i++;
        }
        Sequence[Merchandise_Category.values().length] = ProductsNumber; // 序列数组最后一个值为商品总数目
        Arrays.sort(Sequence); // 随机数组排序

        int Merchandise_i = 0;
        Category_i = 0;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("超市初始化中......");
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
            // 当前商品类别记录
            Market_Category_Record[ran] = record;

            //
            Category_i++;
            //System.out.println("商品类别\"" + Category.getChinese() + "\"共有" + (SequenceEnd - SequenceStart + 1) + "种，编号从(" + (SequenceStart + 1) + "," + (SequenceEnd + 1) + ");");
        }

        System.out.println("超市初始化完毕！");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        return Market_Commodity;
    }

    // Method: 手动添加（修改）商品
    public void Manual_Add_Merchandise() {
        // 添加手机商品
        Market_Commodity[0] = new Phone_Create("华为Mate40 Pro", "NOH-ANOO", 100,
                5999,6999, Merchandise_Category.ELECTRICAL, 6.6,
                3.6, 8, 256, "HuaWei", "HarmoneyOS");
        Market_Commodity[1] = new Phone_Create("华为Mate9 Pro", "LON-AHOO", 50,
                4999,5499, Merchandise_Category.ELECTRICAL, 5,
                3.2, 4, 128, "HuaWei", "Android");
        Market_Commodity[2] = new Phone_Create();

        //  TODO 测试 protected 访问控制符

        System.out.println("\n===== 测试 protected 访问控制符（内部访问） =====");
        System.out.println("public OS: " + ((Phone_Create) Market_Commodity[0]).OS);             // public, 可访问
        System.out.println("protected CPU: " + ((Phone_Create) Market_Commodity[0]).CPU);           // protected, 在同一个包下，可访问
        //System.out.println("private Memeory: "+((Phone_Create) Market_Commodity[0]).Memory);    // private, 私有属性，不可访问
        System.out.println("================== 测试结束 ==================\n");

        // 添加电脑商品
        Market_Commodity[3] = new Computer_Create("宏基掠夺者", "004", 10, 13000,
                14999, Merchandise_Category.ELECTRICAL, "ACER", "500SE", 15.6,
                "165Hz", "2K", "i7-12700K", "RTX 3070Ti", 32, "1T_SSD+2T_HDD");
        Market_Commodity[4] = new Computer_Create("联想拯救者", "005", 10, 11000,
                12999, Merchandise_Category.ELECTRICAL, "LENOVO", "R9000P", 15.6,
                "165Hz", "2K", "i7-12700K", "RTX 3070Ti", 32, "1T_SSD+1T_HDD");
        Market_Commodity[5] = new Computer_Create();

    }


    // Method:超市描述
    public void describe() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\"" + Market_Name + "\"开业啦！，地址：\"" + Market_Address + "\"，" +
                "超市共有\"" + Market_Commodity_Number + "\"种商品，停车位有\"" + Market_Parking_Number + "\"个，欢迎大家选购！");
        System.out.println("-----------------------------------------------------------------------------------");
    }

    // 带有商品类别的描述
    public void describe_Category() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\"" + Market_Name + "\"开业啦！，地址：\"" + Market_Address + "\"，" +
                "超市共有\"" + Market_Commodity_Number + "\"种商品，停车位有\"" + Market_Parking_Number + "\"个，欢迎大家选购！");
        for (int i = 0; i < Market_Category_Record.length; i++) {
            if (Market_Category_Record[i] == null) {
                continue;
            } else {
                System.out.println("\"" + Market_Category_Record[i].category_name + "\"共有\"" + Market_Category_Record[i].count +
                        "\"种，编号范围为(" + Market_Category_Record[i].id_start + "," + Market_Category_Record[i].id_end + ")");
            }
        }

        System.out.println("-----------------------------------------------------------------------------------");

    }


    // >> TODO 私有变量查看
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
