package com.example.intership.mark_i;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.intership.mark_i.DataModel.EnterUser;
import com.example.intership.mark_i.Web.Web;

public class Login {
    private EditText mEditLogin;
    private EditText mEditPass;
    private Button mButtonEnter;
    private Button mButtonForgetPass;

    static final String WARNING_EMPTY_LOGIN = "Поле Логин Пустое!";
    static final String WARNING_EMPTY_PASS = "Поле Пароль Пустое!";

    private Context mContext;
    private EnterUser mLocalUser = new EnterUser();

    public Login(LoginActivity mView, Context context) {
        mEditLogin = (EditText) mView.findViewById(R.id.id_EditText_Login);
        mEditPass = (EditText) mView.findViewById(R.id.id_EditText_Pass);
        mButtonEnter = (Button) mView.findViewById(R.id.id_Button_Enter);
        mButtonForgetPass = (Button) mView.findViewById(R.id.id_Button_ForgetPass);
        this.mContext = context;
    }

    private boolean getDataUser() {
        mLocalUser.setmLogin(mEditLogin.getText().toString());
        if (mLocalUser.getmLogin().isEmpty()) {
            Toast.makeText(mContext, WARNING_EMPTY_LOGIN, Toast.LENGTH_LONG).show();
            return false;
        }
        mLocalUser.setmPassword(mEditPass.getText().toString());
        if (mLocalUser.getmPassword().isEmpty()) {
            Toast.makeText(mContext, WARNING_EMPTY_PASS, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void onButtonEnter(final Web web) {
        mButtonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDataUser()) {
                    //web.getUsers(mLocalUser, mContext);
                    web.autorization(mLocalUser.getmLogin(),mLocalUser.getmPassword(),mContext);
                }
            }
        });
    }


    public void autorization() {
        Web mWeb = new Web();
        onButtonEnter(mWeb);

    }


}
