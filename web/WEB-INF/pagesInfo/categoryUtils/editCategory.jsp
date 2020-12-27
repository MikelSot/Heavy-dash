
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Categoria | Editar</title>
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headTable.jsp" />

    </head>
    <body class="scroll sidebar-toggled">
        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- NAV -->

            <jsp:include page="/WEB-INF/pagesInfo/indexUtils/nav.jsp" />


            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column menu-collapsed">

                <div id="content">

                    <!-- barra top -->
                    <jsp:include page="/WEB-INF/pagesInfo/indexUtils/topbar.jsp" />

                    <div class="container-fluid">
                        <!-- Card categoria -->
                        <jsp:include page="/WEB-INF/pagesInfo/categoryUtils/cardCategory.jsp" />


                        <form action="${pageContext.request.contextPath}/CategoryServlet?action=update&categoryId=${category.categoryId}"  method="POST">


                            <section class="container" >
                                <div>

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Categoria</h4>
                                                </div>
                                                <div class="modal-body">


                                                    <div class="form-row">
                                                        <div class="col-md-8 mb-2">
                                                            <label for="categoryName">Nombre de Categoria</label>
                                                            <input type="text" class="form-control" name="categoryName" maxlength="120" value="${category.categoryName}" required>
                                                        </div>

                                                        <div class="col-md mb-2">
                                                            <label for="states">Estado</label>
                                                            <input type="number" class="form-control" name="states" min="0" max="1" required value="${category.states}">
                                                        </div>    

                                                    </div>

                                                    <div class="form-row">
                                                        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                                                        <div class="col-md mb-2">
                                                            <label for="subCategory">Subcategoria Id</label>                            
                                                            <input type="list" list="list-categoryId" class="form-control" min="1" name="subCategory" required value="${category.subCategory}">
                                                            <datalist id="list-categoryId">
                                                                <c:forEach var="categoryId" items="${categorysId}">
                                                                    <option value="${categoryId.categoryId}"></option>
                                                                </c:forEach>
                                                            </datalist>
                                                        </div>  

                                                        <div class="col-md-8 mb-2">
                                                            <label for="description">Descripcion</label>
                                                            <input type="text" class="form-control" name="description" value="${category.description}">        
                                                        </div>                                                                

                                                    </div>            

                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/categoryUtils/buttonDeleteUpdate.jsp" />

                                </div>
                            </section>



                        </form>




                    </div>



                    <!-- tabla de productos por categoria-->
                    <jsp:include  page="/WEB-INF/pagesInfo/categoryUtils/productBYcategory.jsp"/>
                </div>



                <!-- pie de pagin-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
            </div>

        </div>



        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>

    </body>
</html>
