package com.onesignal.core.internal.language.impl;

import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LanguageContext implements ILanguageContext {
    private final PropertiesModelStore _propertiesModelStore;
    private LanguageProviderDevice deviceLanguageProvider;

    public LanguageContext(PropertiesModelStore _propertiesModelStore) {
        k.e(_propertiesModelStore, "_propertiesModelStore");
        this._propertiesModelStore = _propertiesModelStore;
        this.deviceLanguageProvider = new LanguageProviderDevice();
    }

    @Override // com.onesignal.core.internal.language.ILanguageContext
    public String getLanguage() {
        String language = this._propertiesModelStore.getModel().getLanguage();
        return language == null ? this.deviceLanguageProvider.getLanguage() : language;
    }

    @Override // com.onesignal.core.internal.language.ILanguageContext
    public void setLanguage(String value) {
        k.e(value, "value");
        this._propertiesModelStore.getModel().setLanguage(value);
    }
}
