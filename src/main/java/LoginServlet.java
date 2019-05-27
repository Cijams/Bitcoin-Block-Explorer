import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.misc.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // do some processing here...

        // get response writer
        PrintWriter writer = response.getWriter();

        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";
        htmlRespone += "Your password is: " + password + "</h2>";
        htmlRespone += "</html>";

        String out = new Scanner(new URL("https://blockchain.info/block-height/5?format=json").openStream(), "UTF-8").useDelimiter("\\A").next();
       // System.out.println(out);

        try {
            JSONObject jo = new JSONObject();
            JSONArray ja = new JSONArray();



        } catch (Exception e) {
            e.printStackTrace();
        }


        // return response
     //   writer.println(htmlRespone);
        writer.println(out);

    }
}