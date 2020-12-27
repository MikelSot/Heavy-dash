<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            Tabla Productos
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table display nowrap table-hover" style="width:100%">
                <thead class=" table-dark">
                    <tr>
                        <th scope="col" class="table-bordered">#</th>
                        <th scope="col">id</th>
                        <th>Nombre Empresa</th>
                        <th>Representante</th>                                
                        <th>Estado</th>
                        <th>Codigo Postal</th>
                        <th>Direccion</th>
                        <th>Ciudad</th>
                        <th>Pais</th>
                        <th>Email</th>
                        <th>Tipo de bien</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="supplier" items="${suppliers}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${supplier.supplierId}</th>
                            <td>${supplier.nameCompany}</td>
                            <td>${supplier.contanctName}</td>
                            <td>${supplier.states}</td>
                            <td>${supplier.supplierAddress}</td>
                            <td>${supplier.postalCode}</td>
                            <td>${supplier.city}</td>
                            <td>${supplier.country}</td>
                            <td>${supplier.email}</td>
                            <td>${supplier.typeGoods}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/SupplierServlet?action=edit&supplierId=${supplier.supplierId}"
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
<jsp:include page="/WEB-INF/pagesInfo/supplierUtils/addSupplierForm.jsp" />
<!-- ventana modal de confirmacion -->
<jsp:include page="/WEB-INF/pagesInfo/supplierUtils/modayConfirm.jsp" />
