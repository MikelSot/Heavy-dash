<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="insertCategory" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-m">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Producto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/CategoryServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-8 mb-2">
                            <label for="categoryName">Nombre de Categoria</label>
                            <input type="text" class="form-control" name="categoryName" maxlength="120" required>
                        </div>

                        <div class="col-md mb-2">
                            <label for="states">Estado</label>
                            <input type="number" class="form-control" name="states" min="0" max="1" required>
                        </div>    

                    </div>

                    <div class="form-row">
                        <div class="col-md mb-2">
                            <label for="subCategory">Subcategoria Id</label>                            
                            <input type="list" list="list-categoryId" class="form-control" min="1" name="subCategory" required>
                            <datalist id="list-categoryId">
                                <c:forEach var="categoryId" items="${categorysId}">
                                    <option value="${categoryId.categoryId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>  
                        
                        <div class="col-md-8 mb-2">
                            <label for="description">Descripcion</label>
                            <input type="text" class="form-control" name="description">        
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