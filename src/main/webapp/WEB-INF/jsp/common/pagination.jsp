<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel-footer" style="padding: 0px;">
    <c:choose>
        <c:when test="${result.rows != null}">
            <nav style="text-align: center">
                <ul class="pagination">
                    <li><a href="#" onclick="doQueryByCondition('${result.currentPageNo - 1}')">&laquo;上一页</a></li>
                    <c:choose>
                        <c:when test="${(result.size < result.total || result.size == result.total) && (result.size % result.total  == 0)}">
                            <c:forEach begin="1" end="${result.total / result.size}" var="pageNo">
                                <li><a href="#" onclick="doQueryByCondition('${pageNo}')">${pageNo}</a></li>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach begin="1" end="${result.total / result.size + 1}" var="pageNo">
                                <li><a href="#" onclick="doQueryByCondition('${pageNo}')">${pageNo}</a></li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <li><a href="#" onclick="doQueryByCondition('${result.currentPageNo + 1}')">下一页&raquo;</a></li>
                </ul>
            </nav>
        </c:when>
        <c:otherwise>暂无记录</c:otherwise>
    </c:choose>
</div>
<script>
    var currentPageNo = '${result.currentPageNo}';
    var total = '${result.total}';
    var size = '${result.size}';
    if(currentPageNo == 1){
        $(".pagination li:first-child").addClass("disabled");
        $(".pagination li:first-child a").removeAttr("onclick");
    }
    var totalPageNo = parseInt(total/size) + 1;
    if((parseInt(total) > parseInt(size) || total == size) && (parseInt(size % total) == 0)){
        totalPageNo = parseInt(total/size);
    }
    if(currentPageNo == totalPageNo){
        $(".pagination li:last-child").addClass("disabled");
        $(".pagination li:last-child a").removeAttr("onclick");
    }
    var liNo = parseInt(currentPageNo)+1;
    $("nav li:nth-child("+liNo+")").addClass("active");
</script>