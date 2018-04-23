<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><tiles:getAsString name="title" /></title>
        <script type="text/javascript" src="<spring:url value="/js/someSimpleAppBase.min.js"/>"></script>
        </link>
    </head>
    <body>
        <div>
            <tiles:insertAttribute name="header" />
            <div>
                <tiles:insertAttribute name="body" />
            </div>
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>