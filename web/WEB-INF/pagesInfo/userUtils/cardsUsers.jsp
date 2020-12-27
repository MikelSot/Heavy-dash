<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> 
<div class="row">
    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-1">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-primary text-uppercase mb-1"
                            >
                           # Usuarios
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${totalUsers}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-users fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Earnings (Annual) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-success shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewInactiveUsers" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-success text-uppercase mb-1"
                            >
                            Inactivos
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">                            
                            ${totalInactiveUsers}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-user-times fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewRoles" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-info text-uppercase mb-1"
                            >
                            Roles
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${totalRoles}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-user-tag fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-warning shadow h-100 py-1">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-warning text-uppercase mb-1"
                            >
                           Pedidos
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            falta
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-diagnoses fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-sm-flex align-items-center justify-content-between">
    <h1 class="mb-0 text-gray-800">Usuarios</h1>
</div>

<button
    type="button"
    class="btn btn-success mt-2 mb-4"
    data-toggle="modal"
    data-target="#insertUser"
    >
    <strong class="h5">Nuevo </strong>
    <i class="fas fa-user-plus"></i>
</button>

<!-- numero de usuarios, compras realizadas numero, numero inactivos,  -->

<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#insertWorkDaysEmployee"
    >
    <strong class="h5"></strong>
    <i class="far fa-calendar-alt"></i>
</button>
                        
<button
    type="button"
    class="btn btn-${button} mt-2 mb-4"
    data-toggle="modal"
    data-target="#exampleModalLabel"
    >
    <strong class="h5"></strong>
    <i class="fas fa-${icon}"></i>
</button>     