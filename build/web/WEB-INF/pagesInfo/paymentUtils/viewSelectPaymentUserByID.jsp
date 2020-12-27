<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="viewSelectPaymentUserByID" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Datos del Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body ">
                <div class="table-responsive">
                    <table class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th>Usuario Id</th>
                                <th>Nombre</th>
                                <th>NickName</th>                                
                                <th>Email</th>
                                <th>Estado</th>
                                <th>Role Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <th>${selectPaymentUserByID.userId}</th>
                            <td>${selectPaymentUserByID.userName}</td>
                            <td>${selectPaymentUserByID.nickName}</td>                                    
                            <td>${selectPaymentUserByID.email}</td>
                            <td>${selectPaymentUserByID.active}</td>
                            <td>${selectPaymentUserByID.roleId}</td>
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