package com.cbt.exam.browser.activity;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.mimikridev.ads.nativead.NativeAdViewHolder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5185b;

    public /* synthetic */ o(Object obj, int i2) {
        this.f5184a = i2;
        this.f5185b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f5184a;
        Object obj = this.f5185b;
        switch (i2) {
            case 0:
                ActivityConfigConfirm activityConfigConfirm = (ActivityConfigConfirm) obj;
                int i8 = ActivityConfigConfirm.f5077s;
                try {
                    boolean zOptBoolean = activityConfigConfirm.f5086r.optBoolean("token_masuk_status", false);
                    String strOptString = activityConfigConfirm.f5086r.optString("token_masuk", "");
                    if (!zOptBoolean || strOptString.isEmpty()) {
                        activityConfigConfirm.s();
                    } else {
                        activityConfigConfirm.q();
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(activityConfigConfirm, "Error memproses token", 0).show();
                    return;
                }
            case 1:
                ((com.google.android.material.datepicker.p) obj).b();
                throw null;
            case 2:
                ((NativeAdViewHolder) obj).lambda$new$0(view);
                return;
            case 3:
                z1.d dVar = (z1.d) obj;
                EditText editText = dVar.f17903i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                dVar.p();
                return;
            case 4:
                ((z1.j) obj).t();
                return;
            default:
                z1.v vVar = (z1.v) obj;
                EditText editText2 = vVar.f17968f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = vVar.f17968f;
                if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    vVar.f17968f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    vVar.f17968f.setTransformationMethod(null);
                }
                if (selectionEnd >= 0) {
                    vVar.f17968f.setSelection(selectionEnd);
                }
                vVar.p();
                return;
        }
    }
}
