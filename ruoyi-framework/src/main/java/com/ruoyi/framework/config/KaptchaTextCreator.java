package com.ruoyi.framework.config;

import java.security.SecureRandom;
import java.util.Random;
import com.google.code.kaptcha.text.impl.DefaultTextCreator;

/**
 * 验证码文本生成器
 * 
 * @author ruoyi
 */
public class KaptchaTextCreator extends DefaultTextCreator
{
    private static final String[] CNUMBERS = "0,1,2,3,4,5,6,7,8,9,10".split(",");

//    @Override
//    public String getText()
//    {
//        Integer result = 0;
//        Random random = new SecureRandom();
//        int x = random.nextInt(10);
//        int y = random.nextInt(10);
//        StringBuilder suChinese = new StringBuilder();
//        int randomoperands = (int) Math.round(Math.random() * 2);
//        if (randomoperands == 0)
//        {
//            result = x * y;
//            suChinese.append(CNUMBERS[x]);
//            suChinese.append("*");
//            suChinese.append(CNUMBERS[y]);
//        }
//        else if (randomoperands == 1)
//        {
//            if (!(x == 0) && y % x == 0)
//            {
//                result = y / x;
//                suChinese.append(CNUMBERS[y]);
//                suChinese.append("/");
//                suChinese.append(CNUMBERS[x]);
//            }
//            else
//            {
//                result = x + y;
//                suChinese.append(CNUMBERS[x]);
//                suChinese.append("+");
//                suChinese.append(CNUMBERS[y]);
//            }
//        }
//        else if (randomoperands == 2)
//        {
//            if (x >= y)
//            {
//                result = x - y;
//                suChinese.append(CNUMBERS[x]);
//                suChinese.append("-");
//                suChinese.append(CNUMBERS[y]);
//            }
//            else
//            {
//                result = y - x;
//                suChinese.append(CNUMBERS[y]);
//                suChinese.append("-");
//                suChinese.append(CNUMBERS[x]);
//            }
//        }
//        else
//        {
//            result = x + y;
//            suChinese.append(CNUMBERS[x]);
//            suChinese.append("+");
//            suChinese.append(CNUMBERS[y]);
//        }
//        suChinese.append("=?@" + result);
//        return suChinese.toString();
//    }

    @Override
    public String getText()
    {




        String str="0123456789";
        StringBuilder suChinese = new StringBuilder();
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            suChinese.append(ch);
        }
//        suChinese.append("=?@" );
        return suChinese.toString();
    }

    /* 生成4位验证码*/
    public static void main(String[] args) {

        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
