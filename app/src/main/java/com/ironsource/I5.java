package com.ironsource;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class I5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private J7 f6972d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<Pair<String, String>> f6973f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6974a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private J7 f6977d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6975b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f6976c = "POST";
        private boolean e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ArrayList<Pair<String, String>> f6978f = new ArrayList<>();

        public a(String str) {
            this.f6974a = "";
            if (str == null || str.isEmpty()) {
                return;
            }
            this.f6974a = str;
        }

        public a a(J7 j72) {
            this.f6977d = j72;
            return this;
        }

        public a b(boolean z2) {
            this.f6975b = z2;
            return this;
        }

        public a c() {
            this.f6976c = "POST";
            return this;
        }

        public a a(Pair<String, String> pair) {
            this.f6978f.add(pair);
            return this;
        }

        public a b() {
            this.f6976c = "GET";
            return this;
        }

        public a a(List<Pair<String, String>> list) {
            this.f6978f.addAll(list);
            return this;
        }

        public a a(boolean z2) {
            this.e = z2;
            return this;
        }

        public I5 a() {
            return new I5(this);
        }
    }

    public I5(a aVar) {
        this.e = false;
        this.f6969a = aVar.f6974a;
        this.f6970b = aVar.f6975b;
        this.f6971c = aVar.f6976c;
        this.f6972d = aVar.f6977d;
        this.e = aVar.e;
        if (aVar.f6978f != null) {
            this.f6973f = new ArrayList<>(aVar.f6978f);
        }
    }

    public boolean a() {
        return this.f6970b;
    }

    public String b() {
        return this.f6969a;
    }

    public J7 c() {
        return this.f6972d;
    }

    public ArrayList<Pair<String, String>> d() {
        return new ArrayList<>(this.f6973f);
    }

    public String e() {
        return this.f6971c;
    }

    public boolean f() {
        return this.e;
    }
}
