<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="viewSelectOrderDetailsProductoPaymentID" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">Datos del Producto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body ">
                <div class="table-responsive">
                    <table class="table display nowrap table-hover" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th>Pago_Id</th>
                                <th>Pedido_Id</th>
                                <th>Detalle_Pedido_Id</th>                                
                                <th>Cantidad</th>
                                <th>Producto_Id</th>
                                <th>Nombre_Producto</th>
                                <th>Precio_Unitario</th>
                                <th>Stock</th>
                                <th>Estado</th>
                                <th>SKU</th>
                                <th>Proveedor_Id</th>
                                <th>Categoria_Id</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <th>${selectOrderDetailsProductoPaymentID.paymentId}</th>
                                <td>${selectOrderDetailsProductoPaymentID.orderId}</td>
                                <td>${selectOrderDetailsProductoPaymentID.orderDetailId}</td>                                    
                                <td>${selectOrderDetailsProductoPaymentID.quantity}</td>
                                <td>${selectOrderDetailsProductoPaymentID.productId}</td>
                                <td>${selectOrderDetailsProductoPaymentID.nameProduct}</td>
                                <td>${selectOrderDetailsProductoPaymentID.unitPrice}</td>
                                <td>${selectOrderDetailsProductoPaymentID.stock}</td>
                                <td>${selectOrderDetailsProductoPaymentID.states}</td>
                                <td>${selectOrderDetailsProductoPaymentID.sku}</td>
                                <td>${selectOrderDetailsProductoPaymentID.supplierId}</td>
                                <td>${selectOrderDetailsProductoPaymentID.categoryId}</td>
                            </tr>
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