<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="vwShippingCompanyOrders" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                <th scope="col">Empresa Envio Id</th>
                                <th>Pedido Id</th>                                
                                <th>Estado</th>
                                <th>Fecha Pedido</th>
                                <th>Fecha Envio</th>
                                <th>Usuario Id</th>
                                <th>Usuario</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="vwShippingCompanyOrder" items="${vwShippingCompanyOrders}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${vwShippingCompanyOrder.shippingComanyId}</th>
                                    <td>${vwShippingCompanyOrder.orderId}</td>
                                    <td>${vwShippingCompanyOrder.states}</td>                                    
                                    <td>${vwShippingCompanyOrder.orderDate}</td>                                    
                                    <td>${vwShippingCompanyOrder.shippingDate}</td>                                    
                                    <td>${vwShippingCompanyOrder.userId}</td>                                    
                                    <td>${vwShippingCompanyOrder.userName}</td>                                    
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

