import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer
{
    private void readRequest(Socket socket) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = "";
        while(!line.isEmpty())
        {
            line = input.readLine();
            System.out.println(line);
        }
    }

    private void sendResponse(Socket socket) throws IOException
    {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        output.write("HTTP/1.1 200 OK\n\r\n\r");
        output.flush();
    }

    public void run(int portNumber) throws IOException
    {
        ServerSocket server = new ServerSocket(portNumber);

        while (true)
        {
            Socket client = server.accept();

            readRequest(client);
            sendResponse(client);

            client.close();
        }
    }

    WebServer()
    {

    }
}
