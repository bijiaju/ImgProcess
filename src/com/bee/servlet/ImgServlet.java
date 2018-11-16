package com.bee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bee.pojo.WeChatOrder;
import com.bee.service.impl.ImgServiceImpl;

/**
 * Servlet implementation class QRCodeServlet
 */
@WebServlet("/QRCodeServlet")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ImgServiceImpl imgService = new ImgServiceImpl();//服务
    /**
     * Default constructor. 
     */
    public ImgServlet() {
        // TODO Auto-generated constructor stub
    }

    
    /**
	 * 4.destroy方法
	 */
	@Override
	public void destroy() {
		System.out.println("4.servlet对象销毁了");
	}

	/**
	 * 2.init方法
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.init方法被调用");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		String method = request.getParameter("method");
		if ("processOrder".equals(method)) {
			
				processOrder(request, response);
			
		}else if("createQR".equals(method)){
			
		}else if("transpng".equals(method)){
			
		}
		
	}
	/**
	 * 批量处理QR,遍历文件下文件执行操作
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ParseException 
	 */
	private void processOrder(HttpServletRequest request, HttpServletResponse response)  {
		try {
			String rmb = request.getParameter("rmb");//哈哈
			String tradeName = request.getParameter("tradeName");//哈哈
			String shopName = request.getParameter("shopName");//哈哈
			String payTime = request.getParameter("payTime");//哈哈
	        //date还需要修改
		    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date  paydate = dateformat.parse(payTime);  
			
			
			
			WeChatOrder order = new WeChatOrder();
			order.setRmb(rmb);
			order.setStatus("支付成功");
			order.setTradeName(tradeName);
			order.setShopName(shopName);
			order.setPayTime(paydate);
			order.setPayway("零钱");
			
			
			order.setOrderId(getOrderId(paydate));
			
		
	        order.setShopId("可在支出的商户扫码退款");
	        order.setBarId(getBarId(paydate));
	      //条形码编号
			imgService.pressWeChatText(order);
		    
			 response.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = response.getWriter();
			 //pw.write(QRInfo);
			 pw.flush();
			 pw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getBarId(Date date){
		Random random = new Random();
		//设置barID
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuilder barId = new StringBuilder();
        barId.append("MYBKJHZF");
        String day2 = dateformat2.format(date);
        barId.append(day2);
        for(int i=0;i<8;i++){
     	   int i1 = random.nextInt(9)+1;
     	  barId.append(i1);
        }
        return barId.toString();
	}
	
	public String getOrderId(Date date){
		//交易订单号 
		SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyyMMdd");
       String day = dateformat1.format(date);
       StringBuilder orderId = new StringBuilder();
       orderId.append("4200000133");
       orderId.append(day);
       Random random = new Random();
       for(int i=0;i<10;i++){
    	   int i1 = random.nextInt(9)+1;
    	   orderId.append(i1);
       }
       return orderId.toString();
	}

	
	/**
	 * 请求地址http://localhost:8080/QRCode/QRCodeServlet?method=decodeQR
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void decodeQR(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("Served at:hahaha ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
