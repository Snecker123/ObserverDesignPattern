package pip_proiect_final;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class BucatarGUI extends JFrame implements Observator {

    private final JTextArea zona = new JTextArea();
    private Comanda curenta;

    private Queue<Comanda> coadaBucatar;
    private Queue<Comanda> coadaCurier;

    public BucatarGUI() {
        setTitle("Bucatar");
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

    public void setCozi(Queue<Comanda> b, Queue<Comanda> c) {
        coadaBucatar = b;
        coadaCurier = c;
    }

    //avanseaza statusul comenzii (primita-in pregatire-gata)
    private void avanseaza() {
        if (coadaBucatar == null || coadaCurier == null) return;

        if (curenta == null) curenta = coadaBucatar.poll();
        if (curenta == null) return;

        switch (curenta.getStatus()) {
            case "Primita" -> curenta.setStatus("In pregatire");
            case "In pregatire" -> {
                curenta.setStatus("Gata");
                coadaCurier.add(curenta);
                curenta = null;
            }
        }
    }

    public void actualizeaza(String mesaj) {
        zona.append(mesaj + "\n");
    }
}
