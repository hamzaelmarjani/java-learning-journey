package cc.hamzaelmarjani.database;

import cc.hamzaelmarjani.account.Account;
import cc.hamzaelmarjani.utils.DateUtils;

public class BankDatabase {
    static DateUtils date;
    public Account[] accounts;

    public BankDatabase() {

        date = new DateUtils();
        accounts = new Account[]{
                new Account("212583947120", "Daniel T. Havens", date.parse(2022, 12, 5, 14, 34, 24), 19410, "daniel1985"),
                new Account("212904216753", "Carol A. Rita", date.parse(2024, 9, 17, 10, 2, 12), 19410, "carol.rita2420"),
        };
    }
}
