<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="insertOrder" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Pedido</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/OrderServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">                                                
                        <div div class="col-md mb-3">
                            <label for="name">Nombre Cliente</label>
                            <input type="text" class="form-control" name="name" maxlength="100" required>
                        </div>

                        <div div class="col-md mb-3">
                            <label for="lastName">Apellido</label>
                            <input type="text" class="form-control"  name="lastName" required>
                        </div>

                        <div class="col-md mb-3">
                            <label for="dni">Dni</label>
                            <input type="text" class="form-control" name="dni" pattern="[0-9]+" maxlength="8" required>        
                        </div>

                    </div>

                    <div class="form-row">

                        <div class="col-md-3 mb-3">
                            <label for="orderDate">Fecha Pedido</label>
                            <input type="date" class="form-control" name="orderDate" required>
                        </div>

                        <div class="col-md-3 mb-3">
                            <label for="shippingDate">Fecha Envio</label>
                            <input type="date" class="form-control" name="shippingDate" required>                     
                        </div>

                        <div class="col-md mb-3">
                            <label for="orderAdderss">Direccion</label>
                            <input type="text" class="form-control" name="orderAdderss"  required>                     
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md mb-4">
                            <label for="reference">Referencia(opcional)</label>
                            <input type="text" class="form-control" name="reference" >        
                        </div>


                        <div div class="col-md mb-4">
                            <label for="lot">Lote</label>
                            <input type="number" class="form-control" name="lot" min="1" required>
                        </div>

                        <div class="col-md mb-4">
                            <label for="states">Estado</label>
                            <input type="number" class="form-control" name="states" min="0" max="1" required>        
                        </div>

                        <div class="col-md mb-4">
                            <label for="typeAddress">Tipo de direccion Id</label>
                            <input type="number" class="form-control" name="typeAddress" min="1" max="10" required>        
                        </div>

                    </div>

                    <div class="form-row">

                        <div class="col-md mb-4">
                            <label for="districtId">Distrito Id</label>
                            <input type="number" class="form-control" name="districtId"  min="1" max="165" required>                     
                        </div>

                        <div class="col-md mb-4">
                            <label for="employeeId">Empleado Id</label>
                            <input type="list" list="list-employeeId" class="form-control" min="1" name="employeeId">
                            <datalist id="list-employeeId">
                                <c:forEach var="employee" items="${employeesId}">
                                    <option value="${employee.employeeId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>

                        <div class="col-md mb-4">
                            <label for="shippingComanyId">Empresa Envio Id</label>
                            <input type="list" list="list-shippingComanyId" class="form-control" min="1" name="shippingComanyId">
                            <datalist id="list-shippingComanyId">
                                <c:forEach var="shippingComany" items="${shippingCompanysId}">
                                    <option value="${shippingComany.shippingCompanyId}"></option>
                                </c:forEach>
                            </datalist>
                        </div>

                        <div class="col mb-4" >
                            <label for="userId">Usuario Id</label>
                            <input type="list" list="list-userId" class="form-control" min="1" name="userId" required>
                            <datalist id="list-userId">
                                <c:forEach var="userId" items="${userIds}">
                                    <option value="${userId.userId}"></option>
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