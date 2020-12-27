<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="insertOrderDetails" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Detalle Pedido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/OrderDetailsServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">                                                
                        <div div class="col-md mb-3">                            
                            <label for="orderId">Pedido Id</label>
                            <input type="list" list="list-orderId" class="form-control" min="1" name="orderId" required>
                            <datalist id="list-orderId">
                                <c:forEach var="order" items="${ordersId}">
                                    <option value="${order.orderId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>

                        <div div class="col-md mb-3">                            
                            <label for="productId">Producto Id</label>
                            <input type="list" list="list-productId" class="form-control" min="1" name="productId" required>
                            <datalist id="list-productId">
                                <c:forEach var="product" items="${productsId}">
                                    <option value="${product.productId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>

                        <div class="col-md mb-3">
                            <label for="quantity">Cantidad</label>
                            <input type="number" class="form-control" name="quantity" min="1"  required>        
                        </div>
                        
                    </div>

                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button class="btn btn-primary" id="submit" type="submit">Guardar</button>    
                </div>


            </form>

        </div>
    </div>
</div>