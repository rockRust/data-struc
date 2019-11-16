package bit.arithmetic.demo.date;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * create at:  2019-11-15  15:28
 *
 * @author : js
 * @description:
 */
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

    /**
     * 计算两个时间的时间差月为单位
     *
     * @param beginDate 开始时间
     * @param endDate   截止时间
     * @return
     */
    public static int calcInterval(Date beginDate, Date endDate) {
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        int year = end.get(Calendar.YEAR) - begin.get(Calendar.YEAR);
        int month = year * 12 + end.get(Calendar.MONTH) - begin.get(Calendar.MONTH);
        return month;
    }

    /**
     * 获取指定日志到当前日期的间隔（以月为单位）
     *
     * @param beginDate
     * @return
     */
    public static int dayToNowPeriod(Date beginDate) {
        if (beginDate == null) return -1;
        return calcInterval(beginDate, Calendar.getInstance().getTime());
    }

    public static void main(String[] args) {
        String dateStr = "201711";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date beginDate = null;
        try {
            beginDate = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(dayToNowPeriod(beginDate));
        System.out.println(DurationFormatUtils.formatPeriod(beginDate.getTime(), Calendar.getInstance().getTime().getTime(), "MM"));

        //申请卡的时间  2018.11.10  2019 11 14
        String before = before(Calendar.MONTH, 13);
        System.out.println(before);
    }
}
