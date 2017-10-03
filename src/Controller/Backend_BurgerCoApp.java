package Controller;

import Database.LocalSQLiteDB;

import java.io.File;

/**
 * Created by Julian on 3/10/2017.
 */
public class Backend_BurgerCoApp {

    public static void main(String[] args) {


        System.out.println("Creating Database Link");
        File database_file = new File("Burger.sqlite");
        LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

        System.out.println("Adding user to database");
        String user_fname = "Julian";
        String user_password = "test";

    }

}
