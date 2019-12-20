package com.study.common.util;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类描述：时间操作定义类
 *
 * @version 1.0
 * @author: jingyujie
 * @date： 日期：2018-12-8 时间：下午12:15:03
 */
public class DateUtils extends PropertyEditorSupport {
    public static final SimpleDateFormat date_sdf_yyyy_m = new SimpleDateFormat("yyyy-M");
    // 各种时间格式
    public static final SimpleDateFormat date_sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 各种时间格式
    public static final SimpleDateFormat date_sdf_2 = new SimpleDateFormat("yyyy-MM-dd");
    // 各种时间格式
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    // 各种时间格式
    public static final SimpleDateFormat yyyyM = new SimpleDateFormat("yyyyM");
    // 各种时间格式
    public static final SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyyMM");
    // 各种时间格式
    public static final SimpleDateFormat MM = new SimpleDateFormat("MM");

    public static final SimpleDateFormat yyyy_MM = new SimpleDateFormat("yyyy-MM");
    // 各种时间格式
    public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat time_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 以毫秒表示的时间
    public static final long DAY_IN_MILLIS = 24 * 3600 * 1000;
    private static final long HOUR_IN_MILLIS = 3600 * 1000;
    private static final long MINUTE_IN_MILLIS = 60 * 1000;
    private static final long SECOND_IN_MILLIS = 1000;
    public static final int MINIMAL_DAYS_IN_FIRSTWEEK = 4;
    public static final int FIRST_DAY_OF_WEEK = 2;

    public static String getYYYYM(Date date) {
        return yyyyM.format(date);
    }

    public static String getYYYYMMDD() {
        return date_sdf.format(new Date());
    }

    public static String getYYYYMMDD(Date date) {
        return date_sdf.format(date);
    }

