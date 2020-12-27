
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Product | Editar</title>
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
                        <!-- Card de empleado -->
                        <jsp:include page="/WEB-INF/pagesInfo/productUtils/cardProducto.jsp" />


                        <form action="${pageContext.request.contextPath}/ProductServlet?action=update&productId=${product.productId}"  method="POST">


                            <section class="container" >
                                <div >

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Producto</h4>
                                                </div>
                                                <div class="modal-body">

                                                    <div class="form-row">
                                                        <div class="col-md-8 mb-2">
                                                            <label for="nameProduct">Nombre de Producto</label>
                                                            <input type="text" class="form-control" name="nameProduct" maxlength="120" value="${product.nameProduct}" required>
                                                        </div>

                                                        <div class="col-md mb-2">
                                                            <label for="sku">SKU</label>
                                                            <input type="text" class="form-control" name="sku"  maxlength="20" value="${product.sku}" required>                     
                                                        </div>

                                                    </div>

                                                    <div class="form-row">
                                                        <div class="col-md-4 mb-3">
                                                            <label for="measure">Medida</label>
                                                            <input type="text" class="form-control" name="measure" value="${product.measure}" maxlength="30">        
                                                        </div>


                                                        <div class="col-md-4 mb-3">
                                                            <label for="states">Estado</label>
                                                            <input type="number" class="form-control" name="states" min="0" max="1" value="${product.states}" required>
                                                        </div>

                                                        <div class="col-md-4 mb-3">
                                                            <label for="unitPrice">Precio Unitario</label>
                                                            <input type="number" class="form-control" name="unitPrice" required min="1" step="any" value="${product.unitPrice}">
                                                        </div>

                                                    </div>
                                                    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                                    <div class="form-row">
                                                        <div class="col-md-4 mb-3">        
                                                            <label for="supplierId">Proveedor Id</label>
                                                            <input type="list" list="list-supplierId" class="form-control" min="1" name="supplierId" value="${product.supplierId}" required>
                                                            <datalist id="list-supplierId">
                                                                <c:forEach var="supplierId" items="${suppliersId}">
                                                                    <option value="${supplierId.supplierId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div> 

                                                        <div class="col-md-4 mb-3">
                                                            <label for="categoryId">Categoria Id</label>
                                                            <input type="list" list="list-categoryId" class="form-control" min="1" name="categoryId" value="${product.categoryId}" required>
                                                            <datalist id="list-categoryId">
                                                                <c:forEach var="categoryId" items="${categorysId}">
                                                                    <option value="${categoryId.categoryId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>     
                                                        <div class="col-md-4 mb-3">
                                                            <label for="stock">Stock</label>
                                                            <input type="number" class="form-control" name="stock" min="0" required value="${product.stock}">                     
                                                        </div>

                                                    </div>               

                                                </div>
                                            </div>
                                        </div>

                                    </div>


                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/productUtils/buttonDeleteUpdate.jsp" />

                                </div>
                            </section>



                        </form>




                    </div>




                </div>


                <jsp:include page="/WEB-INF/pagesInfo/productUtils/viewOrderByProduct.jsp" />  
                <!-- moday que incluye cada producto -->
                <jsp:include page="/WEB-INF/pagesInfo/productUtils/includes.jsp" />  
                <!-- pie de pagin-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>

                <jsp:include page="/WEB-INF/pagesInfo/employeesInfo/viewDistrict.jsp" />  
            </div>

        </div>

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>
    </body>
</html>
