package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/areaB")
public class AreaBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if(session.getAttribute("corB") == "none"){
            session.setAttribute("corB", "blue");
            resp.sendRedirect("index.jsp");
        }else{
            session.setAttribute("corB", "none");
            resp.sendRedirect("index.jsp");
        }
    }
}
