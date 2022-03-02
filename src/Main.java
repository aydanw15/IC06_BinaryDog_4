import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String name, breed;
        int age, count = 0;

        Dog[] dogPound = new Dog[10];

        Scanner keyboard = new Scanner(System.in);

        // reading from binary file Dogs.dat
            File binaryFile = new File("Dogs.dat");
            // check to see if file exists & non-zero size
        System.out.println("Previously saved dogs from binary file:");
            if (binaryFile.exists() && binaryFile.length() > 1L)
            {
                try {
                    ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                    // read the entire array into dogPound
                    // readObject returns Object
                    // Dog[] = Object . . .
                    dogPound = ((Dog[]) fileReader.readObject());
                    // loop through array and print out all objects
                    while(dogPound[count] != null)
                        System.out.println(dogPound[count++]);
                    fileReader.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                // read from binary file
            }
            else
            {
                System.out.println("[None, please enter new dog data]");
            }

        do
        {
            System.out.print("Enter the dog's name (or type \"quit\" to exit): ");
            name = keyboard.nextLine();
            if (name.equalsIgnoreCase("quit"))
                break;
            System.out.print("Enter the dog's breed: ");
            breed = keyboard.nextLine();
            System.out.print("Enter the dog's age: ");
            age = keyboard.nextInt();

            //Create a new Dog object, add to array
            dogPound[count++] = new Dog(name, breed, age);

            //get rid of dangling \n
            keyboard.nextLine();
        }
        while(true);

        // after user enters quit, write the dogPound array to binary file
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(dogPound);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
