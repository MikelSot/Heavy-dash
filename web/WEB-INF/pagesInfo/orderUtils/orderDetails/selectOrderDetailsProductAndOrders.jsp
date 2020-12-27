<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/>
<div class="modal fade" id="viewSelectOrderDetailsOrders" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Lista de Pedidos relacionados con el Detalle Pedido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee2" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pedido Id</th>
                                <th>Estado</th>
                                <th>Fecha Pedido</th>                                
                                <th>Fecha Envio</th>
                                <th>Usuario Id</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="selectOrderDetailsOrder" items="${selectOrderDetailsOrders}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectOrderDetailsOrder.orderId}</th>
                                    <td>${selectOrderDetailsOrder.states}</td>
                                    <td>${selectOrderDetailsOrder.orderDate}</td>                                    
                                    <td>${selectOrderDetailsOrder.shippingDate}</td>
                                    <td>${selectOrderDetailsOrder.userId}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>         



<div class="modal fade" id="viewSelectOrderDetailsProduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Lista de Productos relacionados con el Detalle Pedido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee3" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Prodcuto Id</th>
                                <th>Producto</th>
                                <th>Estado</th>                                
                                <th>Precio Unitario</th>
                                <th>Stoke</th>
                                <th>Proveedor Id</th>
                                <th>Categoria Id</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="selectOrderDetailsProduct" items="${selectOrderDetailsProduct}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectOrderDetailsProduct.productId}</th>
                                    <td>${selectOrderDetailsProduct.nameProduct}</td>
                                    <td>${selectOrderDetailsProduct.states}</td>       
                                    <td><format:formatNumber value="${selectOrderDetailsProduct.unitPrice}" type="currency"/></td>
                                    <td>${selectOrderDetailsProduct.stock}</td>
                                    <td>${selectOrderDetailsProduct.supplierId}</td>
                                    <td>${selectOrderDetailsProduct.categoryId}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>         


