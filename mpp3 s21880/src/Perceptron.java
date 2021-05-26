public class Perceptron {

    private double poziomnauczania = 0.5;
    private double wagi[];
    private double deviation = 0;
    private int correct;


    public Perceptron(int correct) {
        this.correct = correct;
    }

    public void ucz(Data data) {
        if (wagi == null)
            losujWagi(data.getInfo().length);
        int y = liczNet(data);

        aktualizujWagi(y, data);
        updateDeviation(y, data);
    }

    public void losujWagi(int count) {
        wagi = new double[count];
        for (int i = 0; i < count; i++) {
            wagi[i] = Math.random() * 1;
        }
    }

    public int liczNet(Data data) {
        double net = 0;
        for (int i = 0; i < data.getInfo().length; i++) {
            net += wagi[i] * ((double) data.getInfo()[i] / data.liczlitery);
        }
        net -= deviation;
        if (net >= 0)
            return 1;
        else
            return 0;
    }

    private void updateDeviation(int y, Data data) {
        int resault = 0;
        if (correct == data.resaultInt)
            resault = 1;
        deviation = deviation - poziomnauczania * (resault - y);
    }

    public void aktualizujWagi(int y, Data data) {
        int resault = 0;
        if (correct == data.resaultInt)
            resault = 1;
        for (int i = 0; i < data.getInfo().length; i++) {
            wagi[i] = wagi[i] + poziomnauczania * (resault - y) * data.getInfo()[i];
        }
    }
}