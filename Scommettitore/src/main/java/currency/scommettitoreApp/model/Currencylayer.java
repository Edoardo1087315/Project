package currency.scommettitoreApp.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Currencylayer {

	
	
	public static Vector<ApiParsing> getJson(String url[]) throws MalformedURLException, IOException {
		
		Vector<ApiParsing> p = new Vector<ApiParsing>();
		for(int i =0; i<=Data.getPeriodo(); i++) {
		URLConnection openConnection = new URL(url[i]).openConnection();
		InputStream in = openConnection.getInputStream();
		
		 String data = "";
		 String line = "";
		 try {
		   InputStreamReader inR = new InputStreamReader( in );
		   BufferedReader buf = new BufferedReader( inR );
		  
		   while ( ( line = buf.readLine() ) != null ) {
			   data+= line;
		   }
		 } finally {
		   in.close();
		 }
		 
		 ObjectMapper obj = new ObjectMapper();
		 p.add(obj.readValue(data,ApiParsing.class));
		}
		 return p;
	
	}
	public static ApiParsing getJson(String url) throws MalformedURLException, IOException {
		
		ApiParsing p = new ApiParsing();
		URLConnection openConnection = new URL(url).openConnection();
		InputStream in = openConnection.getInputStream();
		
		 String data = "";
		 String line = "";
		 try {
		   InputStreamReader inR = new InputStreamReader( in );
		   BufferedReader buf = new BufferedReader( inR );
		  
		   while ( ( line = buf.readLine() ) != null ) {
			   data+= line;
		   }
		 } finally {
		   in.close();
		 }
		 
		 ObjectMapper obj = new ObjectMapper();
		 p = obj.readValue(data,ApiParsing.class);
		
		 return p;
	
	}

}
