<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

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
                        <th>Producto</th>
                        <th>SKU</th>                                
                        <th>Medida</th>
                        <th>Estado</th>
                        <th>Precio Unitario</th>
                        <th>Stock</th>
                        <th>Proveedor</th>
                        <th>Categoria</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="product" items="${products}" varStatus="statusNumber">

                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${product.productId}</th>
                            <td>${product.nameProduct}</td>
                            <td>${product.sku}</td>                                    
                            <td>${product.measure}</td>
                            <td>${product.states}</td>
                            <td><format:formatNumber value="${product.unitPrice}" type="currency"/></td>
                            <td>${product.stock}</td>
                            <td>${product.supplierId}</td>
                            <td>${product.categoryId}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ProductServlet?action=edit&productId=${product.productId}&categoryId=${product.categoryId}"
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
<jsp:include  page="/WEB-INF/pagesInfo/productUtils/addProductoForm.jsp"/>
<!-- ventana modal de confirmacion-->
<jsp:include  page="/WEB-INF/pagesInfo/productUtils/modayConfirm.jsp"/>
