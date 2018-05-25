package com.yiya.util;
import java.lang.reflect.Field;

public class CopyProperties {
	 public static void copyPropertysWithoutNull(Object des, Object src){
	        Class<?> clazz = des.getClass();
	        Field[] srcfields=src.getClass().getDeclaredFields();
	        for(Field field:srcfields){
	            if(field.getName().equals("serialVersionUID"))
	                continue;
	            Field f;
	            try {
	                f = clazz.getDeclaredField(field.getName());
	                f.setAccessible(true);
	                field.setAccessible(true);
	                Object obj = field.get(src);
	                if(obj!=null)
	                    f.set(des,obj);
	            } catch (SecurityException e) {
	                // 
	                e.printStackTrace();
	            }
	            catch (NoSuchFieldException e) {
	                // 
	               // e.printStackTrace();
	            }
	            catch (IllegalArgumentException e) {
	                // 
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                // 
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 

		/**
		 * @category 把src中的非空属性复制到des中
		 * @description 把src中的非空属性复制到des中， paramStr用来指定属性集合，如果不在这个集合内，则不会复制
		 * @case 
		 * @param des 接受属性的对象
		 * @param src 复制来源
		 * @param paramStr 复制的参数集合,是一个字符串用','分割；
		 */
		public static void copyPropertysWithoutNull(Object des, Object src,
                                                    String paramStr) {
			Class<?> clazz = des.getClass();
			Field[] srcfields = src.getClass().getDeclaredFields();
			for (Field field : srcfields) {
				if (field.getName().equals("serialVersionUID"))
					continue;
				Field f;
				try {
					f = clazz.getDeclaredField(field.getName());
					f.setAccessible(true);
					field.setAccessible(true);
					Object obj = field.get(src);
					if (obj != null && paramStr.contains(field.getName()))
						f.set(des, obj);
				} catch (SecurityException e) {
					// 
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// 
					// e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// 
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// 
					e.printStackTrace();
				}
			}
		}
	 
}



