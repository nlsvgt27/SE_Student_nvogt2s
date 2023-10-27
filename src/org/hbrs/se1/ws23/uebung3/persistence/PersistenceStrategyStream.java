package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung2.Member.Member;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException  {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(location))){
            out.writeObject(member);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new PersistenceException(PersistenceException.ExceptionType.NO_FILE_FOUND, "Fehler beim abspeichern");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        ArrayList<E> list = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(location))){
            list = (ArrayList<E>) in.readObject();
            in.close();
            return list;
        } catch (Exception e) {
            throw new PersistenceException(PersistenceException.ExceptionType.NO_FILE_FOUND, "Fehler beim abspeichern");
        }
    }
}
