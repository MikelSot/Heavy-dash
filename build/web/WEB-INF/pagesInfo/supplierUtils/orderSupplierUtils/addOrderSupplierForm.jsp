<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="insertOrderSupplier" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Pedido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>


                                                             
            <form action="${pageContext.request.contextPath}/OrderSupplierServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="orderName">Nombre Producto</label>
                            <input type="text" class="form-control" name="orderName" maxlength="130" required>
                        </div>

                        <div class="col-md mb-3">
                            <label for="unitPrice">Precio Unitario</label>
                            <input type="number" class="form-control" name="unitPrice" min="0" required step="any">
                        </div>    
                        
                        <div class="col-md mb-3">
                            <label for="quantity">Cantidad</label>
                            <input type="number" class="form-control" name="quantity" min="1" required>
                        </div>    

                    </div>

                    <div class="form-row">
                        
                        <div class="col-md">
                            <label for="orderDescription">Descripcion</label>
                            <input type="text" class="form-control" name="orderDescription" >        
                        </div>                           
                    </div>
                              
                    <div class="form-row">                                                
                        <div class="col-md mb-3">
                            <label for="states">Estado</label>
                            <input type="number" class="form-control" name="states" min="1" max="3" required>        
                        </div>                                                            
                        
                        <div class="col-md mb-3">
                            <label for="orderDate">Fecha Pedido</label>
                            <input type="date" class="form-control" name="orderDate" required>        
                        </div> 
                        
                        <div class="col-md mb-3">
                            <label for="shippedDate">Fecha de envio</label>
                            <input type="date" class="form-control" name="shippedDate" required>        
                        </div>                       
                    </div>
                    
                    <div class="form-row">                                                
                        <div class="col-md mb-3">
                            <label for="shippingCompany">Empresa de envio</label>
                            <input type="text" class="form-control" name="shippingCompany">        
                        </div>                                                            
                        
                        <div class="col-md mb-3">
                            <label for="priceShipping">Precio de Envio</label>
                            <input type="number" class="form-control" name="priceShipping" min="0" step="any" required>        
                        </div> 
                        
                        <div class="col-md mb-3">                            
                            <label for="supplierId">Proveedor Id</label>
                            <input type="list" list="list-supplierId" class="form-control" min="1" name="supplierId" required>
                            <datalist id="list-supplierId">
                                <c:forEach var="supplier" items="${suppliersId}">
                                    <option value="${supplier.supplierId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>                       
                    </div>

                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button class="btn btn-primary"  type="submit">Guardar</button>
                </div>


            </form>                 

        </div>
    </div>
</div>