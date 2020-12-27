<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/>
<div class="modal fade" id="viewProducts" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Cantidad de Productos por esta Categoria</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee3" class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Producto Id</th>
                                <th>Producto</th>
                                <th>SKU</th>                                
                                <th>Estado</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Proveedor Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${products}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${product.productId}</th>
                                    <td>${product.nameProduct}</td>                                 
                                    <td>${product.sku}</td>
                                    <td>${product.states}</td>
                                    <td><format:formatNumber value="${product.unitPrice}" type="currency"/></td>
                                    <td>${product.stock}</td>
                                    <td>${product.supplierId}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <a  class="btn btn-primary nav-link" href="${pageContext.request.contextPath}/OrderServlet"  >GO Pedidos</a>
            </div>
        </div>
    </div>
</div>         
