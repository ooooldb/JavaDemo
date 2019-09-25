package com.xiayu.java.designpatterns.composite;

import java.util.ArrayList;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class Composite extends Component {
    private ArrayList<Component> componentArrayList=new ArrayList<>();

    public void add(Component component){
        componentArrayList.add(component);
    }
    public void remove(Component component){
        componentArrayList.remove(component);
    }
    public ArrayList<Component> getChildren(){
        return componentArrayList;
    }
}
