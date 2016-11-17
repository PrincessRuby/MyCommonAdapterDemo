package com.mycommonadapterdemo.bean;

import java.io.Serializable;

/**
 * 所有封装类的父类,所有类皆是可序列化操作
 * @author wyb
 * 
 * 当实现java.io.Serializable接口的实体（类）没有显式地定义一个
 * 名为serialVersionUID，类型为long的变量时，Java序列化机制会根
 * 据编译的class(它通过类名，方法名等诸多因素经过计算而得，理论上
 * 是一一映射的关系，也就是唯一的)自动生成一个serialVersionUID作
 * 序列化版本比较用，这种情况下，如果class文件(类名,方法明等)没有
 * 发生变化(增加空格,换行,增加注释,等等),就算再编译多次,serialVersionUID也不会变化的.
 */
public class BasicBean implements Serializable{
	private static final long serialVersionUID = 1L;
}
