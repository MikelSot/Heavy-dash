<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            Empleados
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${totalEmployees}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-users fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-success shadow h-100 py-1">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-success text-uppercase mb-1"
                            >
                            Salario(Total)
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">                            
                           <format:formatNumber value="${salaryTotal}" type="currency"/>
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-1">
            <div class="card-body nav-link">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-info text-uppercase mb-1">
                            Gerente
                        </div>
                        <span class="h6 mb-0 font-weight-bold text-gray-800">
                            ${stringGerente[0]} ${stringGerente[1]} 
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-warning shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewShippingEmployees" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-warning text-uppercase mb-1"
                            >
                            Envios
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${totalselectChippingEmployees}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-truck fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-sm-flex align-items-center justify-content-between">
    <h1 class="mb-0 text-gray-800">Contenido Emplados</h1>
</div>

<button
    type="button"
    class="btn btn-success mt-2 mb-4"
    data-toggle="modal"
    data-target="#insertRegisterEmployee"
    >
    <strong class="h5">Nuevo </strong>
    <i class="fas fa-user-plus"></i>
</button>
                        
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
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#insertPhoneEmployee"
    >
    <strong class="h5"></strong>
    <i class="fas fa-mobile-alt"></i>
</button>  


<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#viewDistrict"
    >
    <strong class="h5"></strong>
    <i class="fas fa-map-marker-alt"></i>
</button>                          

<button
    type="button"
    class="btn btn-${button} mt-2 mb-4"
    data-toggle="modal"
    data-target="#exampleModalLabel1"
    >
    <strong class="h5"></strong>
    <i class="fas fa-${icon}"></i>
</button>                             
<!-- agregar botos para ingresar telefono y dias de trabajo -->                                                