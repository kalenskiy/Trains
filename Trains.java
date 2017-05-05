package Trains;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;

@XmlRootElement(name = "trains")
public class Trains {
    @XmlElement(name = "train")
    ArrayList<Train> trains = new ArrayList<>();


    public void addTrain(Train train) {
       trains.add(train);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
}
