
<section id="actions" class="py-3 bg-light">
    <div class="container">
        <div class="row">            
            <div class="col">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Empleado
                </button>
            </div>
            <div class="col">
                <a href="${pageContext.request.contextPath}/EmployeeServlet?accion=delete&employeeId=${employee.employeeId}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash-alt"></i>
                    Eliminar Empleado
                </a>
            </div>
        </div>
    </div>
</section>
                   

