<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="viewShippingEmployees" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Envios realizado por los Empleados</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee2" class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pedido_Id</th>
                                <th>Empleado_Id</th>
                                <th>Nombre</th>                                
                                <th>Apellido</th>
                                <th>Producto</th>
                                <th>Producto_Id</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="chippingEmployees" items="${selectChippingEmployees}" varStatus="statusNumber">

                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${chippingEmployees.orderID}</th>
                                    <td>${chippingEmployees.employeeID}</td>
                                    <td>${chippingEmployees.employeeName}</td>                                    
                                    <td>${chippingEmployees.employeeLastName}</td>
                                    <td>${chippingEmployees.productName}</td>
                                    <td>${chippingEmployees.productID}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <a  class="btn btn-primary nav-link" href="${pageContext.request.contextPath}/OrderServlet"  >GO Pedidos</a>
            </div>
        </div>
    </div>
</div>                               