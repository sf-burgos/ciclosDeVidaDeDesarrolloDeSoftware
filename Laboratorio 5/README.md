### Escuela Colombiana de Ingeniería

### Introducción a proyectos Web

### Integrantes

	 Sebastian Nieto	
	 Brayan Burgos

### Parte I. - Jugando a ser un cliente HTTP.
usando los siguientes codigos en la terminal de linux.

    telnet www.escuelaing.edu.co 80
   
    GET sssss/abc.html HTTP/1.0
   
 ¿Qué codigo de error sale?.
 
 En teoria deberia salir el error numero 404, pero en este caso no fue asi.
 
 ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?
 
 aqui se encuentra la informacion al respecto
 
 [errores de HTTP](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
 
#4. realizando una nueva conexion a telnet
	
	telnet www.httpbin.org 80
	
	GET /html HTTP/1.1
	
se obtiene como resultado, lo mismo que el host anterior, obviamente con el codigo correspondiente al url especificado

#5. luego de usar el siguiente comando.
	
 	telnet www.httpbin.org 80
	_________________________
	GEt/html HTTP/1.1
	host:www.httpbin.org
	
##Diferencias entre los comandos GET and POST 

Los metodos que se utilizan son:

1. GET
2. POST
3. PUT
4. HEAD
5. DELETE
6. PATCH
7. OPTIONS

En escencia, la diferencia entre los dos es la forma en la que envian los datos. Se puede encontrar todo lo relacionado con ello en el siguiente link:

[GET & POST](https://www.w3schools.com/tags/ref_httpmethods.asp)


#6. usando los comando de la vida practica 

	curl www.httpbin.org
	curl -v www.httpbin.org
	curl -i www.httpbin.org
	
-i : Este retorna unicamente la información del encabezado HTTP

-v : Este facilita la depuración y ayuda para visualizar datos ocultos del encabezado.

 ### Parte II. - Haciendo una aplicación Web dinámica a bajo nivel.

#1.

[creracion de proyecto maven para servicios web](http://maven.apache.org/archetypes/maven-archetype-webapp/)

ahora se toma el codigo para crear un archivo java 


    package edu.eci.cvds.servlet;

    import java.io.IOException;
    import java.io.Writer;
    import java.util.Optional;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    @WebServlet(
        urlPatterns = "/helloServlet"
    )
    public class SampleServlet extends HttpServlet{
        static final long serialVersionUID = 35L;

        @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Writer responseWriter = resp.getWriter();
           Optional<String> optName = Optional.ofNullable(req.getParameter("name"));
           String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

           resp.setStatus(HttpServletResponse.SC_OK);
           responseWriter.write("Hello" + name + "!");
           responseWriter.flush();
       }
    }

#2. Modificando el pom.xml
    
    <dependency>
     <groupId>javax</groupId>
     <artifactId>javaee-web-api</artifactId>
     <version>7.0</version>
     <scope>provided</scope>
    </dependency>
    
y se agrega al final de tag project

    <build>
    <plugins>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-compiler-plugin</artifactId>
           <version>3.8.0</version>
           <configuration>
               <source>1.8</source>
               <target>1.8</target>
           </configuration>
       </plugin>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-war-plugin</artifactId>
           <version>2.3</version>
           <configuration>
               <failOnMissingWebXml>false</failOnMissingWebXml>
           </configuration>
       </plugin>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-dependency-plugin</artifactId>
           <version>2.6</version>
           <executions>
               <execution>
                   <phase>validate</phase>
                   <goals>
                       <goal>copy</goal>
                   </goals>
                   <configuration>
                       <silent>true</silent>
                       <artifactItems>
                           <artifactItem>
                               <groupId>javax</groupId>
                               <artifactId>javaee-endorsed-api</artifactId>
                               <version>7.0</version>
                               <type>jar</type>
                           </artifactItem>
                       </artifactItems>
                   </configuration>
               </execution>
           </executions>
       </plugin>

       <!-- Tomcat embedded plugin. -->
       <plugin>
           <groupId>org.apache.tomcat.maven</groupId>
           <artifactId>tomcat7-maven-plugin</artifactId>
           <version>2.2</version>
           <configuration>
               <port>8080</port>
               <path>/</path>
           </configuration>
       </plugin>
    </plugins>
    </build>

#3. se revisa el servidor tomcat y esta en condiciones

#4. 
 
    mvn package
    mvn tomcat7:run
#5. 

    localhost:8080/helloservlet

#6.
 
    localhost:8080/helloservlet?name=" developers"
    
#7.

[repositorio maven](https://mvnrepository.com/artifact/com.google.code.gson/gson)

tomando de la pagina la depedencia 2.8.6, se copia y pega en el pom

#8.

[direccion de numeros al final del path](https://jsonplaceholder.typicode.com/todos/1)

se cambian varios numeros como 1,2,100,100, 1816513

#9 añadiendo la clase Todo.

añadir el codigo !!!!RECUERDE!!!!

#10.

    package edu.eci.cvds.servlet;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.net.URLConnection;
    import java.util.List;

    import com.google.gson.Gson;

    import edu.eci.cvds.servlet.model.Todo;

	public class Service {

	   public static Todo getTodo(int id) throws MalformedURLException, IOException {
	       URL urldemo = new URL("https://jsonplaceholder.typicode.com/todos/" + id);
	       URLConnection yc = urldemo.openConnection();
	       BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	       Gson gson = new Gson();
	       Todo todo = gson.fromJson(in, Todo.class);
	       in.close();
	       return todo;
	   }

	   private static String todoToHTMLRow(Todo todo) {
	       return new StringBuilder("<tr>")
		   .append("<td>")
		   .append(todo.getUserId())
		   .append("</td><td>")
		   .append(todo.getId())
		   .append("</td><td>")
		   .append(todo.getTitle())
		   .append("</td><td>")
		   .append(todo.getCompleted())
		   .append("</td>")
		   .append("</tr>")
		   .toString();
	   }

	   public static String todosToHTMLTable(List<Todo> todoList) {
	       StringBuilder stringBuilder = new StringBuilder("<table>")
		   .append("<tr>")
		   .append("<th>User Id</th>")
		   .append("<th>Id</th>")
		   .append("<th>Title</th>")
		   .append("<th>Completed</th>")
		   .append("</tr>");

       for (Todo todo : todoList) {
           stringBuilder.append(todoToHTMLRow(todo));
       }

       return stringBuilder.append("</table>").toString();
    }
    }

#11: usar la superclase y el metodo doGet

#12: agregar el metodo WebServlet y cambiar el nombre por el metodo apropiado, en este caso es "laHeredera"

	@WebServlet(
	    urlPatterns = "/laHeredada"
	)
     public class LaHeredera extends HttpServlet {
	static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    }
    
#13. Se usa el siguiente codigo.

       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       ArrayList<Todo> lis = new ArrayList<Todo>();
       Todo t;
       int temp;
       try {
	       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
	       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : null;
	       temp = Integer.parseInt(id);
	       t = Service.getTodo(temp);
	       lis.add(t);	
	       resp.setStatus(HttpServletResponse.SC_OK);
	       responseWriter.write(Service.todosToHTMLTable(lis));
       }catch(FileNotFoundException e){
           resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
       }catch(NumberFormatException e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }catch(Exception e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       } 
       responseWriter.flush();
   }	

#14. se uso el siguiente comando:

	mvn tomcat7:run
	
#15. Luego para probar en una pagina web usamos el siguiente comando(el numero del id lo cambiamos para poder hace las pruebas):

	http://localhost:8080/laHeredada?id=200
	
### Parte III

#16 El codigo quedaria de la siguiente manera:

       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
       Writer responseWriter = resp.getWriter();
       ArrayList<Todo> lis = new ArrayList<Todo>();
       Todo t;
       int temp;
       try {
	       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
	       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : null;
	       temp = Integer.parseInt(id);
	       t = Service.getTodo(temp);
	       lis.add(t);	
	       resp.setStatus(HttpServletResponse.SC_OK);
	       responseWriter.write(Service.todosToHTMLTable(lis));
       }catch(FileNotFoundException e){
           resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
       }catch(NumberFormatException e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }catch(Exception e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       } 
       responseWriter.flush();
   }

#20. Cuando se usa el metodo post, se puede ver que el recuadro de mensaje tiene mas opciones, cosa que no muestra el get, podriamos decir que el get oculta informacion.

#21. servive  simplemente emsambla la parte logica con el host por medio de los metodos que se encuentran en la clase service.

### Parte III

#1. Para ver las dependecias, acceda al pom.xml

#2. en el archivo web de tipo html se muestran los resultados.

#3. Se necesitan para el nombre del serivicio, el mapping y la lista de bienvenida 



