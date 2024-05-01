import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class HttpRequest
{
    private String method;
    private String url;

    private void readClientRequest(Socket socket) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        ArrayList<String> request = new ArrayList<String>;
        String line = input.readLine();

        method = line.split(" ")[0];
    }

    HttpRequest()
    {

    }

    public String getMethod()
    {
        return method;
    }

    public String getUrl()
    {
        return url;
    }
}
