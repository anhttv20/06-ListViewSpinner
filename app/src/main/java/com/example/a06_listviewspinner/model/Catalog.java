package com.example.a06_listviewspinner.model;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String id,name;
    private List<Product> list;
    public Catalog(){
        list=new ArrayList<>();
    }
    public Catalog(String id,String name){
        this.id=id;
        this.name=name;
        list=new ArrayList<>();
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDuplicate(Product p){
        for(Product i:list){
            if(i.getId().equalsIgnoreCase(p.getId()))
                return true;
        }
        return false;
    }
    public boolean addProduct(Product p){
        boolean rt=isDuplicate(p);
        if(!rt){
            return list.add(p);
        }
        return false;
    }
    public String toString(){
        return id+"-"+name;
    }
}
