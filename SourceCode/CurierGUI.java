package pip_proiect_final;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class CurierGUI extends JFrame implements Observator {

    private final JTextArea zona = new JTextArea();
    private Comanda curenta;

    private Queue<Comanda> coadaCurier;

    public CurierGUI() {
        setTitle("Curier");
        setSize(300, 350);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        zona.setEditable(false);

        JButton buton = new JButton("Avanseaza status");
        buton.addActionListener(e -> avanseaza());

        add(new JScrollPane(zona), BorderLayout.CENTER);
        add(buton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setCoada(Queue<Comanda> c) {
        coadaCurier = c;
    }
    //avanseaza statusul comenzii(gata-in livrare-livrata)
    private void avanseaza() {
        if (coadaCurier == null) return;

        if (curenta == null) curenta = coadaCurier.poll();
        if (curenta == null) return;

        switch (curenta.getStatus()) {
            case "Gata" -> curenta.setStatus("In livrare");
            case "In livrare" -> {
                curenta.setStatus("Livrata");
                curenta = null;
            }
        }
    }

    public void actualizeaza(String mesaj) {
        zona.append(mesaj + "\n");
    }
}
