<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel-footer">
    <c:choose>
        <c:when test="${result.rows.length > 0}">
            <nav style="text-align: center">
                <ul class="pagination">
                    <li><a href="/admin/showStudent?page=${result.currentPageNo - 1}">&laquo;上一页</a></li>
                    <c:forEach begin="1" end="6" var="pageNo">
                        <li><a href="/user/queryList/?page=${i}">${i}</a></li>
                    </c:forEach>
                    <li><a href="/admin/showStudent?page=${result.currentPageNo + 1}">下一页&raquo;</a></li>
                </ul>
            </nav>
        </c:when>
        <c:otherwise>暂无记录</c:otherwise>
    </c:choose>
</div>
