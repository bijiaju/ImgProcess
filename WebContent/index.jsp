<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量二维码处理</title>
<style type="text/css">
#loading {
width:200px;
height:25px;
border:3px solid #C3DAF9;
position:absolute;
top:300px;
left:600px; 
z-index:10000; 
background-color:#F7F9FC;
line-height:25px;
vertical-align:middle;
font-size:11pt;
display:none;
}
body {
background-color:blue;
background-image:url("${pageContext.request.contextPath}/style/img/back.jpg");
background-repeat:no-repeat;
 background-position:40% 40%;
}
#title{
text-align:center;
}

</style>
<script type="text/javascript"  src="${pageContext.request.contextPath}/style/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//显示加载数据
	function ShowDiv() {
	$("#loading").show();
	}

	//隐藏加载数据
	function HiddenDiv() {
	$("#loading").hide();
	}
	
	$("#transpng").click(function(){
		
		var texts = $(":text");
		var srcAddress = $(texts[0]).val();
		var desAddress = $(texts[1]).val();
		var width = $(texts[2]).val();
		var hight = $(texts[3]).val();
		var whiteEdge = $(texts[4]).val();
		var error = $("select option:selected").val();
		//alert(error);
		$.ajax({
				async: true,
				beforeSend: function () {
				ShowDiv();
				},
				complete: function () {
				HiddenDiv();
				},
				type : 'POST' ,
				url : '${pageContext.request.contextPath}/QRCodeServlet?method=transpng',
				data : {
				"srcAddress":srcAddress,
				"desAddress":desAddress,
				"width":width,
				"hight":hight,
				"whiteEdge":whiteEdge,
				"error":error
				},
				success: function (backDate) {
					var backDatas = backDate.split('_');
							//$.each(backDatas,function(index,value){
							     //alert(index+"..."+value);
							  var $img = $("<h2  style='color:red;'>"+backDate+"</h2>");
							$("#tip2").text("");
		  				  $("#tip2").append($img);
		    }
		});

			
	});
		
	$("#getResult").click(function(){
		
		var texts = $(":text");
		var srcAddress = $(texts[0]).val();
		var desAddress = $(texts[1]).val();
		var width = $(texts[2]).val();
		var hight = $(texts[3]).val();
		var whiteEdge = $(texts[4]).val();
		var error = $("select option:selected").val();
		//alert(error);
		$.ajax({
				async: true,
				beforeSend: function () {
				ShowDiv();
				},
				complete: function () {
				HiddenDiv();
				},
				type : 'POST' ,
				url : '${pageContext.request.contextPath}/QRCodeServlet?method=processOrder',
				data : {
				"srcAddress":srcAddress,
				"desAddress":desAddress,
				"width":width,
				"hight":hight,
				"whiteEdge":whiteEdge,
				"error":error
				},
				success: function (backDate) {
					var backDatas = backDate.split('_');
							//$.each(backDatas,function(index,value){
							     //alert(index+"..."+value);
							     var $img = $("<h2  style='color:green;'>"+backDatas[1]+"</h2>");
									$("#tip1").text("");
								    $("#tip1").append($img);
								    var $img = $("<h2  style='color:red;'>"+backDatas[0]+"</h2>");
									$("#tip2").text("");
								    $("#tip2").append($img);
				}
		});
		
		
	});
});
</script>
</head>
<body>
<span id="tip1"></span>
<span id="tip2"></span>

<h1 id="title">生成微信订单</h1>
   <!-- 
		在异步提交的方式下，form标签的action和method属性没有意义
	-->
	<form action="" method="">
		<table border="2" align="center">
			<tr>
				<th>请输入金额</th>
				<td><input type="text" name="rmb"  value=""/></td>
				<td></td>
			</tr>
			<tr>
				<th>商品名</th>
				      <td>
				      <select name="tradeName" >
  							<option value="河南仟福购物广场有限公司">河南仟福购物广场有限公司</option>
  							<option value="7%">7%</option>
  							<option value="30%">30%</option>
  							<option value="15%">15%</option>
						</select>
						</td>
				<td></td>
			</tr>
			<tr>
				<th>商户名称</th>
				<td>
				       <select name="shopName" >
  							<option value="河南仟福购物广场有限公司">河南仟福购物广场有限公司</option>
  							<option value="7%">7%</option>
  							<option value="30%">30%</option>
  							<option value="15%">15%</option>
						</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<th>支付时间</th>
				<td><input type="text" name="payTime" value="400"/></td>
				<td>仍需修改</td>
			<!-- </tr>
			<tr>
				<th>二维码高</th>
				<td><input type="text" name="hight"  value="400"/></td>
				<td>像素</td>
			</tr>
			<tr>
				<th>二维码白边</th>
				<td><input type="text" name="whiteEdge"  value="10"/></td>
				<td>数越小，白边越小</td>
			</tr> -->
		</table>
		
	</form>
    <center>
     		<button id="getResult" style="width:200px; height:100px;">生成图片</button>
     </center>
     <div id="loading"><img src="${pageContext.request.contextPath}/style/img/comm.gif" alt=""/>正在处理数据,请稍候...</div>
    </body>
</html>
