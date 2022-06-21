package MARKET;

import java.util.Date;

public class Test_Interface implements Merchandise_Expiration_Date, Virtual_Merchandise {

    // >> TODO 接口里的方法都是public abstract修饰的，方法有名字，参数和返回值，没有方法体，以分号;结束。
    // >> TODO 因为接口里的方法都是且只能用public abstract修饰，所以这俩修饰符可以省略
    // >> TODO abstract就是抽象方法的修饰符，没有方法体，以分号结束
    // >> TODO 接口里不能定义局部变量，定义的变量默认都是public static final的，这三个修饰符同样可以省略
    // >> TODO 接口甚至可以没有任何方法的定义，只是规定一种类型
    // >> TODO 一个类只能继承一个父类，但是可以实现多个接口
    // >> TODO 如果实现的接口里定义了一样的方法，那么也没问题。但是要求方法名，参数，返回值类型都必须一摸一样。

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
