package com.google.firebase.inappmessaging.internal.injection.modules;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import g2.e;
import i4.a1;
import i4.d;
import i4.j;
import i4.v0;
import i4.x0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import p4.b;
import p4.g;
import r2.p;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class GrpcClientModule {
    private final FirebaseApp firebaseApp;

    public GrpcClientModule(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public static String getSignature(@NonNull PackageManager packageManager, @NonNull String str) {
        Signature[] signatureArr;
        Signature signature;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0 && (signature = signatureArr[0]) != null) {
                return signatureDigest(signature);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String signatureDigest(Signature signature) {
        try {
            return e.e.h().c(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Provides
    public a1 providesApiKeyHeaders() {
        j jVar = a1.f11818d;
        BitSet bitSet = x0.f11971d;
        v0 v0Var = new v0("X-Goog-Api-Key", jVar);
        v0 v0Var2 = new v0("X-Android-Package", jVar);
        v0 v0Var3 = new v0("X-Android-Cert", jVar);
        a1 a1Var = new a1();
        String packageName = this.firebaseApp.getApplicationContext().getPackageName();
        a1Var.e(v0Var, this.firebaseApp.getOptions().getApiKey());
        a1Var.e(v0Var2, packageName);
        String signature = getSignature(this.firebaseApp.getApplicationContext().getPackageManager(), packageName);
        if (signature != null) {
            a1Var.e(v0Var3, signature);
        }
        return a1Var;
    }

    @Provides
    @FirebaseAppScope
    public p providesInAppMessagingSdkServingStub(i4.e eVar, a1 a1Var) {
        List listAsList = Arrays.asList(new g(a1Var));
        q.D(eVar, "channel");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            eVar = new i4.g(eVar, (g) it.next());
        }
        return new p(eVar, d.h.c(p4.e.f13335c, b.f13325a));
    }
}
