package example;

import example.db.AccountRepository;
import example.db.impl.PostgresAccountRepository;
import example.service.Application;


public class Main {

    static AccountRepository accountRepository = new PostgresAccountRepository();

    public static void main(String[] args) {
        new Application().run();
    }
}
