package sg.bigo.ads.common.form.render.a;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.form.render.a.a;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends a {
    public b(@NonNull e.c cVar, @Nullable Map<String, Object> map, Context context, a.InterfaceC0286a interfaceC0286a) {
        super(cVar, map, context, interfaceC0286a);
    }

    @Override // sg.bigo.ads.common.form.render.a.a
    public final View b() {
        View viewA = sg.bigo.ads.common.utils.a.a(this.h, sg.bigo.ads.common.form.render.a.a(2), null, false);
        this.f15658i = viewA;
        if (viewA == null) {
            return null;
        }
        a.a((TextView) viewA.findViewById(R.id.inter_form_edit_title), this.f15656d);
        a(1);
        final EditText editText = (EditText) this.f15658i.findViewById(R.id.inter_form_edit_content);
        String strA = sg.bigo.ads.common.form.a.a(this.e, this.f15654b);
        if (editText != null) {
            editText.setTextColor(sg.bigo.ads.common.form.render.a.b());
            editText.setHint(sg.bigo.ads.common.form.a.a(this.h, R.string.bigo_ad_form_question_hint));
            if (!q.a((CharSequence) strA)) {
                a.InterfaceC0286a interfaceC0286a = this.j;
                if (interfaceC0286a != null) {
                    interfaceC0286a.a(this.f15653a.f15456d, strA);
                }
                this.f15655c = strA;
                editText.setText(strA);
            }
            editText.addTextChangedListener(new TextWatcher() { // from class: sg.bigo.ads.common.form.render.a.b.1
                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable editable) {
                    b.this.f15655c = editText.getText().toString();
                    b bVar = b.this;
                    a.InterfaceC0286a interfaceC0286a2 = bVar.j;
                    if (interfaceC0286a2 != null) {
                        interfaceC0286a2.a(bVar.f15653a.f15456d, bVar.f15655c);
                    }
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
                }
            });
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: sg.bigo.ads.common.form.render.a.b.2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    b bVar = b.this;
                    if (z2) {
                        bVar.a(2);
                    } else {
                        bVar.a();
                    }
                }
            });
        }
        return this.f15658i;
    }
}
