<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><tiles:getAsString name="title" /></title>
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