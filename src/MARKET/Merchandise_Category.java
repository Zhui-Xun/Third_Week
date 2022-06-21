package MARKET;

public enum Merchandise_Category {

    // ��Ʒ��𣺵����ࡢʳƷ�ࡢ��װ�ࡢЬñ�ࡢ����Ʒ�ࡢ�Ҿ��ࡢ���õ����ࡢ��֯Ʒ�ࡢ�������ࡢ�����ࡢδ֪���
    ELECTRICAL(0, "������"),
    KIND_of_FOOD(1, "ʳƷ��"),
    CLOTHES(2, "��װ��"),
    SHOES_AND_HATS(3, "Ьñ��"),
    DAILY_NECESSITIES(4, "����Ʒ��"),
    FURNITURE(5, "�Ҿ���"),
    HOUSEHOLD_APPLIANCES(6, "���õ�����"),
    TEXTILES(7, "��֯Ʒ��"),
    HARDWARE_AND_ELECTRICAL_MATERIALS(8, "��������"),
    KITCHENWARE(9, "������"),
    UNKONW_CATEGORY(10, "δ֪���");

    // ����
    private int Id;
    private String Chinese;

    // ���췽��
    Merchandise_Category(int id, String Chinese) {
        this.Id = id;
        this.Chinese = Chinese;
    }

    // ����ö�ٱ�ŷ���ö������
    public Merchandise_Category getChineseById(int id){
        for(Merchandise_Category category:Merchandise_Category.values()){
            if(id == category.getId()){
                return category;
            }
        }
        return null;
    }


    // ����˽������
    public int getId() {
        return Id;
    }

    public String getChinese() {
        return Chinese;
    }

    // ���� Enum �� toString
    @Override
    public String toString() {
        return "��Ʒ���{" + "Id=" + Id + ", Chinese=" + Chinese + "}";
    }


}


