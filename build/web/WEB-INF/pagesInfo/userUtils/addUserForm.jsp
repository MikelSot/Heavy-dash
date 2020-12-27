
<div class="modal fade" id="insertUser" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-m">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/UserServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-8 mb-2">
                            <label for="userName">Nombre</label>
                            <input type="text" class="form-control" name="userName" maxlength="120" required>
                        </div>

                        <div class="col-md mb-2">
                            <label for="userPassword">Contraseña</label>
                            <input type="password" class="form-control" name="userPassword" required>                     
                        </div>
                    </div>
                    
                    <div class="form-row">
                        <div class="col-md">
                            <label for="email">Email</label>
                            <input type="email" class="form-control"  name="email" placeholder="pepito@gmail">        
                        </div> 
                    </div>    

                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="nickName">Alias</label>
                            <input type="text" class="form-control" name="nickName">        
                        </div>
                      

                        <div class="col-md-4 mb-3">
                            <label for="active">Estado</label>
                            <input type="number" class="form-control" name="active" min="0" max="1" required>
                        </div>
                        
                        <div class="col-md-4 mb-3">
                            <label for="roleId">RoleId</label>
                            <input type="number" class="form-control" name="roleId" required min="1" max="3" step="any">
                        </div>

                    </div>
                                   
                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button class="btn btn-primary"  type="submit">Guardar</button>
                </div>


            </form>









        </div>
    </div>
</div>