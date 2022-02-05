public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;
    private int currentYear = 2021;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        if(hireYear<2021)
            this.hireYear = hireYear;
        else
            this.hireYear=this.currentYear;
    }

    /*
     * Maaşa uygulanan vergiyi hesaplar.
     */
    public double tax() {
        if (this.salary > 1000)
            return this.salary * 0.03;
        else
            return 0;
    }

    /*
     * Haftalık çalışma saati 40 saatin üzerindeyse
     * fazladan çalıştığı her saat için bonus ücret hesabı.
     */
    public int bonus() {
        if (this.workHours > 40) {
            int bonus = (workHours - 40) * 30;
            return bonus;
        }
        else {
            return 0;
        }
    }

    /*
     * Çalışanın işe başlangıç yılına
     * göre maaş artışını hesaplar.
     */
    public double raiseSalary(){
        int year=currentYear-this.hireYear;
        if(year<10){
            return this.salary*0.05;
        }
        if(year>9 && year<20){
            return this.salary*0.10;
        }
        if(year>19){
            return this.salary*0.15;
        }
        return 0;

    }

    @Override
    public String toString() {
        String text = " Çalışan Bilgileri : \n" +
                " Adı =  " +this.name+
                "\n Maaşı = " + this.salary +
                "\n Çalışma Saati = " + this.workHours +
                "\n Başlangıç Yılı = " + this.hireYear +
                "\n Vergi = " + tax() +
                "\n Bonus = " + bonus() +
                "\n Maaş Artışı = " + raiseSalary() +
                "\n Vergi ve Bonuslar İle Maaş = " + (this.salary+bonus()-tax())+
                "\n Toplam Maaş = " + (this.salary+bonus()+raiseSalary()-tax());

        return text;
    }
}
