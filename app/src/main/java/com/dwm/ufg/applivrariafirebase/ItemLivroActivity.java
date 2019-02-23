package com.dwm.ufg.applivrariafirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemLivroActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_livro);
        databaseReference = FirebaseUtils.inicializeFirebase(this);
        
        final EditText titulo = (EditText) findViewById(R.id.id_titulo);
        final EditText autor = (EditText) findViewById(R.id.id_autor);
        final EditText editora = (EditText) findViewById(R.id.id_editora_item);
        final EditText valor = (EditText) findViewById(R.id.id_valor_item);
        final ImageView imagem = (ImageView) findViewById(R.id.id_img_livro_cad);

        final TextView tituloTela = (TextView) findViewById(R.id.id_title_item_livro);
        final Button btnCadastro = (Button) findViewById(R.id.id_button);

        final Livro livroSelecionado = (Livro) getIntent().getSerializableExtra("livro");

        if(livroSelecionado != null){
            titulo.setText(livroSelecionado.getTitulo());
            autor.setText(livroSelecionado.getAutor());
            editora.setText(livroSelecionado.getEditora());
            valor.setText(String.valueOf(livroSelecionado.getValor()));
            if (livroSelecionado.getImagem() != null) {
                int idImagem = this.getResources().getIdentifier(livroSelecionado.getImagem(), "drawable", this.getPackageName());
                imagem.setImageResource(idImagem);
            }else{
                imagem.setImageResource(R.drawable.icon_livro_capa);
            }

            btnCadastro.setText("Editar");
            tituloTela.setText("Editar Livro");
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Cadastro");
        }

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            Livro novolivro = new Livro();
            @Override
            public void onClick(View v) {
                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();
                double valorDouble = Double.parseDouble(valor.getText().toString());

                if(tituloString.equals("") || autorString.equals("") || editoraString.equals("") || valor.getText().toString().equals("")){
                    Toast.makeText(ItemLivroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(btnCadastro.getText().equals("Editar") && livroSelecionado != null){

                    livroSelecionado.setUid(livroSelecionado.uid);
                    livroSelecionado.setTitulo(tituloString);
                    livroSelecionado.setAutor(autorString);
                    livroSelecionado.setEditora(editoraString);
                    livroSelecionado.setValor(valorDouble);

                    databaseReference.child("Livro").child(livroSelecionado.getUid()).setValue(livroSelecionado);
                    Toast.makeText(ItemLivroActivity.this, "Item atualizado com sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    novolivro.setUid(UUID.randomUUID().toString());
                    novolivro.setTitulo(tituloString);
                    novolivro.setAutor(autorString);
                    novolivro.setEditora(editoraString);
                    novolivro.setValor(valorDouble);

                    databaseReference.child("Livro").child(novolivro.getUid()).setValue(novolivro);
                    Toast.makeText(ItemLivroActivity.this, "Item adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });
    }

    private void adicionarLivro(){
        // TODO: 23/02/19  
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
