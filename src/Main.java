import DAO.userDao;
import model.user;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<user> listo =new ArrayList<>();
        user us = new user();
        userDao udao = new userDao();
        Scanner inp = new Scanner(System.in);
        int choose = inp.nextInt();
        while (true){
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    udao.addUser(inp.nextLine(),inp.nextLine(),inp.nextLine(),inp.nextLine(),inp.nextLine());
                    break;
                case 2:
                    String idx= inp.nextLine();
                    while(true){
                        System.out.printf("Nhap id user muon xoa: ");
                        String id= inp.nextLine();
                        udao.delUser(id);
                        System.out.printf("nhap 0 de dung xoa or khac 0 de tiep tuc: ");
                        int checkx =Integer.parseInt( inp.nextLine());
                        if (checkx==0){
                            break;
                        }
                    }
                    break;
                case 3:
                    listo = udao.getUser();
                    for(user o:listo){
                        System.out.printf(o.toString()+"\n");
                    }
                    break;
                default:
                    System.out.printf("ko hop le moi nhap lai:  \n");
            }
            choose = inp.nextInt();
        }
    }
}