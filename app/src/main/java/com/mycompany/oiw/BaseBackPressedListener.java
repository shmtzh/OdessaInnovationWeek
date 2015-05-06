package com.mycompany.oiw;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Sony on 4/28/2015.
 */
public class BaseBackPressedListener implements OnBackPressedListener {

    private final FragmentActivity activity;

    public BaseBackPressedListener(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void doBack() {
        activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

}
