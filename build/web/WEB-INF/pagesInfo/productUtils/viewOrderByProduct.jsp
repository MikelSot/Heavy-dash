<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewOrderByProductt" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Cantidad de Pedidos por producto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="example" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pedido Id</th>
                                <th>Estado</th>
                                <th>Fecha Pedido</th>                                
                                <th>Cantidad</th>
                                <th>Usuario Id</th>
                                <th>Distrito Id</th>
                                <th>Empleado Id</th>
                                <th>Empresa Envio Id</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="ordersByProduct" items="${ordersByProduct}" varStatus="statusNumber">

                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${ordersByProduct.orderId}</th>
                                    <td>${ordersByProduct.states}</td>
                                    <td>${ordersByProduct.orderDate}</td>                                    
                                    <td>${ordersByProduct.quantity}</td>
                                    <td>${ordersByProduct.userId}</td>
                                    <td>${ordersByProduct.districtId}</td>
                                    <td>${ordersByProduct.employeeId}</td>
                                    <td>${ordersByProduct.shippingComanyId}</td>
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