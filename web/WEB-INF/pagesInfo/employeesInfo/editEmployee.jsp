
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Empleado | Editar</title>
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headTable.jsp" />

    </head>
    <body class="scroll sidebar-toggled">
        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- NAV -->

            <jsp:include page="/WEB-INF/pagesInfo/indexUtils/nav.jsp" />


            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column menu-collapsed">

                <div id="content">

                    <!-- barra top -->
                    <jsp:include page="/WEB-INF/pagesInfo/indexUtils/topbar.jsp" />

                    <div class="container-fluid">
                        <!-- Cards de empleado -->
                        <jsp:include page="/WEB-INF/pagesInfo/employeesUtils/cardEmployee.jsp" />
                        <form action="${pageContext.request.contextPath}/EmployeeServlet?accion=update&employeeId=${employee.employeeId}" method="POST" class="container">

                            <section class="container" >
                                <div>
                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h4>Editar Empleado</h4>
                                                </div>


                                                <div class="card-body">

                                                    <div class="form-row mb-3">
                                                        <div class="col-md-6">
                                                            <label for="firstName">Nombre</label>
                                                            <input type="text" class="form-control" name="firstName" maxlength="60" required value="${employee.firstName}" >
                                                        </div>

                                                        <div class="col-md-6 ">
                                                            <label for="lastName">Apellido</label>
                                                            <input type="text" class="form-control" name="lastName"  maxlength="60"  required value="${employee.lastName}">                     
                                                        </div>

                                                    </div>

                                                    <div class="form-row mb-3">
                                                        <div class="col-md-3">
                                                            <label for="dni">Dni</label>
                                                            <input type="text" class="form-control" name="dni" maxlength="8" required value="${employee.dni}">        
                                                        </div>


                                                        <div div class="col-md-3">
                                                            <label for="birthDate">Fecha Nacimiento</label>
                                                            <input type="text" class="form-control" name="birthDate" required value="${employee.birthDate}">
                                                        </div>



                                                        <div div class="col-md-3">
                                                            <label for="postalCode">Codigo Postal</label>
                                                            <input type="text" class="form-control" maxlength="5" name="postalCode" required value="${employee.postalCode}">
                                                        </div>


                                                        <div class="col-md-3">
                                                            <label for="turn">Turno</label>
                                                            <input type="text" class="form-control" maxlength="10" name="turn" required value="${employee.turn}">                                                 
                                                        </div>

                                                    </div>

                                                    <div class="form-row mb-2">
                                                        <div class="col-md-6">
                                                            <label for="email">Email</label>
                                                            <input type="email" class="form-control" name="email" maxlength="150" required value="${employee.email}">
                                                        </div>

                                                        <div class="col-md-6">
                                                            <label for="employeeAddress">Direccion</label>
                                                            <input type="text" class="form-control" name="employeeAddress"  maxlength="120"  required value="${employee.employeeAddress}">                     
                                                        </div>

                                                    </div>


                                                    <div class="form-row mb-3">


                                                        <div class="col-md-3">
                                                            <label for="districtID">Distrito</label>
                                                            <input type="number" class="form-control is-invalid" name="districtID" min="1"  max="${totalDistrics}" required value="${employee.districtID}">        
                                                            <div id="validationServer04Feedback" class="invalid-feedback">
                                                                numero 0< x < ${totalDistrics}
                                                            </div>
                                                        </div>

                                                        <div class="col-md-3">
                                                            <label for="salary">Salario</label>
                                                            <input type="number" class="form-control"  name="salary"  required value="${employee.salary}" step="any" >        
                                                        </div>


                                                        <div div class="col-md-3">
                                                            <label for="employeeHours">Horas de Trabajo</label>
                                                            <input type="text" class="form-control" name="employeeHours" maxlength="2" required value="${employee.employeeHours}">
                                                        </div>



                                                        <div class="col-md-3">
                                                            <label for="sex">Género</label>
                                                            <input type="text" class="form-control" name="sex" maxlength="20" required value="${employee.sex}">
                                                        </div>



                                                    </div>


                                                    <div class="form-row mb-3">

                                                        <div class="col-md-3 ml-2">
                                                            <label for="educationLevel">Educacion</label>
                                                            <input type="text" class="form-control" name="educationLevel" required value="${employee.educationLevel}">        
                                                        </div>

                                                        <div class="col-md-2  ml-2">
                                                            <label for="profession">Especialidad</label>
                                                            <input type="text" class="form-control"  name="profession" maxlength="80" value="${employee.profession}">        
                                                        </div>


                                                        <div div class="col-md-2  ml-2">
                                                            <label for="position">Posicion</label>
                                                            <input type="text" class="form-control" name="position" maxlength="80" required value="${employee.position}">
                                                        </div>

                                                        <div div class="col-md-2  ml-2">
                                                            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                                            <label for="boss">Jefe</label>
                                                            <input type="list" list="list-boss" class="form-control" min="1" name="boss" value="${employee.boss}">
                                                            <datalist id="list-boss">
                                                                <c:forEach var="boss" items="${employeesId}">
                                                                    <option value="${boss.employeeId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>

                                                        <div class="col-md-2 ml-2">
                                                            <label for="states">Estado</label>
                                                            <input type="text" class="form-control"  name="states" maxlength="80" value="${employee.states}">                                                        
                                                        </div>


                                                    </div>


                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                    <!-- boton eliminar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/employeesInfo/buttonEdition.jsp"/>

                                </div>

                            </section>





                        </form>




                    </div>




                </div>

                <!-- moday ver distritos -->
                <jsp:include page="/WEB-INF/pagesInfo/employeesInfo/viewDistrict.jsp" />
                <!-- moday envios que realizo este empleadio-->
                <jsp:include  page="/WEB-INF/pagesInfo/employeesInfo/viewShippingEmployee.jsp"/>


                <!-- pie de pagin-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
            </div>

        </div>


        <!-- moday dias de trabajo-->

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
                                    <input type="number" class="form-control" name="employeeID" min="1" max="${totalEmployees}" required value="${employee.employeeId}">
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


        <!-- moday telefono -->

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
                                    <input type="number" class="form-control" name="employeeID" min="1" max="${totalEmployees}" required value="${employee.employeeId}">
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


        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>
    </body>
</html>
