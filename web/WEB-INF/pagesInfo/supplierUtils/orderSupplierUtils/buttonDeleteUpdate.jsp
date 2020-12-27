<section id="actions" class="py-3 bg-light">
    <div class="container">
        <div class="row">            
            <div class="col-md-4">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Pedido
                </button>
            </div>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/OrderSupplierServlet?action=delete&orderSupplierId=${orderSupplier.orderSupplierId}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash-alt"></i>
                    Eliminar Peliminar
                </a>
            </div>
        </div>
    </div>
</section