package controle;

import com.sun.corba.se.impl.oa.poa.POAImpl;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import modelo.Svg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Reader;

@WebServlet("/geom")
public class GeomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String geometria1 = req.getParameter("geomA");
        String geometria2 = req.getParameter("geomB");

        WKTReader reader = new WKTReader();

        try {
            Geometry geomA = reader.read(geometria1);
            Geometry geomB = reader.read(geometria2);

            Svg geom1 = new Svg(geomA);
            Svg geom2 = new Svg(geomB);
            Svg VB = new Svg(geomA.union(geomB));

            HttpSession session = req.getSession();

            session.setAttribute("geom1", geom1.getPath());
            session.setAttribute("geom2", geom2.getPath());
            session.setAttribute("vb", VB.getViewBox());
            session.setAttribute("corA", "none");
            session.setAttribute("corB", "none");



            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
