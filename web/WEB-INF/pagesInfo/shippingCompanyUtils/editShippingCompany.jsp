
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Empresa Envio | Editar</title>
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

                    <div class="container-fluid">
                        <!-- Card de provedor -->
                        <jsp:include page="/WEB-INF/pagesInfo/shippingCompanyUtils/cardShippingCompany.jsp" />


                        <form action="${pageContext.request.contextPath}/ShippingCompanyServlet?action=update&shippingCompanyId=${shippingCompany.shippingCompanyId}"  method="POST">


                            <section class="container" >
                                <div>

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Proveedor</h4>
                                                </div>
                                                <div class="modal-body">

                                                    <div class="form-row">
                                                        <div class="col-md-8 mb-2">
                                                            <label for="companyName">Nombre Empresa</label>
                                                            <input type="text" class="form-control" name="companyName" maxlength="120" value="${shippingCompany.companyName}" required>
                                                        </div>

                                                        <div class="col-md mb-2">
                                                            <label for="contactName">Representante</label>
                                                            <input type="text" class="form-control" name="contactName" required value="${shippingCompany.contactName}">
                                                        </div>    

                                                    </div>

                                                    <div class="form-row">

                                                        <div class="col-md-6 mb-2">
                                                            <label for="email">Email</label>
                                                            <input type="email" class="form-control" name="email" required value="${shippingCompany.email}">        
                                                        </div>    

                                                        <div class="col-md mb-2">
                                                            <label for="companyAddres">Direccion</label>
                                                            <input type="text" class="form-control" name="companyAddres" required value="${shippingCompany.companyAddres}">        
                                                        </div>                                                                

                                                    </div>

                                                    <div class="form-row">                                                
                                                        <div class="col-md mb-2">
                                                            <label for="postalCode">Codigo Postal</label>
                                                            <input type="text" class="form-control" name="postalCode" maxlength="5" required value="${shippingCompany.postalCode}">        
                                                        </div>                                                            

                                                        <div class="col-md mb-2">
                                                            <label for="active">Estado</label>
                                                            <input type="number" class="form-control" name="active" min="0" max="1" value="${shippingCompany.active}">        
                                                        </div>                        
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/shippingCompanyUtils/buttonDeleteUpdate.jsp" />


                                </div>
                            </section>



                        </form>




                    </div>




                </div>

                <!-- agencias de cada empresa-->
                <jsp:include page="/WEB-INF/pagesInfo/shippingCompanyUtils/agencyUtils/tableAgency.jsp"/>
                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
            </div>

        </div>



        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>

    </body>
</html>
