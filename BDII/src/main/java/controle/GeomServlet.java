package controle;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import modelo.Svg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/geom")
public class GeomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String geometria1 = req.getParameter("geomA");
        String geometria2 = req.getParameter("geomB");

        WKTReader reader = new WKTReader();

        try {
            Svg geom1 = new Svg(reader.read(geometria1));
            Svg geom2 = new Svg(reader.read(geometria2));
            Svg VB = new Svg(reader.read(geometria1).union(reader.read(geometria2)));

            req.setAttribute("geom1", geom1.getPath());
            req.setAttribute("geom2", geom2.getPath());
            req.setAttribute("vb", VB.getViewBox());
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
