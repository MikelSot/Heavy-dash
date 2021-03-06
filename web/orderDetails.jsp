<!DOCTYPE html>
<html lang="es">
    <head>

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy |Detalle Pedido</title>
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headTable.jsp" />


    </head>
    <body class="scroll sidebar-toggled">


        <!-- Page Wrapper -->
        <div id="wrapper">
            <!-- NAV -->

            <jsp:include page="/WEB-INF/pagesInfo/indexUtils/nav.jsp" />

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column menu-collapsed">

                <div id="content">

                    <!-- barra top -->
                    <jsp:include page="/WEB-INF/pagesInfo/indexUtils/topbar.jsp" />


                    <!-- contenido-->
                    <div class="container-fluid">
                        <!-- Cards de empleado -->
                        <jsp:include page="/WEB-INF/pagesInfo/orderUtils/orderDetails/cardsOrderDetails.jsp" />
                        <!-- Modal ver envios realizados por los empleados -->
                        <%--  <jsp:include page="/WEB-INF/pagesInfo/employeesInfo/viewShipping.jsp" /> --%>
                        <!-- tabla detalle pedido-->
                        <jsp:include  page="/WEB-INF/pagesInfo/orderUtils/orderDetails/tableOrderDetails.jsp"/>

                    </div>

                </div>
                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/orderUtils/orderDetails/selectOrderDetailsProductAndOrders.jsp"/>

            </div>
        </div>

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>

    </body>
</html>