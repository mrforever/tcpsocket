import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSocketClient {
    static String clientName = "Mike";
    // set the port number
    public static int portNo = 9501;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
        // Set the connect address, connect with localhost
        InetAddress addr = InetAddress.getByName("127.0.0.1");        
        // Keep the port number same with server
        Socket socket = new Socket(addr, portNo);
        try{
            System.out.println("socket = " + socket);
	    // Set the I/O hander
    	    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println("Hello Server,I am " + clientName);
            String str = in.readLine();
            System.out.println(str);
            out.println("byebye");
        }
        finally{
       	    System.out.println("close the Client socket and the io.");
            socket.close();
        }
    }
}
