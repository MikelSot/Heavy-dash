<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            Tabla Productos
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table display nowrap table-hover" style="width:100%">
                <thead class=" table-dark">
                    <tr>
                        <th scope="col" class="table-bordered">#</th>
                        <th scope="col">id</th>
                        <th>Categoria</th>
                        <th>Descripción</th>                                
                        <th>Stado</th>
                        <th>Subcategoria</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista de empleados -->
                    <c:forEach var="category" items="${categories}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${category.categoryId}</th>
                            <td>${category.categoryName}</td>
                            <td>${category.description}</td>                                    
                            <td>${category.states}</td>
                            <td>${category.subCategory}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/CategoryServlet?action=edit&categoryId=${category.categoryId}"
                                   class="btn btn-danger">
                                    <i class="fas fa-angle-double-right"></i>
                                   <span>Editar</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- moday de confirmacion de ingresar datos, eliminar o actualizar-->
<jsp:include page="/WEB-INF/pagesInfo/categoryUtils/modayConfirm.jsp" />
<!-- ventana modal de agregar empleado -->
<jsp:include  page="/WEB-INF/pagesInfo/categoryUtils/addCategoryForm.jsp"/>
<!-- categoria, subcategoria y 3er nivel-->
<jsp:include page="/WEB-INF/pagesInfo/categoryUtils/viewCategoryPrincipal.jsp" />
<jsp:include page="/WEB-INF/pagesInfo/categoryUtils/viewSubcategory.jsp" />
<jsp:include page="/WEB-INF/pagesInfo/categoryUtils/viewThirdLevel.jsp" />



