package Trains;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;

@XmlRootElement(name = "trains")
public class Trains {
    @XmlElement(name = "train")
    private ArrayList<Train> trains = new ArrayList<>();

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void addTrain(Train train) {
       trains.add(train);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
}
