
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
                        <!-- Card detalle  pedido -->
                        <jsp:include page="/WEB-INF/pagesInfo/orderUtils/orderDetails/cardOrderDetail.jsp" />


                        <form action="${pageContext.request.contextPath}/OrderDetailsServlet?action=update&orderDetailId=${orderDetail.orderDetailId}"  method="POST">


                            <section class="container" >
                                <div>

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Detalle Pedido</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                                                    <div class="form-row">                                                
                                                        <div div class="col-md mb-3">
                                                            <label for="orderId">Pedido Id</label>
                                                            <input type="list" list="list-orderId" class="form-control" min="1" name="orderId" required value="${orderDetail.orderId}">
                                                            <datalist id="list-orderId">
                                                                <c:forEach var="order" items="${ordersId}">
                                                                    <option value="${order.orderId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>

                                                        <div div class="col-md mb-3">
                                                            <label for="productId">Producto Id</label>
                                                            <input type="list" list="list-productId" class="form-control" min="1" name="productId" required value="${orderDetail.productId}">
                                                            <datalist id="list-productId">
                                                                <c:forEach var="product" items="${productsId}">
                                                                    <option value="${product.productId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>

                                                        <div class="col-md mb-3">
                                                            <label for="quantity">Cantidad</label>
                                                            <input type="number" class="form-control" name="quantity" min="1"  required value="${orderDetail.quantity}">        
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/orderUtils/orderDetails/buttonDeleteUpdate.jsp" />

                                </div>
                            </section>
                        </form>
                    </div>
                </div>
                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/orderUtils/orderDetails/viewSelectOrderDetailsUser.jsp"/>
                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/orderUtils/orderDetails/selectOrderDetailsOrders.jsp"/>
            </div>
        </div>
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>

    </body>
</html>
