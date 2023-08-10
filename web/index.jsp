<%-- 
    Document   : index
    Created on : 14/02/2023, 8:47:26 p. m.
    Author     : julia
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.configuracion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            Conexion cn = new Conexion();
            Connection con;
            con = cn.getConexion();
        %>  
        <h1></h1>

        <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Bootstrap Example</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        </head>
        <body>




            <div class="container">
                <h2>Guardado y actualizacion de estudiantes</h2>

                <form action = "" method= "post" autocomplete="off">
                    <div class="form-group">
                        <label for="txtDocumento">Documento</label>
                        <input required type="text" class="form-control" name="txtDocumento" id="txtDocumento">
                    </div>
                    <div class="form-group">
                        <label for="txtNombre">Nombres</label>
                        <input required="" type="text" class="form-control" name="txtNombre" id="txtNombre">
                    </div>
                    <div class="form-group">
                        <label for="txtApellido">Apellido</label>
                        <input required type="text" class="form-control" name="txtApellido" id="txtApellido">
                    </div>
                    <div class="form-group">
                        <label for="txtCelular">Celular</label>
                        <input required type="text" class="form-control" name="txtCelular" id="txtCelular">
                    </div>
                    <button type ="submit" name="accion" value="guardar" class="btn btn-primary">Enviar</button>

                </form>







                <div class="container">
                    <h2>Lista de Estudiantes</h2>
                    <p>Este es el listado de estudiantes que se encuentran registrados en el Colegio</p>  
                    <input class="form-control" id="myInput" type="text" placeholder="Search..">
                    <br>
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Email</th>
                            </tr>
                        </thead>
                        <tbody id="myTable">
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                            </tr>
                            <tr>
                                <td>Mary</td>
                                <td>Moe</td>
                                <td>mary@mail.com</td>
                            </tr>
                            <tr>
                                <td>July</td>
                                <td>Dooley</td>
                                <td>july@greatstuff.com</td>
                            </tr>
                            <tr>
                                <td>Anja</td>
                                <td>Ravendale</td>
                                <td>a_r@test.com</td>
                            </tr>
                        </tbody>
                    </table>

                    <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
                </div>

                <script>
                    $(document).ready(function () {
                        $("#myInput").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#myTable tr").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                    });
                </script>

        </body>
    </html>


</body>
</html>
