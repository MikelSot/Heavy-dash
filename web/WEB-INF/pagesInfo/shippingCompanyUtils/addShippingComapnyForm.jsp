
<div class="modal fade" id="insertShippingComapny" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-m">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Empresa de Envio</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/ShippingCompanyServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-8 mb-2">
                            <label for="companyName">Nombre Empresa</label>
                            <input type="text" class="form-control" name="companyName" maxlength="120" required>
                        </div>

                        <div class="col-md mb-2">
                            <label for="contactName">Representante</label>
                            <input type="text" class="form-control" name="contactName" required>
                        </div>    

                    </div>

                    <div class="form-row">
                        
                        <div class="col-md-6 mb-2">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" required placeholder="pepito@gmail.com">        
                        </div>    
                        
                        <div class="col-md mb-2">
                            <label for="companyAddres">Direccion</label>
                            <input type="text" class="form-control" name="companyAddres" required>        
                        </div>                                                                
                        
                    </div>
                              
                    <div class="form-row">                                                
                        <div class="col-md mb-2">
                            <label for="postalCode">Codigo Postal</label>
                            <input type="text" class="form-control" name="postalCode" maxlength="5" required>        
                        </div>                                                            
                        
                        <div class="col-md mb-2">
                            <label for="active">Estado</label>
                            <input type="number" class="form-control" name="active" min="0" max="1">        
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