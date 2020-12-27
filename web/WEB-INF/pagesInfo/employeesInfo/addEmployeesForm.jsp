<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="insertRegisterEmployee" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Empleado</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/EmployeeServlet?accion=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="firstName">Nombre</label>
                            <input type="text" class="form-control" name="firstName" maxlength="60" required>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="lastName">Apellido</label>
                            <input type="text" class="form-control" name="lastName"  maxlength="60"  required>                     
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-3 mb-4">
                            <label for="dni">Dni</label>
                            <input type="text" class="form-control" name="dni" pattern="[0-9]+" maxlength="8" required>        
                        </div>


                        <div div class="col-md-3 mb-4">
                            <label for="birthDate">Fecha Nacimiento</label>
                            <input type="date" class="form-control" name="birthDate" required>
                        </div>



                        <div div class="col-md-3 mb-4">
                            <label for="postalCode">Codigo Postal</label>
                            <input type="text" class="form-control" maxlength="5" pattern="[0-9]+" name="postalCode" required>
                        </div>


                        <div class="col-md-3 mb-4">
                            <label for="turn">Turno</label>
                            <select class="custom-select" name="turn"  required>
                                <option selected disabled value="">Mañana</option>
                                <option>Mañana</option>
                                <option>Tarde</option>
                            </select>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" maxlength="150" required>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="employeeAddress">Direccion</label>
                            <input type="text" class="form-control" name="employeeAddress"  maxlength="120"  required>                     
                        </div>

                    </div>


                    <div class="form-row">


                        <div class="col-md-3 mb-4">
                            <label for="districtID">Distrito Id</label>
                            <input type="number" class="form-control is-invalid" name="districtID" min="1"  max="${totalDistrics}" required>        
                            <div id="validationServer04Feedback" class="invalid-feedback">
                                numero 0< x < ${totalDistrics}
                            </div>
                        </div>

                        <div class="col-md-3 mb-4">
                            <label for="salary">Salario</label>
                            <input type="number" class="form-control"  name="salary" min="950" required step="any">        
                        </div>


                        <div div class="col-md-3 mb-4">
                            <label for="employeeHours">Horas de Trabajo</label>
                            <input type="text" class="form-control" name="employeeHours" maxlength="2" required>
                        </div>



                        <div class="col-md-3 mb-4">
                            <label for="sex">Género</label>
                            <select class="custom-select" name="sex"  required>
                                <option selected disabled value="">Femenino</option>
                                <option>Masculino</option>
                                <option>Femenino</option>
                                <option>otro</option>
                            </select>

                        </div>



                    </div>


                    <div class="form-row ml-3">

                        <div class="col-md-3 mb-3 ml-2">
                            <label for="educationLevel">Educacion</label>
                            <input type="text" class="form-control" name="educationLevel" required>        
                        </div>

                        <div class="col-md-2 mb-3 ml-2">
                            <label for="profession">Especialidad</label>
                            <input type="text" class="form-control"  name="profession" maxlength="80" >        
                        </div>


                        <div div class="col-md-2 mb-3 ml-2">
                            <label for="position">Posicion</label>
                            <input type="text" class="form-control" name="position" maxlength="80" required>
                        </div>

                        <div div class="col-md-2 mb-3 ml-2">
                            <label for="boss">Jefe</label>
                            <input type="list" list="list-boss" class="form-control" min="1" name="boss">
                            <datalist id="list-boss">
                                <c:forEach var="boss" items="${employeesId}">
                                    <option value="${boss.employeeId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>

                        <div class="col-md-2 mb-3 ml-2">
                            <label for="states">Estado</label>
                            <select class="custom-select" name="states"  required>
                                <option selected disabled value="">Activo</option>
                                <option>Activo</option>                                
                                <option>suspendido</option>
                                <option>Vacaciones</option>
                            </select>
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