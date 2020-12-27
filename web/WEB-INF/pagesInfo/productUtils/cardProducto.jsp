<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<!-- CARD PERSONAL PARA CADA EMPLEADO -->
<div class="row">
    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-1">
            <div class="card-body"  data-toggle="modal" data-target="#viewIncludeProduct" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-primary text-uppercase mb-1"
                            >
                            Incluye
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${totalInclude}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-shapes fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Earnings (Annual) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-success shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewCategoryProduct" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="tex font-weight-bold text-success text-uppercase mb-1"
                            >
                            Categoria
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                             <c:forEach var="category" items="${categoryProduct}">
                                <span>${category.categoryName}</span>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-project-diagram fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
<!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewOrderByProductt" type="button">
                <div class="row no-gutters align-items-center" >
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-info text-uppercase mb-1"
                            >
                            Pedidos
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                            ${totalOrdersByProduct}
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
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-warning text-uppercase mb-1"
                            >
                            # demandada
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                            ${totalQuantityEemanded}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-list-ul fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h1 mb-0 text-gray-800">Contenido Producto</h1>
</div>

<a
    type="button"
    class="btn btn-success mt-2 mb-4"
    href="${pageContext.request.contextPath}/ProductServlet"
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
    <i class="fas fa-map-marker"></i>
</button>
                        

<!-- que inluye cada producto, estado , categoria , cuantos se han vendido -->