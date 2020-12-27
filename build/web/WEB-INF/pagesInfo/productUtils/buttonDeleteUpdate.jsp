<section id="actions" class="py-3 bg-light">
    <div class="container">
        <div class="row">            
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Producto
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ProductServlet?action=delete&productId=${product.productId}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash-alt"></i>
                    Eliminar Producto
                </a>
            </div>
        </div>
    </div>
</section>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- modal para ver el estado y el id de la categpria-->                

<div class="modal fade" id="viewCategoryProduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos de la Categoria</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Categoria</th>                                
                            <th>Estado</th>
                        </tr>
                    </thead>                    
                    <c:forEach var="category" items="${categoryProduct}">
                        <tr>
                            <td>${category.categoryId}</td>
                            <td>${category.categoryName}</td>
                            <td>${category.states}</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>                               