package org.jz.lovediary.api;

/**
 * Created by JZ on 4/23/2016.
 */
public final class AndroidMVPApi {
    public interface Presenter<TView extends AndroidMVPApi.View> {
        void onViewReady(TView view);
    }

    public interface View {

    }

    public interface Provider {

    }
}
