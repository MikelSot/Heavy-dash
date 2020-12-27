<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewSelectUserPayment" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Pagos realizados por el usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee3" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pago Id</th>
                                <th>Fecha Pago</th>
                                <th>Usuario Id</th>                                
                                <th>Detalle Pedido Id</th>
                                <th>Factura Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- mostramos la lista usuarios inactivos-->
                            <c:forEach var="selectUserPayment" items="${selectUserPayment}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectUserPayment.paymentId}</th>
                                    <td>${selectUserPayment.paymentDate}</td>
                                    <td>${selectUserPayment.userId}</td>                                    
                                    <td>${selectUserPayment.orderDetailId}</td>
                                    <td>${selectUserPayment.invoiceId}</td>
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