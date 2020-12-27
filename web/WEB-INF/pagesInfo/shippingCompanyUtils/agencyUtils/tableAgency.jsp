<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/>
<div class="modal fade" id="viewAgency" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Listado de Agencias</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table id="tableEmployee2" class="table display nowrap table-hover" style="width:100%">
                        <thead class=" table-dark">
                            <tr>
                                <th scope="col" class="table-bordered">#</th>
                                <th>Agencia Id</th>
                                <th>Direccion</th>                                
                                <th>Precio Normal</th>
                                <th>Precio Express</th>
                                <th>Dias</th>
                                <th>Distrito Id</th>
                                <th>Empresa Envio Id</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- mostramos la lista de empleados -->
                            <c:forEach var="agency" items="${agencys}" varStatus="statusNumber">
                                <tr>
                                    <td class="table-bordered">${statusNumber.count}</td>
                                    <th>${agency.agencyId}</th>
                                    <td>${agency.agencyAddess}</td>  
                                    <th><format:formatNumber value="${agency.normalPrice}" type="currency"/></th>
                                    <th><format:formatNumber value="${agency.expressPrice}" type="currency"/></th>
                                    <td>${agency.agencyDay}</td>  
                                    <td>${agency.districtId}</td>  
                                    <td>${agency.shippingCompanyId}</td> 
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