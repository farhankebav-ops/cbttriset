package com.onesignal.common.modeling;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ModelChangedArgs {
    private final Model model;
    private final Object newValue;
    private final Object oldValue;
    private final String path;
    private final String property;

    public ModelChangedArgs(Model model, String path, String property, Object obj, Object obj2) {
        k.e(model, "model");
        k.e(path, "path");
        k.e(property, "property");
        this.model = model;
        this.path = path;
        this.property = property;
        this.oldValue = obj;
        this.newValue = obj2;
    }

    public final Model getModel() {
        return this.model;
    }

    public final Object getNewValue() {
        return this.newValue;
    }

    public final Object getOldValue() {
        return this.oldValue;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getProperty() {
        return this.property;
    }
}
