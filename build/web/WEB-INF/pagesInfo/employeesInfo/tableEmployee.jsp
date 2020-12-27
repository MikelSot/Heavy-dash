<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            Tabla Empleados
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table display nowrap table-hover" style="width:100%">
                <thead class="table-dark">
                    <tr>
                        <th scope="col" class="table-bordered">#</th>
                        <th scope="col">id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>                                
                        <th>Dni</th>
                        <th>Fecha Nacimiento</th>
                        <th>Email</th>
                        <th>Salario</th>
                        <th scope="col">Dirección Empleado</th>
                        <th>Postal</th>
                        <th>Horas</th>
                        <th>Turno</th>
                        <th>Ecucacion</th>
                        <th>Profesion Empleado</th>
                        <th>Cargo</th>
                        <th>Sexo</th>
                        <th>Estado</th>
                        <th>Jefe</th>
                        <th>Distrito</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="employee" items="${employees}" varStatus="statusNumber">

                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${employee.employeeId}</th>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>                                    
                            <td>${employee.dni}</td>
                            <td>${employee.birthDate}</td>
                            <td>${employee.email}</td>
                            <td><format:formatNumber value="${employee.salary}" type="currency"/></td>
                            <td>${employee.employeeAddress}</td>
                            <td>${employee.postalCode}</td>
                            <td>${employee.employeeHours}</td>
                            <td>${employee.turn}</td>
                            <td>${employee.educationLevel}</td>
                            <td>${employee.profession}</td>
                            <td>${employee.position}</td>
                            <td>${employee.sex}</td>
                            <td>${employee.states}</td>
                            <td>${employee.boss}</td>
                            <td>${employee.districtID}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/EmployeeServlet?accion=edit&employeeId=${employee.employeeId}&districtID=${employee.districtID}&bossID=0${employee.boss}"
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
<jsp:include  page="/WEB-INF/pagesInfo/employeesInfo/addEmployeesForm.jsp"/>
<!-- moday de confimacion -->
<jsp:include page="/WEB-INF/pagesInfo/employeesInfo/modalConfirm.jsp" />

<!-- moday ver distritos -->
<jsp:include page="/WEB-INF/pagesInfo/employeesInfo/viewDistrict.jsp" />
<!-- moday dias de trabajo-->
<jsp:include page="/WEB-INF/pagesInfo/employeesInfo/modalWorkDay.jsp" />

<!-- moday telefono -->
<jsp:include page="/WEB-INF/pagesInfo/employeesInfo/modayPhone.jsp" />


