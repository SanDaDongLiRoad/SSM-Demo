<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%
        String path = request.getContextPath();
	    request.setAttribute("basePath", path);
    %>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript">
    //Generate four random hex digits.
    function S4(){
        return (((1 + Math.random ()) * 0x10000) | 0).toString (16).substring (1);
    };
    //Generate a pseudo-GUID by concatenating random hexadecimal.
    function guid(){
        return (S4 () + S4 () + "-" + S4 () + "-" + S4 () + "-" + S4 () + "-" + S4 () + S4 () + S4 ());
    };

    function guid2(){
        return (S4 () + S4 () + "" + S4 () + "" + S4 () + "" + S4 () + "" + S4 () + S4 () + S4 ());
    }
    window.location.href = "index";
</script>
</html>