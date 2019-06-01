package domain.service;

import java.util.List;
import java.util.ArrayList;

import domain.parts.Motherboard;

public class MotherboardService {

    private static List<Motherboard> db = new ArrayList<Motherboard>();
    private static int currentId = 1;
    public List<Motherboard> getAll(){
        return db;
    }

    public Motherboard get(int id){
        for(Motherboard p: db){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void add (Motherboard p){
        p.setId(++currentId);
        db.add(p);
    }

    public void update (Motherboard motherboard) {
        for (Motherboard p: db){
            if (p.getId()==motherboard.getId()){
                p.setName(motherboard.getName());
                p.setPrice(motherboard.getPrice());
            }
        }
    }
}
