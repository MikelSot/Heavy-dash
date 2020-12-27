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
                        <th>Direccion</th>
                        <th>Codigo Postal</th>
                        <th>Email</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="shippingCompany" items="${shippingCompanys}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${shippingCompany.shippingCompanyId}</th>
                            <td>${shippingCompany.companyName}</td>
                            <td>${shippingCompany.contactName}</td>
                            <td>${shippingCompany.active}</td>
                            <td>${shippingCompany.companyAddres}</td>
                            <td>${shippingCompany.postalCode}</td>
                            <td>${shippingCompany.email}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ShippingCompanyServlet?action=edit&shippingCompanyId=${shippingCompany.shippingCompanyId}"
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
<jsp:include page="/WEB-INF/pagesInfo/shippingCompanyUtils/addShippingComapnyForm.jsp" />
<!-- moday ver distritos -->
<jsp:include page="/WEB-INF/pagesInfo/employeesInfo/viewDistrict.jsp" />
<!-- ventana modal de confirmacion -->
<jsp:include page="/WEB-INF/pagesInfo/shippingCompanyUtils/modayConfirm.jsp" />
