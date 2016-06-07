<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>传智网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.png" alt="传智播客"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	</div>

	<%@ include file="meau.jsp" %>
		
</div>	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator value="#session.cList" var="c">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath }/product_findByPageCid?cid=<s:property value="#c.cid"/>&page=1">
									<s:property value="#c.cname"/>
								</a>
							</dt>
								<s:iterator value="#c.categorySeconds" var="cs">
									<dd>
										<a href="${pageContext.request.contextPath }/product_findByCsid?csid=<s:property value="#cs.csid"/>&page=1"><s:property value="#cs.csname"/></a>
									</dd>
								</s:iterator>
						</dl>
					</s:iterator>
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">
					
				<div id="result" class="result table clearfix">
						<ul>
							<s:iterator value="pageBean.proList" var="p">
									<li>
										<a href="${pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="pid"/>">
											<img src="${pageContext.request.contextPath}/<s:property value="#p.image"/>" width="170" height="170"  style="display: inline-block;"/>
											   
											<span style='color:green'>
											<s:property value="#p.pname"/>
											</span>
											 
											<span class="price">
												商城价： ￥<s:property value="#p.shop_price"/>元
											</span>
											 
										</a>
									</li>
							</s:iterator>	
						</ul>
				</div>
	<div class="pagination">
			
			<span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.pageCount"/>页</span>
		<s:if test="cid!=null">
			<s:if test="pageBean.page==1">
				<span class="firstPage">&nbsp;</span>
				<span class="previousPage">&nbsp;</span>
			</s:if>
			<s:else>
				<a class="firstPage" href="${pageContext.request.contextPath}/product_findByPageCid?cid=<s:property value="cid"/>&page=1">&nbsp;</a>
				<a class="previousPage" href="${pageContext.request.contextPath}/product_findByPageCid?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
			</s:else>
			
			<s:iterator end="pageBean.pageCount" var="p" begin="1">
				<s:if test="pageBean.page==#p">
					<span class="currentPage"><s:property value="#p"/></span>
				</s:if>
				<s:else>
					<a href="${pageContext.request.contextPath}/product_findByPageCid?cid=<s:property value="cid"/>&page=<s:property value="#p"/>"><s:property value="#p"/></a>
				</s:else>
			</s:iterator>	
			
				
			<s:if test="pageBean.page==pageBean.pageCount">
				<span class="nextPage">&nbsp;</span>
				<span class="lastPage">&nbsp;</span>
			</s:if>
			<s:else>
				<a class="nextPage" href="${pageContext.request.contextPath}/product_findByPageCid?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="${pageContext.request.contextPath}/product_findByPageCid?cid=<s:property value="cid"/>&page=<s:property value="pageBean.pageCount"/>">&nbsp;</a>
			</s:else>
		</s:if>
		<s:if test="csid!=null">
			<s:if test="pageBean.page==1">
				<span class="firstPage">&nbsp;</span>
				<span class="previousPage">&nbsp;</span>
			</s:if>
			<s:else>
				<a class="firstPage" href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="csid"/>&page=1">&nbsp;</a>
				<a class="previousPage" href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
			</s:else>
			
			<s:iterator end="pageBean.pageCount" var="p" begin="1">
				<s:if test="pageBean.page==#p">
					<span class="currentPage"><s:property value="#p"/></span>
				</s:if>
				<s:else>
					<a href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="csid"/>&page=<s:property value="#p"/>"><s:property value="#p"/></a>
				</s:else>
			</s:iterator>	
			
				
			<s:if test="pageBean.page==pageBean.pageCount">
				<span class="nextPage">&nbsp;</span>
				<span class="lastPage">&nbsp;</span>
			</s:if>
			<s:else>
				<a class="nextPage" href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="csid"/>&page=<s:property value="pageBean.pageCount"/>">&nbsp;</a>
			</s:else>
		</s:if>
	</div>
			</form>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >官网</a>
						|
					</li>
					<li>
						<a >论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>
