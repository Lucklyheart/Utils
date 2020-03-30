package com.ip.ipsearch.Util;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtil {

    private HtmlUtil() {}

    /**
     * 判断url是否含有参数
     *
     * @param url
     * @return
     */
    public static boolean haveParameter(String url) {
        return !Uri.parse(url).getQueryParameterNames().isEmpty();
    }

    /**
     * 获取指定HTML标签的指定属性的值
     *
     * @param source  要匹配的源文本
     * @param element 标签名称
     * @param attr    标签的属性名称
     * @return 属性值列表
     */
    public static String getSpecifyLabelValue(String source, String element, String attr) {
        List<String> result = new ArrayList<String>();
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?/>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result.size() > 0 ? result.get(0) : "";
    }

    /***
     * 获取url 指定name的value;
     * @param url
     * @param name
     * @return
     */
    public static String getURLValueByName(String url, String name) {
        String result = "";
        int index = url.indexOf("?");
        String temp = url.substring(index + 1);
        String[] keyValue = temp.split("&");
        for (String str : keyValue) {
            if (str.contains(name)) {
                result = str.replace(name + "=", "");
                break;
            }
        }
        return result;
    }
}
