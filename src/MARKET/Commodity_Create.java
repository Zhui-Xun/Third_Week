package MARKET;

import java.util.SplittableRandom;

public class Commodity_Create {

    private String Pro_name;
    private String Pro_id;
    private int Pro_count;
    private double Pro_purchaseprice;
    private double Pro_soldprice;
    private Merchandise_Category Pro_Category;

    // ���췽��
    public Commodity_Create() {
        this.Pro_name = null;
        this.Pro_id = null;
        this.Pro_count = 0;
        this.Pro_purchaseprice = 0;
        this.Pro_soldprice = 0;
        this.Pro_Category = Merchandise_Category.UNKONW_CATEGORY;
    }

    // ���췽������
    public Commodity_Create(String name, String id, int count) {

        this.Pro_name = "��Ʒ" + name;
        this.Pro_id = "ID-" + id;
        this.Pro_count = count;
        this.Pro_purchaseprice = Math.random() * 200;
        this.Pro_soldprice = Pro_purchaseprice * (1 + Math.random());
        this.Pro_Category = Merchandise_Category.UNKONW_CATEGORY;
    }

    public Commodity_Create(String name, String id, int count,Merchandise_Category Category) {

        this.Pro_name = "��Ʒ" + name;
        this.Pro_id = "ID-" + id;
        this.Pro_count = count;
        this.Pro_purchaseprice = Math.random() * 200;
        this.Pro_soldprice = Pro_purchaseprice * (1 + Math.random());
        this.Pro_Category = Category;
    }

    public Commodity_Create(String name, String id, int count, double purchaseprice, double soldprice, Merchandise_Category Category) {

        this.Pro_name = "��Ʒ" + name;
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


    // ��������
    public double profit() {
        double Profit = Pro_soldprice - Pro_purchaseprice;
        return Profit;
    }

    // ��Ʒ����
    public void describe() {
        System.out.println("����Ʒ���Ϊ��\"" + Pro_Category.getChinese() + "\"��");
        System.out.println("��Ʒ��Ϊ��\"" + Pro_name + "\"����Ʒ���Ϊ��\"" + Pro_id + "\"��" +
                "����Ϊ��\"" + Pro_count + "\"�����ۼ�Ϊ��\"" + Pro_soldprice + "\"");
    }
    public void describe_inter() {
        System.out.println("����Ʒ���Ϊ��\"" + Pro_Category.getChinese() + "\"��");
        System.out.println("��Ʒ��Ϊ��\"" + Pro_name + "\"����Ʒ���Ϊ��\"" + Pro_id + "\"��" +
                "����Ϊ��\"" + Pro_count + "\"��������Ϊ��\"" + Pro_purchaseprice +
                "\"���ۼ�Ϊ��\"" + Pro_soldprice + "\"������Ϊ��\"" + profit() + "\"");
    }

    // ˽�г�Ա��������
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


    // ��������
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

    // ���¿��
    public void Change_Count(int SoldNumber) {
        Pro_count = Pro_count - SoldNumber;
    }
}
