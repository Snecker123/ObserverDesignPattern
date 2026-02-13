package pip_proiect_final;


import java.util.ArrayList;
import java.util.List;

public class Comanda {

    private String status;
    private int id;
    private static int contor = 1;
    private List<Observator> observatori = new ArrayList<>();

    public Comanda() {
    	this.id = contor;
    	contor++;
        this.status = "Primita";
    }

    public int getId() {
        return id;
    }
    
    public void adaugaObservator(Observator o) {
        observatori.add(o);
    }

    public void setStatus(String statusNou) {
        status = statusNou;
        notifica();
    }

    public String getStatus() {
        return status;
    }
    
    //notifica toti observatorii
    private void notifica() {
        for (Observator o : observatori) {
            o.actualizeaza("Comanda #" + id + " → " + status);
        }
    }
}
