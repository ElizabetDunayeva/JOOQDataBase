public final class Nomenclatura {
    private int Cod_Id;
    private String Name;

    public Nomenclatura(int cod_Id, String name) {
        Cod_Id = cod_Id;
        Name = name;
    }

    public int getCod_Id() {
        return Cod_Id;
    }

    public void setCod_Id(int cod_Id) {
        Cod_Id = cod_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Nomenclatura{" +
                "Cod_Id=" + Cod_Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
