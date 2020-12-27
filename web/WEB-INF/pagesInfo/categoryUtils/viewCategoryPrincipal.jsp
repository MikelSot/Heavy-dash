<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewCategoryPrincipal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold " id="exampleModalLabel">Principales Categorias</h5>
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
                                <th scope="col">Category Id</th>
                                <th>Categoria</th>
                                <th>Descripción</th>                                
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="categoryPrincipal" items="${categoryPrincipal}" varStatus="statusNumber">

                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${categoryPrincipal.categoryId}</th>
                                    <td>${categoryPrincipal.categoryName}</td>
                                    <td>${categoryPrincipal.description}</td>                                    
                                    <td>${categoryPrincipal.states}</td>
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
