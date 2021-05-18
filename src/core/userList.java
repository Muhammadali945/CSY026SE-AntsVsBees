package core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Muhammad
 * This class saves all the users created by the user class. It has function to save and return users from a binary file
 * The name of file is "userList.dat"
 */
public class userList implements Serializable {


    private static final long serialVersionUID = 1L;

    private List<user> userList;
    //Class constructor

    public userList() {
        userList = new ArrayList<user>();
    }

    public List<user> getUser() {
        return userList;
    }
    //return user on a specified index
    public user showUser(int i) {
        return userList.get(i);
    }

    public void addUser(user u) {
        userList.add(u);
    }
    //add multiple user to the list
    public void addMultipleUser(userList lst) {
        lst.getUser().forEach(user -> {
            userList.add(user);
        });
    }
    //remove user at a specified index i
    public void removeUser (int i){ userList.remove(i);}

    public int getSize() {
        return this.userList.size();
    }

    public void setUserList(List<user> userList) {
        this.userList = userList;
    }
    // Write the user list to a file named userList.dat
    public static void writeToFile(userList list) throws IOException {
        String filename = "userList.dat";
        // Create the stream objects.
        try {
            FileOutputStream outStream =
                    new FileOutputStream(filename);
            ObjectOutputStream objectOutputFile =
                    new ObjectOutputStream(outStream);

            // Write the serialized object to the file.
            objectOutputFile.writeObject(list);

            // Close the file.
            objectOutputFile.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("The serialized objects " +
                "were written to "+filename);
    }
    //// Read the user list from a file named userList.dat
    public static userList readUserList() throws IOException, ClassNotFoundException {
        String filename = "userList.dat";
        userList list = new userList();
        try
        {
            File f = new File(filename);
            FileInputStream inStream;
            ObjectInputStream objectInputFile = null;
            if (f.exists()) {
                inStream = new FileInputStream(filename);
                objectInputFile = new ObjectInputStream(inStream);
            }
            else {
                System.out.println("File " + filename + " does not exist");
                return list;
            }

            if (f.length() > 0) {
                // Read the serialized objects from the file.
                list = (userList) objectInputFile.readObject();

                System.out.println("read object");

                // Close the file.
                objectInputFile.close();
            } else
                System.out.println("File " + filename + " is empty");

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        System.out.println("list size: "+list.getSize());
        return list;
    }


}