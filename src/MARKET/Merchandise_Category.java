package MARKET;

public enum Merchandise_Category {

    // 商品类别：电子类、食品类、服装类、鞋帽类、日用品类、家具类、家用电器类、纺织品类、五金电料类、厨具类、未知类别
    ELECTRICAL(0, "电子类"),
    KIND_of_FOOD(1, "食品类"),
    CLOTHES(2, "服装类"),
    SHOES_AND_HATS(3, "鞋帽类"),
    DAILY_NECESSITIES(4, "日用品类"),
    FURNITURE(5, "家具类"),
    HOUSEHOLD_APPLIANCES(6, "家用电器类"),
    TEXTILES(7, "纺织品类"),
    HARDWARE_AND_ELECTRICAL_MATERIALS(8, "五金电料类"),
    KITCHENWARE(9, "厨具类"),
    UNKONW_CATEGORY(10, "未知类别");

    // 属性
    private int Id;
    private String Chinese;

    // 构造方法
    Merchandise_Category(int id, String Chinese) {
        this.Id = id;
        this.Chinese = Chinese;
    }

    // 根据枚举编号返回枚举名称
    public Merchandise_Category getChineseById(int id){
        for(Merchandise_Category category:Merchandise_Category.values()){
            if(id == category.getId()){
                return category;
            }
        }
        return null;
    }


    // 访问私有属性
    public int getId() {
        return Id;
    }

    public String getChinese() {
        return Chinese;
    }

    // 覆盖 Enum 的 toString
    @Override
    public String toString() {
        return "商品类别{" + "Id=" + Id + ", Chinese=" + Chinese + "}";
    }


}


