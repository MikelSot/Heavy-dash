<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="vwOrderShippings" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos de las Empresas</h5>
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
                                <th scope="col">Pedido Id</th>
                                <th>Estado</th>
                                <th>Empresa Envio Id</th>                                
                                <th>Empresa</th>
                                <th>Representante</th>
                                <th>Email</th>
                                <th>Estado Empresa</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="vwOrderShipping" items="${vwOrderShippings}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${vwOrderShipping.orderId}</th>
                                    <td>${vwOrderShipping.states}</td>
                                    <td>${vwOrderShipping.shippingComanyId }</td>                                    
                                    <td>${vwOrderShipping.companyName}</td>
                                    <td>${vwOrderShipping.contactName}</td>
                                    <td>${vwOrderShipping.email}</td>
                                    <td>${vwOrderShipping.active}</td>
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




<div class="modal fade" id="vwOrderEmployees" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos de los Empleados</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee5" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pedido Id</th>
                                <th>Estado</th>
                                <th>Empleado Id</th>
                                <th>Apellido</th>                                
                                <th>Email</th>
                                <th>Posición</th>
                                <th>Jefe</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="vwOrderEmployee" items="${vwOrderEmployees}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${vwOrderEmployee.orderId}</th>
                                    <td>${vwOrderEmployee.states}</td>
                                    <td>${vwOrderEmployee.employeeId}</td>                                    
                                    <td>${vwOrderEmployee.lastName}</td>                                    
                                    <td>${vwOrderEmployee.email}</td>                                    
                                    <td>${vwOrderEmployee.position}</td>                                    
                                    <td>${vwOrderEmployee.boss}</td>                                    
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




