<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> 
<div class="modal fade" id="viewSelectProductPaymentses" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold " id="exampleModalLabel">Otras compras que tienen en común el producto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee4" class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Pago Id</th>
                                <th>Usuario Id</th>
                                <th>Nombre</th>
                                <th>Pedido Id</th>                                
                                <th>Detalle Pedido</th>                                
                                <th>Cantidad</th>                                
                                <th>Producto Id</th>                                
                                <th>Categoria Id</th>                                
                                <th>Producto</th>                                
                                <th>Precio Unitario</th>                                
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="selectProductPaymentses" items="${selectProductPaymentses}" varStatus="statusNumber">

                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${selectProductPaymentses.paymentId}</th>
                                    <td>${selectProductPaymentses.userId}</td>
                                    <td>${selectProductPaymentses.userName}</td>                                    
                                    <td>${selectProductPaymentses.orderId}</td>
                                    <td>${selectProductPaymentses.orderDetailId}</td>
                                    <td>${selectProductPaymentses.quantity}</td>
                                    <td>${selectProductPaymentses.productId}</td>
                                    <td>${selectProductPaymentses.categoryId}</td>
                                    <td>${selectProductPaymentses.nameProduct}</td>
                                    <td><format:formatNumber value="${selectProductPaymentses.unitPrice}" type="currency"/></td>
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
