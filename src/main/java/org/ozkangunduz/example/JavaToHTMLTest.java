package org.ozkangunduz.example;

import org.ozkangunduz.JavaToHTML;

import java.util.List;

public class JavaToHTMLTest {

    public static void main(String[] args) {
        Account account1 = new Account("John", 11);
        Account account2 = new Account("Doe", 56);
        List<Account> accounts = List.of(account1, account2);

        String htmlTable = JavaToHTML.toHTMLTable(accounts);
        System.out.println(htmlTable);
    }
}
