
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Pedidos | Editar</title>
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
                        <!-- Cards de pedido -->
                        <jsp:include page="/WEB-INF/pagesInfo/orderUtils/cardOrder.jsp" />


                        <form action="${pageContext.request.contextPath}/OrderServlet?action=update&orderId=${order.orderId}"  method="POST">


                            <section class="container" >
                                <div>

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Pedido</h4>
                                                </div>
                                                <div class="modal-body">

                                                    <div class="form-row">                                                
                                                        <div div class="col-md mb-3">
                                                            <label for="name">Nombre Cliente</label>
                                                            <input type="text" class="form-control" name="name" maxlength="100" required value="${order.name}">
                                                        </div>

                                                        <div div class="col-md mb-3">
                                                            <label for="lastName">Apellido</label>
                                                            <input type="text" class="form-control"  name="lastName" required value="${order.lastName}">
                                                        </div>

                                                        <div class="col-md mb-3">
                                                            <label for="dni">Dni</label>
                                                            <input type="text" class="form-control" name="dni" pattern="[0-9]+" maxlength="8" required value="${order.dni}">        
                                                        </div>

                                                    </div>

                                                    <div class="form-row">

                                                        <div class="col-md-3 mb-3">
                                                            <label for="orderDate">Fecha Pedido</label>
                                                            <input type="date" class="form-control" name="orderDate" required value="${order.orderDate}">
                                                        </div>

                                                        <div class="col-md-3 mb-3">
                                                            <label for="shippingDate">Fecha Envio</label>
                                                            <input type="date" class="form-control" name="shippingDate" required value="${order.shippingDate}">                     
                                                        </div>

                                                        <div class="col-md mb-3">
                                                            <label for="orderAdderss">Direccion</label>
                                                            <input type="text" class="form-control" name="orderAdderss"  required value="${order.orderAdderss}">                     
                                                        </div>

                                                    </div>

                                                    <div class="form-row">
                                                        <div class="col-md mb-4">
                                                            <label for="reference">Referencia(opcional)</label>
                                                            <input type="text" class="form-control" name="reference" value="${order.reference}" >        
                                                        </div>


                                                        <div div class="col-md mb-4">
                                                            <label for="lot">Lote</label>
                                                            <input type="number" class="form-control" name="lot" min="1" required value="${order.lot}">
                                                        </div>

                                                        <div class="col-md mb-4">
                                                            <label for="states">Estado</label>
                                                            <input type="number" class="form-control" name="states" min="0" max="1" required value="${order.states}">        
                                                        </div>

                                                        <div class="col-md mb-4">
                                                            <label for="typeAddress">Tipo de direccion Id</label>
                                                            <input type="number" class="form-control" name="typeAddress" min="1" max="10" required value="${order.typeAddress}">        
                                                        </div>

                                                    </div>

                                                    <div class="form-row">

                                                        <div class="col-md mb-4">
                                                            <label for="districtId">Distrito Id</label>
                                                            <input type="number" class="form-control" name="districtId"  min="1" max="165" required value="${order.districtId}">                     
                                                        </div>
                                                        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>                  

                                                        <div class="col-md mb-4">
                                                            <label for="employeeId">Empleado Id</label>
                                                            <input type="list" list="list-employeeId" class="form-control" min="1" name="employeeId" value="${order.employeeId}">
                                                            <datalist id="list-employeeId">
                                                                <c:forEach var="employee" items="${employeesId}">
                                                                    <option value="${employee.employeeId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>

                                                        <div class="col-md mb-4">                 
                                                            <label for="shippingComanyId">Empresa Envio Id</label>
                                                            <input type="list" list="list-shippingComanyId" class="form-control" min="1" name="shippingComanyId" value="${order.shippingComanyId}">
                                                            <datalist id="list-shippingComanyId">
                                                                <c:forEach var="shippingComany" items="${shippingCompanysId}">
                                                                    <option value="${shippingComany.shippingCompanyId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>

                                                        <div class="col mb-4">
                                                            <label for="userId">Usuario Id</label>
                                                            <input type="list" list="list-userId" class="form-control" min="1" name="userId" value="${order.userId}" required>
                                                            <datalist id="list-userId">
                                                                <c:forEach var="userId" items="${userIds}">
                                                                    <option value="${userId.userId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/orderUtils/buttonDeleteUpdate.jsp" />
                                </div>
                            </section>
                        </form>
                    </div>
                </div>
                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
                <!-- datos del usuario-->
                <jsp:include  page="/WEB-INF/pagesInfo/orderUtils/viewSelectOrdersUser.jsp"/>
                <!-- datos de la empresa o empleado que realizo o va realizar el envio-->
                <jsp:include  page="/WEB-INF/pagesInfo/orderUtils/viewSelectOrdersShipping.jsp"/>
                
           
            </div>
        </div>
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>

    </body>
</html>
