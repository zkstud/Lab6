package pl.lublin.wsei.java.cwiczenia.test;

import pl.lublin.wsei.java.cwiczenia.MyDB;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", 3306, "mydb");
        db.setUser("root");
        db.setPassword("123456789zxc");
        Connection conn = db.getConnection();
        if(conn != null)
            System.out.println("Polaczenie z baza danych jest nawiazane");
        db.closeConnection();
        System.out.println("Polaczenie z baza zakonczone");
    }
}
