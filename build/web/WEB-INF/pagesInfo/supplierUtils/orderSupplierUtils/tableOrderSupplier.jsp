<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> 
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            Tabla Productos
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table display nowrap table-hover" style="width:100%">
                <thead class=" table-dark">
                    <tr>
                        <th scope="col" class="table-bordered">#</th>
                        <th scope="col">id</th>
                        <th>Nombre Producto</th>
                        <th>Precio Unitario</th>                                
                        <th>Cantidad</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Fecha Pedido</th>
                        <th>Fecha Envio</th>
                        <th>Empresa de Envio</th>
                        <th>Precio de Envio</th>
                        <th>Proveedor Id</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="orderSupplier" items="${orderSuppliers}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${orderSupplier.orderSupplierId}</th>
                            <td>${orderSupplier.orderName}</td>
                            <td><format:formatNumber value="${orderSupplier.unitPrice}" type="currency"/></td>
                            <td>${orderSupplier.quantity}</td>
                            <td>${orderSupplier.orderDescription}</td>
                            <td>${orderSupplier.states}</td>
                            <td>${orderSupplier.orderDate}</td>
                            <td>${orderSupplier.shippedDate}</td>
                            <td>${orderSupplier.shippingCompany}</td>
                            <td><format:formatNumber value="${orderSupplier.priceShipping}" type="currency"/></td>
                            <td>${orderSupplier.supplierId}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/OrderSupplierServlet?action=edit&orderSupplierId=${orderSupplier.orderSupplierId}"
                                   class="btn btn-danger">
                                    <i class="fas fa-angle-double-right"></i>
                                    <span>Editar</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>


<!-- ventana modal de agregar empleado -->
<jsp:include page="/WEB-INF/pagesInfo/supplierUtils/orderSupplierUtils/addOrderSupplierForm.jsp" />
<!-- ventana modal de confirmacion -->
<jsp:include page="/WEB-INF/pagesInfo/supplierUtils/orderSupplierUtils/modayConfirm.jsp" />
