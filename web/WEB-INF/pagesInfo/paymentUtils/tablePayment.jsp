<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> 
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            Tabla de  Pago
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table display nowrap table-hover" style="width:100%">
                <thead class="table-dark">
                    <tr>
                        <th scope="col" class="table-bordered">#</th>
                        <th scope="col">id</th>
                        <th>Fecha de Pago</th>                            
                        <th>Usuario Id</th>
                        <th>Detalle Pedido Id</th>
                        <th>Factura Id</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="payment" items="${payments}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${payment.paymentId}</th>
                            <td>${payment.paymentDate}</td>
                            <td>${payment.userId}</td>
                            <td>${payment.orderDetailId}</td>
                            <td>${payment.invoiceId}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/PaymentServlet?action=edit&paymentId=${payment.paymentId}&invoiceId=0${payment.invoiceId}&orderDetailId=${payment.orderDetailId}&userId=${payment.userId}"
                                   class="btn btn-danger">
                                    <i class="fas fa-angle-double-right"></i>
                                    <span>Editar</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>


<!-- ventana modal de agregar pago -->
<jsp:include page="/WEB-INF/pagesInfo/paymentUtils/addPaymentForm.jsp" />
<!-- ventana modal de confimacion -->
<jsp:include page="/WEB-INF/pagesInfo/paymentUtils/modalConfirm.jsp" />
<!-- ventana modal, tabla de factura -->
<jsp:include page="/WEB-INF/pagesInfo/paymentUtils/invoiceTable.jsp" />




