package cc.hamzaelmarjani.database;

import cc.hamzaelmarjani.account.Account;
import cc.hamzaelmarjani.utils.DateUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class BankDatabase implements Iterable<Account> {
    static DateUtils date;
    public List<Account> accounts = new ArrayList<>();

    public BankDatabase() {
        date = new DateUtils();
        Collections.addAll(
                accounts,
                new Account("212583947120", "Daniel T. Havens", date.parse(2022, 12, 5, 14, 34, 24), 19410, "daniel1985"),
                new Account("212904216753", "Carol A. Rita", date.parse(2024, 9, 17, 10, 2, 12), 19410, "carol.rita2420")
        );
    }

    @Override
    public Iterator<Account> iterator() {
        return new ListIterator(this);
    }

    private static class ListIterator implements Iterator<Account> {
        private final List<Account> list;
        private int index;

        public ListIterator(BankDatabase list) {
            this.list = list.accounts;
        }

        @Override
        public boolean hasNext() {
            return index < list.toArray().length;
        }

        @Override
        public Account next() {
            return list.get(index++);
        }
    }
}
