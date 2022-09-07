<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>${page_title}</title>
</head>
<body>
    <div class="container">
        <div class="header">
<%--            <jsp:include page="${page_header}"/>--%>
        </div>
        <div class="content">
<%--            <div class="main-top"><jsp:include page="${main_top}"/></div>--%>
<%--            <div class="main-bot"><jsp:include page="${main_bot}"/></div>--%>
<%--            <div class="main-left"><jsp:include page="${main_left}"/></div>--%>
<%--            <div class="main-right"><jsp:include page="${main_right}"/></div>--%>
            <div class="main-content">
                <jsp:include page="${main_content}"/>
            </div>
        </div>
        <div class="footer">
<%--            <jsp:include page="${page_footer}"/>--%>
        </div>
        <div class="static">
<%--            <jsp:include page="${page_static}"/>--%>
        </div>
    </div>
</body>
</html>