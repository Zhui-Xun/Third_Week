package MARKET;

import java.util.Date;

public class Test_Interface implements Merchandise_Expiration_Date, Virtual_Merchandise {

    // >> TODO �ӿ���ķ�������public abstract���εģ����������֣������ͷ���ֵ��û�з����壬�Էֺ�;������
    // >> TODO ��Ϊ�ӿ���ķ���������ֻ����public abstract���Σ������������η�����ʡ��
    // >> TODO abstract���ǳ��󷽷������η���û�з����壬�ԷֺŽ���
    // >> TODO �ӿ��ﲻ�ܶ���ֲ�����������ı���Ĭ�϶���public static final�ģ����������η�ͬ������ʡ��
    // >> TODO �ӿ���������û���κη����Ķ��壬ֻ�ǹ涨һ������
    // >> TODO һ����ֻ�ܼ̳�һ�����࣬���ǿ���ʵ�ֶ���ӿ�
    // >> TODO ���ʵ�ֵĽӿ��ﶨ����һ���ķ�������ôҲû���⡣����Ҫ�󷽷���������������ֵ���Ͷ�����һ��һ����

    public boolean notExpireInDays(int days) {
        return false;
    }

    public Date getProducedDate(Date date) {
        return date;
    }

    public Date getExpireDate() {
        return null;
    }

    public double leftDatePercent() {
        return 0;
    }

    public double leftActualValue(double leftDatePercent) {
        return 0;
    }
}
