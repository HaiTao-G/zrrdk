package com.dibole.util;


import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author Tao
 * @version 1.0.0
 * @className RandomUtil.java
 * @description TODO
 * @createTime 2020年12月08日 18:22:00
 */
public class RandomUtil {
    /**
     * 生成32位编码
     *
     * @return string
     */
    public static String getUUID(String str) {
        String uuid;
        if(!StringUtils.isNotEmpty(str)){
            uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        }else{
            uuid = str + "_" + UUID.randomUUID().toString().trim().replaceAll("-", "");
        }
        return uuid;
    }

    /**
     * 随机生成订单号 id未数据库的id字段
     *
     * @return string
     */
    public static String getOrderNo(String id) {
        String date = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
        int randomInt = new Random().nextInt(999);
        String randomFix4 = getLast4Char(String.valueOf(randomInt));
        String idFix4 = getLast4Char(id);
        return date + idFix4 + randomFix4;
    }

    /**
     * 获取id最后四位字符串,  长度不足4的,前面补0
     *
     * @param str
     * @return
     */
    private static String getLast4Char(String str) {
        int strLength = str.length();
        if (strLength > 4) {
            str = str.substring(strLength - 4);
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 4 - str.length(); i++) {
                sb.append("0");
            }
            sb.append(str);
            str = sb.toString();
        }
        return str;
    }

    /**
     * <生成固定长度随机数--数字+大小写字母>
     * <功能详细描述>
     *
     * @param length 传入的字符串的长度
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String randomLengthNum(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int r = (int) (Math.random() * 3);
            int rn1 = (int) (48 + Math.random() * 10);
            int rn2 = (int) (65 + Math.random() * 26);
            int rn3 = (int) (97 + Math.random() * 26);
            switch (r) {
                case 0:
                    builder.append((char) rn1);
                    break;
                case 1:
                    builder.append((char) rn2);
                    break;
                case 2:
                    builder.append((char) rn3);
                    break;
            }
        }
        return builder.toString();
    }

    /**
     * 生成验房师id
     * @return
     */
    public static String getOrderId(){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmssSSSS");
        return sdFormat.format(date);
    }

    /**
     * 生成验房师id
     * @return
     */
    public static String getDobOrderId(String param){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
        String dobOrderId = param+sdFormat.format(date)+new RandomUtil().getDiffNO(6);
        return dobOrderId;
    }

    /**
     * 生成n个不同的随机数，且随机数区间为[0,10)
     * @param n
     * @return
     */
    public String getDiffNO(int n){
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        String numStr="";
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            numStr= numStr+num;
        }
        return numStr;
    }
}
