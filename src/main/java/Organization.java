public final class Organization {
    private int INN;
    private int Account;
    private String Name;



    public Organization(int INN, int account, String name) {
        this.INN = INN;
        Account = account;
        Name = name;
    }



    public int getINN() {
        return INN;
    }

    public void setINN(int INN) {
        this.INN = INN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAccount() {
        return Account;
    }

    public void setAccount(int account) {
        Account = account;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "INN=" + INN +
                ", Name='" + Name + '\'' +
                ", Account=" + Account +
                '}';
    }
}
