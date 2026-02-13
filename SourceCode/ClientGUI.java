package pip_proiect_final;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class ClientGUI extends JFrame implements Observator {

    private final JTextArea zona = new JTextArea();
    private final JButton buton = new JButton("Plaseaza comanda");

    private final int clientId;
    private final Queue<Comanda> coadaBucatar;
    private BucatarGUI bucatar;
    private CurierGUI curier;
    private Comanda comanda; //o singura comanda per client

    public ClientGUI(int clientId, Queue<Comanda> coadaBucatar) {
        this.clientId = clientId;
        this.coadaBucatar = coadaBucatar;

        setTitle("Client " + clientId);
        setSize(300, 350);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        zona.setEditable(false);
        buton.addActionListener(e -> plaseazaComanda());

        add(new JScrollPane(zona), BorderLayout.CENTER);
        add(buton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void conecteaza(BucatarGUI b, CurierGUI c) {
        this.bucatar = b;
        this.curier = c;
    }

    private void plaseazaComanda() {
        if (comanda != null) return; //deja plasata o data

        Comanda c = new Comanda();
        this.comanda = c;

        //observatori
        c.adaugaObservator(this);
        c.adaugaObservator(bucatar);
        c.adaugaObservator(curier);

        //adauga in coada bucatar
        coadaBucatar.add(c);

        //status initial
        c.setStatus("Primita");
    }

    public void actualizeaza(String mesaj) {
        zona.append(mesaj + "\n");
    }
}
