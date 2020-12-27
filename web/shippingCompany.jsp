<!DOCTYPE html>
<html lang="es">
    <head>

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | empleados</title>
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
                        <jsp:include page="/WEB-INF/pagesInfo/shippingCompanyUtils/cardsShippingCompany.jsp" />
                        <!-- Modal agencias -->
                        <jsp:include page="/WEB-INF/pagesInfo/shippingCompanyUtils/agencyUtils/tableAgency.jsp" />
                        <!-- tabla de empresas de envio-->
                        <jsp:include  page="/WEB-INF/pagesInfo/shippingCompanyUtils/tableShippingComapny.jsp"/>

                    </div>

                </div>

                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
                <!-- modal envio que realizo o va realizar la empresa -->
                <jsp:include  page="/WEB-INF/pagesInfo/shippingCompanyUtils/vwShippingCompanyOrders.jsp"/>

            </div>

        </div>

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>
    </body>
</html>