    public static Date getDateYYYYMMDD(String date) {
        try {
            return date_sdf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToString(Date date) {
        return date != null ? datetimeFormat.format(date) : null;
    }

    public static Date stringToDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        try {
            return datetimeFormat.parse(date);
        } catch (ParseException e) {
            //log.info("日期格式错误：{}", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static Date getDateYYYYMD(String date) throws ParseException {
        return date_sdf_2.parse(date);
    }

    // 指定模式的时间格式
    public static SimpleDateFormat getSDFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 当前日历，这里用中国时间表示
     *
     * @return 以当地时区表示的系统当前日历
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 指定毫秒数表示的日历
     * g
     *
     * @param millis 毫秒数
     * @return 指定毫秒数表示的日历
     */
    public static Calendar getCalendar(long millis) {
        Calendar cal = Calendar.getInstance();
        // --------------------cal.setTimeInMillis(millis);
        cal.setTime(new Date(millis));
        return cal;
    }

    // ////////////////////////////////////////////////////////////////////////////
    // getDate
    // 各种方式获取的Date
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 当前日期
     *
     * @return 系统当前时间
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 指定毫秒数表示的日期
     *
     * @param millis 毫秒数
     * @return 指定毫秒数表示的日期
     */
    public static Date getDate(long millis) {
        return new Date(millis);
    }

    /**
     * 时间戳转换为字符串
     *
     * @param time
     * @return
     */
    public static String timestamptoStr(Timestamp time) {
        Date date = null;
        if (null != time) {
            date = new Date(time.getTime());
        }
        return date2Str(date_sdf);
    }

    /**
     * 字符串转换时间戳
     *
     * @param str
     * @return
     */
    public static Timestamp str2Timestamp(String str) {
        Date date = str2Date(str, date_sdf);
        return new Timestamp(date.getTime());
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @param sdf
     * @return
     */
    public static Date str2Date(String str, SimpleDateFormat sdf) {
        if (null == str || "".equals(str)) {
            return null;
        }
        Date date = null;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个时间的中间的月数
     *
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static int getMonthSpace(String date1, String date2, String format)
            throws ParseException {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        result = (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * 12 + c1.get(Calendar.MONTH)
                - c2.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 日期转换为字符串
     *
     * @param date_sdf 日期格式
     * @return 字符串
     */
    public static String date2Str(SimpleDateFormat date_sdf) {
        Date date = getDate();
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }

    /**
     * 得到当前时间
     */
    public static String dateNow2Str() {
        return date2Str(date_sdf);
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateformat(String date, String format) {
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        Date _date = null;
        try {
            _date = sformat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sformat.format(_date);
    }

    /**
     * 日期转换为字符串
     *
     * @param date     日期
     * @param date_sdf 日期格式
     * @return 字符串
     */
    public static String date2Str(Date date, SimpleDateFormat date_sdf) {
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }

    /**
     * 日期转换为字符串
     *
     * @param format 日期格式
     * @return 字符串
     */
    public static String getDate(String format) {
        Date date = new Date();
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 日期转换为字符串
     *
     * @param format 日期格式
     * @return 字符串
     */
    public static Date getDate(SimpleDateFormat format) {
        Date date = new Date();
        String nowDate = format.format(date);

        try {
            return format.parse(nowDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 指定毫秒数的时间戳
     *
     * @param millis 毫秒数
     * @return 指定毫秒数的时间戳
     */
    public static Timestamp getTimestamp(long millis) {
        return new Timestamp(millis);
    }

    /**
     * 以字符形式表示的时间戳
     *
     * @param time 毫秒数
     * @return 以字符形式表示的时间戳
     */
    public static Timestamp getTimestamp(String time) {
        return new Timestamp(Long.parseLong(time));
    }

    /**
     * 系统当前的时间戳
     *
     * @return 系统当前的时间戳
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 指定日期的时间戳
     *
     * @param date 指定日期
     * @return 指定日期的时间戳
     */
    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * 指定日历的时间戳
     *
     * @param cal 指定日历
     * @return 指定日历的时间戳
     */
    public static Timestamp getCalendarTimestamp(Calendar cal) {
        // ---------------------return new Timestamp(cal.getTimeInMillis());
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp gettimestamp() {
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(dt);
        Timestamp buydate = Timestamp.valueOf(nowTime);
        return buydate;
    }

    public static Timestamp getDateTimestamp() {
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = df.format(dt);

        return str2Timestamp(nowTime);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // getMillis
    // 各种方式获取的Millis
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 系统时间的毫秒数
     *
     * @return 系统时间的毫秒数
     */
    public static long getMillis() {
        return new Date().getTime();
    }

    /**
     * 指定日历的毫秒数
     *
     * @param cal 指定日历
     * @return 指定日历的毫秒数
     */
    public static long getMillis(Calendar cal) {
        // --------------------return cal.getTimeInMillis();
        return cal.getTime().getTime();
    }

    /**
     * 指定日期的毫秒数
     *
     * @param date 指定日期
     * @return 指定日期的毫秒数
     */
    public static long getMillis(Date date) {
        return date.getTime();
    }

    /**
     * 指定时间戳的毫秒数
     *
     * @param ts 指定时间戳
     * @return 指定时间戳的毫秒数
     */
    public static long getMillis(Timestamp ts) {
        return ts.getTime();
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatDate
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：年-月-日
     *
     * @return 默认日期按“年-月-日“格式显示
     */
    public static String formatDate() {
        return date_sdf.format(getCalendar().getTime());
    }

    /**
     * 获取时间字符串
     */
    public static String getDataString(SimpleDateFormat formatstr) {
        return formatstr.format(getCalendar().getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日
     *
     * @param cal 指定的日期
     * @return 指定日期按“年-月-日“格式显示
     */
    public static String formatDate(Calendar cal) {
        return date_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日
     *
     * @param date 指定的日期
     * @return 指定日期按“年-月-日“格式显示
     */
    public static String formatDate(Date date) {
        return date_sdf.format(date);
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：年-月-日
     *
     * @param millis 指定的毫秒数
     * @return 指定毫秒数表示日期按“年-月-日“格式显示
     */
    public static String formatDate(long millis) {
        return date_sdf.format(new Date(millis));
    }

    /**
     * 默认日期按指定格式显示
     *
     * @param pattern 指定的格式
     * @return 默认日期按指定格式显示
     */
    public static String formatDate(String pattern) {
        return getSDFormat(pattern).format(getCalendar().getTime());
    }

    /**
     * 指定日期按指定格式显示
     *
     * @param cal     指定的日期
     * @param pattern 指定的格式
     * @return 指定日期按指定格式显示
     */
    public static String formatDate(Calendar cal, String pattern) {
        return getSDFormat(pattern).format(cal.getTime());
    }

    /**
     * 指定日期按指定格式显示
     *
     * @param date    指定的日期
     * @param pattern 指定的格式
     * @return 指定日期按指定格式显示
     */
    public static String formatDate(Date date, String pattern) {
        return getSDFormat(pattern).format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatTime
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：年-月-日 时：分
     *
     * @return 默认日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime() {
        return time_sdf.format(getCalendar().getTime());
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param millis 指定的毫秒数
     * @return 指定毫秒数表示日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(long millis) {
        return time_sdf.format(new Date(millis));
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param cal 指定的日期
     * @return 指定日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(Calendar cal) {
        return time_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param date 指定的日期
     * @return 指定日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(Date date) {
        return time_sdf.format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatShortTime
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：时：分
     *
     * @return 默认日期按“时：分“格式显示
     */
    public static String formatShortTime() {
        return short_time_sdf.format(getCalendar().getTime());
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：时：分
     *
     * @param millis 指定的毫秒数
     * @return 指定毫秒数表示日期按“时：分“格式显示
     */
    public static String formatShortTime(long millis) {
        return short_time_sdf.format(new Date(millis));
    }

    /**
     * 指定日期的默认显示，具体格式：时：分
     *
     * @param cal 指定的日期
     * @return 指定日期按“时：分“格式显示
     */
    public static String formatShortTime(Calendar cal) {
        return short_time_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：时：分
     *
     * @param date 指定的日期
     * @return 指定日期按“时：分“格式显示
     */
    public static String formatShortTime(Date date) {
        return short_time_sdf.format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // parseDate
    // parseCalendar
    // parseTimestamp
    // 将字符串按照一定的格式转化为日期或时间
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src     将要转换的原始字符窜
     * @param pattern 转换的匹配格式
     * @return 如果转换成功则返回转换后的日期
     * @throws ParseException
     */
    public static Date parseDate(String src, String pattern) throws ParseException {
        return getSDFormat(pattern).parse(src);

    }

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src     将要转换的原始字符窜
     * @param pattern 转换的匹配格式
     * @return 如果转换成功则返回转换后的日期
     * @throws ParseException
     */
    public static Calendar parseCalendar(String src, String pattern) throws ParseException {

        Date date = parseDate(src, pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String formatAddDate(String src, String pattern, int amount) throws ParseException {
        Calendar cal;
        cal = parseCalendar(src, pattern);
        cal.add(Calendar.DATE, amount);
        return formatDate(cal);
    }

    public static String formatAddMonth(String src, String pattern, int month) throws ParseException {
        Calendar cal;
        cal = parseCalendar(src, pattern);
        cal.add(Calendar.MONTH, month);
        return formatDate(cal);
    }

    public static Date formatAddMonth(Date src, int month) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(src);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }


    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src     将要转换的原始字符窜
     * @param pattern 转换的匹配格式
     * @return 如果转换成功则返回转换后的时间戳
     * @throws ParseException
     */
    public static Timestamp parseTimestamp(String src, String pattern) throws ParseException {
        Date date = parseDate(src, pattern);
        return new Timestamp(date.getTime());
    }

    // ////////////////////////////////////////////////////////////////////////////
    // dateDiff
    // 计算两个日期之间的差值
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 计算两个时间之间的差值，根据标志的不同而不同
     *
     * @param flag   计算标志，表示按照年/月/日/时/分/秒等计算
     * @param calSrc 减数
     * @param calDes 被减数
     * @return 两个日期之间的差值
     */
    public static int dateDiff(char flag, Calendar calSrc, Calendar calDes) {

        long millisDiff = getMillis(calSrc) - getMillis(calDes);

        if (flag == 'y') {
            return (calSrc.get(Calendar.YEAR) - calDes.get(Calendar.YEAR));
        }

        if (flag == 'd') {
            return (int) (millisDiff / DAY_IN_MILLIS);
        }

        if (flag == 'h') {
            return (int) (millisDiff / HOUR_IN_MILLIS);
        }

        if (flag == 'm') {
            return (int) (millisDiff / MINUTE_IN_MILLIS);
        }

        if (flag == 's') {
            return (int) (millisDiff / SECOND_IN_MILLIS);
        }

        return 0;
    }

    /**
     * String类型 转换为Date, 如果参数长度为10 转换格式”yyyy-MM-dd“ 如果参数长度为19 转换格式”yyyy-MM-dd HH:mm:ss“ * @param text String类型的时间值
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            try {
                if (text.indexOf(":") == -1 && text.length() == 10) {
                    setValue(DateUtils.date_sdf.parse(text));
                } else if (text.indexOf(":") > 0 && text.length() == 19) {
                    setValue(DateUtils.datetimeFormat.parse(text));
                } else {
                    throw new IllegalArgumentException("Could not parse date, date format is error ");
                }
            } catch (ParseException ex) {
                IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
                iae.initCause(ex);
                throw iae;
            }
        } else {
            setValue(null);
        }
    }

    public static int getYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getDate());
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 两个时间减多少天
     */
    public static long subtractDay(Date endDate, Date startDate) {
        return (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 返回Date参数的 前后N天日期 取决于第二个参数
     * 返回date
     *
     * @param date
     * @param i
     * @return
     */
    public static Date ReturnTheDay(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, i);
        return calendar.getTime();
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            try {
                return new SimpleDateFormat(pattern).format(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "";
    }

    public static String format(Object value, String pattern) {
        if (value != null) {
            try {
                Date date = null;
//				if(value instanceof oracle.sql.TIMESTAMP) {
//					date = new Date(((oracle.sql.TIMESTAMP)value).dateValue().getTime());
//				} else {
//					date = (Date)value;
//				}
                return new SimpleDateFormat(pattern).format(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "";
    }

    public static Date getDateTime(String dateTime) {
        Date date = new Date();
        String datePart = DateUtils.format(date, "yyyy-MM-dd");
        String dateTimePart = datePart + " " + dateTime;
        Date newDate = DateUtils.parse(dateTimePart, "yyyy-MM-dd HH:mm");
        return newDate;
    }

    public static Date parse(String date, String pattern) {
        Date newDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            newDate = sdf.parse(date);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("日期转换错误：" + date + "，转换为：" + pattern);
        }
        return newDate;
    }

    /**
     * @描述: 得到date的昨天
     */
    public static Date getYesterdayByDate(String date, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            Date temp = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(temp);
            cal.add(Calendar.DAY_OF_MONTH, -1);
            return cal.getTime();
        } catch (Exception ex) {
        }
        return null;
    }
    public static Date GetLastMonth(String date, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            Date temp = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(temp);
            cal.add(Calendar.MONTH, -1);
            return cal.getTime();
        } catch (Exception ex) {
        }
        return null;
    }
    public static Date GetDateMonth(String date, String pattern,Integer is) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            Date temp = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(temp);
            cal.set(Calendar.DATE, is);
            return cal.getTime();
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * @描述: 得到某一月的天数
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * @描述: 得到某一月的天数
     */
    public static int getDaysOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * @描述: 得到某一季的天数
     */
    public static int getDaysOfQuarter(int year, int quarter) {
        Calendar cal = Calendar.getInstance();
        int days = 0;
        int firstMonth = (quarter - 1) * 3;
        for (int i = firstMonth; i < firstMonth + 3; i++) {
            cal.set(year, i, 1);
            days += cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        return days;
    }

    /**
     * @描述: 得到某一年的天数
     */
    public static int getDaysOfYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, 0, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * @描述: 得到某一年的天数
     */
    public static int getDaysOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * @描述: 得到某一周的星期一的时间
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
        cal.setMinimalDaysInFirstWeek(MINIMAL_DAYS_IN_FIRSTWEEK);
        cal.set(year, Calendar.JANUARY, 1);
        int addDays = week * 7;
        if (cal.get(Calendar.WEEK_OF_YEAR) == 1) {
            addDays = (week - 1) * 7;
        }
        cal.add(Calendar.DATE, addDays);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return cal.getTime();

    }

    /**
     * @描述: 得到某一周的第一天
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
        cal.setMinimalDaysInFirstWeek(MINIMAL_DAYS_IN_FIRSTWEEK);
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayOfWeek = 8;
        }

        cal.setTimeInMillis((cal.getTimeInMillis() + (FIRST_DAY_OF_WEEK - dayOfWeek) * 86400000L));
        return cal.getTime();
    }

    /**
     * @描述: 得到某一月的第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * @描述: 得到某一月的最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * @描述: 得到上月的第一天
     */
    public static Date getFirstDayOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cal.getTimeInMillis() - cal.get(Calendar.DAY_OF_MONTH) * 86400000L);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * @描述: 得到上月的最后一天
     */
    public static Date getLastDayOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cal.getTimeInMillis() - cal.get(Calendar.DAY_OF_MONTH) * 86400000L);
        return cal.getTime();
    }

    /**
     * @描述: 得到下月的第一天
     */
    public static Date getFirstDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.setTimeInMillis(cal.getTimeInMillis() + cal.getActualMaximum(Calendar.DAY_OF_MONTH) * 86400000L);
        return cal.getTime();
    }

    /**
     * 得到下一个月的日期
     * @param date
     * @return
     */
    public static Date getDayOfNextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, +1);
        return cal.getTime();
    }

    /**
     * @描述: 得到下月的最后一天
     */
    public static Date getLastDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cal.getTimeInMillis() + cal.getActualMaximum(Calendar.DAY_OF_MONTH) * 86400000L);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.setTimeInMillis(cal.getTimeInMillis() + (cal.getActualMaximum(Calendar.DAY_OF_MONTH) - 1) * 86400000L);
        return cal.getTime();
    }


    /**
     * @描述: 得到某一日期的周数
     */
    public static int getWeekOfDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
        cal.setMinimalDaysInFirstWeek(MINIMAL_DAYS_IN_FIRSTWEEK);
        cal.set(year, month - 1, day, 0, 0, 0);
        return cal.get(Calendar.WEEK_OF_YEAR);

    }

    /**
     * @描述: 得到某一日期的天数
     */
    public static int getDayOfDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    public static Date getDate2() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date yesterday() {
        return new Date(System.currentTimeMillis() - 86400000L);
    }

    public static Date getEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2099);
        cal.set(Calendar.MONTH, 12 - 1);
        cal.set(Calendar.DATE, 31);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date parseToDate(Object value) {
        if (value instanceof Timestamp) {
            return (Date) ((Timestamp) value);
        }
        if (value instanceof java.sql.Date) {
            return (Date) value;
        }
        return (Date) value;

    }

    /**
     * 获取指定日期时间
     *
     * @param calendarConstant 指定时间类型
     * @param appointNum       指定时间
     * @return
     */
    public static Date getAppointDate(int calendarConstant, int appointNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(calendarConstant, appointNum);
        return calendar.getTime();
    }
    /**
     * 两个日期之间计算月份间隔数
     * @param startTime 开始时间 yyyy-MM-dd
     * @param endTime 结束时间 yyyy-MM-dd
     * @return
     * @throws ParseException
     */
/*	public static Integer intervalMonth(String startTime, String endTime) throws ParseException {
		DateTime start = new DateTime(yyyy_MM.parse(startTime));
		DateTime end= new DateTime(yyyy_MM.parse(endTime));
		int intervalMonth = Months.monthsBetween(start, end).getMonths()+1;
		return intervalMonth;
	}*/

    /**
     * 比较两个日期之间月份是否相等.
     *
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     * @author grover
     */
/*	public static boolean isEqualMonth(String time1, String time2) throws ParseException{
		DateTime dt1 = new DateTime(yyyy_MM.parse(time1));
		DateTime dt2= new DateTime(yyyy_MM.parse(time2));
		if(dt1.monthOfYear().equals(dt2.monthOfYear())){
			return true;
		}
		return false;
	}*/
    public static String calSpendTimes(String startTime, String endTime) {
        Date startTimeDateType = DateUtils.parse(startTime, "yyyy-MM-dd HH:mm:ss");

        Date endTimeDateType = null;
        if (endTime != null) {
            endTimeDateType = DateUtils.parse(endTime, "yyyy-MM-dd HH:mm:ss");
        }

        long totalTimes = (endTime == null) ?
                (Calendar.getInstance().getTimeInMillis() - startTimeDateType.getTime())
                :
                (endTimeDateType.getTime() - startTimeDateType.getTime());

        long dayCount = totalTimes / (1000 * 60 * 60 * 24);//计算天
        long restTimes = totalTimes % (1000 * 60 * 60 * 24);//剩下的时间用于计于小时
        long hourCount = restTimes / (1000 * 60 * 60);//小时
        restTimes = restTimes % (1000 * 60 * 60);
        long minuteCount = restTimes / (1000 * 60);

        String spendTimes = dayCount + "天" + hourCount + "小时" + minuteCount + "分";

        return spendTimes;
    }

    /**
     * 拆分两个日期获取月份
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        try {
            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    static int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * @param date yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static boolean isValidDateTime(String date) {
        try {
            int year = Integer.parseInt(date.substring(0, 4));
            if (year <= 0)
                return false;
            int month = Integer.parseInt(date.substring(5, 7));
            if (month <= 0 || month > 12)
                return false;
            int day = Integer.parseInt(date.substring(8, 10));
            if (day <= 0 || day > DAYS[month])
                return false;
            if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {
                return false;
            }
            int hour = Integer.parseInt(date.substring(11, 13));
            if (hour < 0 || hour > 23)
                return false;
            int minute = Integer.parseInt(date.substring(14, 16));
            if (minute < 0 || minute > 59)
                return false;
            int second = Integer.parseInt(date.substring(17, 19));
            if (second < 0 || second > 59)
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param date yyyy-MM-dd
     * @return
     */
    public static boolean isValidMoth(String date) {
        try {
            int year = Integer.parseInt(date.substring(0, 4));
            if (year <= 0)
                return false;
            int month = Integer.parseInt(date.substring(5, 7));
            if (month <= 0 || month > 12)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param date yyyy-MM-dd
     * @return
     */
    public static boolean isValidDate(String date) {
        try {
            int year = Integer.parseInt(date.substring(0, 4));
            if (year <= 0)
                return false;
            int month = Integer.parseInt(date.substring(5, 7));
            if (month <= 0 || month > 12)
                return false;
            int day = Integer.parseInt(date.substring(8, 10));
            if (day <= 0 || day > DAYS[month])
                return false;
            if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static final boolean isGregorianLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isValidDate("2004-02-29"));
        System.out.println(dateToString(getDateBefore(new Date(),7)));
        System.out.println(dateToString(getMonthBefore(new Date(),3)));
    }

    /**
     * 获取指定月的前一月（年）或后一月（年）
     *
     * @param dateStr
     * @param addYear
     * @param addMonth 月份为 实际月份减一
     * @param addDate
     * @param ymd      1月 2 年 3月最后一天 4年最后一天
     * @return
     * @throws Exception 方法的简述.
     * @throws Exception
     */
    public static String getAnyDay(String dateStr, int addYear, int addMonth,
                                   int addDate, int ymd) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(
                    "yyyy");
            Date sourceDate = sdf.parse(dateStr);
            SimpleDateFormat sdf_ = new SimpleDateFormat(
                    "yyyy-MM");
            Date sourceDate_ = sdf_.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.clear();
            cal.setTime(sourceDate);
            cal.add(Calendar.YEAR, addYear);
            cal.add(Calendar.MONTH, sourceDate_.getMonth() + addMonth);
            if (ymd == 1) {// 月
                cal.add(Calendar.DAY_OF_MONTH, 0);
            } else if (ymd == 2) {
                cal.set(Calendar.DAY_OF_YEAR, 1);
            } else if (ymd == 3) {
                cal.set(Calendar.DAY_OF_MONTH,
                        cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                System.out.println(cal.getTime().getMonth());
            } else {
                cal.set(Calendar.YEAR, cal.getTime().getYear() + 1900);
                cal.set(Calendar.DAY_OF_YEAR,
                        cal.getActualMaximum(Calendar.DAY_OF_YEAR));
            }
            cal.add(Calendar.DATE, addDate);

            SimpleDateFormat returnSdf = new SimpleDateFormat(
                    "yyyy-MM-dd");

            String dateTmp = returnSdf.format(cal.getTime());
            return dateTmp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 获取上周，本周，下周日期
     * @param date
     * @param week
     * @param weekNum
     * @return
     */
    public static String getDateByWeek(Date date,String week,int weekNum){
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
        //System.out.println("当前："+now);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(week.equals("last")){
            // 获取上周几
            if(weekNum == 7){
                cal.add(Calendar.DATE, 0);
            }else {
                cal.add(Calendar.DATE, -1 * 7);
            }
            // 周日的时间
            cal.set(Calendar.DAY_OF_WEEK, getWeekByNum(weekNum));
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
           /* System.out.println("上周"+weekNum+":"+dateStr);*/
            return dateStr;
        }
        if(week.equals("now")){
            // 获取本周几
            if(weekNum == 7){
                cal.add(Calendar.DATE, 1*7);
            }else {
                cal.add(Calendar.DATE, 0*7);
            }
            // 周日的时间
            cal.set(Calendar.DAY_OF_WEEK, getWeekByNum(weekNum));
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
          /*  System.out.println("本周"+weekNum+":"+dateStr);*/
            return dateStr;
        }
        if(week.equals("next")){
            // 获取下周几
            if(weekNum == 7){
                cal.add(Calendar.DATE, 2*7);
            }else {
                cal.add(Calendar.DATE, 1*7);
            }
            // 周日的时间
            cal.set(Calendar.DAY_OF_WEEK, getWeekByNum(weekNum));
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            /*System.out.println("下周"+weekNum+":"+dateStr);*/
            return dateStr;
        }
        return "";
    }

    /**
     * 获取对应周
     * @param num
     * @return
     */
    public static int getWeekByNum(int num){
        if(num < 7){
            return num+1;
        }
        return 1;
    }
    //获取对应星期几
    public static int getWeekNum(int num){
        if(num > 1){
            return num-1;
        }
        return 7;
    }


    /**
     * 得到几天前的时间
     * 
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(Calendar.DATE, no.get(Calendar.DATE) - day);
        return no.getTime();
    }

    /**
     * 得到前几个月的时间
     * 
     * @param d
     * @param month
     * @return
     */
    public static Date getMonthBefore(Date d, int month) {
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(Calendar.MONTH,no.get(Calendar.MONTH)-month);
        return no.getTime();
    }
}

