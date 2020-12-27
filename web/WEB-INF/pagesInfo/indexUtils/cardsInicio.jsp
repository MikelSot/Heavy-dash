<div class="d-sm-flex align-items-center justify-content-between mb-3">
    <h1 class="h1 mb-0 text-gray-800">Inicio</h1>
</div>

<div class="row">

    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-primary shadow h-100 py-2">
            <a class="card-body nav-link" href="${pageContext.request.contextPath}/ProductServlet">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2 ml-2">
                        <div class="text font-weight-bold text-primary text-uppercase mb-1">
                            Productos</div>
                        <div class="h4 mb-0 font-weight-bold text-gray-800">${toatlProducts}</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-box-open fa-3x text-gray-300"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <!-- Earnings (Annual) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-success shadow h-100 py-2">
            <a class="card-body nav-link" href="${pageContext.request.contextPath}/PaymentServlet">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-success text-uppercase mb-1">
                            Facturas</div>
                        <div class="h4 mb-0 font-weight-bold text-gray-800">${totalFactura}</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-money-check fa-3x text-gray-300"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>


    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-info shadow h-100 py-2">
            <a class="card-body nav-link" href="${pageContext.request.contextPath}/OrderSupplierServlet">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-info text-uppercase mb-1">
                            Compras</div>
                        <div class="h4 mb-0 font-weight-bold text-gray-800">${totalOrdersupplier}</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-shipping-fast fa-3x text-gray-300"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-warning shadow h-100 py-2">
            <a class="card-body nav-link" href="${pageContext.request.contextPath}/OrderServlet">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-warning text-uppercase">
                            Pedidos</div>       
                        <div class="h4 mb-0 font-weight-bold text-gray-800">${totalOrders}</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-cubes fa-4x text-gray-300"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>
</div>
<div class="row">

    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-info shadow h-100 py-2">
            <a class="card-body nav-link" href="${pageContext.request.contextPath}/UserServlet">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-info text-uppercase mb-1">
                            Usuarios</div>
                        <div class="h4 mb-0 font-weight-bold text-gray-800">${toatlUsers}</div>
                    </div>
                    <div class="col-auto">
                        <i class="far fa-user-circle fa-3x text-gray-400"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <!-- Earnings (Annual) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-warning shadow h-100 py-2">
            <a class="card-body nav-link" href="${pageContext.request.contextPath}/SupplierServlet">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-warning text-uppercase mb-1">
                            Proveedores</div>
                        <div class="h4 mb-0 font-weight-bold text-gray-800">${totalSupplier}</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-suitcase fa-3x text-gray-300"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>


    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-primary shadow h-100 py-2">
            <a class="card-body nav-link" href="${pageContext.request.contextPath}/EmployeeServlet">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-primary text-uppercase mb-1">
                            Empleados</div>
                        <div class="h4 mb-0 font-weight-bold text-gray-800">
                            ${totalEmployees}</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-users fa-3x text-gray-300"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4 mt-3">
        <div class="card border-left-danger shadow h-100 py-2">
            <a class="card-body nav-link" href="#">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-danger text-uppercase mb-1">
                            Configurar el Sistema</div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-cogs fa-3x text-gray-300"></i>
                    </div>
                </div>
            </a>
        </div>
    </div>
</div>

