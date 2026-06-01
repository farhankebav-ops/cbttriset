package com.cbt.exam.browser.activity;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f5157a;

    public a0(SharedPreferences sharedPreferences) {
        this.f5157a = sharedPreferences;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f5157a.edit().putString("autoSave", editable.toString()).apply();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
    }
}
