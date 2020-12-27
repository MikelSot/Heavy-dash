<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewSubcategory" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Subcategorias</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee2" class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th scope="col">Categori Id</th>
                                <th>Categoria</th>
                                <th>Descripción</th>                                
                                <th>Estado</th>
                                <th>Subcategoria Id</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                        <c:forEach var="catgorySubcategory" items="${catgorySubcategory}" varStatus="statusNumber">

                            <tr>
                                <td class="table-bordered">${statusNumber.count}</td>
                                <th>${catgorySubcategory.categoryId}</th>
                                <td>${catgorySubcategory.categoryName}</td>
                                <td>${catgorySubcategory.description}</td>                                    
                                <td>${catgorySubcategory.states}</td>
                                <td>${catgorySubcategory.subCategory}</td>
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
