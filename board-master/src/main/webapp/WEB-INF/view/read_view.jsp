<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>
<html>
<head><title>�� �б�</title></head>
<body>
<table>
<tr>
	<td>����</td>
	<td>${article.title}</td>
</tr>
<tr>
	<td>�ۼ���</td>
	<td>${article.writerName}</td>
</tr>
<tr>
	<td>�ۼ���</td>
	<td><fmt:formatDate value="${article.postingDate}" 
		pattern="yyyy-MM-dd" /></td>
</tr>
<tr>
	<td>����</td>
	<td>
		<pre><c:out value="${article.content}" /></pre>
	</td>
</tr>
<tr>
	<td colspan="2">
	<a href="list?p=${param.p}">��Ϻ���</a>
	<a href="reply_form.jsp?parentId=${article.id}&p=${param.p}">�亯����</a>
	<a href="update_form.jsp?articleId=${article.id}&p=${param.p}">�����ϱ�</a>
	<a href="delete_form.jsp?articleId=${article.id}">�����ϱ�</a>
	</td>
</tr>
</table>
</body>
</html>