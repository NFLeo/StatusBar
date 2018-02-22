package com.leo.project.statusbar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 底部弹窗Fragment
 */
public abstract class BaseDialogFragment
        extends DialogFragment implements View.OnTouchListener {

    protected Dialog dialog;
    protected Context context;

    private View parentView;
    private int themeId;

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        themeId = setThemeRes();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        setDialog();
        initView(dialog);
        setView();
        return dialog;
    }

    // 设置基础对话框
    protected void setDialog() {
        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        dialog = new Dialog(context, themeId);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        parentView = LayoutInflater.from(context).inflate(getLayoutId(), null);
        dialog.setContentView(parentView);
        dialog.setCanceledOnTouchOutside(false); // 外部点击取消

        ScreenUtils.translateSetTextColerStatusBar(getActivity());
        ScreenUtils.setTextColorStatusBar(getActivity(), true);

        setLayoutParams();
        if (parentView != null) {
            parentView.setOnTouchListener(this);
        }
    }

    public View getParentView() {
        return parentView;
    }

    public int setThemeRes() {
        return R.style.DialogFragment;
    }

    // 设置窗体尺寸
    public void setLayoutParams() {
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
    }

    /** 设置自定义对话框布局 */
    protected abstract int getLayoutId();

    protected abstract void setView();

    protected abstract void initView(Dialog dialog);

    public void dismissParent() {
        dismiss();
    }

    public void gotoActivity(Class<?> cls)
    {
        gotoActivity(cls, null);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void gotoActivity(Class<?> cls, Bundle bundle)
    {
        if (null == cls) {
            return;
        }

        Intent intent = new Intent();
        intent.setClass(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void setCanceledOnTouchOutside(boolean isCancel) {
        if (dialog != null) {
            dialog.setCancelable(isCancel);
        }
    }

    @Override
    public void onDestroy() {
        dismissParent();
        super.onDestroy();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        getActivity().dispatchTouchEvent(event);
        return false;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        //这里直接调用show方法会报java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }
}