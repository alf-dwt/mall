<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table border="1" width="100%">
	<tr>
		<td>商品图片</td>
		<td>商品数量</td>
		<td>总金额</td>
	</tr>
	<s:iterator value="list" var="orderItem">
		<tr>
			<td><img width="40" height="45" src="<s:property value="#orderItem.product.image"/>"/></td>
			<td><s:property value="#orderItem.count"/></td>
			<td><s:property value="#orderItem.subtotal"/></td>
		</tr>
	</s:iterator>
</table>