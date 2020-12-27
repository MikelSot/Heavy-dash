<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<!-- CARD PERSONAL PARA CADA EMPLEADO -->
<div class="row">
    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewSelectOrderPaymentID" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-primary text-uppercase mb-1"
                            >
                            Pedido Id
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                            ${selectOrderPaymentID.orderId}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="far fa-address-book fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Earnings (Annual) Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-success shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewSelectOrderDetailsProductoPaymentID" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="tex font-weight-bold text-success text-uppercase mb-1"
                            >
                            Producto
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                            ${selectOrderDetailsProductoPaymentID.nameProduct}
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-tasks fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-info shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewInvoiceById" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="text font-weight-bold text-info text-uppercase mb-1">
                            Factura Ruc
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                            ${invoiceById.ruc}  
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-money-check fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Pending Requests Card Example -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-warning shadow h-100 py-1">
            <div class="card-body" data-toggle="modal" data-target="#viewSelectPaymentUserByID" type="button">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div
                            class="text font-weight-bold text-warning text-uppercase mb-1"
                            >
                            Usuario
                        </div>
                        <div class="h6 mb-0 font-weight-bold text-gray-800">
                            ${selectPaymentUserByID.userName}                    
                        </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-user-circle fa-2x text-gray-300"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h1 mb-0 text-gray-800">Contenido Pago</h1>
</div>

<a
    type="button"
    class="btn btn-success mt-2 mb-4"
    href="${pageContext.request.contextPath}/PaymentServlet"
    >
    <strong class="h5"></strong>
    <i class="fas fa-arrow-left"></i>
</a>


<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#viewInvoiceTable"
    >
    <strong class="h5"></strong>
    <i class="fas fa-money-check"></i>
</button> 
<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#viewSelectUserPayments"
    >
    <strong class="h5">${totalSelectUserPayments}</strong>
    <i class="fas fa-user-check"></i>    
</button>     

<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#viewSelectProductPaymentses"
    >
    <strong class="h5">${totalSelectProductPaymentses}</strong>
    <i class="fas fa-tasks"></i>
</button>    

<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#viewSelectInvoicesPaymentses"
    >
    <strong class="h5">${totalSelectInvoicesPaymentses}</strong>
    <i class="fas fa-money-check-alt"></i>
</button>        

<!-- usuario al que pertenece ese pago, ver que otros pagos genero, el producto y la orden a la que pertenece ese pago , el detalle pedido-->   