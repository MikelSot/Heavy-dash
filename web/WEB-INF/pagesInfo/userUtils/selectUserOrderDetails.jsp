<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewSelectUserOrderDetails" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Detalle los pedidos</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee4" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Detalle Pedido Id</th>
                                <th>Pedido Id</th>
                                <th>Producto Id</th>                                
                                <th>Producto</th>
                                <th>Cantidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- mostramos la lista usuarios inactivos-->
                            <c:forEach var="selectUserOrderDetail" items="${selectUserOrderDetails}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectUserOrderDetail.orderDetailId}</th>
                                    <td>${selectUserOrderDetail.orderId}</td>
                                    <td>${selectUserOrderDetail.productId}</td>                                    
                                    <td>${selectUserOrderDetail.product}</td>
                                    <td>${selectUserOrderDetail.quantity}</td>
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