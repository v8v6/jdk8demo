package com.sc.cd;

import com.sc.cd.util.DateTimeUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {

        System.out.println((1<<16)-1);

        System.out.println(Objects.equals(1L,"1"));
        DecimalFormat df   =   new   DecimalFormat("###,##0.00");

        System.out.println(df.format(24332222111.7));

        DecimalFormat df2 = new DecimalFormat("###.00");
        DecimalFormat df3 = new DecimalFormat("###.00");
        System.out.println("转换2="+df2.format(1/(float)8));
        System.out.println("转换3="+df3.format(1.1256));

        try{
            String hello="生成秘钥生。";
            int len=hello.getBytes("utf-8").length;
            if(len%8!=0){
                System.out.println("不是8的整数倍");
                byte[] hellotemp=new byte[len+(8-len%8)];
                for(int i=0;i<len;i++){
                    hellotemp[i]=hello.getBytes("utf-8")[i];
                }
                hello=new String(hellotemp,"utf-8");
                System.out.println(hello);
            }
            System.out.println(hello.getBytes("utf-8").length);
        }catch (Exception ex){

        }

        System.out.println("=====================");


        LocalDate localDate = LocalDate.now();
        localDate = LocalDate.of(2019,9, 12);
        LocalDate minLocalDate = localDate.minusMonths(1);
        Date cDate = new Date();
        try {
            Date parseDate = DateUtils.parseDate("2019-10","yyyy-MM");
            Date date1 = DateUtils.parseDate(new DateTime(DateTimeUtil.localDate2Date(minLocalDate)).toString("yyyy-MM"), "yyyy-MM");
            System.out.println(parseDate.before(date1));

            Date date2 = DateUtils.parseDate(new DateTime(DateTimeUtil.localDate2Date(localDate)).toString("yyyy-MM"), "yyyy-MM");
            System.out.println(parseDate.after(date2));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
