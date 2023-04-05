package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public class GenericsImplementation {
    public static void main(String[] args) {
        Generics<String> objectString = new Generics<String>();
        objectString.add(new String[]{"Hello", "Hi"});
        System.out.println(Arrays.toString(objectString.getObjects()));
        objectString.replace("Hi","Hourav");
        System.out.println(Arrays.toString(objectString.getObjects()));

    }
}


class Generics<T>{
    private T[] objects;

    public void add(T[] str){
        this.objects =  str;
    }
    public T[] getObjects(){
        return objects;
    }
    public T getObjects(int ind){
        return objects[ind];
    }
    public void setObject(int ind,T str){
        this.objects[ind]=str;
    }

    public void replace(String find,T rep){
        for (int i=0;i<getObjects().length;i++){
            if(getObjects()[i].equals(find)){
                this.setObject(i,rep);
            }

        }
    }

}
