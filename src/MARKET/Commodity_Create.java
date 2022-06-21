package MARKET;

import java.util.SplittableRandom;

public class Commodity_Create {

    private String Pro_name;
    private String Pro_id;
    private int Pro_count;
    private double Pro_purchaseprice;
    private double Pro_soldprice;
    private Merchandise_Category Pro_Category;

    // 构造方法
    public Commodity_Create() {
        this.Pro_name = null;
        this.Pro_id = null;
        this.Pro_count = 0;
        this.Pro_purchaseprice = 0;
        this.Pro_soldprice = 0;
        this.Pro_Category = Merchandise_Category.UNKONW_CATEGORY;
    }

    // 构造方法重载
    public Commodity_Create(String name, String id, int count) {

        this.Pro_name = "商品" + name;
        this.Pro_id = "ID-" + id;
        this.Pro_count = count;
        this.Pro_purchaseprice = Math.random() * 200;
        this.Pro_soldprice = Pro_purchaseprice * (1 + Math.random());
        this.Pro_Category = Merchandise_Category.UNKONW_CATEGORY;
    }

    public Commodity_Create(String name, String id, int count,Merchandise_Category Category) {

        this.Pro_name = "商品" + name;
        this.Pro_id = "ID-" + id;
        this.Pro_count = count;
        this.Pro_purchaseprice = Math.random() * 200;
        this.Pro_soldprice = Pro_purchaseprice * (1 + Math.random());
        this.Pro_Category = Category;
    }

    public Commodity_Create(String name, String id, int count, double purchaseprice, double soldprice, Merchandise_Category Category) {

        this.Pro_name = "商品" + name;
        this.Pro_id = "ID-" + id;
        this.Pro_count = count;
        this.Pro_purchaseprice = purchaseprice;
        this.Pro_soldprice = soldprice;
        this.Pro_Category = Category;

    }

    public static Commodity_Create[] Commodity_Create_list(int ProductNumber) {

        Commodity_Create merchandise_list[] = new Commodity_Create[ProductNumber];
        for (int i = 0; i < ProductNumber; i++) {
            String name = "00" + (i + 1);
            String id = "00" + (i + 1);
            merchandise_list[i] = new Commodity_Create(name, id, 200);
        }
        return merchandise_list;

    }


    // 计算利润
    public double profit() {
        double Profit = Pro_soldprice - Pro_purchaseprice;
        return Profit;
    }

    // 商品描述
    public void describe() {
        System.out.println("《商品类别为：\"" + Pro_Category.getChinese() + "\"》");
        System.out.println("商品名为：\"" + Pro_name + "\"，商品编号为：\"" + Pro_id + "\"，" +
                "数量为：\"" + Pro_count + "\"个，售价为：\"" + Pro_soldprice + "\"");
    }
    public void describe_inter() {
        System.out.println("《商品类别为：\"" + Pro_Category.getChinese() + "\"》");
        System.out.println("商品名为：\"" + Pro_name + "\"，商品编号为：\"" + Pro_id + "\"，" +
                "数量为：\"" + Pro_count + "\"个，进价为：\"" + Pro_purchaseprice +
                "\"，售价为：\"" + Pro_soldprice + "\"，利润为：\"" + profit() + "\"");
    }

    // 私有成员变量访问
    public String getPro_name() {
        return Pro_name;
    }

    public String getPro_id() {
        return Pro_id;
    }

    public int getPro_count() {
        return Pro_count;
    }

    public double getPro_purchaseprice() {
        return Pro_purchaseprice;
    }

    public double getPro_soldprice() {
        return Pro_soldprice;
    }

    public Merchandise_Category getPro_Category() {
        return Pro_Category;
    }


    // 变量设置
    public void setPro_name(String pro_name) {
        Pro_name = pro_name;
    }

    public void setPro_id(String pro_id) {
        Pro_id = pro_id;
    }

    public void setPro_count(int pro_count) {
        Pro_count = pro_count;
    }

    public void setPro_purchaseprice(double pro_purchaseprice) {
        Pro_purchaseprice = pro_purchaseprice;
    }

    public void setPro_soldprice(double pro_soldprice) {
        Pro_soldprice = pro_soldprice;
    }

    public void setPro_Category(Merchandise_Category pro_Category) {
        Pro_Category = pro_Category;
    }

    // 更新库存
    public void Change_Count(int SoldNumber) {
        Pro_count = Pro_count - SoldNumber;
    }
}
