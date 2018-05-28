package com.baikunlong.gittest;

import java.util.*;

public class DataBase {
	private static List<Person> persons;
	public static List<Person>  getPersons()
	{
		if(persons==null)
		{
			persons=new ArrayList<Person>();
			persons.add(new Person("张三", "1385967656", "abc@123.com", "可爱"));
			persons.add(new Person("李四", "1367890121", "ls@123.com", "美丽"));
			persons.add(new Person("王五", "1361223677", "ww@123.com", "邪恶"));
			for(int i=0;i<100;i++){
				persons.add(new Person("某某"+i,"12345"+i,"123@qq.com"+i,"哈希"+i));
			}
			
		}
		return persons;
	}
}
