package aereo.usjt.br.aereo;

/**
 * Created by Claudio Miranda on 12/09/2015.
 */
import java.util.ArrayList;
import java.util.TreeSet;

public class Controle {

        private static final ArrayList<Voo> voos = cadastroDeVoos();

        public Controle() {

        }

        public Voo buscarNome(String nome) {
            for (Voo voo : voos) {
                if (nome.equals(voo.getNome())) {
                    return voo;
                }
            }
            return null;
        }

        public TreeSet<Voo> listarVoos(String destino, String origem) {
            TreeSet<Voo> voos = new TreeSet<Voo>();



            if (destino.length() > 0 && origem.length() > 0) {
                voos = buscarDestinoOrigem(destino, origem);
            } else if (destino.length() > 0) {
                voos = buscarDestino(destino);
            } else if (origem.length() > 0) {
                voos = buscarOrigem(origem);

            } else {
                voos = todos();
            }

            return voos;
        }

         private TreeSet<Voo> buscarDestino(String destino) {
            TreeSet<Voo> lista = new TreeSet<Voo>();
            for (Voo voo : voos) {
                if (destino.equals(voo.getDestino())) {
                    lista.add(voo);
                }
            }
            return lista;
        }


        private TreeSet<Voo> buscarOrigem(String origem) {
            TreeSet<Voo> lista = new TreeSet<Voo>();
            for (Voo voo : voos) {
                if (origem.equals(voo.getOrigem())) {
                    lista.add(voo);
                }
            }
            return lista;
        }


        private TreeSet<Voo> buscarDestinoOrigem(String destino, String origem) {
            TreeSet<Voo> lista = new TreeSet<Voo>();
            for (Voo voo : voos) {
                if (destino.equals(voo.getDestino())
                        && origem.equals(voo.getOrigem())) {
                    lista.add(voo);
                }
            }
            return lista;
        }



        private TreeSet<Voo> todos() {
            TreeSet<Voo> voos = new TreeSet<Voo>();
            for (Voo voo : voos) {
                voos.add(voo);
            }
            return voos;
        }

        private static ArrayList<Voo> cadastroDeVoos(){
            ArrayList<Voo> voos = new ArrayList<Voo>();
            voos.add(new Voo("70CA/BRAS", "Aeroporto Internacional de Viracopos/Campinas","Aeroporto Internacional de BrasÃ­lia - Presidente Juscelino Kubitschek", 3,"Airbus300", "Atrasado", 490.5, "bandeira001"));
            voos.add(new Voo("455PA/ALAG","Aeroporto Internacional de Porto Alegre - Salgado Filho","Aeroporto Internacional de MaceiÃ³ - Zumbi dos Palmares", 3,"Airbus300", "Atrasado", 490.5, "bandeira002"));



            return voos;
        }
    }










