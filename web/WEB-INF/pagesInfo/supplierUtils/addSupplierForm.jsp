
<div class="modal fade" id="insertSupplier" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="staticBackdropLabel">Agregar Producto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <form action="${pageContext.request.contextPath}/SupplierServlet?action=insert"  method="POST">
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-8 mb-2">
                            <label for="nameCompany">Nombre Empresa</label>
                            <input type="text" class="form-control" name="nameCompany" maxlength="120" required>
                        </div>

                        <div class="col-md mb-2">
                            <label for="contanctName">Representante</label>
                            <input type="text" class="form-control" name="contanctName" required>
                        </div>    

                    </div>

                    <div class="form-row">
                        
                        <div class="col-md mb-3">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" required placeholder="pepito@gmail.com">        
                        </div>    
                        
                        <div class="col-md mb-3">
                            <label for="supplierAddress">Direccion</label>
                            <input type="text" class="form-control" name="supplierAddress" required>        
                        </div>                                                                
                        
                        <div class="col-md mb-3">
                            <label for="typeGoods">Tipo de bienes</label>
                            <input type="text" class="form-control" name="typeGoods" required>        
                        </div> 
                    </div>
                              
                    <div class="form-row">                                                
                        <div class="col-md mb-4">
                            <label for="postalCode">Codigo Postal</label>
                            <input type="text" class="form-control" name="postalCode" maxlength="5" required>        
                        </div>                                                            
                        
                        <div class="col-md mb-4">
                            <label for="city">Ciudad</label>
                            <input type="text" class="form-control" name="city">        
                        </div> 
                        
                        <div class="col-md mb-4">
                            <label for="country">País</label>
                            <input type="text" class="form-control" name="country" required>        
                        </div> 
                        
                        <div class="col-md mb-4">
                            <label for="states">Estado</label>
                            <input type="number" class="form-control" name="states" min="0" max="1" required>        
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