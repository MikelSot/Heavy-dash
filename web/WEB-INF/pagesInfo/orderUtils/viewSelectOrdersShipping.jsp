<div class="modal fade" id="viewSelectOrdersShippingCompany" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos de  la Empresa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-responsive">
                    <thead>
                        <tr>
                            <th>Empresa_Id</th>
                            <th>Empresa</th>                                
                            <th>Representante</th>
                            <th>Estado</th>
                            <th>Direccion</th>
                            <th>Codigo_Postal</th>
                            <th>Email</th>
                        </tr>
                    </thead>                    
                    <tr>
                        <td>${selectOrdersShippingCompany.shippingCompanyId}</td>
                        <td>${selectOrdersShippingCompany.companyName}</td>
                        <td>${selectOrdersShippingCompany.contactName}</td>
                        <td>${selectOrdersShippingCompany.active}</td>
                        <td>${selectOrdersShippingCompany.companyAddres}</td>
                        <td>${selectOrdersShippingCompany.postalCode}</td>
                        <td>${selectOrdersShippingCompany.email}</td>
                    </tr>

                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>    


<div class="modal fade" id="viewSelectOrdersEmployee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos del Empleado</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-responsive">
                    <thead>
                        <tr>
                            <th>Empleado_Id</th>
                            <th>Nombre</th>                                
                            <th>Apellido</th>
                            <th>Dni</th>
                            <th>Email</th>
                            <th>Horas</th>
                            <th>Turno</th>
                            <th>Posición</th>
                            <th>Estado</th>
                            <th>Distrito</th>
                            <th>Jefe_Id</th>
                            <th>Apellido_Jefe</th>
                        </tr>
                    </thead>                    
                    <tr>
                        <td>${selectOrdersEmployee.employeeId}</td>
                        <td>${selectOrdersEmployee.firstName}</td>
                        <td>${selectOrdersEmployee.lastName}</td>
                        <td>${selectOrdersEmployee.dni}</td>
                        <td>${selectOrdersEmployee.email}</td>
                        <td>${selectOrdersEmployee.employeeHours}</td>
                        <td>${selectOrdersEmployee.turn}</td>
                        <td>${selectOrdersEmployee.position}</td>
                        <td>${selectOrdersEmployee.states}</td>
                        <td>${selectOrdersEmployee.district}</td>
                        <td>${selectOrdersEmployee.boss}</td>
                        <td>${selectOrdersEmployee.bossLastName}</td>
                    </tr>

                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>                           