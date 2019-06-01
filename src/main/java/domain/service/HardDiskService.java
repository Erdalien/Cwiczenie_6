package domain.service;

import java.util.List;
import java.util.ArrayList;

import domain.parts.HardDisk;

public class HardDiskService {

    private static List<HardDisk> db = new ArrayList<HardDisk>();
    private static int currentId = 1;
    public List<HardDisk> getAll(){
        return db;
    }

    public HardDisk get(int id){
        for(HardDisk p: db){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void add (HardDisk p){
        p.setId(++currentId);
        db.add(p);
    }

    public void update (HardDisk hardDisk) {
        for (HardDisk p: db){
            if (p.getId()== hardDisk.getId()){
                p.setName(hardDisk.getName());
                p.setPrice(hardDisk.getPrice());
                p.setCapacity(hardDisk.getCapacity());
            }
        }
    }
}
