package com.yarolegovich.slidingrootnav.sample;

        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Message;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class LoginRegisterActivity extends Activity {
    Button login;
    Button register;
    EditText etusername;
    EditText etpassword;
    String username;
    String password;
    ProgressDialog p;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

//		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//		.detectDiskReads()
//		.detectDiskWrites()
//		.detectNetwork()   // or .detectAll() for all detectable problems
//		.penaltyLog()
//		.build());
//		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//		.detectLeakedSqlLiteObjects()
//		.penaltyLog()
//		.penaltyDeath()
//		.build());



        init();
        register.setOnClickListener(new RegisterOnclick());
        login.setOnClickListener(new LoginOnclick());
    }
    private void init()
    {
        etusername=(EditText) findViewById(R.id.etusername);
        etpassword=(EditText) findViewById(R.id.etpassword);
        login=(Button) findViewById(R.id.login);
        register=(Button) findViewById(R.id.register);
        p=new ProgressDialog(LoginRegisterActivity.this);
        p.setTitle("登陆中");
        p.setMessage("登陆中，马上就好");
    }
    private class RegisterOnclick implements OnClickListener
    {
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(LoginRegisterActivity.this, Register.class);
            startActivity(intent);
            //TODO
        }

    }
    private class LoginOnclick implements OnClickListener
    {
        public void onClick(View arg0) {
            username=etusername.getText().toString().trim();
            if (username==null||username.length()<=0)
            {
                etusername.requestFocus();
                etusername.setError("对不起，用户名不能为空");
                return;
            }
            else
            {
                username=etusername.getText().toString().trim();
            }
            password=etpassword.getText().toString().trim();
            if (password==null||password.length()<=0)
            {
                etpassword.requestFocus();
                etpassword.setError("对不起，密码不能为空");
                return;
            }
            else
            {
                password=etpassword.getText().toString().trim();
            }
            p.show();
            new Thread(new Runnable() {

                public void run() {
                    /*
                    Operaton operaton=new Operaton();
                    String result=operaton.login("Login", username, password);
                    Message msg=new Message();
                    msg.obj=result;
                    handler.sendMessage(msg);*/
                    //TODO
                }
            }).start();

        }
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String string=(String) msg.obj;
            p.dismiss();
            Toast.makeText(LoginRegisterActivity.this, string, 0).show();
            super.handleMessage(msg);
        }
    };

}