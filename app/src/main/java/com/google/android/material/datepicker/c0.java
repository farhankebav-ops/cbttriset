package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cbt.exam.browser.R;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f5345a;

    public c0(n nVar) {
        this.f5345a = nVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f5345a.f5364c.f5341f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        b0 b0Var = (b0) viewHolder;
        n nVar = this.f5345a;
        int i8 = nVar.f5364c.f5337a.f5393c + i2;
        b0Var.f5342a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i8)));
        TextView textView = b0Var.f5342a;
        Context context = textView.getContext();
        textView.setContentDescription(a0.b().get(1) == i8 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i8)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i8)));
        c cVar = nVar.f5366f;
        if (a0.b().get(1) == i8) {
            w1.f fVar = cVar.f5344b;
        } else {
            w1.f fVar2 = cVar.f5343a;
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b0((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
