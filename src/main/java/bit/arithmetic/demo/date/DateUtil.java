package bit.arithmetic.demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 获取指定间隔之前的日期
     *
     * @param unit   时间单位
     * @param before 间隔
     * @return yyyyMMddHHmmss
     */
    public static String before(int unit, int before) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(unit, -before);
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String format = sdf.format(time);
        return format;
    }

    public static void main(String[] args) {
        //申请卡的时间  2018.11.10  2019 11 14
        String before = before(Calendar.MONTH, 13);
        System.out.println(before);
    }
}
