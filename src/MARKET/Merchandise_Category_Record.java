package MARKET;

import java.security.PublicKey;

public class Merchandise_Category_Record {

    public String category_name;    // 商品类别名称
    public int count;               // 商品总数
    public int id_start;            // 商品类别起始编号
    public int id_end;              // 商品类别结束编号
    //public Merchandise_Category_Record[] Category_Record;  // 所有商品类别


    // 构造方法
    public Merchandise_Category_Record() {
        this.category_name = "null";
        this.count = 0;
        this.id_end = 0;
        this.id_start = 0;
        //this.Category_Record = new Merchandise_Category_Record[Merchandise_Category.values().length];
    }

    public Merchandise_Category_Record(String CategoryName, int Count, int IdStart, int IdEnd) {
        this.category_name = CategoryName;
        this.count = Count;
        this.id_end = IdEnd;
        this.id_start = IdStart;
        //this.Category_Record = new Merchandise_Category_Record[Merchandise_Category.values().length];
    }

}
