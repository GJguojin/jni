package com.gj.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.pngquant.PngQuant;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			try {
				System.out.print("A)png图片转webp  B)png图片压缩  请选择要进行的操作：");
				String chose = sc.next();
				System.out.print("请输入图路径：");
				String file = sc.next();
				
				if(file == null || !file.toLowerCase().endsWith(".png")){
					throw new Exception("输入错误的路径或不是png图片");
				}
				
				BufferedImage image = ImageIO.read(new File(file));
				Long t1 = System.currentTimeMillis();
				if ("A".equalsIgnoreCase(chose)) {
					String outFile = file.replace(".png", ".webp");
					ImageIO.write(image, "webp", new File(outFile));
				} else {
					String outFile = file.replace(".png", ".min.png");
					PngQuant pngQuant = new PngQuant();
			    	pngQuant.setQuality(20);
			    	BufferedImage remapped = pngQuant.getRemapped(image);
			    	ImageIO.write(remapped, "png", new File(outFile));
					
				} 
				Long t2= System.currentTimeMillis();
				System.out.println("图片处理完成,用时："+(t2-t1)+"ms");
			} catch (Exception e) {
				System.out.print("系统异常："+e.getMessage());
			}finally {
				System.out.print("是否继续（Y/N）:");
				String exit =  sc.next();
				if(!"Y".equalsIgnoreCase(exit)){
					sc.close();
					flag = false;
				}else{
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
				}
			}
		}		
	}
}
