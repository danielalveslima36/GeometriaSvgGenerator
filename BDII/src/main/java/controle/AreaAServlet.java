package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/areaA")
public class AreaAServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if(session.getAttribute("corA") == "none"){
            session.setAttribute("corA", "red");
            resp.sendRedirect("index.jsp");
        }else{
            session.setAttribute("corA", "none");
            resp.sendRedirect("index.jsp");
        }

    }


}
