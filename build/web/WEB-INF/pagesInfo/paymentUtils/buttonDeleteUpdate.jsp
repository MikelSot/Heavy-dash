<section id="actions" class="py-3 bg-light">
    <div class="container">
        <div class="row">            
            <div class="col-md-2">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar
                </button>
            </div>
            <div class="col-md-2">
                <a href="${pageContext.request.contextPath}/PaymentServlet?action=delete&paymentId=${payment.paymentId}" class="btn btn-danger btn-block">
                    <i class="fas fa-trash-alt"></i>
                    Eliminar
                </a>
            </div>
        </div>
    </div>
</section>