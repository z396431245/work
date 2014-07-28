package com.xunta.android.tools; 

import android.util.Log;

import com.xunta.android.common.Constent;

/**   
 * @Title: MyLog.java 
 * @Package com.seekta.android.tools 
 * @Description: TODO(Log打印日志类) 
 * @author zhangchao   
 * @date 2014年7月23日 下午10:32:20   
 */
public class MyLog {

	public static String TAG = "SeekTa";
	
	public static void e(String msg){
		if(Constent.isLog){
			Log.e(TAG,msg);
		}
	}
	
	public static void e(String tag,String msg){
		if(Constent.isLog){
			Log.e(tag,msg);
		}
	}
	
	public static void d(String msg){
		if(Constent.isLog){
			Log.d(TAG,msg);
		}
	}
	
	public static void d(String tag,String msg){
		if(Constent.isLog){
			Log.d(tag,msg);
		}
	}
	
}
 