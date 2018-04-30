<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><tiles:getAsString name="title" /></title>
        <script type="text/javascript" src="<spring:url value="/js/jquery.min.js"/>"></script>
        <script type="text/javascript" src="<spring:url value="/js/bootstrap.min.js"/>"></script>
        <link rel="stylesheet" type="text/css" href="<spring:url value="/css/bootstrap.css"/>"/>

        <link href="https://fonts.googleapis.com/css?family=EB+Garamond|Gaegu|Jua|Gamja+Flower" rel="stylesheet">
    </head>
    <body>
        <div>
            <tiles:insertAttribute name="header" />
            <main class="container">
                <tiles:insertAttribute name="top" />
                <div class="row" style="font-family: 'EB Garamond', serif;">
                    <div class="col-sm-3 col-md-3 col-xl-2" style="font-family: 'Jua', sans-serif;">
                        <tiles:insertAttribute name="side" />
                    </div>
                    <div class="col-sm-9 col-md-9 col-xl-10">
                        <tiles:insertAttribute name="body" />
                    </div>
                </div>
            </main>
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>