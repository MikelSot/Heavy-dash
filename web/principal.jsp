<!DOCTYPE html>
<html lang="es">
    <head>

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp"/>
        <title>Heavy</title>
    </head>
    <body class="scroll sidebar-toggled">


        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- nav-->
            <jsp:include page="/WEB-INF/pagesInfo/indexUtils/nav.jsp" />            

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column menu-collapsed">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->                    
                    <jsp:include page="/WEB-INF/pagesInfo/indexUtils/topbar.jsp" />



                    <!-- EN ESTE DIV VA EL CONTENIDO PAPU -->
                    <div class="container-fluid">
                        
                        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/cardsInicio.jsp" />
                        
                        
                        
                    </div>






                </div>
   

                
                
                <!-- Footer  QUEDA -->                
                <jsp:include page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp" />

            </div>

        </div>
                                             
                <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp"/>

    </body>
</html>