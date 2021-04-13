package pers.yangzhen.io.fileclass;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 */
public class FindJPGFileTest {

	@Test
	public void test1(){
		File srcFile = new File("d:/local/photo/Saved Pictures");
		
		String[] fileNames = srcFile.list();
		for(String fileName : fileNames){
			if(fileName.endsWith(".jpg")){//endWith()判断字符串是否以指定的后缀结尾
				System.out.println(fileName);
			}
		}
	}
	@Test
	public void test2(){
		File srcFile = new File("d:/local/photo/Saved Pictures");
		
		File[] listFiles = srcFile.listFiles();
		for(File file : listFiles){
			if(file.getName().endsWith(".jpg")){
				System.out.println(file.getAbsolutePath());
			}
		}
	}
	//上面两个方式本质上都是将文件的名称或者File对象存到一个数组中，
	// 通过boolean endWith(String str)判断其是否以该后缀结尾

	/*
	 * File类提供了两个文件过滤器方法
	 * public String[] list(FilenameFilter filter)
	 * public File[] listFiles(FileFilter filter)
	 */
	@Test
	public void test3(){
		File srcFile = new File("d:/local/photo/Saved Pictures");
		
		File[] subFiles = srcFile.listFiles(new FilenameFilter() {//接口的匿名实现类
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".jpg");
			}
		});

		for(File file : subFiles){
			System.out.println(file.getName());
		}
	}
	
}
