<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewInactiveUsers" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Usuarios Inactivos</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee2" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Usuario Id</th>
                                <th>Nombre</th>
                                <th>Email</th>                                
                                <th>Estado</th>
                                <th>Role Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- mostramos la lista usuarios inactivos-->
                            <c:forEach var="inactiveUser" items="${inactiveUsers}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${inactiveUser.userId}</th>
                                    <td>${inactiveUser.userName}</td>
                                    <td>${inactiveUser.email}</td>                                    
                                    <td>${inactiveUser.active}</td>
                                    <td>${inactiveUser.roleId}</td>
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


<div class="modal fade" id="viewRoles" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Lista de Roles</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee3" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Role Id</th>
                                <th>Role</th>
                                <th>Estado</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <!-- mostramos la lista usuarios inactivos-->
                            <c:forEach var="role" items="${roles}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${role.roleId}</th>
                                    <td>${role.roleName}</td>
                                    <td>${role.active}</td>                                    
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