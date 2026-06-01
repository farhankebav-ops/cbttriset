package com.onesignal.core.internal.purchases.impl;

import a3.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferencePlayerPurchasesKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.url._UrlKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TrackGooglePurchase implements IStartableService, IApplicationLifecycleHandler {
    private static Class<?> iInAppBillingServiceClass;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private final IPreferencesService _prefs;
    private Method getPurchasesMethod;
    private Method getSkuDetailsMethod;
    private boolean isWaitingForPurchasesRequest;
    private Object mIInAppBillingService;
    private ServiceConnection mServiceConn;
    private boolean newAsExisting;
    private final List<String> purchaseTokens;
    public static final Companion Companion = new Companion(null);
    private static int iapEnabled = -99;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getAsInterfaceMethod(Class<?> cls) {
            Method[] methods = cls.getMethods();
            k.d(methods, "clazz.methods");
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && k.a(parameterTypes[0], IBinder.class)) {
                    return method;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getGetPurchasesMethod(Class<?> cls) {
            k.b(cls);
            Method[] methods = cls.getMethods();
            k.d(methods, "clazz!!.methods");
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 4 && k.a(parameterTypes[0], Integer.TYPE) && k.a(parameterTypes[1], String.class) && k.a(parameterTypes[2], String.class) && k.a(parameterTypes[3], String.class)) {
                    return method;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getGetSkuDetailsMethod(Class<?> cls) {
            k.b(cls);
            Method[] methods = cls.getMethods();
            k.d(methods, "clazz!!.methods");
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?> returnType = method.getReturnType();
                if (parameterTypes.length == 4 && k.a(parameterTypes[0], Integer.TYPE) && k.a(parameterTypes[1], String.class) && k.a(parameterTypes[2], String.class) && k.a(parameterTypes[3], Bundle.class) && k.a(returnType, Bundle.class)) {
                    return method;
                }
            }
            return null;
        }

        public final boolean canTrack(Context context) {
            k.e(context, "context");
            if (TrackGooglePurchase.iapEnabled == -99) {
                TrackGooglePurchase.iapEnabled = context.checkCallingOrSelfPermission("com.android.vending.BILLING");
            }
            try {
                if (TrackGooglePurchase.iapEnabled == 0) {
                    TrackGooglePurchase.iInAppBillingServiceClass = Class.forName("com.android.vending.billing.IInAppBillingService");
                }
                return TrackGooglePurchase.iapEnabled == 0;
            } catch (Throwable unused) {
                TrackGooglePurchase.iapEnabled = 0;
                return false;
            }
        }

        private Companion() {
        }
    }

    public TrackGooglePurchase(IApplicationService _applicationService, IPreferencesService _prefs, IOperationRepo _operationRepo, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore) {
        k.e(_applicationService, "_applicationService");
        k.e(_prefs, "_prefs");
        k.e(_operationRepo, "_operationRepo");
        k.e(_configModelStore, "_configModelStore");
        k.e(_identityModelStore, "_identityModelStore");
        this._applicationService = _applicationService;
        this._prefs = _prefs;
        this._operationRepo = _operationRepo;
        this._configModelStore = _configModelStore;
        this._identityModelStore = _identityModelStore;
        this.purchaseTokens = new ArrayList();
        this.newAsExisting = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryBoughtItems() {
        if (this.isWaitingForPurchasesRequest) {
            return;
        }
        new Thread(new b(this, 22)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: queryBoughtItems$lambda-0, reason: not valid java name */
    public static final void m3143queryBoughtItems$lambda0(TrackGooglePurchase this$0) {
        k.e(this$0, "this$0");
        this$0.isWaitingForPurchasesRequest = true;
        try {
            if (this$0.getPurchasesMethod == null) {
                Method getPurchasesMethod = Companion.getGetPurchasesMethod(iInAppBillingServiceClass);
                this$0.getPurchasesMethod = getPurchasesMethod;
                k.b(getPurchasesMethod);
                getPurchasesMethod.setAccessible(true);
            }
            Method method = this$0.getPurchasesMethod;
            k.b(method);
            Object objInvoke = method.invoke(this$0.mIInAppBillingService, 3, this$0._applicationService.getAppContext().getPackageName(), "inapp", null);
            k.c(objInvoke, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle = (Bundle) objInvoke;
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                k.b(stringArrayList2);
                int size = stringArrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = stringArrayList2.get(i2);
                    k.b(stringArrayList);
                    String str2 = stringArrayList.get(i2);
                    String string = new JSONObject(str).getString("purchaseToken");
                    if (!this$0.purchaseTokens.contains(string) && !arrayList2.contains(string)) {
                        arrayList2.add(string);
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    this$0.sendPurchases(arrayList, arrayList2);
                } else if (stringArrayList2.size() == 0) {
                    this$0.newAsExisting = false;
                    this$0._prefs.saveBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, Boolean.FALSE);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this$0.isWaitingForPurchasesRequest = false;
    }

    private final void sendPurchases(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        try {
            if (this.getSkuDetailsMethod == null) {
                Method getSkuDetailsMethod = Companion.getGetSkuDetailsMethod(iInAppBillingServiceClass);
                this.getSkuDetailsMethod = getSkuDetailsMethod;
                k.b(getSkuDetailsMethod);
                getSkuDetailsMethod.setAccessible(true);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Method method = this.getSkuDetailsMethod;
            k.b(method);
            Object objInvoke = method.invoke(this.mIInAppBillingService, 3, this._applicationService.getAppContext().getPackageName(), "inapp", bundle);
            k.c(objInvoke, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle2 = (Bundle) objInvoke;
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                k.b(stringArrayList);
                int size = stringArrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    String str = stringArrayList.get(i2);
                    i2++;
                    JSONObject jSONObject = new JSONObject(str);
                    String sku = jSONObject.getString(InAppPurchaseMetaData.KEY_PRODUCT_ID);
                    String iso = jSONObject.getString("price_currency_code");
                    BigDecimal bigDecimalDivide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    k.d(bigDecimalDivide, "price.divide(BigDecimal(1000000))");
                    k.d(sku, "sku");
                    k.d(iso, "iso");
                    linkedHashMap.put(sku, new PurchaseInfo(sku, iso, bigDecimalDivide));
                }
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList.size();
                int i8 = 0;
                while (i8 < size2) {
                    String str2 = arrayList.get(i8);
                    i8++;
                    String str3 = str2;
                    if (linkedHashMap.containsKey(str3)) {
                        Object obj = linkedHashMap.get(str3);
                        k.b(obj);
                        arrayList3.add(obj);
                    }
                }
                if (arrayList3.isEmpty()) {
                    return;
                }
                IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackPurchaseOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), this.newAsExisting, new BigDecimal(0), arrayList3), false, 2, null);
                this.purchaseTokens.addAll(arrayList2);
                this._prefs.saveString(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_PURCHASE_TOKENS, this.purchaseTokens.toString());
                this._prefs.saveBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, Boolean.TRUE);
                this.newAsExisting = false;
                this.isWaitingForPurchasesRequest = false;
            }
        } catch (Throwable th) {
            Logging.warn("Failed to track IAP purchases", th);
        }
    }

    private final void trackIAP() {
        if (this.mServiceConn != null) {
            if (this.mIInAppBillingService != null) {
                queryBoughtItems();
            }
        } else {
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.onesignal.core.internal.purchases.impl.TrackGooglePurchase$trackIAP$serviceConn$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName name, IBinder service) {
                    k.e(name, "name");
                    k.e(service, "service");
                    try {
                        Method asInterfaceMethod = TrackGooglePurchase.Companion.getAsInterfaceMethod(Class.forName("com.android.vending.billing.IInAppBillingService$Stub"));
                        k.b(asInterfaceMethod);
                        asInterfaceMethod.setAccessible(true);
                        this.this$0.mIInAppBillingService = asInterfaceMethod.invoke(null, service);
                        this.this$0.queryBoughtItems();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                    k.e(name, "name");
                    TrackGooglePurchase.iapEnabled = -99;
                    this.this$0.mIInAppBillingService = null;
                }
            };
            this.mServiceConn = serviceConnection;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this._applicationService.getAppContext().getApplicationContext().bindService(intent, serviceConnection, 1);
        }
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus(boolean z2) {
        trackIAP();
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        if (Companion.canTrack(this._applicationService.getAppContext())) {
            try {
                JSONArray jSONArray = new JSONArray(this._prefs.getString(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_PURCHASE_TOKENS, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI));
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.purchaseTokens.add(jSONArray.get(i2).toString());
                }
                boolean z2 = jSONArray.length() == 0;
                this.newAsExisting = z2;
                if (z2) {
                    Boolean bool = this._prefs.getBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, Boolean.TRUE);
                    k.b(bool);
                    this.newAsExisting = bool.booleanValue();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this._applicationService.addApplicationLifecycleHandler(this);
            trackIAP();
        }
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }
}
