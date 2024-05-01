import java.io.IOException;

public class WebServerApplication
{
    public static void main(String[] args)
    {
        WebServer server = new WebServer();

        try
        {
            server.run(80);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}