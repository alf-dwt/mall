<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script>
			function showDetail(oid){
				var div1 = document.getElementById("div"+oid);
				var btn = document.getElementById("btn"+oid);
				if(btn.value=="订单详情"){
					//1.创建异步交互对象
					var xmlhttp = ajaxFunction();
					//2.设置监听
					xmlhttp.onreadystatechange=function()
					  {
					  if (xmlhttp.readyState==4 && xmlhttp.status==200)
					    {
					    div1.innerHTML=xmlhttp.responseText;
					    }
					  };
					//3.打开连接
					xmlhttp.open("GET","${pageContext.request.contextPath}/adminorder_findOrderItem.action?time="+new Date().getTime()+"&oid="+oid,true);
					//4.发送
					xmlhttp.send(null);
					btn.value = "关闭详情";
				}else{
					btn.value="订单详情";
					div1.innerHTML="";
				}
				
				
				
			}
			
			function ajaxFunction(){
				var xmlhttp;
				if (window.XMLHttpRequest)
				  {// code for IE7+, Firefox, Chrome, Opera, Safari
				  xmlhttp=new XMLHttpRequest();
				  }
				else
				  {// code for IE6, IE5
				  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				  }
				  return xmlhttp;
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										总金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td width="*" align="center">
										订单详情
									</td>
									
								</tr>
								<s:iterator var="order" value="pageBean.proList" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#order.oid"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#order.total"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:property value="#order.name"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:if test="#order.state==1">未付款</s:if>
												<s:if test="#order.state==2">
													<a href="${pageContext.request.contextPath }/adminorder_updateState.action?oid=<s:property value="#order.oid"/>"><font color="blue">发货</font></a>
												</s:if>
												<s:if test="#order.state==3">未确认收货</s:if>
												<s:if test="#order.state==4">交易完成</s:if>
												
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input id="btn<s:property value="#order.oid"/>" value="订单详情" type="button" onclick="showDetail(<s:property value="#order.oid"/>)"/>
												<div id="div<s:property value="#order.oid"/>"></div>
											</td>
										</tr>
									</s:iterator>	
							</table>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<div class="pagination">
			
								<span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.pageCount"/>页</span>
								<s:if test="pageBean.page==1">
									<span class="firstPage">&nbsp;</span>
									<span class="previousPage">&nbsp;</span>
								</s:if>
								<s:else>
									<a class="firstPage" href="${pageContext.request.contextPath}/adminorder_findAll.action?page=1">&nbsp;</a>
									<a class="previousPage" href="${pageContext.request.contextPath}/adminorder_findAll.action?page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
								</s:else>
								
								<s:iterator end="pageBean.pageCount" var="p" begin="1">
									<s:if test="pageBean.page==#p">
										<span class="currentPage"><s:property value="#p"/></span>
									</s:if>
									<s:else>
										<a href="${pageContext.request.contextPath}/adminorder_findAll.action?page=<s:property value="#p"/>"><s:property value="#p"/></a>
									</s:else>
								</s:iterator>	
								
									
								<s:if test="pageBean.page==pageBean.pageCount">
									<span class="nextPage">&nbsp;</span>
									<span class="lastPage">&nbsp;</span>
								</s:if>
								<s:else>
									<a class="nextPage" href="${pageContext.request.contextPath}/adminorder_findAll.action?page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
									<a class="lastPage" href="${pageContext.request.contextPath}/adminorder_findAll.action?page=<s:property value="pageBean.pageCount"/>">&nbsp;</a>
								</s:else>
							</div>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

