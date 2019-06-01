package domain.service;

import java.util.List;
import java.util.ArrayList;

import domain.parts.GraphicCard;

public class GraphicCardService {

    private static List<GraphicCard> db = new ArrayList<GraphicCard>();
    private static int currentId = 1;
    public List<GraphicCard> getAll(){
        return db;
    }

    public GraphicCard get(int id){
        for(GraphicCard p: db){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void add (GraphicCard p){
        p.setId(++currentId);
        db.add(p);
    }

    public void update (GraphicCard graphicCard) {
        for (GraphicCard p: db){
            if (p.getId()==graphicCard.getId()){
                p.setName(graphicCard.getName());
                        p.setPrice(graphicCard.getPrice());
                                p.setRam(graphicCard.getRam());
            }
        }
    }

}
