interface HighVoltage{
    public void print();
}
interface LowVoltage{
    public void print();
}
class _380V implements HighVoltage{
    int voltage;
    public void print(){
        System.out.println("Напряжение 380 вольт");
    }
}
class _220V implements LowVoltage{
    int voltage;
    public void print(){
        System.out.println("Зарядка на напряжении 220 вольт");
    }
}
class Charging{
    private HighVoltage highVoltage;
    public Charging(HighVoltage highVoltage){
        this.highVoltage=highVoltage;
    }
    public void charge(){
        highVoltage.print();
    }
}

class Adatper implements HighVoltage{
    LowVoltage lowVoltage;
    public Adatper(LowVoltage lowVoltage){
        this.lowVoltage=lowVoltage;
    }
    @Override
    public void print() {
        lowVoltage.print();
    }
}
public class Main {
    public static void main(String[] args) {
        HighVoltage V380= new _380V();
        Adatper V220=new Adatper(new _220V());
        Charging charger=new Charging(V220);
        charger.charge();
    }
}
