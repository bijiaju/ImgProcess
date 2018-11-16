package com.bee.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bee.pojo.WeChatOrder;
import com.bee.util.ImageUtils;

public class ImgServiceImpl {
	
	
	
	
	
	/**
	 * 制作微信图片
	 */
	public static void pressWeChatText(WeChatOrder order){
		try {
			// 店铺名称, 大小要动
		       ImageUtils.pressText("丹尼斯广场有限公司","C:/Users/bee/Desktop/test/src.png", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,42, -20, -588, 1.0f ,1.1);//测试OK
		       //设置价格，大小不动
		       ImageUtils.pressTextNoPace("56.00","C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.BOLD,Color.BLACK,75, 0, -440, 1.0f);//测试OK
		       //当前状态 大小不动
		       ImageUtils.pressText("支付成功","C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,39, -165, -205, 1.0f,0.98);//测试OK
		       //商品，大小要动
		       ImageUtils.pressText("河南仟福购物广场有限公司","C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,39, -5, -100, 1.0f,0.98);//测试OK
		       //商户名称
		       ImageUtils.pressText("河南仟福购物广场有限公司","C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,39, -5, 3, 1.0f,0.98);//测试OK

		       
		     //支付时间
		       SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		       String payTime = dateformat.format(new Date());
		       System.out.println(payTime);
		       ImageUtils.pressText(payTime,"C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,39, -70, 110, 1.0f,0.98);//测试OK
		       //零钱
		       ImageUtils.pressText("零钱","C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,39, -203, 215, 1.0f,0.98);//测试OK
		       SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyyMMdd");
		       String day = dateformat1.format(new Date());
		       StringBuilder orderId = new StringBuilder();
		       orderId.append("4200000133");
		       orderId.append(day);
		       Random random = new Random();
		       for(int i=0;i<10;i++){
		    	   int i1 = random.nextInt(9)+1;
		    	   orderId.append(i1);
		       }
		       //交易订单号
		        ImageUtils.pressText(orderId.toString(),"C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,39, 29, 320, 1.0f,0.98);//测试OK

		        SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		        StringBuilder barId = new StringBuilder();
		        barId.append("MYBKJHZF");
		        String day2 = dateformat2.format(new Date());
		        barId.append(day2);
		        for(int i=0;i<5;i++){
		     	   int i1 = random.nextInt(9)+1;
		     	  barId.append(i1);
		        }
		      //条形码编号
		        ImageUtils.pressTextNoPace(barId.toString(),"C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,34, -70, 690, 1.0f);//测试OK

		       //可以在支出的商户扫码退款
		        ImageUtils.pressText("可在支出的商户扫码退款","C:/Users/bee/Desktop/test/src1_pressText.jpg", "C:/Users/bee/Desktop/test/src1_pressText.jpg","微软雅黑",Font.PLAIN,Color.BLACK,39, -30, 423, 1.0f,0.98);//测试OK
	            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
