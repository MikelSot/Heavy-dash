<div class="modal fade" id="viewSelectOrdersUser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos del Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Usuario Id</th>
                            <th>Nombre</th>                                
                            <th>NickName</th>
                            <th>Email</th>
                            <th>Estado</th>
                            <th>Role Id</th>
                        </tr>
                    </thead>                    
                        <tr>
                            <td>${selectOrdersUser.userId}</td>
                            <td>${selectOrdersUser.userName}</td>
                            <td>${selectOrdersUser.nickName}</td>
                            <td>${selectOrdersUser.email}</td>
                            <td>${selectOrdersUser.active}</td>
                            <td>${selectOrdersUser.roleId}</td>
                        </tr>
               
                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>    