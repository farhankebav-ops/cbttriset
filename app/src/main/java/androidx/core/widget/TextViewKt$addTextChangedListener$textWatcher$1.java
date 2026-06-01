package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import e6.l;
import e6.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ l $afterTextChanged;
    final /* synthetic */ r $beforeTextChanged;
    final /* synthetic */ r $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(l lVar, r rVar, r rVar2) {
        this.$afterTextChanged = lVar;
        this.$beforeTextChanged = rVar;
        this.$onTextChanged = rVar2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9));
    }
}
