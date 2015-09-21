package aereo.usjt.br.aereo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Claudio Miranda on 20/09/2015.
 */
public class CompletoVooActivity extends ActionBarActivity {

    TextView vooNome;
    ImageView vooImageView;
    TextView vooValor;
    TextView vooDestino;
    TextView vooOrigem;
    TextView vooQdeEscalas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completo_voo);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(VooActivity.VOO);
        Voo voo = (Voo)obj;
        setupViews(voo);

    }

    private void setupViews(Voo voo) {
        vooNome = (TextView) findViewById(R.id.txt_voo_nome);
        vooNome.setText(voo.getNome());
       vooImageView = (ImageView) findViewById(R.id.voo_image_view);
        Drawable drawable = Util.getDrawable(this, voo.getImagem());
        vooImageView.setImageDrawable(drawable);
        vooValor = (TextView) findViewById(R.id.txt_voo_valor);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        vooValor.setText(""+formatter.format(voo.getValor()));
        vooDestino = (TextView) findViewById(R.id.txt_voo_destino);
        vooDestino.setText(voo.getDestino());
        vooOrigem = (TextView) findViewById(R.id.txt_voo_origem);
        vooOrigem.setText(voo.getOrigem());

    }



}
