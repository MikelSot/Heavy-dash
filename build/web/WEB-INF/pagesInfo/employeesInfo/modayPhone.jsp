
<div class="modal fade" id="insertPhoneEmployee" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Telefono</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/EmployeeServlet?accion=insertPhone"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md mb-3">
                            <label for="employeeID">Empleado Id</label>
                            <input type="number" class="form-control" name="employeeID" min="1" max="${totalEmployees}" required>
                        </div>

                        <div class="col-md mb-3">
                            <label for="phonesEmployeeOne">Telefono</label>
                            <input type="tel" class="form-control" name="phonesEmployeeOne"  minlength="9" maxlength="9"  required>                     
                        </div>
                        
                        <div class="col-md mb-3">
                            <label for="lastName">Telefono(2)</label>
                            <input type="tel" class="form-control" name="lastName"  minlength="9" maxlength="9">                     
                        </div>
                    </div>                  
                </div>
                <div class="modal-footer">
                    <button type="button" class=" btn btn-secondary" data-dismiss="modal">Close</button>
                    <button class="btn btn-info"  type="submit">Guardar</button>
                </div>

            </form>                
        </div>
    </div>
</div>

