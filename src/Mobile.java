import java.util.ArrayList;
import java.util.Scanner;

public class Mobile {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    public void getMenu() {
        System.out.println("----Menu----");
        System.out.println("1. Print All Contacts");
        System.out.println("2. Add New Contact");
        System.out.println("3. Update Existing Contact");
        System.out.println("4. Remove Existing Contact");
        System.out.println("5. Search Contact");
        System.out.println("6. Quit");

    }

    public void selectMenu(int count){
            switch (count) {
                case 0:
                    printContacts();
                    break;
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    searchContacts();
                    break;
            }

    }
    private void printContacts() {
        System.out.println("Total contacts: "+this.contacts.size());
        int count = 0;
        for (Contact contact : getContacts()){
            System.out.println(count+1+"."+"\t"+"Name: "+ contact.getName()+"\t"+"Phone: "+contact.getPhone());
        }
    }

    private void addContact() {
        try {
            String name;
            String phone;
            Contact existingContact;
            System.out.println("Enter name: \r");
            name = sc.nextLine();
            System.out.println("Enter Phone: \r");
            phone = sc.nextLine();

            existingContact= searchContactsByName(name);
                if(existingContact != null ){
                    System.out.println("Contact with given name already exists. \r");
                    System.out.println("Name: "+ existingContact.getName()+"\t"+"Phone: "+existingContact.getPhone());
                    return;
                }else
                {
                    existingContact = searchContactsByPhone(phone);
                    if(existingContact != null){
                        System.out.println("Contact with given name already exists. \r");
                        System.out.println("Name: "+ existingContact.getName()+"\t"+"Phone: "+existingContact.getPhone());
                        return;
                    }
                }

            Contact contact = new Contact();
            contact.setName(name);
            contact.setPhone(phone);
            contacts.add(contact);
            System.out.println("Contact added");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    private void updateContact() {
        try {
            String name;
            String phone;
            Contact existingContact;
            System.out.println("Enter name: \r");
            name = sc.nextLine();
            existingContact = searchContactsByName(name);
            if (existingContact == null) {
                System.out.println("Contact with given name doesn't exists. \r");
                return;
            }
            System.out.println("Enter new number\r");
            phone = sc.nextLine();
            existingContact.setPhone(phone);
            System.out.println("Contact updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void removeContact() {
        try {
            String name;
            Contact existingContact;
            System.out.println("Enter name\r");
            name = sc.nextLine();
            searchContactsByName(name);
            existingContact = searchContactsByName(name);
            if (existingContact == null) {
                System.out.println("Contact with given name doesn't exists. \r");
                return;
            }
            contacts.remove(existingContact);
            System.out.println("Contact removed");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void searchContacts() {
        String name;
        Contact existingContact;
        System.out.println("Enter name: \r");
        name = sc.nextLine();
        existingContact = searchContactsByName(name);
        if(existingContact != null ){
            System.out.println("Contact found \r");
            System.out.println("Name: "+ existingContact.getName()+"\t"+"Phone: "+existingContact.getPhone());
        }
        else {
                System.out.println("Contact not found. \r");
        }
    }

    private Contact searchContactsByName(String name) {

        return getContacts()
                .stream()
                .filter(c -> c.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private Contact searchContactsByPhone(String phone) {
        return getContacts()
                .stream()
                .filter(c -> c.getPhone().equals(phone)).findFirst().orElse(null);
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

}
