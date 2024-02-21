package sn.ucad.covid19.services;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import sn.ucad.covid19.entities.Cas;
import sn.ucad.covid19.repository.ICas;

import java.util.Date;
import java.util.List;

@RestController

public class CasService {
    @Autowired
    private ICas icasrepository;
    @RequestMapping(value="/corona/cas", method=RequestMethod.GET)
    public List<Cas> getAll(){
        return icasrepository.findAll();
    }
    @RequestMapping(value="/corona/casparville", method=RequestMethod.GET)
    public List<Cas>getAllByVille(@RequestParam String ville){
        return  icasrepository.findAllByVille(ville);
    }
    @RequestMapping(value="/corona/casquartier", method=RequestMethod.GET)
     public List<Cas>getAllByQuartier(@RequestParam String quartier){
        return icasrepository.findAllByQuartier(quartier);
     }
     @RequestMapping(value ="corona/cas/save",method=RequestMethod.POST)
     public List<Cas> save(Cas cas,@RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
         cas.setDate(datecas);
        icasrepository.save(cas);
        return icasrepository.findAll();
     }
     @RequestMapping(value="/corona/cas/{id}",method=RequestMethod.DELETE)
     public List<Cas> delete(@PathVariable Long id){
        if (icasrepository.getById(id) !=null){
            icasrepository.delete(icasrepository.getById(id));
        }
        return icasrepository.findAll();
     }
    @RequestMapping(value="/corona/cas/get",method=RequestMethod.GET)
     public Cas get(@RequestParam Long id){
        return icasrepository.getById(id);
     }
      @RequestMapping(value="/corona/cas/update/{id}",method=RequestMethod.PUT)
     public List<Cas> update( @PathVariable Long id,Cas cas,@RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
        cas.setId(id);
        cas.setDate(datecas);
        icasrepository.save(cas);
        return  icasrepository.findAll();
     }
}
