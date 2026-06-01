package com.unity3d.ads.adplayer.model;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OnVisibilityChangeEvent implements WebViewEvent {
    private final String category = "ADVIEWER";
    private final String name = "ON_VISIBILITY_CHANGE";
    private final Object[] parameters;

    public OnVisibilityChangeEvent(boolean z2) {
        this.parameters = new Object[]{Boolean.valueOf(z2)};
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public String getCategory() {
        return this.category;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public String getName() {
        return this.name;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public Object[] getParameters() {
        return this.parameters;
    }
}
