import java.time.LocalDate;

public final class Invoice {
    private int Number;
    private LocalDate Date_Of;
    private int Organization_ID;


    public Invoice(int number, LocalDate date_Of, int organization_ID) {
        Number = number;
        Date_Of = date_Of;
        Organization_ID = organization_ID;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public LocalDate getDate_Of() {
        return Date_Of;
    }

    public void setDate_Of(LocalDate date_Of) {
        Date_Of = date_Of;
    }

    public int getOrganization_ID() {
        return Organization_ID;
    }

    public void setOrganization_ID(int organization_ID) {
        Organization_ID = organization_ID;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "Number=" + Number +
                ", Date_Of=" + Date_Of +
                ", Organization_ID=" + Organization_ID +
                '}';
    }
}
