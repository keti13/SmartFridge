package ge.gtu.smartfridgewebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired private Repository repo;
    public Iterable<Food> listAll(){
        return repo.findAll();
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
