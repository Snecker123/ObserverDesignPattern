package pip_proiect_final;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Queue<Comanda> coadaBucatar = new LinkedList<>(); // Primita -> bucatar
        Queue<Comanda> coadaCurier  = new LinkedList<>(); // Gata -> curier
    	
        
        //int nr=2;    //nr este numarul de clienti
        Scanner sc = new Scanner(System.in);
        System.out.println("dati nr de clienti\n");
        int nr = sc.nextInt();
        
        BucatarGUI bucatar = new BucatarGUI();
        CurierGUI curier = new CurierGUI();
        bucatar.setCozi(coadaBucatar, coadaCurier);
        curier.setCoada(coadaCurier);
        
        for(int i = 0; i < nr ; i++)
        {
        	ClientGUI client = new ClientGUI(i+1, coadaBucatar);
        	client.conecteaza(bucatar, curier);
        }
        
        
    }
}
