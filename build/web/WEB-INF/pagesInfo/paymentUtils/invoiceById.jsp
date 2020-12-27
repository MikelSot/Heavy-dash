<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="viewInvoiceById" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title" id="exampleModalLabel">Datos de la Categoria</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Factura Id</th>
                                <th>RUC</th>
                                <th>Direccion Domicilio Fiscal</th>                                
                                <th>Razon Social</th>
                            </tr>
                        </thead>
                            <tr>
                                <th>${invoiceById.invoiceId}</th>
                                <td>${invoiceById.ruc}</td>
                                <td>${invoiceById.direccion}</td>                                    
                                <td>${invoiceById.razon}</td>
                            </tr>
                    </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>                   