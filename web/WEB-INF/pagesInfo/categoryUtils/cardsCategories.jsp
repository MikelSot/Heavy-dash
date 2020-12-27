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
                           # Categorias
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${totalCategories}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-store fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Earnings (Annual) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-success shadow h-100 py-1">
            <div class="card-body"  data-toggle="modal" data-target="#viewCategoryPrincipal" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-success text-uppercase mb-1"
                            >
                            Principal
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">                            
                            ${totalCategoryPrincipal}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-cube fa-1x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-1">
            <div class="card-body"  data-toggle="modal" data-target="#viewSubcategory" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-info text-uppercase mb-1"
                            >
                            Subcategorias
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${totalCatgorySubcategory}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-cube fa-1x text-gray-300"></i>
                        <i class="fas fa-cube fa-1x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-warning shadow h-100 py-1">
            <div class="card-body"  data-toggle="modal" data-target="#viewThirdLevel" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-warning text-uppercase mb-1"
                            >
                            3<sup class="text-lowercase">er</sup> Nivel
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            18
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-cubes fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-sm-flex align-items-center justify-content-between">
    <h1 class="mb-2 text-gray-800">Categorias</h1>
</div>

<button
    type="button"
    class="btn btn-success mt-2 mb-4"
    data-toggle="modal"
    data-target="#insertCategory"
    >
    <strong class="h5">Nuevo </strong>
    <i class="fas fa-plus"></i>
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
    class="btn btn-${button} mt-2 mb-4"
    data-toggle="modal"
    data-target="#exampleModalLabel"
    >
    <strong class="h5"></strong>
    <i class="fas fa-${icon}"></i>
</button>  

<!-- seleccionar subcategoria y eso es toso 0 cards -->