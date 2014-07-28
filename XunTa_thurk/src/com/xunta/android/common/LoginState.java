package com.xunta.android.common; 

import android.app.Activity;
import android.content.SharedPreferences;

/**   
 * @Title: LoginState.java 
 * @Package com.seekta.android.common 
 * @Description: TODO(存储登录信息类) 
 * @author zhangchao   
 * @date 2014年7月26日 下午12:56:41   
 */
public class LoginState {

	public static final String USER_STATE = "user_state";
	public static final String USERID = "userId";
	public static final String USERNAME = "userName";
	public static final String PHOTOURL = "photoUrl";
	
	public static boolean isLogin(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		String str = sp.getString(USERID, "");
		if("".equals(str)){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**保存用户头像*/
	public static void setPhotoUrl(Activity activity,String str){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		sp.edit().putString(PHOTOURL, str).commit();
	}
	
	/**获取用户头像*/
	public static String getPhotoUrl(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		return sp.getString(PHOTOURL, "");
	}
	
	/**保存用户名*/
	public static void setUserName(Activity activity,String str){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		sp.edit().putString(USERNAME, str).commit();
	}
	
	/**获取用户名*/
	public static String getUserName(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		return sp.getString(USERNAME, "");
	}
	
	/**保存userid*/
	public static void setUserId(Activity activity,String str){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		sp.edit().putString(USERID, str).commit();
	}

	/**获取userid*/
	public static String getUserId(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		return sp.getString(USERID, "");
	}
	
}
 