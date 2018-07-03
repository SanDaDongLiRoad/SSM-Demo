<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel-footer">
    <c:choose>
        <c:when test="${result.rows != null}">
            <nav style="text-align: center">
                <ul class="pagination">
                    <li><a href="${basePath}/user/queryUserListByPageNo?pageNo=${result.currentPageNo - 1}">&laquo;上一页</a></li>
                        <c:forEach begin="1" end="${result.total / result.size + 1}" var="pageNo">
                            <li><a href="${basePath}/user/queryUserListByPageNo?pageNo=${pageNo}">${pageNo}</a></li>
                        </c:forEach>
                    <li><a href="${basePath}/user/queryUserListByPageNo?pageNo=${result.currentPageNo + 1}">下一页&raquo;</a></li>
                </ul>
            </nav>
        </c:when>
        <c:otherwise>暂无记录</c:otherwise>
    </c:choose>
</div>
