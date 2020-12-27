<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            Tabla Usuarios
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table display nowrap table-hover" style="width:100%">
                <thead class=" table-dark">
                    <tr>
                        <th scope="col" class="table-bordered">#</th>
                        <th scope="col">id</th>
                        <th>Nombre</th>
                        <th>Dni</th>
                        <th>Apellido</th>
                        <th>Fecha Pedido</th>
                        <th>Fecha Envio</th>                                
                        <th>Direccion</th>
                        <th>Lote</th>
                        <th>Referencia</th>
                        <th>Tipo de direccion</th>
                        <th>Estado</th>                        
                        <th>Distrito Id</th>
                        <th>Empleado Id</th>
                        <th>Empresa de Envio</th>
                        <th>Usuario Id</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="order" items="${orders}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${order.orderId}</th>
                            <td>${order.name}</td>
                            <td>${order.lastName}</td>
                            <td>${order.dni}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.shippingDate}</td>
                            <td>${order.orderAdderss}</td>
                            <td>${order.lot}</td>
                            <td>${order.reference}</td>
                            <td>${order.typeAddress}</td>
                            <td>${order.states}</td>
                            <td>${order.districtId}</td>
                            <td>${order.employeeId}</td>
                            <td>${order.shippingComanyId}</td>
                            <td>${order.userId}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/OrderServlet?action=edit&orderId=${order.orderId}&userId=${order.userId}&typeAddress=${order.typeAddress}&districtId=${order.districtId}&employeeId=0${order.employeeId}&shippingComanyId=0${order.shippingComanyId}"
                                   class="btn btn-danger">
                                    <i class="fas fa-angle-double-right"></i>
                                   <span>Editar</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>


<!-- ventana modal de agregar empleado -->
<jsp:include  page="/WEB-INF/pagesInfo/orderUtils/addOrderForm.jsp"/>
<!-- ventana modal de confirmacion -->
<jsp:include  page="/WEB-INF/pagesInfo/orderUtils/modayConfirm.jsp"/>
<!-- ventana modal tipo de direccion -->
<jsp:include  page="/WEB-INF/pagesInfo/orderUtils/typeAddress.jsp"/>
<!-- ventana modal distrito y provincia -->
<jsp:include  page="/WEB-INF/pagesInfo/employeesInfo/viewDistrict.jsp"/>


