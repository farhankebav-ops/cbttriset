package com.ironsource.environment;

import a1.a;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.ironsource.I4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class CrashProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f8480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    I4 f8481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f8482c;
    Uri e;
    String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f8485i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    UriMatcher f8483d = new UriMatcher(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f8484f = 1;
    final int g = 2;
    final String j = "REPORTS";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = this.f8483d.match(uri);
        if (iMatch == 1) {
            return this.h;
        }
        if (iMatch == 2) {
            return this.f8485i;
        }
        throw new IllegalArgumentException(a.k("Invalid URI: ", uri));
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f8480a = getContext();
        this.f8481b = new I4(this.f8480a);
        this.f8482c = this.f8480a.getPackageName();
        this.e = Uri.parse("content://" + this.f8482c + "/REPORTS");
        this.h = "vnd.android.cursor.dir/CrashReporter.Reports";
        this.f8485i = "vnd.android.cursor.item/CrashReporter/Reports";
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = this.f8483d.match(uri);
        if (iMatch == 1) {
            return I4.c();
        }
        if (iMatch == 2) {
            return I4.a(Integer.parseInt(uri.getLastPathSegment()));
        }
        throw new IllegalArgumentException(a.k("Invalid URI: ", uri));
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
