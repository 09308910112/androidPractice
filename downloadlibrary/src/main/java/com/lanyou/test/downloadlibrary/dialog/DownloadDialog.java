package com.lanyou.test.downloadlibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lanyou.test.downloadlibrary.R;

/**
 * @author Wingbiu
 */

public class DownloadDialog extends Dialog {

    private Context mContext ;
    private TextView tvTiele;
    private ProgressBar progressbar;
    private TextView btnCancel;
    private TextView btnConfirm;
    private TextView tvNumber;

    public DownloadDialog(@NonNull Context context) {
        this(context, R.style.customDialogStyle);
    }

    public DownloadDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context ;
        initView() ;
    }

    private void initView() {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.dlg_download, null);
        tvTiele = layout.findViewById(R.id.title);
        progressbar = layout.findViewById(R.id.progressbar);
        btnCancel = layout.findViewById(R.id.cancel_btn);
        btnConfirm = layout.findViewById(R.id.confirm_btn);
        tvNumber = layout.findViewById(R.id.tv_number) ;

        setContentView(layout);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setTitle(String title) {
        if (tvTiele != null) {
            tvTiele.setText(title);
        }
    }
    public void setLeftText(String leftText) {
        if (btnCancel != null) {
            btnCancel.setText(leftText);
        }
    }
    public void setRightext(String rightText) {
        if (btnConfirm != null) {
            btnConfirm.setText(rightText);
        }
    }

    public void setOnLeftListener(String leftText ,View.OnClickListener leftListener) {
        if (btnCancel != null) {
            btnCancel.setText(leftText);
            btnCancel.setOnClickListener(leftListener);
        }
    }

    public void setOnRightListener(String rightText ,View.OnClickListener rightListener) {
        if (btnConfirm != null) {
            btnConfirm.setText(rightText);
            btnConfirm.setOnClickListener(rightListener);
        }
    }

    public void setProgress(int progress) {
        if (progressbar != null) {
            tvNumber.setText(progress+"");
            progressbar.setProgress(progress);
        }
    }


}
