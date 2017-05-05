package Trains;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args){
        File file = new File("C:\\Users\\Dom.com\\IdeaProjects\\XMLParse\\src\\Trains\\1.xml");
        Trains trains = new Trains();
        try {
            trains = readXml(file, trains);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        trains.addTrain(new Train(3,"Kiev","Moscow", "11.11.2017", "11:00" ));
        trains.addTrain(new Train(4,"London","Kiev", "12.11.2017", "22:00" ));

        for (int i = 0; i < trains.getTrains().size(); i++) {
             int a = Integer.parseInt(trains.getTrains().get(i).getDeparture().substring(0,2));
             double b = Integer.parseInt(trains.getTrains().get(i).getDeparture().substring(3,5))*0.01;
             b += a;
             if(b >= 15 && b <= 19)
                 System.out.println(trains.getTrains().get(i).toString());
        }

        try {
            writeXml(file, trains);
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    public static Trains readXml(File file, Trains trains) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        trains = (Trains)unmarshaller.unmarshal(file);
        System.out.println(trains.toString());
        return trains;

    }
    public static void writeXml(File file, Trains trains) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(trains, file);
        marshaller.marshal(trains, System.out);

    }

}
