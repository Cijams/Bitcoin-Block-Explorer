import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Visits extends HttpServlet {

    private int count = 0;
    private Hashtable<String, String> table = new Hashtable<String, String>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String id = session.getId( );
        String value = table.get( id );
        System.out.println( "id = " + id + ", value = " + value );
        if ( value == null ) {
            ++count;
            table.put( id, String.valueOf( count ) );
        }

        out.print(count);
        if (count % 10 == 1 && count != 11) {
            out.print("st");
        } else if (count % 10 == 2 && count != 12) {
            out.print("nd");
        } else if (count % 10 == 3 && count != 13) {
            out.print("rd");
        } else {
            out.print("th");
        }
    }
}


