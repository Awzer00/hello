package com.project.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomValidateCode {

	public static final String RANDOM_CODE_KEY = "RANDOM_VALIDATE_CODE_KEY";// 放到session中的key
	private Random random = new Random();
	private String baseString = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";// 随机产生的字符串

	private int width = 80;// 图片宽
	private int height = 30;// 图片高
	private int lineSize = 10;// 干扰线数量
	private int stringNum = 4;// 随机产生字符数量

	/*
	 * 获得字体
	 */
	private Font getFont() {
		Random ran = new Random();
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18+ran.nextInt(5));
	}

	/*
	 * 获得颜色
	 */
	private Color getRandColor(int fc, int bc) {
		if (fc > 255){
			fc = 255;
		}
		if (bc > 255){
			bc = 255;
		}
		if(fc < 0){
			fc = 0;
		}
		if(bc < 0){
			bc = 0;
		}
		int r = fc + random.nextInt(bc - fc - 16);
		int g = fc + random.nextInt(bc - fc - 14);
		int b = fc + random.nextInt(bc - fc - 18);
		return new Color(r, g, b);
	}

	/**
	 * 生成随机图片
	 */
	public void getRandcode(HttpServletRequest request,
			HttpServletResponse response) {
		
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
//		g.setColor(Color.RED);
		g.fillRect(2, 2, width - 4, height - 4);
		//g.drawRect(x, y, width, height);
//		//g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
//		
//		
//		// 绘制干扰线
		for (int i = 0; i < lineSize; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(width);
			int yl = random.nextInt(height);
			g.setColor(getRandColor(110, 133));
			g.drawLine(x, y, xl, yl);
//			int x1 = random.nextInt(width);
//			int x2 = random.nextInt(width);
//			int y1 = random.nextInt(height);
//			int y2 = random.nextInt(height);
//			g.setColor(getRandColor(110, 133));
//			g.drawLine(x1, y1, x2, y2);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			int x = random.nextInt(baseString.length());
			char rand = baseString.charAt(x);
			randomString += rand;
			
			int a = random.nextInt(10);
			int b = random.nextInt(8);
			g.setFont(getFont());
			g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
					.nextInt(121)));
			g.drawString(rand + "", 13 * i + b, 18 + a);
		}
		g.dispose();
		HttpSession session = request.getSession();
		session.setAttribute(RANDOM_CODE_KEY, randomString);
//		System.out.println(randomString);
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}