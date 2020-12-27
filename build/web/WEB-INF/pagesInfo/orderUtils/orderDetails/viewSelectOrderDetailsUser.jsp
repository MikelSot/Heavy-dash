<div class="modal fade" id="viewSelectOrderDetailIdUserId" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos del Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Usuario Id</th>
                            <th>Nombre</th>                                
                            <th>NickName</th>
                            <th>Email</th>
                            <th>Estado</th>
                            <th>Role Id</th>
                        </tr>
                    </thead>                    
                    <tr>
                        <td>${selectOrderDetailIdUserId.userId}</td>
                        <td>${selectOrderDetailIdUserId.userName}</td>
                        <td>${selectOrderDetailIdUserId.nickName}</td>
                        <td>${selectOrderDetailIdUserId.email}</td>
                        <td>${selectOrderDetailIdUserId.active}</td>
                        <td>${selectOrderDetailIdUserId.roleId}</td>
                    </tr>

                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/>

<div class="modal fade" id="viewSelectOrderDetailIdProduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos del Producto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table class="table display nowrap table-hover" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">Prodcuto Id</th>
                                <th>Producto</th>
                                <th>Estado</th>                                
                                <th>Precio Unitario</th>
                                <th>Stoke</th>
                                <th>Proveedor Id</th>
                                <th>Categoria Id</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- mostramos la lista de empleados -->
                            <tr>
                                <th>${selectOrderDetailIdProduct.productId}</th>
                                <td>${selectOrderDetailIdProduct.nameProduct}</td>
                                <td>${selectOrderDetailIdProduct.states}</td>       
                                <td><format:formatNumber value="${selectOrderDetailIdProduct.unitPrice}" type="currency"/></td>
                                <td>${selectOrderDetailIdProduct.stock}</td>
                                <td>${selectOrderDetailIdProduct.supplierId}</td>
                                <td>${selectOrderDetailIdProduct.categoryId}</td>
                            </tr>

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


