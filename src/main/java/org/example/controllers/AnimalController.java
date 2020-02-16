package org.example.controllers;

import org.example.DAO.AnimalDAO;
import org.example.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class AnimalController {

    @Autowired
    AnimalDAO dao;

    @RequestMapping("/viewAnimals")
    public String viewAnimals(Model m){
        List<Animal> list=dao.getAnimals();
        m.addAttribute("list",list);
        return "viewAnimals";
    }
    @RequestMapping("/animalForm")
    public String animalForm(Model m){
        m.addAttribute("command", new Animal());
        return "animalForm";
    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public String insert(@ModelAttribute("emp") Animal a){
        dao.insert(a);
        return "redirect:/viewAnimals";
    }

    @RequestMapping("/index")
    public String retIndex(Model m){
       // m.addAttribute("command", new Animal());
        return "../../index";
    }

    @RequestMapping(value="/editAnimal/{id}")
    public String edit(@PathVariable int id, Model m){
        Animal a = dao.getById(id);
        m.addAttribute("command",a);
        return "editForm";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") Animal a){
        dao.update(a);
        return "redirect:/viewAnimals";
    }

    @RequestMapping(value="/deleteAnimal/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewAnimals";
    }
}