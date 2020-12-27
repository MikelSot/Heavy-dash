<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewSelectUserOrders" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Pedidos resalizados por el usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee2" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pedido Id</th>
                                <th>Estado</th>
                                <th>Fecha Pedido</th>                                
                                <th>Fecha Envio</th>
                                <th>Direccion</th>
                                <th>Dni</th>
                                <th>Apellido</th>
                                <th>Tipo de direccion</th>
                                <th>Distrito</th>
                                <th>Distrito Id</th>
                                <th>Empleado Id</th>
                                <th>Empresa Envio Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- mostramos la lista usuarios inactivos-->
                            <c:forEach var="selectUserOrder" items="${selectUserOrders}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectUserOrder.orderId}</th>
                                    <td>${selectUserOrder.states}</td>
                                    <td>${selectUserOrder.orderDate}</td>                                    
                                    <td>${selectUserOrder.shippingDate}</td>
                                    <td>${selectUserOrder.orderAdderss}</td>
                                    <td>${selectUserOrder.dni}</td>
                                    <td>${selectUserOrder.lastName}</td>
                                    <td>${selectUserOrder.typeAddress}</td>
                                    <td>${selectUserOrder.district}</td>
                                    <td>${selectUserOrder.districtId}</td>
                                    <td>${selectUserOrder.employeeId}</td>
                                    <td>${selectUserOrder.shippingComanyId}</td>
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