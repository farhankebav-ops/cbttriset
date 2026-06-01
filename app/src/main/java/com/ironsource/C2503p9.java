package com.ironsource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.StringUtils;
import com.mimikridev.ads.util.Constant;
import com.unity3d.mediation.adapters.levelplay.LevelPlayBaseAdapter;
import com.vungle.ads.BuildConfig;

/* JADX INFO: renamed from: com.ironsource.p9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class C2503p9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9648a = "IntegrationHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9649b = "getNetworkSDKVersion";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9650c = "getAdapterSDKVersion";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9651d = "getAdapterVersion";
    private static final String e = "getVersion";

    /* JADX INFO: renamed from: com.ironsource.p9$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9652a;

        public a(Context context) {
            this.f9652a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Log.w(C2503p9.f9648a, "--------------- Google Play Services --------------");
                if (!this.f9652a.getPackageManager().getApplicationInfo(this.f9652a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                    Log.e(C2503p9.f9648a, "Google Play Services - MISSING");
                    return;
                }
                Log.i(C2503p9.f9648a, "Google Play Services - VERIFIED");
                String strB = com.ironsource.mediationsdk.r.m().b(this.f9652a);
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                Log.i(C2503p9.f9648a, "GAID is: " + strB + " (use this for test devices)");
            } catch (Exception e) {
                C2531r4.d().a(e);
                Log.e(C2503p9.f9648a, "Google Play Services - MISSING");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r8, java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.C2503p9.a(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void b(Context context) {
        Log.i(f9648a, "Verifying Integration:");
        c(context);
        String[] strArr = {"AppLovin", "APS", "BidMachine", "Bigo", "Chartboost", "Fyber", "AdMob", "HyprMX", "InMobi", "IronSource", BuildConfig.OMSDK_PARTNER_NAME, "Facebook", "Mintegral", "MobileFuse", "Moloco", "MyTarget", "Ogury", "Pangle", "Smaato", "SuperAwesome", Q6.G1, "Verve", "Yandex"};
        for (int i2 = 0; i2 < 23; i2++) {
            String str = strArr[i2];
            if (!a(context, str)) {
                String lowerCase = StringUtils.toLowerCase(str);
                lowerCase.getClass();
                switch (lowerCase) {
                    case "vungle":
                        Log.i(f9648a, ">>>> Liftoff Monetization - NOT VERIFIED");
                        break;
                    case "admob":
                        Log.i(f9648a, ">>>> Google (AdMob and Ad Manager) - NOT VERIFIED");
                        break;
                    case "facebook":
                        Log.i(f9648a, ">>>> Meta - NOT VERIFIED");
                        break;
                    default:
                        Log.e(f9648a, ">>>> " + str + " - NOT VERIFIED");
                        break;
                }
            } else {
                String lowerCase2 = StringUtils.toLowerCase(str);
                lowerCase2.getClass();
                switch (lowerCase2.hashCode()) {
                    case -805296079:
                        if (lowerCase2.equals("vungle")) {
                        }
                        break;
                    case 92668925:
                        if (lowerCase2.equals(Constant.ADMOB)) {
                        }
                        break;
                    case 497130182:
                        if (!lowerCase2.equals(Constant.FACEBOOK)) {
                        }
                        break;
                    default:
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Unknown Source)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:195)
                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:88)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    Method dump skipped, instruction units count: 310
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.C2503p9.b(android.content.Context):void");
            }

            private static void c(Context context) {
                Log.i(f9648a, "*** Permissions ***");
                PackageManager packageManager = context.getPackageManager();
                if (packageManager.checkPermission("android.permission.INTERNET", context.getPackageName()) == 0) {
                    Log.i(f9648a, "android.permission.INTERNET - VERIFIED");
                } else {
                    Log.e(f9648a, "android.permission.INTERNET - MISSING");
                }
                if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
                    Log.i(f9648a, "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
                } else {
                    Log.e(f9648a, "android.permission.ACCESS_NETWORK_STATE - MISSING");
                }
            }

            private static void b(Object obj) {
                String str;
                try {
                    Class<?> cls = obj.getClass();
                    if (obj instanceof LevelPlayBaseAdapter) {
                        str = f9649b;
                    } else {
                        str = f9650c;
                    }
                    Log.i(f9648a, "SDK Version - " + ((String) cls.getMethod(str, null).invoke(obj, null)));
                } catch (Exception e4) {
                    C2531r4.d().a(e4);
                    Log.w(f9648a, "Unable to get SDK version");
                }
            }

            private static void a(Context context) {
                new a(context).start();
            }

            private static void a(Object obj) {
                try {
                    Log.i(f9648a, "Adapter Version - " + ((String) obj.getClass().getMethod(obj instanceof LevelPlayBaseAdapter ? f9651d : "getVersion", null).invoke(obj, null)));
                } catch (Exception e4) {
                    C2531r4.d().a(e4);
                    Log.w(f9648a, "Unable to get adapter version");
                }
            }
        }
