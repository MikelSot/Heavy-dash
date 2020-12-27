<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<format:setLocale value="es_PE"/> <!-- para darle formato al salario -->

<div class="d-sm-flex align-items-center justify-content-between">
    <h1 class="h1 mb-0 text-gray-800">Contenido Categoria</h1>
</div>
                        
<a
    type="button"
    class="btn btn-success mt-2 mb-4"
    href="${pageContext.request.contextPath}/CategoryServlet"
    >
    <strong class="h5"></strong>
    <i class="fas fa-arrow-left"></i>
</a>
                      
              
<button
    type="button"
    class="btn btn-primary mt-2 mb-4"
    data-toggle="modal"
    data-target="#viewProducts"
    >
    <strong class="h5">${totalProducts}</strong>
    <i class="fas fa-boxes"></i>
</button> 
    

