
<!DOCTYPE html>
<html>
    <head>
        <!-- etiquetas head y meta -->
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Usuario | Editar</title>
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
                        <!-- Cards de empleado -->
                        <jsp:include page="/WEB-INF/pagesInfo/userUtils/cardUser.jsp" />


                        <form action="${pageContext.request.contextPath}/UserServlet?action=update&userId=${user.userId}"  method="POST">


                            <section class="container" >
                                <div>

                                    <div class="row" >
                                        <div class="col-md-auto">
                                            <div class="card">                                                
                                                <div class="card-header">
                                                    <h4>Editar Usuario</h4>
                                                </div>
                                                <div class="modal-body">

                                                    <div class="form-row">
                                                        <div class="col-md-8 mb-2">
                                                            <label for="userName">Nombre</label>
                                                            <input type="text" class="form-control" name="userName" maxlength="120"  value="${user.userName}" required>
                                                        </div>

                                                        <div class="col-md mb-2">
                                                            <label for="userPassword">Contraseña  </label>  <i class="fas fa-eye" id="eye"></i>
                                                            <input type="password" name="userPassword" id="password" class="form-control" value="${user.userPassword}" required>                     
                                                        </div>
                                                    </div>

                                                    <div class="form-row">
                                                        <div class="col-md">
                                                            <label for="email">Email</label>
                                                            <input type="email" class="form-control"  name="email" value="${user.email}">        
                                                        </div> 
                                                    </div>    

                                                    <div class="form-row">
                                                        <div class="col-md-4 mb-3">
                                                            <label for="nickName">Alias</label>
                                                            <input type="text" class="form-control" name="nickName" value="${user.nickName}">        
                                                        </div>


                                                        <div class="col-md-4 mb-3">
                                                            <label for="active">Estado</label>
                                                            <input type="number" class="form-control" name="active" min="0" max="1" required value="${user.active}">
                                                        </div>

                                                        <div class="col-md-4 mb-3">
                                                            <label for="roleId">RoleId</label>
                                                            <input type="number" class="form-control" name="roleId" required min="1" max="3" step="any" value="${user.roleId}">
                                                        </div>

                                                    </div>



                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                    <!-- boton de elmininar o guardar -->
                                    <jsp:include page="/WEB-INF/pagesInfo/userUtils/buttonDeleteUpdate.jsp" />

                                </div>
                            </section>



                        </form>




                    </div>




                </div>



                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>
                <!-- modal pedidos que realizo el ususario-->
                <jsp:include  page="/WEB-INF/pagesInfo/userUtils/selectUserOrders.jsp"/>
                <!-- modal de talle de pedido-->
                <jsp:include  page="/WEB-INF/pagesInfo/userUtils/selectUserOrderDetails.jsp"/>
                <!-- modal pagos que realizo el usuario-->
                <jsp:include  page="/WEB-INF/pagesInfo/userUtils/selectUserPayment.jsp"/>
            </div>

        </div>



        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>


        <script>
            const password = document.getElementById("password")
            const eye = document.getElementById("eye")

            eye.addEventListener('click', () => {
                if (password.type == "password") {
                    password.type = "text"
                    setTimeout(() => {
                        password.type = "password"
                    }, 3000)
                } else {
                    password.type = "password"
                }
            })

        </script>
    </body>
</html>
