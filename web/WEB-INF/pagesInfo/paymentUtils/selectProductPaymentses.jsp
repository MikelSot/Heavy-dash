<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> 
<div class="modal fade" id="viewSelectInvoicesPaymentses" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold " id="exampleModalLabel">Otras Compras que se realizaron con la Factura</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee5" class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pago Id</th>
                                <th>Factura Id</th>
                                <th>Usuario Id</th>                                
                                <th>Nombre</th>
                                <th>Detalle Pedido Id</th>
                                <th>Cantidad</th>
                                <th>Pedido Id</th>
                                <th>Producto Id</th>
                                <th>Producto</th>
                                <th>Precio Unitario</th>
                                <th>Stock</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="selectInvoicesPayments" items="${selectInvoicesPaymentses}" varStatus="statusNumber">

                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectInvoicesPayments.paymentId}</th>
                                    <td>${selectInvoicesPayments.invoiceId}</td>
                                    <td>${selectInvoicesPayments.userId}</td>                                    
                                    <td>${selectInvoicesPayments.userName}</td>
                                    <td>${selectInvoicesPayments.orderDetailId}</td>
                                    <td>${selectInvoicesPayments.quantity}</td>
                                    <td>${selectInvoicesPayments.orderId}</td>
                                    <td>${selectInvoicesPayments.productId}</td>
                                    <td>${selectInvoicesPayments.nameProduct}</td>
                                    <td><format:formatNumber value="${selectInvoicesPayments.unitPrice}" type="currency"/></td>
                                    <td>${selectInvoicesPayments.stock}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>         
