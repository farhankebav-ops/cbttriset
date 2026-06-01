package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.ironsource.InterfaceC2554sa;

/* JADX INFO: renamed from: com.ironsource.ha, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2360ha extends WebView implements InterfaceC2571ta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2554sa f8679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Sc f8680b;

    public /* synthetic */ C2360ha(Context context, InterfaceC2554sa interfaceC2554sa, int i2, kotlin.jvm.internal.f fVar) {
        this(context, (i2 & 2) != 0 ? new InterfaceC2554sa.a(0, 1, null) : interfaceC2554sa);
    }

    @Override // com.ironsource.InterfaceC2571ta
    public void a(String script) {
        kotlin.jvm.internal.k.e(script, "script");
        InterfaceC2554sa interfaceC2554sa = this.f8679a;
        if (interfaceC2554sa == null) {
            kotlin.jvm.internal.k.l("javascriptEngine");
            throw null;
        }
        if (!interfaceC2554sa.a()) {
            InterfaceC2554sa interfaceC2554sa2 = this.f8679a;
            if (interfaceC2554sa2 == null) {
                kotlin.jvm.internal.k.l("javascriptEngine");
                throw null;
            }
            interfaceC2554sa2.a(this);
        }
        InterfaceC2554sa interfaceC2554sa3 = this.f8679a;
        if (interfaceC2554sa3 != null) {
            interfaceC2554sa3.a(script);
        } else {
            kotlin.jvm.internal.k.l("javascriptEngine");
            throw null;
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent event) {
        Sc sc;
        kotlin.jvm.internal.k.e(event, "event");
        if (i2 == 4 && (sc = this.f8680b) != null && sc.onBackButtonPressed()) {
            return true;
        }
        return super.onKeyDown(i2, event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2360ha(Context context, InterfaceC2554sa javascriptEngine) {
        this(context);
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(javascriptEngine, "javascriptEngine");
        this.f8679a = javascriptEngine;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2360ha(Context context) {
        super(context);
        kotlin.jvm.internal.k.e(context, "context");
    }

    public final void a(Sc sc) {
        this.f8680b = sc;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2360ha(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(attrs, "attrs");
    }

    public final void a() {
        this.f8680b = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2360ha(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(attrs, "attrs");
    }
}
