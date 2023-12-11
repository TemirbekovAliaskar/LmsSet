package serviceGroup.impl;

import role.Role1;
import serviceGroup.RoleService;

import java.util.Scanner;

public class RoleImpl implements RoleService {
    @Override
    public Role1 login(Role1 admin) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            boolean truess = false;
            try {
                System.out.print("Login :");
                String login = scanner.nextLine();
                System.out.print("Password :");
                String pass = scanner.nextLine();
                if(login.endsWith("@gmail.com") && login.length() >= 12 && pass.length() >= 8){
                    truess = true;
                    try {
                        if (admin.getLogin().equals(login) && admin.getPassword().equals(pass)){
                            System.out.println("Welcome");
                            return admin;
                        }
                        else {
                            throw new Exception("Not found pass and login ");
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }else throw new Exception("!!!!!!!!!!!!!!!!!");

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
        }
    }

    @Override
    public Role1 addLogin(Role1 admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("login :");
        String login = scanner.nextLine();
        if (admin.getLogin().equalsIgnoreCase(login)){
            System.out.println("New pass : ");
            String pass = scanner.nextLine();
            admin.setPassword(pass);
            System.out.println("Successful !");
        }
        return admin;
    }
}
