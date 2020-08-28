package com.wnslp.ssm.common.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        //编写时间转换器，支持多种时间格式
        SimpleDateFormat sdf = getSimpleDateFormat(source);
        try {
            Date date = sdf.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleDateFormat getSimpleDateFormat(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            System.out.println("日期格式错误");
        }
        return sdf;
    }
}

