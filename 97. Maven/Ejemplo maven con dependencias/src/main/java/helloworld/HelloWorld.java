package helloworld;

import com.google.gson.Gson;


public class HelloWorld {

	public static void main(String args[]){

        Gson gson = new Gson();
        System.out.println(gson.toJson("Hello World!") );

	}

}