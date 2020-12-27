
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Pedidos Proveedor | Editar</title>
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
                        <jsp:include page="/WEB-INF/pagesInfo/supplierUtils/orderSupplierUtils/cardOrderSupplier.jsp" />


                        <form action="${pageContext.request.contextPath}/OrderSupplierServlet?action=update&orderSupplierId=${orderSupplier.orderSupplierId}"  method="POST">


                            <section class="container" >
                                <div>

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Pedido Proveedor</h4>
                                                </div>
                                                <div class="modal-body">

                                                    <div class="form-row">
                                                        <div class="col-md-6 mb-3">
                                                            <label for="orderName">Nombre Producto</label>
                                                            <input type="text" class="form-control" name="orderName" maxlength="130" required value="${orderSupplier.orderName}">
                                                        </div>

                                                        <div class="col-md mb-3">
                                                            <label for="unitPrice">Precio Unitario</label>
                                                            <input type="number" class="form-control" name="unitPrice" min="0" required step="any" value="${orderSupplier.unitPrice}">
                                                        </div>    

                                                        <div class="col-md mb-3">
                                                            <label for="quantity">Cantidad</label>
                                                            <input type="number" class="form-control" name="quantity" min="1" required value="${orderSupplier.quantity}">
                                                        </div>    

                                                    </div>

                                                    <div class="form-row">

                                                        <div class="col-md">
                                                            <label for="orderDescription">Descripcion</label>
                                                            <input type="text" class="form-control" name="orderDescription" value="${orderSupplier.orderDescription}">        
                                                        </div>                           
                                                    </div>

                                                    <div class="form-row">                                                
                                                        <div class="col-md mb-3">
                                                            <label for="states">Estado</label>
                                                            <input type="number" class="form-control" name="states" min="1" max="3" required value="${orderSupplier.states}">        
                                                        </div>                                                            

                                                        <div class="col-md mb-3">
                                                            <label for="orderDate">Fecha Pedido</label>
                                                            <input type="date" class="form-control" name="orderDate" value="${orderSupplier.orderDate}" required>        
                                                        </div> 

                                                        <div class="col-md mb-3">
                                                            <label for="shippedDate">Fecha de envio</label>
                                                            <input type="date" class="form-control" name="shippedDate" required value="${orderSupplier.shippedDate}">        
                                                        </div>                       
                                                    </div>

                                                    <div class="form-row">                                                
                                                        <div class="col-md mb-3">
                                                            <label for="shippingCompany">Empresa de envio</label>
                                                            <input type="text" class="form-control" name="shippingCompany" value="${orderSupplier.shippingCompany}">        
                                                        </div>                                                            

                                                        <div class="col-md mb-3">
                                                            <label for="priceShipping">Precio de Envio</label>
                                                            <input type="number" class="form-control" name="priceShipping" min="0" step="any" required value="${orderSupplier.priceShipping}">        
                                                        </div> 

                                                        <div class="col-md mb-3">
                                                            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                                            <label for="supplierId">Proveedor Id</label>
                                                            <input type="list" list="list-supplierId" class="form-control" min="1" name="supplierId" required value="${orderSupplier.supplierId}">
                                                            <datalist id="list-supplierId">
                                                                <c:forEach var="supplier" items="${suppliersId}">
                                                                    <option value="${supplier.supplierId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>                       
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/supplierUtils/orderSupplierUtils/buttonDeleteUpdate.jsp" />


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
