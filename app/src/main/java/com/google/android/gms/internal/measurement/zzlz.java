package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzlz {
    public static zzlr zzb(Class cls) {
        String strL;
        ClassLoader classLoader = zzlz.class.getClassLoader();
        if (cls.equals(zzlr.class)) {
            strL = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!cls.getPackage().equals(zzlz.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            strL = androidx.camera.core.processing.util.a.l(cls.getPackage().getName(), ".BlazeGenerated", cls.getSimpleName(), "Loader");
        }
        try {
            try {
                try {
                    try {
                        return (zzlr) cls.cast(((zzlz) Class.forName(strL, true, classLoader).getConstructor(null).newInstance(null)).zza());
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InstantiationException e4) {
                        throw new IllegalStateException(e4);
                    }
                } catch (NoSuchMethodException e8) {
                    throw new IllegalStateException(e8);
                }
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzlz.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzlr) cls.cast(((zzlz) it.next()).zza()));
                } catch (ServiceConfigurationError e10) {
                    Logger.getLogger(zzlm.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), (Throwable) e10);
                }
            }
            if (arrayList.size() == 1) {
                return (zzlr) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzlr) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException(e11);
            } catch (NoSuchMethodException e12) {
                throw new IllegalStateException(e12);
            } catch (InvocationTargetException e13) {
                throw new IllegalStateException(e13);
            }
        }
    }

    public abstract zzlr zza();
}
