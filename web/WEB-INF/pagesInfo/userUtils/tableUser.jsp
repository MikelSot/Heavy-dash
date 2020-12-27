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
                        <th>Usuario</th>
                        <th>Alias</th>                                
                        <th>Email</th>
                        <th>Clave</th>
                        <th>Estado</th>
                        <th>RoleId</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="user" items="${users}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${user.userId}</th>
                            <td>${user.userName}</td>
                            <td>${user.nickName}</td>                                    
                            <td>${user.email}</td>
                            <td>${user.userPassword}</td>
                            <td>${user.active}</td>
                            <td>${user.roleId}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/UserServlet?action=edit&userId=${user.userId}"
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


<!-- ventana modal de agregar usuario -->
<jsp:include  page="/WEB-INF/pagesInfo/userUtils/addUserForm.jsp"/>
<!-- ventana modal de confirmacion -->
<jsp:include  page="/WEB-INF/pagesInfo/userUtils/modalConfirm.jsp"/>
<!-- ventana modal usuarios inactivos -->
<jsp:include  page="/WEB-INF/pagesInfo/userUtils/modalInactiveUsers.jsp"/>
