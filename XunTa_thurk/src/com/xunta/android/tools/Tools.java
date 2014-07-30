package com.xunta.android.tools; 

import android.text.TextUtils;


/**   
 * @Title: Tools.java 
 * @Package com.seekta.android.tools 
 * @Description: TODO(工具类) 
 * @author zhangchao   
 * @date 2014年7月23日 下午10:27:01   
 */
public class Tools {
	
	/**
	 * 判断字符串是否为空
	 * 空 返回 false
	 * 不为空 返回 true
	 * */
	public static boolean isNull(String content){
		if(null != content && !"".equals(content) && !"null".equals(content)){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证手机格式
	 */
	public static boolean isMobileNO(String mobiles) {
		/*
		总结起来就是第一位必定为1，第二位必定为2到9，其他位置的可以为0-9
		*/
		//"[1]"代表第1位为数字1，"[3-9]"代表第二位可以为3-9中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
		String telRegex = "[1][3-9]\\d{9}";
		if (TextUtils.isEmpty(mobiles)){
			return false;
		}else{
			return mobiles.matches(telRegex);
		}
    }

}
 