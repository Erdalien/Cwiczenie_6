package domain.service;

import domain.parts.RAMMemory;

import java.util.ArrayList;
import java.util.List;

public class RAMMemoryService {

    private static List<RAMMemory> db = new ArrayList<RAMMemory>();
    private static int currentId = 1;
    public List<RAMMemory> getAll(){
        return db;
    }

    public RAMMemory get(int id){
        for(RAMMemory p: db){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void add (RAMMemory p){
        p.setId(++currentId);
        db.add(p);
    }

    public void update (RAMMemory ramMemory) {
        for (RAMMemory p: db){
            if (p.getId()==ramMemory.getId()){
                p.setName(ramMemory.getName());
                p.setPrice(ramMemory.getPrice());
                p.setRam(ramMemory.getRam());
            }
        }
    }
}
