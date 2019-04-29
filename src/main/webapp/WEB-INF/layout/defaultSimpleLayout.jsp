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

        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-64409105-2"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag(){dataLayer.push(arguments);}
            gtag('js', new Date());

            gtag('config', 'UA-64409105-2');
        </script>

    </head>
    <body>
        <div>
            <tiles:insertAttribute name="header" />
            <main class="container">
                <div class="row" style="font-family: 'EB Garamond', serif;">
                    <div class="col-sm-12 col-md-12 col-xl-12">
                        <tiles:insertAttribute name="body" />
                    </div>
                </div>
            </main>
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>