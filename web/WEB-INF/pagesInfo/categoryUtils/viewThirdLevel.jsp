<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="viewThirdLevel" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold " id="exampleModalLabel">3<sup class="text-lowercase">er</sup> Nivel</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee4" class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th class="table-bordered">#</th>
                                <th scope="col">Categori Id</th>
                                <th>Categoria</th>
                                <th>Descripción</th>                                
                                <th>Estado</th>
                                <th>Subcategoria Id</th>                              
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="catgoryThirdLevel" items="${catgoryThirdLevel}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${catgoryThirdLevel.categoryId}</th>
                                    <td>${catgoryThirdLevel.categoryName}</td>
                                    <td>${catgoryThirdLevel.description}</td>                                    
                                    <td>${catgoryThirdLevel.states}</td>                                    
                                    <td>${catgoryThirdLevel.subCategory}</td>                                    
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
