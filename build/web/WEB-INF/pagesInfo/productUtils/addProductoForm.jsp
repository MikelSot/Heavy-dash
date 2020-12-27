<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="insertProduct" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-m">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Producto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/ProductServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-8 mb-2">
                            <label for="nameProduct">Nombre de Producto</label>
                            <input type="text" class="form-control" name="nameProduct" maxlength="120" required>
                        </div>

                        <div class="col-md mb-2">
                            <label for="sku">SKU</label>
                            <input type="text" class="form-control" name="sku"  maxlength="10"  required>                     
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="measure">Medida</label>
                            <input type="text" class="form-control" name="measure" maxlength="30">        
                        </div>


                        <div class="col-md-4 mb-3">
                            <label for="states">Estado</label>
                            <input type="number" class="form-control" name="states" min="0" max="1" required>
                        </div>

                        <div class="col-md-4 mb-3">
                            <label for="unitPrice">Precio Unitario</label>
                            <input type="number" class="form-control" name="unitPrice" required min="1" step="any">
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="supplierId">Proveedor Id</label>
                            <input type="list" list="list-supplierId" class="form-control" min="1" name="supplierId" required>
                            <datalist id="list-supplierId">
                                <c:forEach var="supplierId" items="${suppliersId}">
                                    <option value="${supplierId.supplierId}"></option>
                                </c:forEach>
                            </datalist>
                        </div> 

                        <div class="col-md-4 mb-3">
                            <label for="categoryId">Categoria Id</label>
                            <input type="list" list="list-categoryId" class="form-control" min="1" name="categoryId" required>
                            <datalist id="list-categoryId">
                                <c:forEach var="categoryId" items="${categorysId}">
                                    <option value="${categoryId.categoryId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>     
                        <div class="col-md-4 mb-3">
                            <label for="stock">Stock</label>
                            <input type="number" class="form-control" name="stock" min="0" required>                     
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