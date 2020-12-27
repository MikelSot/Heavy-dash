<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="viewSelectOrderPaymentID" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Datos del Pedido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body ">
                <div class="table-responsive">
                    <table  class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th>Pago_Id</th>
                                <th>Pedido_Id</th>
                                <th>Estado</th>                                
                                <th>Fecha_Pedido</th>
                                <th>Fecha_Envio</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Dni</th>
                                <th>Tipo_de_direccion_Id</th>
                                <th>Distrito_Id</th>
                                <th>Empleado_Id</th>
                                <th>Empresa_envio_Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <th>${selectOrderPaymentID.paymentId}</th>
                            <td>${selectOrderPaymentID.orderId}</td>
                            <td>${selectOrderPaymentID.states}</td>                                    
                            <td>${selectOrderPaymentID.orderDate}</td>
                            <td>${selectOrderPaymentID.shippingDate}</td>
                            <td>${selectOrderPaymentID.name}</td>
                            <td>${selectOrderPaymentID.lastName}</td>
                            <td>${selectOrderPaymentID.dni}</td>
                            <td>${selectOrderPaymentID.typeAddress}</td>
                            <td>${selectOrderPaymentID.districtId}</td>
                            <td>${selectOrderPaymentID.employeeId}</td>
                            <td>${selectOrderPaymentID.shippingComanyId}</td>
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