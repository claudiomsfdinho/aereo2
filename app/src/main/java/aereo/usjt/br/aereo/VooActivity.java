package aereo.usjt.br.aereo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.util.TreeSet;

public class VooActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo);

        Controle controle = new Controle();
        //capturando a msg do intent

        Intent intent = getIntent();
        String destino = intent.getStringExtra(MainActivity.DESTINO);
        String origem = intent.getStringExtra(MainActivity.ORIGEM);


        TreeSet<Voo> lista = controle.listarVoos(origem, destino);

        // texto da View
        TextView textView = (TextView) findViewById(R.id.txt_lista_voo);
        String message = "";

        for (Voo voo : lista) {
            message += voo.getNome()  + "" + voo.getSituacao() +  "\n";
        }

        if (message.length() == 0) {


            message = "Voo não encontrado";

            textView.setLines(3);
        } else {
            textView.setLines(lista.size());

        }


        textView.setText(message);
    }


}
