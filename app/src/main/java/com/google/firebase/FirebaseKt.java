package com.google.firebase;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.k;
import q6.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class FirebaseKt {

    /* JADX INFO: renamed from: com.google.firebase.FirebaseKt$coroutineDispatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1<T> implements ComponentFactory {
        public static final AnonymousClass1<T> INSTANCE = new AnonymousClass1<>();

        @Override // com.google.firebase.components.ComponentFactory
        public final w create(ComponentContainer componentContainer) {
            k.k();
            throw null;
        }
    }

    public static final FirebaseApp app(Firebase firebase, String name) {
        k.e(firebase, "<this>");
        k.e(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        k.d(firebaseApp, "getInstance(...)");
        return firebaseApp;
    }

    private static final <T extends Annotation> Component<w> coroutineDispatcher() {
        k.k();
        throw null;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        k.e(firebase, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        k.d(firebaseApp, "getInstance(...)");
        return firebaseApp;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        k.e(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        k.d(options, "getOptions(...)");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        k.e(firebase, "<this>");
        k.e(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options) {
        k.e(firebase, "<this>");
        k.e(context, "context");
        k.e(options, "options");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options);
        k.d(firebaseAppInitializeApp, "initializeApp(...)");
        return firebaseAppInitializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options, String name) {
        k.e(firebase, "<this>");
        k.e(context, "context");
        k.e(options, "options");
        k.e(name, "name");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options, name);
        k.d(firebaseAppInitializeApp, "initializeApp(...)");
        return firebaseAppInitializeApp;
    }
}
