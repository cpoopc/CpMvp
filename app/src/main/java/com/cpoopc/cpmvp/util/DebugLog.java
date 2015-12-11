/***
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

For more information, please refer to <http://unlicense.org/>
*/

package com.cpoopc.cpmvp.util;

import android.text.TextUtils;
import android.util.Log;


/**
 * 调试用的LOG工具,可以显示log所在文件,行数
 *
 * @date 21.06.2012
 * @author Mustafa Ferhan Akman
 * @modify cpoopc
 * Create a simple and more understandable Android logs. 
 * */

public class DebugLog {

//    static boolean debuggable = BuildConfig.DEBUG;
    static boolean debuggable = true;
    static String tagPrefix = "cp:";
	static String className;
	static String methodName;
	static int lineNumber;

    private DebugLog(){
        /* Protect from instantiations */
    }

    public static void setDebuggAble(boolean debug) {
        debuggable = debug;
    }

	public static boolean isDebuggable() {
//        android.util.Log.e("----", "+BuildConfig.DEBUG   " +BuildConfig.DEBUG);
		return debuggable;
	}

	private static String createLog(String log ) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append(methodName);
		buffer.append(":");
		buffer.append(lineNumber);
		buffer.append("]");
		buffer.append(log);

		return buffer.toString();
	}

	private static void getMethodNames(StackTraceElement[] sElements) {
		getMethodNames(null, sElements);
	}

	private static void getMethodNames(String prefix, StackTraceElement[] sElements) {
		className = sElements[1].getFileName();
		if (!TextUtils.isEmpty(prefix)) {
			className = prefix + " " + className;
		}else if (!TextUtils.isEmpty(tagPrefix)) {
			className = tagPrefix + className;
		}
		methodName = sElements[1].getMethodName();
		lineNumber = sElements[1].getLineNumber();
	}

	public static void e(String message){
		if (!isDebuggable())
			return;

		// Throwable instance must be created before any methods
		getMethodNames(null, new Throwable().getStackTrace());
		Log.e(className, createLog(message));
	}

	public static void e(String tag, String message){
		if (!isDebuggable())
			return;

		// Throwable instance must be created before any methods
		getMethodNames(tag, new Throwable().getStackTrace());
		Log.e(className, createLog(message));
	}

	public static void i(String message){
		if (!isDebuggable())
			return;

		getMethodNames(null, new Throwable().getStackTrace());
		Log.i(className, createLog(message));
	}

	public static void i(String tag, String message) {
		if (!isDebuggable())
			return;

		getMethodNames(tag, new Throwable().getStackTrace());
		Log.i(className, createLog(message));
	}

	public static void d(String message){
		if (!isDebuggable())
			return;

		getMethodNames(null, new Throwable().getStackTrace());
		Log.d(className, createLog(message));
	}

	public static void d(String tag, String message) {
		if (!isDebuggable())
			return;

		getMethodNames(tag, new Throwable().getStackTrace());
		Log.d(className, createLog(message));
	}

	public static void v(String message){
		if (!isDebuggable())
			return;

		getMethodNames(null, new Throwable().getStackTrace());
		Log.v(className, createLog(message));
	}

	public static void v(String tag, String message) {
		if (!isDebuggable())
			return;

		getMethodNames(tag, new Throwable().getStackTrace());
		Log.v(className, createLog(message));
	}

	public static void w(String message){
		if (!isDebuggable())
			return;

		getMethodNames(null, new Throwable().getStackTrace());
		Log.w(className, createLog(message));
	}

	public static void w(String tag, String message) {
		if (!isDebuggable())
			return;

		getMethodNames(tag, new Throwable().getStackTrace());
		Log.w(className, createLog(message));
	}

	public static void wtf(String message){
		if (!isDebuggable())
			return;

		getMethodNames(null, new Throwable().getStackTrace());
		Log.wtf(className, createLog(message));
	}

	public static void wtf(String tag, String message) {
		if (!isDebuggable())
			return;

		getMethodNames(tag, new Throwable().getStackTrace());
		Log.wtf(className, createLog(message));
	}

//	private static void appendToSb(String message, StringBuilder stringBuilder) {
//		if (stringBuilder != null) {
//			stringBuilder.append(message).append("\n");
//		}
//	}
//
//	public static void e(String message, StringBuilder stringBuilder) {
//		appendToSb(message, stringBuilder);
//		e(message);
//	}
//
//	public static void i(String message, StringBuilder stringBuilder){
//		appendToSb(message, stringBuilder);
//		i(message);
//	}
//
//	public static void d(String message, StringBuilder stringBuilder){
//		appendToSb(message, stringBuilder);
//		d(message);
//	}
//
//	public static void v(String message, StringBuilder stringBuilder){
//		appendToSb(message, stringBuilder);
//		v(message);
//	}
//
//	public static void w(String message, StringBuilder stringBuilder){
//		appendToSb(message, stringBuilder);
//		w(message);
//	}
//
//	public static void wtf(String message, StringBuilder stringBuilder){
//		appendToSb(message, stringBuilder);
//		wtf(message);
//	}

}
