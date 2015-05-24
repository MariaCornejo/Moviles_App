package com.example.mybffapp_;



import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;

public class RegistroActivity extends Activity 

{

	private EditText campoNombre, campoApellidos, campoEmail, campoPassword;
	private Button miBoton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro_main);
			
		
	}
	public void Registrar(View view)
	{
		String nombre,apellidos,email,password;
		campoNombre = (EditText) findViewById(R.id.EditNombre);
		campoApellidos = (EditText) findViewById(R.id.EditApellidos);
		campoEmail = (EditText) findViewById(R.id.EditEmail);
		campoPassword = (EditText) findViewById(R.id.EditPassword);
		nombre=campoNombre.getText().toString();
		apellidos=campoApellidos.getText().toString();
		email=campoEmail.getText().toString();
		password=campoPassword.getText().toString();
		DBAdapter db= new DBAdapter(this);
        db.open();
        long id=db.insertUsuario(nombre,apellidos,email,password);
        db.close();
        Toast.makeText(getBaseContext(),
				"Se registró exitosamente... Bienvenido!",
				Toast.LENGTH_SHORT).show(); 
        Intent i = new Intent (RegistroActivity.this, InfoActivity.class);
		i.putExtra("nombre", nombre+"");
		i.putExtra("apellido", apellidos+"");
		startActivity(i);

	}


}