<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> 
<div class="modal fade" id="viewSelectUserPayments" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold " id="exampleModalLabel">Otras compras realizados por el usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="example" class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pago Id</th>
                                <th>Usuario Id</th>
                                <th>Nombre</th>                                
                                <th>Factura Id</th>
                                <th>Pedido Id</th>
                                <th>Fecha Pedido</th>
                                <th>Detalle Pedido Id</th>
                                <th>Cantidad</th>
                                <th>Producto Id</th>
                                <th>Producto</th>
                                <th>Precio Unitario</th>
                                <th>Stock</th>
                                <th>Monto</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="selectUserPayments" items="${selectUserPayments}" varStatus="statusNumber">

                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectUserPayments.paymentId}</th>
                                    <td>${selectUserPayments.userId}</td>
                                    <td>${selectUserPayments.userName}</td>
                                    <td>${selectUserPayments.invoiceId}</td>
                                    <td>${selectUserPayments.orderId}</td>
                                    <td>${selectUserPayments.orderDate}</td>
                                    <td>${selectUserPayments.orderDetailId}</td>
                                    <td>${selectUserPayments.quantity}</td>
                                    <td>${selectUserPayments.productId}</td>
                                    <td>${selectUserPayments.nameProduct}</td>
                                    <td><format:formatNumber value="${selectUserPayments.unitPrice}" type="currency"/></td>
                                    <td>${selectUserPayments.stock}</td>                                    
                                    <td><format:formatNumber value="${selectUserPayments.monto}" type="currency"/></td>
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
