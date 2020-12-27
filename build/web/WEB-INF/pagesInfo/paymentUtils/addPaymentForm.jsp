<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="insertPayment" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-m">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Pago</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>


                                                             
            <form action="${pageContext.request.contextPath}/PaymentServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md">
                            <label for="paymentDate">Fecha de Pago</label>
                            <input type="date" class="form-control" name="paymentDate" required>
                        </div>

                        <div class="col-md ">                            
                            <label for="userId">Usuario Id</label>
                            <input type="list" list="list-userId" class="form-control" min="1" name="userId" required>
                            <datalist id="list-userId">
                                <c:forEach var="user" items="${usersId}">
                                    <option value="${user.userId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>                              

                    </div>

                  
                    <div class="form-row">                                                
                        <div class="col-md">                            
                            <label for="orderDetailId">Detalle Pedido Id</label>
                            <input type="list" list="list-orderDetailId" class="form-control" min="1" name="orderDetailId" required>
                            <datalist id="list-orderDetailId">
                                <c:forEach var="orderDetailId" items="${orderDetailsId}">
                                    <option value="${orderDetailId.orderDetailId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>                                                            
                        
                        <div class="col-md">
                            <label for="invoiceId">Factura Id</label>
                            <input type="list" list="list-invoiceId" class="form-control" min="1" name="invoiceId" >
                            <datalist id="list-invoiceId">
                                <c:forEach var="invoicesId" items="${invoicesId}">
                                    <option value="${invoicesId.invoiceId}"></option>
                                </c:forEach>
                            </datalist>
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