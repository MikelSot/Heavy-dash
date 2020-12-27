        
<ul class="navbar-nav bg-gradient-info sidebar sidebar-dark accordion menu-fixedd toggled" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/index.jsp">
        <div class="sidebar-brand-icon rotate-n-15">
            <img src="resource/img/heavy.svg" alt="" style="height: 45px; width: 45pxs;">
        </div>                                      <!-- ponemos un icono -->
        <div class="sidebar-brand-text mx-3" style="font-family: 'Montserrat', sans-serif;">Heavy <sup> <i class="fas fa-star-of-david"></i> </sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp"> 
            <i class="fas fa-home"></i>
            <span style="font-family: 'Montserrat', sans-serif;">Inicio</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Interface
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
           aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-server"></i>
            <span>Control</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Componentes:</h6>
                <a class="collapse-item" href="${pageContext.request.contextPath}/ProductServlet">Productos</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/CategoryServlet">Categorias</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/UserServlet">Usuarios</a>
            </div>
        </div>
    </li>

    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
           aria-expanded="true" aria-controls="collapsePages">
            <i class="fas fa-shopping-cart"></i>
            <span>Ventas</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Componentes:</h6>
                <a class="collapse-item" href="${pageContext.request.contextPath}/PaymentServlet">Facturas</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/OrderServlet">Pedido</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/OrderDetailsServlet">Detalle Pedido</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-truck"></i>
            <span>Compras</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Componentes:</h6>
                <a class="collapse-item" href="${pageContext.request.contextPath}/SupplierServlet">Proveedores</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/OrderSupplierServlet">Pedido Proveedores</a>
                <h6 class="collapse-header">Otras Paginas:</h6>
                <a class="collapse-item" href="${pageContext.request.contextPath}/ShippingCompanyServlet">Empresas de Envío</a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Adicional
    </div>


    <!-- Nav Item - Charts -->
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/EmployeeServlet">
            <i class="fas fa-users-cog"></i>
            <span>Empleados</span></a>
    </li>

    <!-- Nav Item - Tables -->
    <li class="nav-item">
        <a class="nav-link" href="#">
            <i class="fas fa-chart-line"></i>
            <span>Reportes</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) QUEDA [<-] -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>