<section id="actions" class="py-3 bg-light">
    <div class="container">
        <div class="row">            
            <div class="col-md-auto">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Empresa
                </button>
            </div>
            <div class="col-md-auto">
                <a href="${pageContext.request.contextPath}/ShippingCompanyServlet?action=delete&shippingCompanyId=${shippingCompany.shippingCompanyId}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash-alt"></i>
                    Eliminar Empresa
                </a>
            </div>
        </div>
    </div>
</section>