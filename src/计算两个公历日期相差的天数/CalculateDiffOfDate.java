package 计算两个公历日期相差的天数;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 计算两个日期的差
 */
class CalculateDiffOfDate {

    public int differentDays(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        //获取该年中有多少天。不需要考虑月份的问题。
        int days1 = calendar1.get(Calendar.DAY_OF_YEAR);
        int days2 = calendar2.get(Calendar.DAY_OF_YEAR);

        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        if (year1 != year2) { //同一年
            int timeDistance = 0;
            //一年可能差365天，也可能是差366天
            for (int i = Math.min(year1, year2); i < Math.max(year1, year2); i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) { //闰年
                    timeDistance += 366;
                } else {//不是闰年
                    timeDistance += 365;
                }
            }

            return timeDistance + Math.abs(days2 - days1);
        } else {//不同年
            return days2 - days1;
        }
    }

    public long differentDaysByMillisecond(Date date1, Date date2) {
        return (Math.abs(date1.getTime() - date2.getTime())) / (24 * 60 * 60 * 1000);//每一天相差的毫秒数、
    }

    public static void main(String[] args) {
        String dateStr = "2008-1-1 1:21:28";
        String dateStr2 = "2019-1-5 12:29:28";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(dateStr);
            Date date2 = format.parse(dateStr2);
            CalculateDiffOfDate calculateDiffOfDate = new CalculateDiffOfDate();
            System.out.println("两个日期的差距：" + calculateDiffOfDate.differentDays(date, date2));
            System.out.println("两个日期的差距：" + calculateDiffOfDate.differentDaysByMillisecond(date, date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
