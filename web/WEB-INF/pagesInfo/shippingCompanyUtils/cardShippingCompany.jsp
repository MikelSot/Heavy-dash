<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<!-- CARD PERSONAL PARA CADA EMPLEADO -->
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
                            Edad
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            Falta
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-birthday-cake fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Earnings (Annual) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-success shadow h-100 py-1">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="tex font-weight-bold text-success text-uppercase mb-1"
                            >
                            Distrito
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                           Falta 
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-street-view fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
<!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-1">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-info text-uppercase mb-1"
                            >
                            Dias de Trabajo
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                            Falta
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="far fa-calendar-alt fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-warning shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewAgency" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-warning text-uppercase mb-1"
                            >
                            Agencias
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                            ${totalAgencys}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-mobile-alt fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h1 mb-0 text-gray-800">Contenido Empresa de Envio</h1>
</div>
                        
<a
    type="button"
    class="btn btn-success mt-2 mb-4"
    href="${pageContext.request.contextPath}/ShippingCompanyServlet"
    >
    <strong class="h5"></strong>
    <i class="fas fa-arrow-left"></i>
</a>                      
    

<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#viewDistrict"
    >
    <strong class="h5"></strong>
    <i class="fas fa-map-marker-alt"></i>
</button>      