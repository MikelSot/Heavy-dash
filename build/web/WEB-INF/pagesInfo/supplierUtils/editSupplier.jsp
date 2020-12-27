
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Proveedor | Editar</title>
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
                        <jsp:include page="/WEB-INF/pagesInfo/supplierUtils/cardSupplier.jsp" />


                        <form action="${pageContext.request.contextPath}/SupplierServlet?action=update&supplierId=${supplier.supplierId}"  method="POST">


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
                                                            <label for="nameCompany">Nombre Empresa</label>
                                                            <input type="text" class="form-control" name="nameCompany" maxlength="120" value="${supplier.nameCompany}" required>
                                                        </div>

                                                        <div class="col-md mb-2">
                                                            <label for="contanctName">Representante</label>
                                                            <input type="text" class="form-control" name="contanctName" value="${supplier.contanctName}" required>
                                                        </div>    

                                                    </div>

                                                    <div class="form-row">

                                                        <div class="col-md mb-3">
                                                            <label for="email">Email</label>
                                                            <input type="email" class="form-control" name="email" required value="${supplier.email}">        
                                                        </div>    

                                                        <div class="col-md mb-3">
                                                            <label for="supplierAddress">Direccion</label>
                                                            <input type="text" class="form-control" name="supplierAddress" required value="${supplier.supplierAddress}" >        
                                                        </div>                                                                

                                                        <div class="col-md mb-3">
                                                            <label for="typeGoods">Tipo de bienes</label>
                                                            <input type="text" class="form-control" name="typeGoods" required value="${supplier.typeGoods}" >        
                                                        </div> 
                                                    </div>

                                                    <div class="form-row">                                                
                                                        <div class="col-md mb-4">
                                                            <label for="postalCode">Codigo Postal</label>
                                                            <input type="text" class="form-control" name="postalCode" maxlength="5" required value="${supplier.postalCode}" >        
                                                        </div>                                                            

                                                        <div class="col-md mb-4">
                                                            <label for="city">Ciudad</label>
                                                            <input type="text" class="form-control" name="city" value="${supplier.city}">        
                                                        </div> 

                                                        <div class="col-md mb-4">
                                                            <label for="country">País</label>
                                                            <input type="text" class="form-control" name="country" required value="${supplier.country}">        
                                                        </div> 

                                                        <div class="col-md mb-4">
                                                            <label for="states">Estado</label>
                                                            <input type="number" class="form-control" name="states" min="0" max="1" required value="${supplier.states}">        
                                                        </div> 
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/supplierUtils/buttonDeleteUpdate.jsp" />


                                </div>
                            </section>



                        </form>




                    </div>




                </div>



                <!-- pie de pagin-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
            </div>

        </div>



        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>

    </body>
</html>
