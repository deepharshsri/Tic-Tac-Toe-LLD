package com.deepansh.tic_tac_toe;


public class User {
    

    String id;
    String name;
    Symbol symbol;
    
    User(String id,String name) {
        this.id = id;
        this.name = name;
        
    }

    //getter and setter methods for id, name, and symbol can be added here if needed.

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setUserSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
