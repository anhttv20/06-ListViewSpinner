package com.example.a06_listviewspinner.model;

public class Product {
    private String id,name;
    private Catalog catalog;
    public Product(){}
    public Product(Catalog catalog){
        this.catalog=catalog;
    }
    public Product(String id,String name){
        this.id=id;
        this.name=name;
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

    public Product(String id, String name, Catalog catalog){
        this.id=id;
        this.name=name;
        this.catalog=catalog;
    }
    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
    public String toString(){
        return id+" - "+name;
    }
}
