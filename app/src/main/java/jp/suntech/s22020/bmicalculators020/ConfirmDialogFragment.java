package jp.suntech.s22020.bmicalculators020;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ConfirmDialogFragment extends DialogFragment {
    @NonNull
    @Override

    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("確認", new DialogButtonClickListener());
        builder.setTitle("警告");
        builder.setMessage("適切な肥満度を求めるためには、6歳未満の場合はカウプ指数が、6歳から15歳まではローレル指数が使われます。本アプリはBMIのみに対応しています");
        AlertDialog dialog = builder.create();
        return dialog;
    }

    public class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //
            String msg = "";
            //
            switch (which) {
                //
                case DialogInterface.BUTTON_POSITIVE:

                    break;

            }
            //
            //Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }

    }
}
