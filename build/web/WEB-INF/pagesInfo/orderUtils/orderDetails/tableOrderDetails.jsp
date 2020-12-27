<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            Tabla Usuarios
        </h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table display nowrap table-hover" style="width:100%">
                <thead class=" table-dark">
                    <tr>
                        <th scope="col" class="table-bordered">#</th>
                        <th scope="col">id</th>
                        <th>Pedido Id</th>
                        <th>Producto Id</th>
                        <th>Cantidad</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- mostramos la lista detalle pedido-->
                    <c:forEach var="orderDetail" items="${orderDetails}" varStatus="statusNumber">
                        <tr>
                            <td class="table-bordered">${statusNumber.count}</td>
                            <th>${orderDetail.orderDetailId}</th>
                            <td>${orderDetail.orderId}</td>
                            <td>${orderDetail.productId}</td>
                            <td>${orderDetail.quantity}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/OrderDetailsServlet?action=edit&orderDetailId=${orderDetail.orderDetailId}"
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


<!-- ventana modal de agregar empleado -->
<jsp:include  page="/WEB-INF/pagesInfo/orderUtils/orderDetails/addOrderDetailsForm.jsp"/>
<jsp:include page="/WEB-INF/pagesInfo/orderUtils/orderDetails/modayConfirm.jsp"/>
