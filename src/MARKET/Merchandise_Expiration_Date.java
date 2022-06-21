package MARKET;
import java.util.Date;

// ��Ʒ�����ڽӿ�

public interface Merchandise_Expiration_Date {

    /**
     * ��ֹ����ǰ����Ʒ�ı����������Ƿ񳬹����ݵ�����
     *
     * @param days ��ֹ����ǰ�������ڳ�����ô����
     * @return ��ֹ����ǰ��true���������ʣ�������Ȳ�������false��������ڲ��������
     */
    boolean notExpireInDays(int days);

    /**
     * @return ��Ʒ��������
     */
    Date getProducedDate(Date date);

    /**
     * @return ��Ʒ�����ڵ�����
     */
    public abstract Date getExpireDate();

    /**
     * @return ��ֹ����ǰ��ʣ�ౣ���ڻ�ʣ���ܱ����ڳ��ȵİٷֱ�
     */
    double leftDatePercent();

    /**
     * ����ʣ�����Ч�ڰٷֱȣ��ó���Ʒ����ʵ�ʵļ�ֵ
     *
     * @param leftDatePercent ʣ����Ч�ڰٷֱ�
     * @return ʣ���ʵ�ʼ�ֵ
     */
    double leftActualValue(double leftDatePercent);

}
