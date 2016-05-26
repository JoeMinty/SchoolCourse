package com.mao.infocrawler.utils;

/**
 * Created by mao on 2016/5/9.
 */
public class StringUtil {

	public final static String USER_ID = "userid";
	
	public final static String USER_NAME = "username";
	
	public final static String USER_TYPE = "usertype";
	
	public final static String USER_MESSAGE_COUNT = "msgcount";
	
    /**
     * str是否为空
     * @param str
     * @return
     */
    public static boolean validateString(String str) {
        if ("".equals(str.trim()) || str == null)
            return false;
        return true;
    }
}
