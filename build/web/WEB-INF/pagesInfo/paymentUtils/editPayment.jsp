
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Pedidos Proveedor | Editar</title>
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headTable.jsp" />

    </head>
    <body class="scroll">
        <!-- Page Wrapper -->
        <div id="wrapper sidebar-toggled">

            <!-- NAV -->

            <jsp:include page="/WEB-INF/pagesInfo/indexUtils/nav.jsp" />


            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column menu-collapsed">

                <div id="content">

                    <!-- barra top -->
                    <jsp:include page="/WEB-INF/pagesInfo/indexUtils/topbar.jsp" />

                    <div class="container-fluid">
                        <!-- Card de provedor -->
                        <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/cardPayment.jsp" />


                        <form action="${pageContext.request.contextPath}/PaymentServlet?action=update&paymentId=${payment.paymentId}"  method="POST">


                            <section class="container" >
                                <div>

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Pago</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="form-row">
                                                        <div class="col-md">
                                                            <label for="paymentDate">Fecha de Pago</label>
                                                            <input type="date" class="form-control" name="paymentDate" value="${payment.paymentDate}" required>
                                                        </div>
                                                        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                                                        <div class="col-md">
                                                            <label for="userId">Usuario Id</label>
                                                            <input type="list" list="list-userId" class="form-control" min="1" name="userId" required value="${payment.userId}" >
                                                            <datalist id="list-userId">
                                                                <c:forEach var="user" items="${usersId}">
                                                                    <option value="${user.userId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>                              

                                                    </div>


                                                    <div class="form-row">                                                
                                                        <div class="col-md">
                                                            <label for="orderDetailId">Detalle Pedido Id</label>
                                                            <input type="list" list="list-orderDetailId" class="form-control" min="1" name="orderDetailId" required value="${payment.orderDetailId}">
                                                            <datalist id="list-orderDetailId">
                                                                <c:forEach var="orderDetailId" items="${orderDetailsId}">
                                                                    <option value="${orderDetailId.orderDetailId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>                                                            

                                                        <div class="col-md">
                                                            <label for="invoiceId">Factura Id</label>
                                                            <input type="list" list="list-invoiceId" class="form-control" min="1" name="invoiceId" value="${payment.invoiceId}">
                                                            <datalist id="list-invoiceId">
                                                                <c:forEach var="invoicesId" items="${invoicesId}">
                                                                    <option value="${invoicesId.invoiceId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div> 

                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/buttonDeleteUpdate.jsp" />

                                </div>
                            </section>

                        </form>

                    </div>

                </div>
                <!-- pie de pagin-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>

            </div>

        </div>

        <!-- modal factura Id y tabla factura-->
        <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/invoiceById.jsp" />
        <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/invoiceTable.jsp" />
        <!-- modal info pedido-->
        <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/viewSelectOrderPaymentID.jsp" />
        <!-- modal info producto-->
        <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/viewSelectOrderDetailsProductoPaymentID.jsp" />
        <!-- modal info usuario-->
        <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/viewSelectPaymentUserByID.jsp" />
        <!-- modal info otras boletas generadas por mismo usuario-->
        <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/selectUserPayments.jsp" />
       <!-- modal info otras boletas que tengan en comun el producto-->
       <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/selectProductPaymentses.jsp" />
       <!-- modal info otras boletas que genero la factura-->
       <jsp:include page="/WEB-INF/pagesInfo/paymentUtils/selectInvoicesPaymentses.jsp" />

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>

    </body>
</html>
