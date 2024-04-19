<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>
<html>
<head><title>�Խñ� ���</title></head>
<body>
<table border="1">
	<c:if test="${listModel.totalPageCount > 0}">
	<tr>
		<td colspan="5">
		${listModel.startRow}-${listModel.endRow}
		[${listModel.requestPage}/${listModel.totalPageCount}]
		</td>
	</tr>
	</c:if>
	
	<tr>
		<td>�� ��ȣ</td>
		<td>����</td>
		<td>�ۼ���</td>
		<td>�ۼ���</td>
		<td>��ȸ��</td>
	</tr>
	
<c:choose>
	<c:when test="${listModel.hasArticle == false}">
	<tr>
		<td colspan="5">
			�Խñ��� �����ϴ�.
		</td>
	</tr>
	</c:when>
	<c:otherwise>
	<c:forEach var="article" items="${listModel.articleList}">
	<tr>
		<td>${article.id}</td>
		<td>
			<c:if test="${article.level > 0}">
			<c:forEach begin="1" end="${article.level}">-</c:forEach>&gt;
			</c:if>
			<c:set var="query" 
				value="articleId=${article.id}&p=${listModel.requestPage}"/>
			<a href="<c:url value="/read?${query}"/>">
			${article.title}
			</a>
		</td>
		<td>${article.writerName}</td>
		<td>${article.postingDate}</td>
		<td>${article.readCount}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5">
		
		<c:if test="${beginPage > 10}">
			<a href="<c:url value="/list?p=${beginPage-1}"/>">����</a>
		</c:if>
		<c:forEach var="pno" begin="${beginPage}" end="${endPage}">
		<a href="<c:url value="/list?p=${pno}" />">[${pno}]</a>
		</c:forEach>
		<c:if test="${endPage < listModel.totalPageCount}">
			<a href="<c:url value="/list?p=${endPage + 1}"/>">����</a>
		</c:if>
		</td>
	</tr>
	</c:otherwise>
</c:choose>
	
	<tr>
		<td colspan="5">
			<a href="writeForm.jsp">�۾���</a>
		</td>
	</tr>	
</table>
</body>
</html>