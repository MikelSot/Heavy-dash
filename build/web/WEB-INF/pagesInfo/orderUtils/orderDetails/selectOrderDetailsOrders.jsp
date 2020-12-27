<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewSelectOrderDetailIdOrders" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Datos del Pedido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table class="table display nowrap table-hover" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">Pedido_Id</th>
                                <th>Estado</th>
                                <th>Fecha_Pedido</th>                                
                                <th>Fecha_Envio</th>
                                <th>Direccion_Envio</th>
                                <th>Dni</th>
                                <th>Apellido</th>
                                <th>Tipo_de_direccion</th>
                                <th>Distrito</th>
                                <th>Distrito_Id</th>
                                <th>Empleado_Id</th>
                                <th>Empresa_Envio_Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- mostramos la lista usuarios inactivos-->
                            <tr>
                                <th>${selectOrderDetailIdOrders.orderId}</th>
                                <td>${selectOrderDetailIdOrders.states}</td>
                                <td>${selectOrderDetailIdOrders.orderDate}</td>                                    
                                <td>${selectOrderDetailIdOrders.shippingDate}</td>
                                <td>${selectOrderDetailIdOrders.orderAdderss}</td>
                                <td>${selectOrderDetailIdOrders.dni}</td>
                                <td>${selectOrderDetailIdOrders.lastName}</td>
                                <td>${selectOrderDetailIdOrders.typeAddress}</td>
                                <td>${selectOrderDetailIdOrders.district}</td>
                                <td>${selectOrderDetailIdOrders.districtId}</td>
                                <td>${selectOrderDetailIdOrders.employeeId}</td>
                                <td>${selectOrderDetailIdOrders.shippingComanyId}</td>
                            </tr>
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