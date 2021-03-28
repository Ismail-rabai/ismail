package mesCommandes;

import javax.servlet.http.Cookie;

public class Identification {
	
		 static String chercheNom (Cookie [] cookies) {
			 
			 String valeur = "inconnue";
			 if (cookies != null) {
		         for (Cookie cookie : cookies) {
		             if (cookie.getName().equals("nom")) {
		            	 valeur = cookie.getValue();            	 
		             }
		         }
		     }
			 return valeur;
		}
		 
		 static String cherchemdp (Cookie [] cookies) {
			 
			
			 String valeur = "inconnue";
			 if (cookies != null) {
		         for (Cookie cookie : cookies) {
		             if (cookie.getName().equals("motdepasse")) {
		            	 valeur = cookie.getValue();            	 
		             }
		         }
		     }
			 return valeur;
		}

		public static String verifier(Cookie[] cookies) {
			// TODO Auto-generated method stub
			return null;
		}
}