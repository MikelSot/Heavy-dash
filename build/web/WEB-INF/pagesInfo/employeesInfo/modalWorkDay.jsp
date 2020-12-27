
<div class="modal fade" id="insertWorkDaysEmployee" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar dias de Trabajo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/EmployeeServlet?accion=insertWorkDay"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md">
                            <label for="employeeID">Empleado Id</label>
                            <input type="number" class="form-control" name="employeeID" min="1" max="${totalEmployees}" required>
                        </div>

                        <div class="col-md">
                            <label for="workDayID">Dia de Semana Id (1)</label>
                            <input type="number" class="form-control" name="workDayID"  min="1" max="7"  required>                     
                        </div>
                    </div>   
                    
                    <div class="form-row">
                        <div class="col-md">
                            <label for="workDayID2">Dia de Semana Id (2)</label>
                            <input type="number" class="form-control" name="workDayID2"  min="1" max="7" required>                     
                        </div>
                        
                        <div class="col-md">
                            <label for="workDayID3">Dia de Semana Id (3)</label>
                            <input type="number" class="form-control" name="workDayID3" min="1" max="7" >
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

