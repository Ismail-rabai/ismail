package mesCommandes;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscriptionClient extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String nomRecu=null, motPasseRecu=null; 
 String nomCookie=null, motPasseCookie=null;
 String nom = null;
 
 nomRecu = request.getParameter("nom");
 motPasseRecu = request.getParameter("motdepasse");
 Cookie[] mesCookies = request.getCookies();
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 if (mesCookies != null)
 { 
	nomCookie = Identification.chercheNom(mesCookies);
	motPasseCookie = Identification.cherchemdp(mesCookies);
	
 }
 
 if (nomCookie==null && nomRecu==null){ 
 // Cas 1 : cas où il n'y a ni de cookies ni de parametres
 out.println("<html>");
 out.println("<body>");
 out.println("<head>"); 
 out.println("<title> inscription d'un client </title>");
 out.println("</head>");
 out.println("<body bgcolor='white' >"); 
 out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
 out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
 out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>"); 

 out.print(" <form action='sinscrire' method='GET' > ");
 out.println("nom");
 out.println("<input type='text' size='20' name='nom' >");
 out.println("<br>");
 out.println("mot de passe");
 out.println("<input type='password' size='20' name='motdepasse'> <br>");
 out.println("<input type='submit' value='inscription'>");
 out.println("</form>"); 
 out.println("</body>");
 out.println("</html>");
 } else if (nomCookie==null && nomRecu!=null){
 
 // Cas 2 : cas où il n'y a pas de cookies mais les paramètres nom et mot de passes sont présents : 
	 out.println("<html>");
	 out.println("<body>");
	 out.println("<head>"); 
	 out.println("<title> inscription d'un client </title>");
	 out.println("</head>");
	 out.println("<body bgcolor='white' >"); 
	 out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
	 out.println("<h3>" + "Identifier vous " + "</h3>");
	 out.print(" <form action='sinscrire' method='GET' > ");
	 out.println("nom");
	 out.println("<input type='text' size='20' name='nom' >");
	 out.println("<br>");
	 out.println("mot de passe");
	 out.println("<input type='password' size='20' name='motdepasse'> <br>");
	 out.println("<input type='submit' value='sidentifier'>");
	 out.println("</form>"); 
	 out.println("</body>");
	 out.println("</html>");
	 Cookie MonCookie = new Cookie("nom", nomRecu);
	 response.addCookie(MonCookie);
	 Cookie MonCookie2 = new Cookie("motdepasse", motPasseRecu);
	 response.addCookie(MonCookie2);
	
 }
 else if ((identique(nomRecu,nomCookie) && identique(motPasseRecu,motPasseCookie)) 
) 
 {

	 RequestDispatcher rp = request.getRequestDispatcher("achat");
	 rp.forward(request, response);



 
 } 
 else {
 
	 out.println("<html>");
     out.println("<body>");
     out.println("<head>");
     out.println("<title> inscription d'un client </title>");
     out.println("</head>");
     out.println("<body bgcolor='white' >");
     out.println( nomCookie +" | "+ motPasseCookie  );
     out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
     out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>"); 
     out.print(" <form action='sinscrire' method='GET' > ");
     out.println("nom");
     out.println("<input type='text' size='20' name='nom' >");
     out.println("<br>");
     out.println("mot de passe");
     out.println("<input type='password' size='20' name='motdepasse'> <br>");
     out.println("<input type='submit' value='Sidentifier'>");
     out.println("</form>");
     out.println("</body>");
     out.println("</html>");

 }
 
 
 
 }
 
 public void doPost(HttpServletRequest request,
 HttpServletResponse response)
 throws IOException, ServletException
 { 
	 
 doGet(request, response);
 }
 boolean identique (String recu, String cookie) {
 return ((recu != null) && (recu.length() >3) && (cookie != null) && (recu.equals(cookie) ));
 }
}