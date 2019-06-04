package modelo;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Svg {

    private Geometry geometry;
    private Geometry envelope;
    private List<Coordinate> listaCoordenadas;

    public Svg(Geometry geometry){
        this.geometry = geometry;
        envelope = geometry.getEnvelope();
        listaCoordenadas = Arrays.asList(geometry.getCoordinates());
    }


    //Método que retorna a viewBox da geometria
    public String getViewBox(){
        StringBuilder builder = new StringBuilder();

        builder.append(getMenorX());
        builder.append(" ");
        builder.append(-getMaiorY());
        builder.append(" ");
        builder.append(getMaiorX()-getMenorX());
        builder.append(" ");
        builder.append(getMaiorY()-getMenorY());

        return builder.toString();
    }

    private double getMenorX() {
        return listaCoordenadas.stream()
                .min(Comparator.comparing(a->Double.valueOf(a.x)))
                .get().x;
    }

    private double getMaiorX() {
        return listaCoordenadas.stream()
                .max(Comparator.comparing(a->Double.valueOf(a.x)))
                .get().x;
    }

    private double getMenorY() {
        return listaCoordenadas.stream()
                .min(Comparator.comparing(a->Double.valueOf(a.y)))
                .get().y;
    }

    private double getMaiorY() {
        return listaCoordenadas.stream()
                .max(Comparator.comparing(a->Double.valueOf(a.y)))
                .get().y;
    }

    //Método que retorna o caminho da geometria em formato SVG
    public String getPath(){

        StringBuilder builder = new StringBuilder();

        Coordinate coordenadas[] = geometry.getCoordinates();

        if(coordenadas.length>1){
            builder.append("M");
            builder.append(coordenadas[0].x);
            builder.append(" ");
            builder.append(-coordenadas[0].y);
            builder.append(" ");
            builder.append("L");

            for(int i=1; i<coordenadas.length-1;i++){
                builder.append(coordenadas[i].x);
                builder.append(" ");
                builder.append(-coordenadas[i].y);
                builder.append(" ");
            }

            builder.append("Z");
        }

        return builder.toString();
    }

}