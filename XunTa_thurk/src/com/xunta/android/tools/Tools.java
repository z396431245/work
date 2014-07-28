package com.xunta.android.tools; 


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

}
 