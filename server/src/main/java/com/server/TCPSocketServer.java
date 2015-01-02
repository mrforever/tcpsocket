import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
	// set the port number
	public static int portNo = 9501;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
	    // TODO Auto-generated method stub
	    ServerSocket s = new ServerSocket(portNo);
	    System.out.println("The Server is start: " + s);
	    // Blocking until there is client's connect
	    Socket socket = s.accept();
	    try{ 
	    	System.out.println("Accept the Client: " + socket);
	    	// Set the I/O hander
	    	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);                    
	    	while (true){
	            String str = in.readLine();
	            if (str.equals("byebye")){
	                break;
	            }
	            System.out.println("In Server reveived the info: " + str);
	            out.println(str);
	        }
	    } 
	    finally{
	        System.out.println("close the Server socket and the io.");
	        socket.close();
	        s.close();
	    }
	}
}
